package bankingSystem;

public class BankAccountThreadRunner {
	
	public static void main(String [] args){
	
		
		BankAccount account = new BankAccount();
		final double amount = 100;
		final int count = 10;
		final int threads = 100;
		
		for(int i = 1 ; i <= 100; i++){
			
			DepositRunnable d = new DepositRunnable(account,amount,count);
			WithdrawRunnable w = new WithdrawRunnable(account,amount,count);
		
		Thread dt = new Thread(d);
		Thread wt = new Thread(w);
		dt.start();
		wt.start();
		}
	}

}
