package scientificprogrammablecalculator;

import ComplexNumberClass.ComplexNumber;
import java.net.URL;
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
import DataStructures.Variables;

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
    private final Variables variables = new Variables();

   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        numbers = FXCollections.observableArrayList(stack.toList());
        lastNumbersColumn.setCellValueFactory(new PropertyValueFactory<>("ComplexString"));
        lastNumbersTableView.setItems(numbers);
        lastNumbersTableView.setPlaceholder(new Label("Empty"));
        
        lastNumbersTableView.setStyle("-fx-background-color:transparent;\n"
                + "-fx-selection-bar-non-focused:#b9eebe;\n"
                + "-fx-selection-bar:green;\n");
    }    

    @FXML
    private void submitButtonPressed(ActionEvent event) {
        String stringFromTextField = mainTextField.getText().replace(" ", "");
        
        if (!stack.isEmpty()) {
            if (stringFromTextField.matches(">[a-z]")) {
                char variableName = stringFromTextField.substring(1).toCharArray()[0];
                variables.setVariableValue(variableName, stack.pop());
                updateTableView();
                clearTextField();
                return;
            } else if (stringFromTextField.matches("\\+[a-z]var")) {
                char variableName = stringFromTextField.substring(1).toCharArray()[0];
                ComplexNumber value = variables.getVariableValue(variableName);
                variables.setVariableValue(variableName, value.add(stack.peek()));
                clearTextField();
                return;
            } else if (stringFromTextField.matches("\\-[a-z]var")) {
                char variableName = stringFromTextField.substring(1).toCharArray()[0];
                ComplexNumber value = variables.getVariableValue(variableName);
                variables.setVariableValue(variableName, value.subtract(stack.peek()));
                clearTextField();
                return;
            }
        }
        if (stringFromTextField.matches("<[a-z]")) {
            char variableName = stringFromTextField.substring(1).toCharArray()[0];
            ComplexNumber value = variables.getVariableValue(variableName);
            stack.push(value);
            updateTableView();
            clearTextField();
            return;
        } 
        
        if (stringFromTextField.isEmpty()) {
            showAlert("Invalid Input", "You can't submit an empty number or an empty operation.");
            return;
        }
        
        ComplexNumber number;
        try {
            number = ComplexNumber.parseComplexNumber(stringFromTextField);
            stack.push(number);
        } catch (NumberFormatException e) {
            showAlert("Invalid Input" ,"The entered number or operation is not valid.");
            return;
        }
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void sumButtonPressed(ActionEvent event) throws InterruptedException {
        if (stack.size() < 2) {
            showAlert("Invalid operation", "Not enough entered numbers.");
            return;
        }
        
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
        if (stack.size() < 2) {
            showAlert("Invalid operation", "Not enough entered numbers.");
            return;
        }
        
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
        if (stack.size() < 2) {
            showAlert("Invalid operation", "Not enough entered numbers.");
            return;
        }
        
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
        if (stack.size() < 2) {
            showAlert("Invalid operation", "Not enough entered numbers.");
            return;
        }
        
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
        if (stack.isEmpty()) {
            showAlert("Invalid operation", "No entered numbers.");
            return;
        }
        
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
        if (stack.isEmpty()) {
            showAlert("Invalid operation", "No entered numbers.");
            return;
        }
        
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
        if (stack.isEmpty()) {
            showAlert("Invalid operation", "No entered numbers.");
            return;
        }
        
        stack.pop();
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void swapButtonPressed(ActionEvent event) {
        if (stack.size() < 2) {
            showAlert("Invalid operation", "Not enough entered numbers.");
            return;
        }
        
        stack.swap();
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void dupButtonPressed(ActionEvent event) {
        if (stack.isEmpty()) {
            showAlert("Invalid operation", "No entered numbers.");
            return;
        }
        
        stack.dup();
        
        /* Update TableView items */
        updateTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void cslButtonPressed(ActionEvent event) {
        if (stack.size() < 2) {
            showAlert("Invalid operation", "Not enough entered numbers.");
            return;
        }
        
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
        
        lastNumbersTableView.getSelectionModel().select(0);
    }
    
    private void showAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setContentText(content);
        alert.setHeaderText(header);
        alert.showAndWait();
        return;
    }

    /*private boolean checkForVariablesOperation(String stringFromTextField) {
        if (stringFromTextField.matches(">[a-z]")) {
            char variableName = stringFromTextField.substring(1).toCharArray()[0];
            variables.setVariableValue(variableName, stack.pop());
            return true;
        } else if (stringFromTextField.matches("<[a-z]")) {
            char variableName = stringFromTextField.substring(1).toCharArray()[0];
            ComplexNumber value = variables.getVariableValue(variableName);
            return true;
        } else if (stringFromTextField.matches("\\+[a-z]var")) {
            char variableName = stringFromTextField.substring(1).toCharArray()[0];
            ComplexNumber value = variables.getVariableValue(variableName);
            variables.setVariableValue(variableName, value.add(stack.peek()));
            return true;
        } else if (stringFromTextField.matches("\\-[a-z]var")) {
            char variableName = stringFromTextField.substring(1).toCharArray()[0];
            ComplexNumber value = variables.getVariableValue(variableName);
            variables.setVariableValue(variableName, value.subtract(stack.peek()));
            return true;
        }
        return false;
    }*/

}