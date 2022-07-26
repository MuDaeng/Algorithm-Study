package stepFirst;

public class GetMiddleChars {
	public static void main(String[] args) {
		System.out.println(new GetMiddleChars().solution("qwer"));	
	}
	public String solution(String s) {
		int middleLength = s.length() / 2;
		if(s.length() % 2 == 0) {
			return s.substring(middleLength - 1, middleLength + 1);
		}else {
			return s.substring(middleLength, middleLength + 1);
		}
	}
}
