import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Assignment4 extends Application {
	private String inputPassword;
	private String inputFirmPassword;
	//https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html lists how to use a 
			//JComboBox, but I can't figure out how to change my program to that
	        //Also changing user.ignoreCase would be nice, I can't figure if its correct.

	/**
	 * Author, PriestofTuna 
	 * date: 11/4/15
	 * Purpose:
	 * to create accounts for Tuna.net services
	 * 
	 */

	public static void main(String[] args) {
		launch(args);
	}

	// Account was here

	@Override
	public void start(Stage primaryStage) {
		Label UserLbl = new Label("Username");
		Label PassLbl = new Label("Password");
		Label AccountLbl = new Label("Accounts");
		Label FiNameLbl = new Label("First name");
		Label LaNameLbl = new Label("Last name");
		Label EmailLbl = new Label("Email");
		Label FirmPassLbl = new Label("Confirm password");
		//included in profile to make it easy to change profile da
		Button signUp = new Button("Sign up");

		primaryStage.setTitle("Account creator");
		TextField UserTxt = new TextField();
		PasswordField PassTxt = new PasswordField();
		PasswordField FirmPassTxt = new PasswordField();
		TextField fiNameTxt = new TextField();
		TextField laNameTxt = new TextField();
		TextField emailTxt = new TextField();
		
		
		final ComboBox acomboBox = new ComboBox();
		acomboBox.getItems().addAll(enums.values());
		enums Account = null;
		acomboBox.setValue(enums.Guest);
		
		
		// The below "input" based variables are to gain the values of the
		// user's information
		signUp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String inputUser, inputfiName, inputlaName, inputEmail;
				enums inputAccount;
				// inputPassword was previously a string, inputFirmPassword was
				// previously a String above
				inputPassword = PassTxt.getText();
				inputFirmPassword = FirmPassTxt.getText();

				inputUser = UserTxt.getText();
				
				
				inputAccount = (enums) acomboBox.getValue();
								
				
				inputfiName = fiNameTxt.getText();
				inputlaName = laNameTxt.getText();
				inputEmail = emailTxt.getText();

				Account asdf = new Account(inputfiName, inputlaName, inputEmail, inputUser,  inputFirmPassword, inputAccount,
						 inputPassword);
				//asdf is the account created by the constructors
				inputUser.equalsIgnoreCase(inputUser);
				
				String pattern = "\\w+@\\w+\\.\\w+";
				String patternPass = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,64}"; 
				

				if (inputPassword.equals(inputFirmPassword)) {
					PassTxt.setStyle("-fx-border-color: white;");
					FirmPassTxt.setStyle("-fx-border-color: white;");

				} else {
					PassTxt.setStyle("-fx-border-color: red;");
					FirmPassTxt.setStyle("-fx-border-color: red;");
					PassLbl.setText("Invalid password, passwords must match");
					FirmPassLbl.setText("invalid password, passwords must match");
					
				}
				if(inputPassword.matches(patternPass)) {
					
				}else {
					PassTxt.setStyle("-fx-border-color: red;");
					FirmPassTxt.setStyle("-fx-border-color: red;");
					PassLbl.setText("at least 8 char, use special chars");
				}

				if (inputUser.isEmpty()) {
					UserTxt.setStyle("-fx-border-color: red;");
					UserLbl.setText("invalid username");
				} else {
					UserTxt.setStyle("-fx-border-color: white;");
				}
				if (inputPassword.isEmpty()) {
					PassTxt.setStyle("-fx-border-color: red;");
				PassLbl.setText("Password is required");
				}

				if (inputFirmPassword.isEmpty()) {
					FirmPassTxt.setStyle("-fx-border-color: red;");
				    FirmPassLbl.setText("Password confirmation required");
				}

				
				if (inputfiName.isEmpty()) {
					fiNameTxt.setStyle("-fx-border-color: red;");
					FiNameLbl.setText("enter your first name");;
				} else {
					fiNameTxt.setStyle("-fx-border-color: white;");
				}
				if (inputlaName.isEmpty()) {
					laNameTxt.setStyle("-fx-border-color: red;");
				    LaNameLbl.setText("enter your last name");
				} else {
					laNameTxt.setStyle("-fx-border-color: white;");
				}
				if (inputEmail.isEmpty()) {
					emailTxt.setStyle("-fx-border-color: red;");
				    EmailLbl.setText("Enter your email");
				} else {
					emailTxt.setStyle("-fx-border-color: white;");
				}
				if (inputEmail.matches(pattern)) {
					emailTxt.setStyle("-fx-border-color: white;");
				}else {
					emailTxt.setStyle("-fx-border-color: red;");
				}
				
				

				if (inputPassword.equals(inputFirmPassword) && inputEmail.matches(pattern)) {
					JOptionPane.showMessageDialog(null,"Your account is " + inputUser);
				}

			}
		});

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);

		grid.add(UserLbl, 0, 0);
		grid.add(UserTxt, 1, 0);
		grid.add(PassLbl, 0, 2);
		grid.add(PassTxt, 1, 2);
		grid.add(FirmPassLbl, 0, 3);
		grid.add(FirmPassTxt, 1, 3);
		grid.add(AccountLbl, 0, 4);
		grid.add(acomboBox, 1, 4);
		// Needs to use a drop down list for comboBox
		grid.add(FiNameLbl, 0, 5);
		grid.add(fiNameTxt, 1, 5);
		grid.add(LaNameLbl, 0, 6);
		grid.add(laNameTxt, 1, 6);
		grid.add(EmailLbl, 0, 7);
		grid.add(emailTxt, 1, 7);
		grid.add(signUp, 1, 8);
		Scene scene = new Scene(grid, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
