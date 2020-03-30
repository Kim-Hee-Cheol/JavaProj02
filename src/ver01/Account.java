package ver01;

public class Account {
	
	private String no;
	private String owner;
	private int balance;
	
	public Account(String no,String owner, int balance) {
		
		this.no = no;
		this.owner = owner;
		this.balance = balance;
	}

	public String getno() {
		return no;
	}

	public void setno(String no) {
		this.no = no;
	}
	
	public String getowner() {
		return owner;
	}

	public void setowner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
