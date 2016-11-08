
import java.util.Optional;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.util.Pair;
/**
 *author Liz Dao
 *@date 11/08/2016
 *@class CSC200 Chapter 4.1
 *
 */
public class equal extends Application {
	public static void main(String[] args){
		Application.launch();
		
	}
@Override	
public void start(Stage stage) throws Exception {
	int count = 0;
	while(count<3){
	Dialog<Pair<String,String>> login = new Dialog<>();
	login.setTitle("Login");
	login.setHeaderText("Please enter username and password");

	login.setGraphic(new ImageView(this.getClass().getResource("LUFFY.png").toString()));

	ButtonType lg = new ButtonType("Sign in", ButtonData.OK_DONE);
	login.getDialogPane().getButtonTypes().addAll(lg, ButtonType.CANCEL);
	
	
	GridPane grid = new GridPane();
	grid.setPadding( new Insets(20,20,20,20));
	grid.setVgap(10);
	grid.setHgap(10);

	TextField username = new TextField();
	username.setPromptText("Username");
	grid.add(new Label("Username:"),0,0);
	grid.add(username,0,1);

	PasswordField pass = new PasswordField();
	pass.setPromptText("Password");
	grid.add(new Label("Password:"),1,0);
	grid.add(pass,1,1);
	
	
	ChoiceBox<String> choicebox = new ChoiceBox<String>();
	choicebox.setItems(FXCollections.observableArrayList("Free Account", "VIP"));
	choicebox.setValue("Free Account");
	grid.add(choicebox, 3, 0);
	
	login.getDialogPane().setContent(grid);
	
	login.setResultConverter(loginButton -> {
	    if (loginButton == lg) {
	    	return new Pair<>(username.getText(), pass.getText());
        }else{
        return null;}});

	
        Optional<Pair<String, String>> result = login.showAndWait();
        	if(username.getText().equalsIgnoreCase("liz") && pass.getText().equalsIgnoreCase("186")){
          			if(choicebox.getValue().toString().equals("VIP")){
        			Alert alert = new Alert(AlertType.INFORMATION);
        			alert.setTitle("Login Successfully");
        			alert.setHeaderText(null);
        			alert.setContentText("Welcome "+ username.getText().toUpperCase());
        			alert.showAndWait();
        			count = 11;
        		
        		} else {
        			++count;
        		
        		}
      
    			} else {
    				++count;
    				
    			}  		
    		
      	


}
	if(count>=3 && count<10){
	Alert warning = new Alert(AlertType.INFORMATION);
	warning.setTitle("Too many failed attempts");
	warning.setContentText("Please contact your administration to unlock your account");
	warning.show();
	
}

}
}

