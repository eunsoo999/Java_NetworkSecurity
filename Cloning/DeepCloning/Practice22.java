import java.util.Scanner;

public class Practice22 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner sc = new Scanner(System.in);
		Diary diary = new Diary();
		Diary shallowDiary = (Diary) diary.clone();
		
		System.out.println("Original Array:\n" + diary.toString());
		System.out.println("Cloned Array:\n" + shallowDiary.toString());
		
		System.out.print("\n�����ϰ� ���� �迭�� �����ϼ���(1-original/2-cloned): ");
		int answer_update = sc.nextInt();
		System.out.print("�����ϰ� ���� ��¥�� �ε����� �Է��ϼ���: ");
		int answer_index = sc.nextInt();
		System.out.print("�⵵: ");
		int input_year = sc.nextInt();
		System.out.print("��: ");
		int input_month = sc.nextInt();
		System.out.print("��: ");
		int input_date = sc.nextInt();
		
		if (answer_update == 1) {
			diary.getListOfDates()[answer_index] = new Date(input_year, input_month, input_date);
		}
		else if (answer_update == 2) {
			shallowDiary.getListOfDates()[answer_index] = new Date(input_year, input_month, input_date);
		}
		
		System.out.println("\nOriginal Array:\n" + diary.toString());
		System.out.println("Cloned Array:\n" + shallowDiary.toString());
	}
}

