package pkgHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Loan {
	double LoanAmount;
	double InterestRate;
	int termYear;
	Date dueDate;
	double AddPayments;
	double futureValue;
	boolean Compounds;
	
	private LinkedList<Payment> loanPayments = new LinkedList<Payment>();

	public Loan(double loanAmount, double interestRate, int termYear, Date dueDate, double addPayments,
			double futureValue, boolean compounds) {
		super();
		LoanAmount = loanAmount;
		InterestRate = interestRate;
		this.termYear = termYear;
		this.dueDate = dueDate;
		AddPayments = addPayments;
		this.futureValue = futureValue;
		Compounds = compounds;
		this.loanPayments = loanPayments;
		double dRollingBalance = this.LoanAmount;
		int iPaymentNbr = 0;
		
		do {
			Payment p = new Payment(++iPaymentNbr, dueDate, dRollingBalance, this);
			
			loanPayments.add(p);
			dRollingBalance = p.getBalance();
			
			System.out.print("Payment Nbr ");
			System.out.print(iPaymentNbr);
			System.out.print(" ");
			System.out.println(loanPayments.getLast().getBalance());
			
			if(loanPayments.getLast().getBalance() <= 0) {
				loanPayments.getLast().zeroBalance();
				break;
			}
		}
		while (true);
		System.out.println(loanPayments.size());
			}

	public double getLoanAmount() {
		return LoanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		LoanAmount = loanAmount;
	}

	public double getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}

	public double getTermYear() {
		return termYear;
	}

	public void setTermYear(int termYear) {
		this.termYear = termYear;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public double getAddPayments() {
		return AddPayments;
	}

	public void setAddPayments(double addPayments) {
		AddPayments = addPayments;
	}

	public double getFutureValue() {
		return futureValue;
	}

	public void setFutureValue(double futureValue) {
		this.futureValue = futureValue;
	}

	public boolean getCompounds() {
		return Compounds;
	}

	public void setCompounds(boolean compounds) {
		Compounds = compounds;
	}

	public LinkedList<Payment> getLoanPayments() {
		return loanPayments;
	}

	public void setLoanPayments(LinkedList<Payment> loanPayments) {
		this.loanPayments = loanPayments;
	}
	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
			
		} catch (ParseException e) {
			return null;
		}
	}
	
}



