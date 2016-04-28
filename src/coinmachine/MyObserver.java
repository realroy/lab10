package coinmachine;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {

	/*public static void main(String[] args) {
		CoinMachine subject = new CoinMachine(10);
		MyObserver myobserver = new MyObserver();
		subject.addObserver(myobserver);
		subject.insert(new Coin(5));
		myobserver.update(subject, new Object());
	}*/

	@Override
	public void update(Observable subject, Object info) {
		System.out.println("Update: " + ((CoinMachine)subject).getBalance());

	}
	
}
