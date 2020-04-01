package ver03;


public class NormalAccount extends Account{

	public NormalAccount(String no, String owner, int balance, int add) {
		super(no, owner, balance, add);

	}
	@Override
	public String getno() {
		
		return super.getno();
	}
	@Override
	public void setno(String no) {
		
		super.setno(no);
	}
	@Override
	public int getAdd() {
		
		return super.getAdd();
	}
	@Override
	public void setAdd(int add) {
		
		super.setAdd(add);
	}

	@Override
	public int getBalance() {
	
		return super.getBalance();
	}
	@Override
	public void setBalance(int balance) {
	
		super.setBalance(balance);
	}
	
	@Override
	public String getowner() {
		
		return super.getowner();
	}
	
	@Override
	public void setowner(String owner) {
		
		super.setowner(owner);
	}
	
	
}
