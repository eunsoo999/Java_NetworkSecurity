import java.util.Scanner;

public class Practice22 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner sc = new Scanner(System.in);
		Diary diary = new Diary();
		Diary shallowDiary = (Diary) diary.clone();
		
		System.out.println("Original Array:\n" + diary.toString());
		System.out.println("Cloned Array:\n" + shallowDiary.toString());
		
		System.out.print("\n변경하고 싶은 배열을 선택하세요(1-original/2-cloned): ");
		int answer_update = sc.nextInt();
		System.out.print("변경하고 싶은 날짜의 인덱스를 입력하세요: ");
		int answer_index = sc.nextInt();
		System.out.print("년도: ");
		int input_year = sc.nextInt();
		System.out.print("월: ");
		int input_month = sc.nextInt();
		System.out.print("일: ");
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

