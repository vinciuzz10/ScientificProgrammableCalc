package GUI;

import CustomClasses.Calculator;
import CustomClasses.ComplexNumber;
import CustomClasses.UserOperation;
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
import java.io.IOException;
import java.util.Map;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

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
    @FXML
    private TableView<Map.Entry<Character, ComplexNumber>> variablesTableView;
    @FXML
    private TableColumn<Variables.Entry, Character> variableKeyColumn;
    @FXML
    private TableColumn<Variables.Entry, ComplexNumber> variableValueColumn;
    @FXML
    private Button userOperationButton;
    @FXML
    private TableView<UserOperation> userOperationsTableView;
    @FXML
    private TableColumn<UserOperation, String> operationTableColumn;
    @FXML
    private TableColumn<UserOperation, String> formulaTableColumn;
    @FXML
    private MenuItem computeMenuItem;
    
    
    private ObservableList<UserOperation> customOperations;
    private ObservableList<ComplexNumber> numbers;
    private ObservableList<Map.Entry<Character, ComplexNumber>> variableObservableList;
    private final NumberStack stack = new NumberStack();
    private final Variables variables = new Variables();
    private Calculator calc;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        /* Last Numbers Table View setup */
        numbers = FXCollections.observableArrayList(stack.toList());
        lastNumbersColumn.setCellValueFactory(new PropertyValueFactory<>("ComplexString"));
        lastNumbersTableView.setItems(numbers);
        lastNumbersTableView.setPlaceholder(new Label("Empty"));
        
        lastNumbersTableView.setStyle("-fx-background-color:transparent;\n"
                + "-fx-selection-bar-non-focused:#b9eebe;\n"
                + "-fx-selection-bar:green;\n");

        /* Variables Table View setup */
        variableObservableList = FXCollections.observableArrayList();
        variableObservableList.addAll(variables.entrySet());
        
        variableKeyColumn.setCellValueFactory((TableColumn.CellDataFeatures<Map.Entry, Character> param) -> new SimpleObjectProperty<>((Character) param.getValue().getKey()));
        variableValueColumn.setCellValueFactory((TableColumn.CellDataFeatures<Map.Entry, ComplexNumber> param) -> new SimpleObjectProperty<>((ComplexNumber) param.getValue().getValue()));
        
        variablesTableView.setItems(variableObservableList);
       
        /* UserOperations setUp*/
        customOperations = FXCollections.observableArrayList();
        
        userOperationsTableView.setItems(customOperations);
        userOperationsTableView.setPlaceholder(new Label("Empty"));
        operationTableColumn.setCellValueFactory(new PropertyValueFactory("name"));
        formulaTableColumn.setCellValueFactory(new PropertyValueFactory("operationAsString"));
        
        /* Calculator initialisation */
        calc = new Calculator(stack, variables);
    }    

    @FXML
    private void submitButtonPressed(ActionEvent event) {
        int i = 1;
        
        String stringFromTextField = mainTextField.getText().replace(" ", "");
        
        if (!stack.isEmpty()) {
            if (stringFromTextField.matches(">[A-Z]")) {
                char variableName = stringFromTextField.substring(1).toCharArray()[0];
                variables.put(variableName, stack.pop());
                updateVariablesTableView();
                updateLastNumbersTableView();
                clearTextField();
                return;
            } else if (stringFromTextField.matches("\\+[A-Z]")) {
                char variableName = stringFromTextField.substring(1).toCharArray()[0];
                variables.addToVariable(variableName, stack.peek());
                updateVariablesTableView();
                clearTextField();
                return;
            } else if (stringFromTextField.matches("\\-[A-Z]")) {
                char variableName = stringFromTextField.substring(1).toCharArray()[0];
                variables.subtractToVariable(variableName, stack.peek());
                updateVariablesTableView();
                clearTextField();
                return;
            }
        }
        if (stringFromTextField.matches("<[A-Z]")) {
            char variableName = stringFromTextField.substring(1).toCharArray()[0];
            ComplexNumber value = variables.get(variableName);
            stack.push(value);
            updateLastNumbersTableView();
            clearTextField(); 
            return;
        } 
        
        if (stringFromTextField.isEmpty()) {
            showAlert("Invalid Input", "You can't submit an empty number or an empty operation.");
            clearTextField();
            return;
        }
        
        ComplexNumber number;
        try {
            number = ComplexNumber.parseComplexNumber(stringFromTextField);
            stack.push(number);
        } catch (NumberFormatException e) {
            showAlert("Invalid Input" ,"The entered number or operation is not valid.");
            clearTextField();
            return;
        }
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void sumButtonPressed(ActionEvent event) throws InterruptedException {
        if (stack.size() < 2) {
            showAlert("Invalid operation", "Not enough entered numbers.");
            return;
        }
        
        calc.sum();
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void differenceButtonPressed(ActionEvent event) {
        if (stack.size() < 2) {
            showAlert("Invalid operation", "Not enough entered numbers.");
            return;
        }
        
        calc.difference();
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void productButtonPressed(ActionEvent event) {
        if (stack.size() < 2) {
            showAlert("Invalid operation", "Not enough entered numbers.");
            return;
        }
        
        calc.product();
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void quotientButtonPressed(ActionEvent event) {
        if (stack.size() < 2) {
            showAlert("Invalid operation", "Not enough entered numbers.");
            return;
        }
        
        calc.quotient();
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void sqrtButtonPressed(ActionEvent event) {
        if (stack.isEmpty()) {
            showAlert("Invalid operation", "No entered numbers.");
            return;
        }
        
        calc.sqrt();
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void invertSignButtonPressed(ActionEvent event) {
        if (stack.isEmpty()) {
            showAlert("Invalid operation", "No entered numbers.");
            return;
        }
        
        calc.invertSign();
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void clearButtonPressed(ActionEvent event) {
        stack.clear();
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
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
        updateLastNumbersTableView();
        
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
        updateLastNumbersTableView();
        
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
        updateLastNumbersTableView();
        
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
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }
    
    @FXML
    private void userOperationButtonPressed(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLUserOperations.fxml"));
        Parent root = (Parent)loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("/UserOperations/FXMLUserOperation.fxml"));
        FXMLUserOperationsController controller = loader.getController();
        controller.loadInfo(customOperations,this);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("User Operations");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("manageOperationsIcon.png")));
        stage.show();
        stage.setResizable(false);
        
    }

    @FXML
    private void computeCustomOperation(ActionEvent event) {
        UserOperation selected = userOperationsTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("No user-operation selected", "Please select an ser-operation before pressing 'compute'");
        }
        Boolean b= calc.executeUserOperation(selected);
        if(!b){
            showAlert("Invalid operation", "The operation is not valid, or the operands are not enough to compute it.");
            return;
        }
        updateLastNumbersTableView();
    }
    
    @FXML
    private void enterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            submitButtonPressed(null);
        }
    }
    
    
    
    /* ----------------- UTILITY METHODS ----------------- */
    
    private void clearTextField() {
        mainTextField.clear();
    }
    
    private void updateLastNumbersTableView() {
        List<ComplexNumber> tmp = stack.toList();
        numbers.clear();
        numbers.setAll(tmp);
        
        lastNumbersTableView.getSelectionModel().select(0);
    }
    
    private void updateVariablesTableView() {
        variableObservableList.clear();
        variableObservableList.addAll(variables.entrySet());
    }
    
    private void showAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setContentText(content);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

    void updateUserOperations(ObservableList<UserOperation> operations) {
        customOperations.clear();
        customOperations.addAll(operations);
    }
    
}