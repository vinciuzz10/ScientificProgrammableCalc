package scientificprogrammablecalculator;

import ComplexNumberClass.ComplexNumber;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import DataStructures.NumberStack;

/**
 *
 * @author Vinciuzz10
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button submitButton;
    @FXML
    private Button sumButton;
    @FXML
    private Button differenceButton;
    @FXML
    private Button productButton;
    @FXML
    private Button quotientButton;
    @FXML
    private Button sqrtButton;
    @FXML
    private Button invertSignButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button delButton;
    @FXML
    private Button swapButton;
    @FXML
    private Button dupButton;
    @FXML
    private Button cslButton;
    @FXML
    private TableView<ComplexNumber> lastNumbersTableView;
    @FXML
    private TableColumn<ComplexNumber, String> lastNumbersColumn;
    @FXML
    private TextField mainTextField;
    
    
    
    private ObservableList<ComplexNumber> numbers;
    private final NumberStack stack = new NumberStack();

   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        numbers = FXCollections.observableArrayList(stack.toList());
        lastNumbersColumn.setCellValueFactory(new PropertyValueFactory<>("ComplexString"));
        lastNumbersTableView.setItems(numbers);
        lastNumbersTableView.setPlaceholder(new Label("Empty"));
    }    

    @FXML
    private void submitButtonPressed(ActionEvent event) {
        String stringFromTextField = mainTextField.getText().replace(" ", "");
        
        if (stringFromTextField.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("You can't submit an empty number or an empty operation.");
            alert.setHeaderText("Invalid Input");
            alert.showAndWait();
            return;
        }
        
        ComplexNumber number;
        try {
            number = ComplexNumber.parseComplexNumber(stringFromTextField);
            stack.push(number);
        } catch (NumberFormatException e) {
            showNumberFormatAlert();
        }
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void sumButtonPressed(ActionEvent event) {
        if (stack.size() < 2)
            return;
        
        ComplexNumber secondOperand = stack.pop();
        ComplexNumber firstOperand = stack.pop();
        
        ComplexNumber sum = firstOperand.add(secondOperand);
        stack.push(sum);
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void differenceButtonPressed(ActionEvent event) {
        if (stack.size() < 2)
            return;
        
        ComplexNumber secondOperand = stack.pop();
        ComplexNumber firstOperand = stack.pop();
        
        ComplexNumber difference = firstOperand.subtract(secondOperand);
        stack.push(difference);
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void productButtonPressed(ActionEvent event) {
        if (stack.size() < 2)
            return;
        
        ComplexNumber secondOperand = stack.pop();
        ComplexNumber firstOperand = stack.pop();
        
        ComplexNumber product = firstOperand.multiply(secondOperand);
        stack.push(product);
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void quotientButtonPressed(ActionEvent event) {
        if (stack.size() < 2)
            return;
        
        ComplexNumber secondOperand = stack.pop();
        ComplexNumber firstOperand = stack.pop();
        
        ComplexNumber quotient = firstOperand.divide(secondOperand);
        stack.push(quotient);
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void sqrtButtonPressed(ActionEvent event) {
        ComplexNumber number = stack.pop();
        
        ComplexNumber sqrt = number.sqrt();
        stack.push(sqrt);
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void invertSignButtonPressed(ActionEvent event) {
        ComplexNumber number = stack.pop();
        
        ComplexNumber opposite = number.opposite();
        stack.push(opposite);
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void clearButtonPressed(ActionEvent event) {
        stack.clear();
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void delButtonPressed(ActionEvent event) {
        if (stack.isEmpty()) 
            throw new EmptyStackException();
        
        stack.pop();
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void swapButtonPressed(ActionEvent event) {
        if (stack.size() < 2) 
            return;
        
        stack.swap();
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void dupButtonPressed(ActionEvent event) {
        if (stack.isEmpty()) 
            throw new EmptyStackException();
        
        stack.dup();
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    private void overButtonPressed(ActionEvent event) {
        stack.over();
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void cslButtonPressed(ActionEvent event) {
        if (stack.size() < 2) 
            return;
        
        stack.over();
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }
    
    private void clearTextField() {
        mainTextField.clear();
    }
    
    private void updateTableView() {
        List<ComplexNumber> tmp = stack.toList();
        numbers.clear();
        numbers.setAll(tmp);
    }
    
    private void showNumberFormatAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setContentText("The entered number format is not valid.");
        alert.setHeaderText("Invalid Input");
        alert.showAndWait();
        return;
    }

}