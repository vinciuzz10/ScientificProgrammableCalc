package GUI;

import CalculatorExceptions.InvalidOperandsException;
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
import java.util.EmptyStackException;
import java.util.Map;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
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
    @FXML
    private Button saveVarButton;
    @FXML
    private Button restoreVarButton;
    
    
    private ObservableList<UserOperation> customOperations;
    private ObservableList<ComplexNumber> numbers;
    private ObservableList<Map.Entry<Character, ComplexNumber>> variableObservableList;
    private final Calculator calc = new Calculator();
    private final NumberStack stack = calc.getStack();
    private final Variables variables = calc.getVar();


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
        formulaTableColumn.setCellValueFactory(new PropertyValueFactory("OperationAsString"));
    }    

    @FXML
    private void submitButtonPressed(ActionEvent event) {
        
        String stringFromTextField = mainTextField.getText().replace(" ", "");
        
        /* Check if the user has entered something in the textfield, otherwise shows an alert. */
        if (stringFromTextField.isEmpty()) {
            showAlert("Error", "Invalid Input", "You can't submit an empty number or an empty operation.", AlertType.ERROR);
            clearTextField();
            return;
        }

        if (!stack.isEmpty()) {
            if (stringFromTextField.matches(">[A-Z]")) {
                char variableName = stringFromTextField.substring(1).toCharArray()[0];
                calc.storeInVariable(variableName);
                updateVariablesTableView();
                updateLastNumbersTableView();
                clearTextField();
                return;
            } else if (stringFromTextField.matches("\\+[A-Z]")) {
                char variableName = stringFromTextField.substring(1).toCharArray()[0];
                calc.addToVariable(variableName);
                updateVariablesTableView();
                clearTextField();
                return;
            } else if (stringFromTextField.matches("\\-[A-Z]")) {
                char variableName = stringFromTextField.substring(1).toCharArray()[0];
                calc.subtractToVariable(variableName);
                updateVariablesTableView();
                clearTextField();
                return;
            }
        }
        if (stringFromTextField.matches("<[A-Z]")) {
            char variableName = stringFromTextField.substring(1).toCharArray()[0];
            calc.pickFromVariable(variableName);
            updateLastNumbersTableView();
            clearTextField(); 
            return;
        }
        
        /* Check if the user has entered a ComplexNumber correctly. */
        ComplexNumber number;
        try {
            number = ComplexNumber.parseComplexNumber(stringFromTextField);
            calc.push(number);
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid Input" ,"The entered number or operation is not valid.", AlertType.ERROR);
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
        try {
            calc.sum();
        } catch (InvalidOperandsException e) {
            showAlert("Error", "Invalid operation", "Not enough entered numbers.", AlertType.ERROR);
            return;
        }
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void differenceButtonPressed(ActionEvent event) {
        try {
            calc.difference();
        } catch (InvalidOperandsException e) {
            showAlert("Error", "Invalid operation", "Not enough entered numbers.", AlertType.ERROR);
            return;
        }

        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void productButtonPressed(ActionEvent event) {
        try {
            calc.product();
        } catch (InvalidOperandsException e) {
            showAlert("Error", "Invalid operation", "Not enough entered numbers.", AlertType.ERROR);
            return;
        }
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void quotientButtonPressed(ActionEvent event) {
        try {
            calc.quotient();
        } catch (InvalidOperandsException e) {
            showAlert("Error", "Invalid operation", "Not enough entered numbers.", AlertType.ERROR);
            return;
        }
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void sqrtButtonPressed(ActionEvent event) {
        try {
            calc.sqrt();
        } catch (EmptyStackException e) {
            showAlert("Error", "Invalid operation", "No entered numbers.", AlertType.ERROR);
            return;
        }
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void invertSignButtonPressed(ActionEvent event) {
        try {
            calc.invertSign();
        } catch (EmptyStackException e) {
            showAlert("Error", "Invalid operation", "No entered numbers.", AlertType.ERROR);
            return;
        }
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void clearButtonPressed(ActionEvent event) {
        try {
            calc.clear();
        } catch (EmptyStackException e) {
            return;
        }
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void delButtonPressed(ActionEvent event) {
        try {
            calc.pop();
        } catch (EmptyStackException e) {
            showAlert("Error", "Invalid operation", "No entered numbers.", AlertType.ERROR);
            return;
        };
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void swapButtonPressed(ActionEvent event) {
        try {
            calc.swap();
        } catch (InvalidOperandsException e) {
            showAlert("Error", "Invalid operation", "Not enough entered numbers.", AlertType.ERROR);
            return;
        }
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void dupButtonPressed(ActionEvent event) {
        try {
            calc.dup();
        } catch (EmptyStackException e) {
            showAlert("Error", "Invalid operation", "No entered numbers.", AlertType.ERROR);
            return;
        }
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }

    @FXML
    private void cslButtonPressed(ActionEvent event) {
        try {
            calc.over();
        } catch (InvalidOperandsException e) {
            showAlert("Error", "Invalid operation", "Not enough entered numbers.", AlertType.ERROR);
            return;
        }
        
        /* Update TableView items */
        updateLastNumbersTableView();
        
        /* Clear both real part text field and imaginary part text field */
        clearTextField();
    }
    
    @FXML
    private void userOperationButtonPressed(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLUserOperations.fxml"));
        Parent root = (Parent)loader.load();
        FXMLUserOperationsController controller = loader.getController();
        controller.loadInfo(customOperations,calc,this);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("User Operations");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("manageOperationsIcon.png")));
        stage.show();
        stage.setResizable(false);
    }
    
    @FXML
    private void saveVarButtonPressed(ActionEvent event) {
        calc.storeVariablesStatus();
        showAlert("", "Saving completed", "The variables have been stored succesfully.", AlertType.INFORMATION);
    }

    @FXML
    private void restoreVarButtonPressed(ActionEvent event) {
        try {
            calc.restoreVariableStatus();
        } catch (EmptyStackException e) {
            showAlert("Error", "Restore variables", "No variables stored.", AlertType.ERROR);
            return;
        }
        
        /* Update TableView items */
        updateVariablesTableView();
        showAlert("", "Restore variables", "The variables have been restored succesfully.", AlertType.INFORMATION);
    }

    @FXML
    private void computeCustomOperation(ActionEvent event) {
        UserOperation selected = userOperationsTableView.getSelectionModel().getSelectedItem();
        
        if (selected == null) {
            showAlert("Error", "No user-operation selected", "Please select an ser-operation before pressing 'compute'", AlertType.ERROR);
        }
        
        if(!calc.executeUserOperation(selected)){
            showAlert("Error", "Invalid operation", "The operation is not valid, or the operands are not enough to compute it.", AlertType.ERROR);
            return;
        }
        
        /* Update TableView items */
        updateLastNumbersTableView();
        updateVariablesTableView();
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
    
    private void showAlert(String title, String header, String content, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

    void updateUserOperations(ObservableList<UserOperation> operations) {
        customOperations.clear();
        customOperations.addAll(operations);
    }
    
}