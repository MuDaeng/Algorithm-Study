package stepFirst;

public class AddtionAnotherNum {
	//받아온 1자리의 숫자중 없는 나머지 숫자들의 합을 구함
	public int solution(int[] numbers) {
		int result = 1+2+3+4+5+6+7+8+9;
		for(int num : numbers) {
			result -= num;
		}
		return result;
	}
}
