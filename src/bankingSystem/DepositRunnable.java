package bankingSystem;

public class DepositRunnable implements Runnable {
	
	private BankAccount account;
	private double amount;
	private int count;
	private int delay = 1;
	
	public DepositRunnable(BankAccount account,double amount,int count){
		this.account = account;
		this.amount = amount;
		this.count = count;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			for ( int i = 0; i <= count; i++){
			
				//System.out.println("depositing....... $" + amount);
				account.deposit(amount);
				Thread.sleep(delay);
				//System.out.println("Now your balance is: " + account.getBalance());
			}
		}	
		catch(InterruptedException e){}
		
	
	}
}
