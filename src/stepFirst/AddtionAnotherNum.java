package stepFirst;

public class AddtionAnotherNum {
	//�޾ƿ� 1�ڸ��� ������ ���� ������ ���ڵ��� ���� ����
	public int solution(int[] numbers) {
		int result = 1+2+3+4+5+6+7+8+9;
		for(int num : numbers) {
			result -= num;
		}
		return result;
	}
}
