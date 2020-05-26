import java.util.Random;
import java.util.Scanner;

public class Practice19 {

	public enum Game {
		ROCK(0), PAPER(1), SCISSORS(2), ERROR(-1);
		
		Game(int num) {
			CodeNum = num;
		}
		
		int CodeNum;
		public int getCodeNum() {
			return CodeNum;
		}

		public String decode() {
			if(getCodeNum() ==  SCISSORS.CodeNum)
				return "가위";
			else if(getCodeNum() ==  ROCK.CodeNum)
				return "바위";
			else if(getCodeNum() == PAPER.CodeNum)
				return "보";
			else
				return "에러";
		}
		
		public static Game encode(String input) {
			switch(input) {
				case "가위" : 
					return Game.SCISSORS;
				case "바위" : 
					return Game.ROCK;
				case "보" : 
					return Game.PAPER;
		}
			return Game.ERROR;
	}
		
		public static Game getCode(int num) {
			for (Game g : Game.values()) {
				if(g.CodeNum == num) {
					return g;
				}
			}
			return Game.ERROR;
		}
		
	}
	
	public enum Score {
		WIN, LOSE, EQUAL;

		public static char[] print(Score rslt) {
			String str = "";
			
			switch(rslt) {
			case WIN :
				str = "당신이 이겼습니다.";
				return str.toCharArray();
			case LOSE :
				str = "컴퓨터가 이겼습니다.";
				return str.toCharArray();
			case EQUAL :
				str = "비겼습니다.";
				return str.toCharArray();
			default :
				str = "오류가 발생했습니다. 재시작하세요.";
				return str.toCharArray();	
			}
		}
	}
	
	static Score[][] scoreBoard = {
			{Score.EQUAL, Score.LOSE, Score.WIN},
			{Score.WIN, Score.EQUAL, Score.LOSE},
			{Score.LOSE, Score.WIN, Score.EQUAL}
	};
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random random = new Random();
		
		Game com = Game.getCode(random.nextInt(3));
		
		System.out.println("컴퓨터의 입력 : " + com.decode());
		System.out.print("당신의 입력 : ");
		String yourInput = s.next();
		
		Game userCode = Game.encode(yourInput);
		
		Score rslt = whoswin(userCode, com);
		System.out.println(Score.print(rslt));
		
		s.close();
	}

	private static Score whoswin(Game user, Game com) {
		return scoreBoard[user.getCodeNum()][com.getCodeNum()];
	}
}
