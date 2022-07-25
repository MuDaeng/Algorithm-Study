package algorithm;

public class ChangeStringToInteger {
	public static void main(String[] args) {
		String s = "one4seveneight";
		System.out.println(new ChangeStringToInteger().solution(s));
	}
    private static String[] numbersEng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public int solution(String s) {
        for(int i = 0; i < numbersEng.length; i++){
            if(s.contains(numbersEng[i])){
               s = s.replaceAll(numbersEng[i], String.valueOf(i));
            }
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}