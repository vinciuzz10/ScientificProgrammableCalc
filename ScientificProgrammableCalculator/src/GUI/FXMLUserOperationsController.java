package GUI;

import CustomClasses.Calculator;
import CustomClasses.UserOperation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Alfonso Giso
 */
public class FXMLUserOperationsController implements Initializable {

    @FXML
    private TableView<UserOperation> userOperationTable;
    @FXML
    private MenuItem editFunction;
    @FXML
    private MenuItem deleteFunction;
    @FXML
    private TableColumn<UserOperation, String> userOperationNameClm;
    @FXML
    private TableColumn<UserOperation, String> userOperationOperationClm;
    @FXML
    private TextField insertOperationTextField;
    @FXML
    private Button createOperationButton;
    @FXML
    private Button LoadOperationButton;
    @FXML
    private Button saveTofFileButton;

    private ObservableList<UserOperation> operations;
    private FXMLDocumentController mainReference;
    private Calculator calc;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        operations = FXCollections.observableArrayList();
        userOperationTable.getItems().addAll(operations);
        userOperationNameClm.setCellValueFactory(new PropertyValueFactory("name"));
        userOperationOperationClm.setCellValueFactory(new PropertyValueFactory("operationAsString"));
        userOperationTable.setPlaceholder(new Label("Empty"));
    }    

    @FXML
    private void createOperation(ActionEvent event) {
        String[] tmp = insertOperationTextField.getText().split(" ");
        for (String op: tmp) {
            if (!calc.getAllowedOperations().contains(op) && !op.matches("[><+-][A-Z]")) {
                showAlert("Error", "Invalid user-operation", "The entered user-operation contains invalid suboperations.", Alert.AlertType.ERROR);
                insertOperationTextField.clear();
                return;
            } 
        }
        
        TextInputDialog tid = new TextInputDialog();
        tid.setTitle("Provide a name");
        tid.setHeaderText("Enter operation name:");
        tid.setContentText("Name:");
        Optional<String> result = tid.showAndWait();
        if(result.isPresent()){
            if(tid.getResult().equals("")){
                insertOperationTextField.clear();
                return;
            }
            UserOperation op = new UserOperation(tid.getResult(),tmp);
            operations.add(op);
            userOperationTable.setItems(operations);
            mainReference.updateUserOperations(operations);
            insertOperationTextField.clear();
            calc.addOperationToMap(op);
        }
    }

    @FXML
    private void loadFromFile(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("Text Files","*.txt");
        fileChooser.getExtensionFilters().add(extension);
       
        File file = fileChooser.showOpenDialog(null);
        if (file == null) {
            showAlert("Error", "Error in loading file", "You must specify a file.", Alert.AlertType.ERROR);
            return;
        }
        operations.clear();
        //userOperationTable.getItems().clear();
        try (Scanner sc = new Scanner(file)) {
            String line, opName, opFormula;
            while (sc.hasNext()) {
                line = sc.nextLine();
                opName = line.split("\t")[0];
                opFormula = line.split("\t")[1];
                UserOperation op = new UserOperation(opName, opFormula.split(" "));
                operations.add(op);
                calc.addOperationToMap(op);
            }
        }
        
        userOperationTable.setItems(operations);
        mainReference.updateUserOperations(operations);
    }

    @FXML
    private void saveToFile(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("Text Files","*.txt");
        fileChooser.getExtensionFilters().add(extension);
       
        File file = fileChooser.showSaveDialog(null);
        if (file == null) {
            showAlert("Error", "Error in saving file", "You must specify a file.", Alert.AlertType.ERROR);
            return;
        }
        
        try (PrintWriter pw = new PrintWriter(file)) {
            operations.forEach(op -> {
                pw.write(op.getName() + "\t" + op.getOperationAsString() + "\n");
            });
        }
    }

    @FXML
    private void editOperationFunction(ActionEvent event) {
        UserOperation selected = userOperationTable.getSelectionModel().getSelectedItem();
        if(selected == null)
            return;
        
        TextInputDialog tid = new TextInputDialog();
        tid.setTitle("Edit");
        tid.setHeaderText("Edit selected user operation");
        tid.setContentText("Function");
        tid.getEditor().setText(selected.getOperationAsString());
        tid.showAndWait();
        
        UserOperation newOp = new UserOperation(selected.getName(),tid.getResult().split(" "));
        operations.remove(selected);
        operations.add(newOp);
        userOperationTable.setItems(operations);
        mainReference.updateUserOperations(operations);
        
        calc.addOperationToMap(newOp);
    }

    @FXML
    private void deleteOperationFunction(ActionEvent event) {
        UserOperation selected = userOperationTable.getSelectionModel().getSelectedItem();
        if(selected == null)
            return;
        
        Alert deleteAlert = showAlert("Confirm removal", "", "All associated operations will be removed. Are you sure?", Alert.AlertType.CONFIRMATION);
        if (deleteAlert.getResult() == ButtonType.OK) {
            List<UserOperation> tmp = new ArrayList();
            tmp.addAll(operations);
        
            deleteOperation(selected, tmp);
        
            operations.clear();
            operations.addAll(tmp);
            operations.remove(selected);

            userOperationTable.setItems(operations);
            mainReference.updateUserOperations(operations);

            calc.removeOperation(selected.getName());
        }
    }
    
    @FXML
    private void enterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            createOperation(null);
        }
    }
    
    
    
    
    // ------------------ UTILITY METHODS ------------------
    
    public void loadInfo(List<UserOperation> operationsList, Calculator calc, FXMLDocumentController mainCOntroller){
        mainReference = mainCOntroller;
        operations.addAll(operationsList);
        this.calc = calc;
        userOperationTable.getItems().addAll(operations);
    }
    
    private Alert showAlert(String title, String header, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(header);
        alert.showAndWait();
        return alert;
    }
    
    private void deleteOperation (UserOperation selected, List<UserOperation> tmp) {
        for (UserOperation op: operations) {
            String[] subOp = op.getOperation();
            for (String s: subOp) {
                if (s.equals(selected.getName())) {
                    tmp.remove(op);
                    deleteOperation(op, tmp);
                    break;
                }
            }
        }
    }
    
}
