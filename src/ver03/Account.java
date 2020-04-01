package ver03;

public abstract class Account {
	
	private String no;
	private String owner;
	private int balance;
	private int add;
	
	public Account(String no,String owner, int balance, int add) {
		
		this.no = no;
		this.owner = owner;
		this.balance = balance;
		this.add = add;
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

	public int getAdd() {
		return add;
	}

	public void setAdd(int add) {
		this.add = add;
	}
	
	public void cal() {
		
	}
	
	
	
}
