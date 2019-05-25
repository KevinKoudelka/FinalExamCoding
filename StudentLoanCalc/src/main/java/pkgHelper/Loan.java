package pkgHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Loan {
	double LoanAmount;
	double InterestRate;
	int TermYear;
	Date DueDate;
	double AddPayments;
	double DutureValue;
	boolean Compounds;
	private double FutureValue = 0;
	
	private LinkedList<Payment> LoanPayments = new LinkedList<Payment>();

	public Loan(double loanAmount, double interestRate, int termYear, Date dueDate, double addPayments,
			double futureValue, boolean compounds) {
		super();
		LoanAmount = loanAmount;
		InterestRate = interestRate;
		TermYear = termYear;
		DueDate = dueDate;
		AddPayments = addPayments;
		FutureValue = futureValue;
		this.Compounds = compounds;
		
		double dRollingBalance = this.LoanAmount;
		int iPaymentNbr = 0;
		
		do {
			Payment p = new Payment(++iPaymentNbr, dueDate, dRollingBalance, this);
			
			LoanPayments.add(p);
			dRollingBalance = p.getBalance();
			
			System.out.print("Payment Nbr ");
			System.out.print(iPaymentNbr);
			System.out.print(" ");
			System.out.println(LoanPayments.getLast().getBalance());
			
			if(LoanPayments.getLast().getBalance() <= 0) {
				LoanPayments.getLast().zeroBalance();
				break;
			}
		}
		while (true);
		System.out.println(LoanPayments.size());
			}

	public double getLoanAmount() {
		return LoanAmount;
	}

	public double getInterestRate() {
		return InterestRate;
	}

	public int getTermYear() {
		return TermYear;
	}



	public double getAddPayments() {
		return AddPayments;
	}

	public double getFutureValue() {
		return FutureValue;
	}

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
			
		} catch (ParseException e) {
			return null;
		}
	}
	public String getTotPayment() {
		double sum = 0;
		for (Payment p: LoanPayments) {
			sum +=p.getIPMT();
		}
		return ""+ Math.round((sum+LoanAmount)*100.0)/100.0;
	}
	public String getTotInterest() {
		double sum = 0;
		for (Payment p: LoanPayments) {
			sum +=p.getIPMT();
		}
		return ""+ Math.round((sum*100.0))/100.0;
	}
	
}



