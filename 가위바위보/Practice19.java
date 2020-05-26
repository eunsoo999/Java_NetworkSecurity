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
				return "����";
			else if(getCodeNum() ==  ROCK.CodeNum)
				return "����";
			else if(getCodeNum() == PAPER.CodeNum)
				return "��";
			else
				return "����";
		}
		
		public static Game encode(String input) {
			switch(input) {
				case "����" : 
					return Game.SCISSORS;
				case "����" : 
					return Game.ROCK;
				case "��" : 
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
				str = "����� �̰���ϴ�.";
				return str.toCharArray();
			case LOSE :
				str = "��ǻ�Ͱ� �̰���ϴ�.";
				return str.toCharArray();
			case EQUAL :
				str = "�����ϴ�.";
				return str.toCharArray();
			default :
				str = "������ �߻��߽��ϴ�. ������ϼ���.";
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
		
		System.out.println("��ǻ���� �Է� : " + com.decode());
		System.out.print("����� �Է� : ");
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
