import java.util.Scanner;

public class TestingScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. Load All User's ListenKeys \n 2. Load by user id");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
	    switch (input) {
		case "1": {
			
			System.out.println("1111");;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + input);
		}
	}

}
