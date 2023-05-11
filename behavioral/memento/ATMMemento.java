package behavioral.memento;

import java.util.List;
import java.util.ArrayList;

class ATM
{
	private String cash;

	public void withdraw(String cash)
	{
		System.out.println("Withdrawing cash for you ..." + cash);
		this.cash = cash;
	}

	public Snapshot saveSnapshot()
	{
		System.out.println("Saving  snapshot... ");
		return new Snapshot(cash);
	}

	public void restoreFromMemento(Snapshot snapshot)
	{
		cash = snapshot.getBalance();
		System.out.println("Canceling withdraw, sending first amount: " + cash);
	}

	public static class Snapshot
	{
		private final String cash;

		public Snapshot(String cashToSave)
		{
			cash = cashToSave;
		}

		public String getBalance()
		{
			return cash;
		}
	}
}

class ATMMemento
{
	
	public static void main(String[] args)
	{
		
		List<ATM.Snapshot> balanceList = new ArrayList<ATM.Snapshot>();

		ATM atm = new ATM();

		//cash travel and record the eras
		atm.withdraw("1800$");
		balanceList.add(atm.saveSnapshot());
		atm.withdraw("100$");
		balanceList.add(atm.saveSnapshot());
		atm.withdraw("3400$");
		balanceList.add(atm.saveSnapshot());
		atm.withdraw("300$");
		balanceList.add(atm.saveSnapshot());
		atm.withdraw("2300$");

		atm.restoreFromMemento(balanceList.get(0));

	}
}
