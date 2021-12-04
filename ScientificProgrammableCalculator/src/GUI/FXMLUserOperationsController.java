package GUI;

import CustomClasses.UserOperation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    
    /**
     * Initializes the controller class.
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
        TextInputDialog tid = new TextInputDialog();
        tid.setTitle("Provide a Name");
        tid.setHeaderText("Enter operation name:");
        tid.setContentText("Name:");
        tid.showAndWait();
        operations.add(new UserOperation(tid.getResult(),tmp));
        userOperationTable.setItems(operations);
        mainReference.updateUserOperations(operations);
        insertOperationTextField.clear();
    }

    @FXML
    private void loadFromFile(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("Text Files","*.txt");
        fileChooser.getExtensionFilters().add(extension);
       
        File file = fileChooser.showOpenDialog(null);
        if (file == null) {
            //Implement alert
            return;
        }
        
        try (Scanner sc = new Scanner(file)) {
            String line, opName, opFormula;
            while (sc.hasNext()) {
                line = sc.nextLine();
                opName = line.split("\t")[0];
                opFormula = line.split("\t")[1];
                UserOperation op = new UserOperation(opName, opFormula.split(" "));
                operations.add(op);
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
            //Implement alert
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
        //selected.setOperation(tid.getResult().split(" "));
        operations.remove(selected);
        operations.add(new UserOperation(selected.getName(),tid.getResult().split(" ")));
        userOperationTable.setItems(operations);
        mainReference.updateUserOperations(operations);
    }

    @FXML
    private void deleteOperationFunction(ActionEvent event) {
        UserOperation selected =userOperationTable.getSelectionModel().getSelectedItem();
        if(selected == null)
            return;
        operations.remove(selected);
        userOperationTable.setItems(operations);
        mainReference.updateUserOperations(operations);
    }
    
    @FXML
    private void enterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            createOperation(null);
        }
    }
    
    public void loadInfo(List<UserOperation> operationsList,FXMLDocumentController mainCOntroller){
        mainReference = mainCOntroller;
        operations.addAll(operationsList);
        userOperationTable.getItems().addAll(operations);
    }
}