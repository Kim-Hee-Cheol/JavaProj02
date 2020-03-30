package ver02;

public class NormalAccount extends Account{
	
	double INTEREST_RATE = 0.02;

	public NormalAccount(String no, String owner, int balance,
			double iNTEREST_RATE) {
		super(no, owner, balance);
		INTEREST_RATE = iNTEREST_RATE;
	}
	
	//보통예금계좌
	public void Normal () {
		int normalAccount =
				balance + (balance * INTEREST_RATE) + dep;
	}
	
	
	
}
