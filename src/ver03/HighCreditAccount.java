package ver03;

public class HighCreditAccount extends Account{
	
	int gradeAdd;

	public HighCreditAccount(String no, String owner, int balance, int add, int gradeAdd) {
		super(no, owner, balance,add);
		this.gradeAdd = gradeAdd;
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
	public int getGradeAdd() {
		return gradeAdd;
	}
	
	public void setGradeAdd(int gradeAdd) {
		this.gradeAdd = gradeAdd;
	}
	
	

	
}
