package Midterm;

public class Parse {
	public static void main(String[] args) {
		System.out.println(new PostfixProcessor("5 7 8 * +"));
		System.out.println(new PostfixProcessor("5 7 8 + *"));
		System.out.println(new PostfixProcessor("5 7 + 8 *"));
		System.out.println(new PostfixProcessor("1 2 + 3 4 + 5 6 * 2 * * +"));
		System.out.println(new PostfixProcessor("9 7 8 * -"));
	}
}


// 5 + 7 * 8 = * + 5 7 8