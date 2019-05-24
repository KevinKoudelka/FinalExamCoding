package pkgHelper;

import java.util.Date;
import org.apache.poi.ss.formula.functions.*;

public class Payment{
	
	int PaymentID;
	Date DueDate;
	double IPMT;
	double PPMT;
	double TotalPrinciple;
	double Balance;
	private Loan l;
	
	
	public Payment(int paymentID, Date dueDate, double balance, Loan l) {
		PaymentID = paymentID;
		DueDate = dueDate;
		Balance = balance;
		this.l = l;
		this.PPMT = Math.abs(getPPMT());
		this.TotalPrinciple = this.PPMT +l.getAddPayments();
		this.IPMT = (balance)*(l.getInterestRate()/12);
		this.Balance=balance-this.TotalPrinciple;
		
	}
	public double getPPMT() {
		return Finance.ppmt(l.getInterestRate()/12, this.PaymentID, l.getTermYear()*12, l.getLoanAmount());
	}
	public double getBalance() {
		Balance = Math.round(Balance*100.0)/100.0;
		return Balance;
	}
	public void zeroBalance() {
		Balance = 0;
	}
	public double getIPMT() {
		return IPMT;
	}
	}

