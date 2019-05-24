package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgHelper.Loan;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField InterestRate;
	@FXML
	private TextField termYear;
	@FXML
	private Label lbTotalPayments;

	@FXML
	private TextField AddPayments;
	
	@FXML
	private DatePicker PaymentStartDate;
	@FXML
	private Label lblTotalInterest;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		System.out.println("Amount: " + LoanAmount.getText());
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Amount: " + dLoanAmount);	
		double interestRate = Double.parseDouble(InterestRate.getText());
		int term = Integer.parseInt(termYear.getText());
		LocalDate localDate = PaymentStartDate.getValue();
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
		double extraPayment = Double.parseDouble(AddPayments.getText());
		boolean Compound = true;
		double fV = 0;
		
		Loan myLoan = new Loan(dLoanAmount, interestRate, term, date, extraPayment, fV, Compound);
		lbTotalPayments.setText(myLoan.getTotPayment());
		lblTotalInterest.setText(myLoan.getTotInterest());
		
		System.out.println(localDate);
	}
}
