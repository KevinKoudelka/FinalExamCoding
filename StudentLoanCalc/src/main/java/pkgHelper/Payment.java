package pkgHelper;

import java.util.Date;
import org.apache.poi.ss.formula.functions.*;

public class Payment{
	
	int paymentID;
	Date dueDate;
	double IPMT;
	double PPMT;
	double totalPrinciple;
	double balance;
	Loan l;
	
	
	public Payment(int paymentID, Date dueDate, double balance, Loan l) {
		super();
		paymentID = paymentID;
		dueDate = dueDate;
		balance = balance;
		this.l = l;
		this.PPMT = getPPMT();
		this.totalPrinciple = this.PPMT +l.getAddPayments();
		this.IPMT = (balance)*((l.getInterestRate())/12);
		
	}
	public double getPPMT() {
		return Finance.ppmt(l.getInterestRate()/12, this.paymentID, (int) (l.getTermYear()*12), l.getLoanAmount());
	}
	public double getBalance() {
		balance = Math.round(balance*100.0)/100.0;
		return balance;
	}
	public void zeroBalance() {
		balance = 0;
	}
	}

