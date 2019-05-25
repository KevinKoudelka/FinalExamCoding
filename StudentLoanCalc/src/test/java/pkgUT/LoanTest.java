package pkgUT;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import pkgHelper.Loan;

public class LoanTest {

	@Test
	public void LoanTest() {
		
		double loanAmount = 100000;
		double interestRate = .07;
		int term = 20;
		double extraPayment = 0;
		Date dueDate = Loan.parseDate("2019-07-04");
		boolean Compound = false;
		double futureValue = 0;
		
		Loan l = new Loan(loanAmount, interestRate, term, dueDate, extraPayment, futureValue, Compound);
	}
	@Test
	public void totalPrincipleTest() {
		Loan l = new Loan(1000.0, 0.07,20, Loan.parseDate("2019-07-04"),0,0,false);
		double total =l.getLoanAmount();
		assertTrue(total == 1000.0);
}
	@Test
	public void totalInterestTest() {
		Loan l = new Loan(1000.0, 0.07,1, Loan.parseDate("2019-07-04"),0,0,false);
		String total =l.getTotInterest();
		assertEquals(total,"38.32");
}
	@Test
	public void totalPaymentTest() {
		Loan l = new Loan(1000.0, 0.07,1, Loan.parseDate("2019-07-04"),0,0,false);
		String total =l.getTotPayment();
		assertEquals(total,"1038.32");
}
}
