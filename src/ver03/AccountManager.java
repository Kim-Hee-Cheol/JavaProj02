package ver03;

import java.util.InputMismatchException;
import java.util.Scanner;
import ver03. CustomSpecialRate;;

public class AccountManager {
	static Account[] accountArray = new Account[50];
	static HighCreditAccount[] hcAccount = new HighCreditAccount[50];
	static Scanner scanner = new Scanner(System.in);
	
	
	public void showMenu() {
		System.out.println("1.계좌계설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	
	public void makeAccount() {
		
	
		
		System.out.println("--------");
		System.out.println("계좌선택");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		System.out.println("선택:");
		
		int choice =scanner.nextInt();
		
		scanner.nextLine();
		
	
		switch(choice) {
		case 1:
			System.out.print("계좌번호: ");
			String ino = scanner.next();
			
			System.out.print("계좌주: ");
			String iowner = scanner.next();
			
			System.out.print("잔고: ");
			int ibalance = scanner.nextInt();
			scanner.nextLine();

			System.out.print("기본이자%(정수형태로입력) : ");
			int iadd = scanner.nextInt();
			scanner.nextLine();

			for(int i=0; i<accountArray.length; i++) {
				if(accountArray[i] == null) {
					accountArray[i] = new NormalAccount(ino,iowner,ibalance,iadd);
					System.out.println("결과 : 계좌가 생성되었습니다.");
					break;
				}
					
			}
			break;
			
		case 2:
			System.out.print("계좌번호: ");
			String ino2 = scanner.next();
			
			System.out.print("계좌주: ");
			String iowner2 = scanner.next();
			
			System.out.print("잔고: ");
			int ibalance2 = scanner.nextInt();
			scanner.nextLine();

			System.out.print("기본이자%(정수형태로입력) : ");
			int iadd2 = scanner.nextInt();
			scanner.nextLine();
			
			System.out.print("신용등급(A,B,C등급): ");
			int credit=0;
			String grade = scanner.nextLine();
			switch(grade) {
			case "A":
				credit = 7;
				break;
			case "B":
				credit = 4;
				break;
			case "C":
				credit = 2;
				break;
			}
			for(int i=0; i<hcAccount.length; i++) {
				if(hcAccount[i] == null) {
					hcAccount[i] =
						new HighCreditAccount(ino2,iowner2,ibalance2,iadd2,credit);
					System.out.println("결과 : 계좌가 생성되었습니다.");
					break;
				}
			}
			break;	
		}
		
	}
	
	public void depositMoney() {
		System.out.println("--------");
		System.out.println("입금");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String no = scanner.next();
		scanner.nextLine();
		System.out.print("입금액: ");
		try {
			int dep = scanner.nextInt();
			
			if(dep%500!=0) {
				System.out.println("500원단위로 입금가능합니다.");
				depositMoney();
			}
			if(!(dep>=0)) {
				System.out.println("음수를 입금 할 수 없습니다.");
			}
			else {
				if(findAccount(no)==null) {
					if(findAccount2(no) == null) {
						System.out.println("입력한 계좌번호를 찾지 못했습니다.");
					}
					else {
						findAccount2(no).setBalance(findAccount2(no).getBalance()+
							findAccount2(no).getBalance()*
							findAccount2(no).getAdd()/100+
							findAccount2(no).getBalance()*
							findAccount2(no).getGradeAdd()/100+dep);
						System.out.println("입금완료");
					}
				}
				else { //일반계좌 계산
					findAccount(no).setBalance(findAccount(no).getBalance()+
							findAccount(no).getBalance()*
							findAccount(no).getAdd()/100+dep);
					System.out.println("입금완료");
				}
				
			}
		}
		catch(InputMismatchException e) {
			System.out.println("숫자만 입력하세요.");
		}
	}
	
	public void withdrawMoney() {
		System.out.println("--------");
		System.out.println("출금");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String no = scanner.next();
		
		System.out.print("출금액: ");
		try {
			int withd = scanner.nextInt();
			scanner.nextLine();
			if(!(withd%1000==0)) {
				System.out.println("1000원단위로만 출금가능합니다.");
				withdrawMoney();
			}
			if(!(withd>=0)) {
				System.out.println("음수를 출금할 수 없습니다.");
				withdrawMoney();
			}
			else {
				if(findAccount(no) == null) {
					if(findAccount2(no)==null) 
						System.out.println("입력한 계좌번호를 찾지 못했습니다.");
					
					else {
						if(withd > findAccount(no).getBalance()) {
							System.out.println("잔고가 부족합니다. 금액전체를 출금할까요? 1=(YES), 2=(NO)");
							int choice = scanner.nextInt();
							switch(choice) {
							case 1:
								findAccount(no).setBalance(findAccount(no).getBalance()-findAccount(no).getBalance());
								System.out.println("금액전체가 출급처리되었습니다.");
								break;
							case 2:
								findAccount(no).setBalance(findAccount(no).getBalance());
								System.out.println("출금요청이 취소되었습니다.");
								break;
							}
						}
						else {
							findAccount(no).setBalance(findAccount(no).getBalance()-withd);
							System.out.println("출금되었습니다.");
						}
					}
				}
				else {
					if(withd > findAccount(no).getBalance()) {
						System.out.println("잔고가 부족합니다. 금액전체를 출금할까요? 1=(YES), 2=(NO)");
						int choice = scanner.nextInt();
						switch(choice) {
						case 1:
							findAccount(no).setBalance(findAccount(no).getBalance()-findAccount(no).getBalance());
							System.out.println("금액전체가 출급처리되었습니다.");
							break;
						case 2:
							findAccount(no).setBalance(findAccount(no).getBalance());
							System.out.println("출금요청이 취소되었습니다.");
							break;
						}
					}
					else {
						findAccount(no).setBalance(findAccount(no).getBalance() - withd);
						System.out.println("출금되었습니다.");
					}
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println("숫자만 입력해주세요.");
		}
	}
	
	public void showAccInfo() {
		System.out.println("--------");
		System.out.println("계좌목록보기");
		System.out.println("--------");
		
		for(int i = 0; i < accountArray.length+hcAccount.length; i++) {
			if (accountArray[i] == null) {
				for(int s = 0; s<accountArray.length+hcAccount.length; s++) {
					if(hcAccount[s] == null) {
						break;
					}
					else {
						System.out.println("계좌번호: "+ hcAccount[s].getno());
						System.out.println("고객이름: "+ hcAccount[s].getowner());
						System.out.println("잔고: "+ hcAccount[s].getBalance());
						System.out.println("기본이자: "+ hcAccount[s].getAdd());
						System.out.print("신용등급: ");
						if(hcAccount[s].getGradeAdd()==7) {
							System.out.print("A");
						}
						else if(hcAccount[s].getGradeAdd()==4) {
							System.out.print("B");
						}
						else {
							System.out.print("C");
						}
					}
					System.out.println("");
				}
				break;
			}
			System.out.println("계좌번호: "+ accountArray[i].getno());
			System.out.println("고객이름: "+ accountArray[i].getowner());
			System.out.println("잔고: "+ accountArray[i].getBalance());
			System.out.println("기본이자 : "+ accountArray[i].getAdd());
			System.out.println("-------------------");
		
		
		}
		System.out.println("\n전체계좌정보 출력이 완료되었습니다.");
	}

	
	private Account findAccount(String no) {
		for(int i=0; i < accountArray.length; i++) {
			if(accountArray[i] == null) {
				break;
			}
			if (accountArray[i].getno().equals(no)) {
				return accountArray[i];
			}
		}
		return null;
	}
	public HighCreditAccount findAccount2(String no) {
		 for(int i=0;i<hcAccount.length;i++) {
		 	 if(hcAccount[i] == null) {
		 	 		break;
		 	}
		 	if(hcAccount[i].getno().equals(no)) {
		 	 	return hcAccount[i];
		 	}
		}
		return null;
	}
}