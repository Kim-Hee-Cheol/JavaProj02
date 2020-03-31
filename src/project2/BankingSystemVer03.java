package project2;

import java.util.InputMismatchException;
import java.util.Scanner;
import ver03.MenuSelectException;
import ver03.AccountManager;
import ver03.MenuChoice;

public class BankingSystemVer03  implements MenuChoice{

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args){
		
		AccountManager manager = new AccountManager();
		while (true) {
			manager.showMenu();
			try {
				int selectNo = scanner.nextInt();
				if(selectNo>=1 && selectNo<=5)
					switch(selectNo) {
					case MenuChoice.MAKE:
						manager.makeAccount();
						break;
					case MenuChoice.DEPOSIT:
						manager.depositMoney();
						break;
					case MenuChoice.WITHDRAW:
						manager.withdrawMoney();
						break;
					case MenuChoice.INQUIRE:
						manager.showAccInfo();
						break;
					case MenuChoice.EXIT:
						System.out.println("프로그램을 종료합니다.");
						return;
				}
				else {
					throw new MenuSelectException("지정된 숫자만 입력하세요");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("숫자만 입력해주세요.");
			}
			catch(MenuSelectException e){
				System.out.println(e.getMessage());
			}
		}
	}
}
	
