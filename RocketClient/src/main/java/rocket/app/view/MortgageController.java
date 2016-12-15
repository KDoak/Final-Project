package rocket.app.view;

import eNums.eAction;
import exceptions.RateException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)

	@FXML
	private Label Income;
	@FXML
	private Label Expenses;
	@FXML
	private Label CreditScore;
	@FXML
	private Label HouseCost;

	@FXML
	private Label Term;
	@FXML
	private TextField txtIncome;
	@FXML
	private TextField txtExpenses;
	@FXML
	private TextField txtCreditScore;
	@FXML
	private TextField txtHouseCost;
	@FXML
	private ComboBox<String> cmbTerm;
	@FXML
	private Button calculate;
	@FXML 
	private Label MortgagePayment;
	@FXML 
	private Label Error;
	@FXML 
	private Label ErrorWarning;
	@FXML
	private Label lblMortgagePayment;
	
	
	@FXML
	private void cmbBox() {
		cmbTerm.getItems().add("15 Years");
		cmbTerm.getItems().add("30 Years");
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		//	TODO - RocketClient.RocketMainController
		try{
			lq.setdRate(RateBLL.getRate(lq.getiCreditScore()));
		}
		catch (RateException e){
			lq.setdRate(0);
			ErrorWarning.setText("Invalid Credit Score");
		}
		if (cmbTerm.getValue()=="15 Years") {
			lq.setiTerm(15*12);
		}
		else if(cmbTerm.getValue() == "30 Years") {
			lq.setiTerm(30*12);
		}
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		lq.setiDownPayment(Integer.parseInt(txtHouseCost.getText()));
		
		lq.setdIncome(Double.parseDouble(txtIncome.getText()));
		lq.setdExpenses(Double.parseDouble(txtExpenses.getText()));
		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		double Payment = lRequest.getdPayment();
		if (Payment<= 0.36*(lRequest.getdIncome()/12) && Payment <= 0.28*(lRequest.getdIncome()/12 - lRequest.getdExpenses())) {
			System.out.format("%.2f", Payment);
	}
}}
