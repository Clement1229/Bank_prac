package bankingSystem;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	
	private double balance;
	private Lock balanceChangeLock;
	private Condition sufficientFundsCondition;
	//public double amount;
	
	
	public BankAccount(){
		balance = 0;
		balanceChangeLock = new ReentrantLock();
		sufficientFundsCondition = balanceChangeLock.newCondition();
	
	}
	
	
	public void deposit(double amount){
		
		balanceChangeLock.lock();
		try{
			System.out.print("Depositing " + amount);
			double newBalance = balance + amount;
			System.out.println(" new balance is " + newBalance);
			balance = newBalance;
		}
		finally{
			balanceChangeLock.unlock();
		}
	}
	
	public void withdraw(double amount){
		balanceChangeLock.lock();
		try{
			while (balance < amount)
				sufficientFundsCondition.await();
			System.out.print("withdrawing " + amount);
			
			double NewBalance = balance - amount;
			System.out.println(" new balance is " + amount);
			balance = NewBalance;
		}
		catch(InterruptedException e){}
		finally{
			balanceChangeLock.unlock();
		}
	}
	
	public double getBalance(){
		return balance;
	}
}
