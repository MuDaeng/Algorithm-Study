package stepFirst;

public class NewIdTest {
	public static void main(String[] args) {
		String[] testcases = {"...!@BaT#*..y.abcdefghijklm.", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p"};
		System.out.println(new NewIdTest().solution(testcases[0]));
	}
	//정규표현식문제
    public String solution(String new_id) {
        new_id = new_id.toLowerCase().replaceAll("[^0-9a-z\\_\\-\\.]","")
            .replaceAll("\\.+",".");
        if(!new_id.isEmpty() && new_id.charAt(0) == '.'){
            new_id = new_id.substring(1);
        }
        new_id = removeLastDot(new_id);
        if(new_id.isEmpty()) {
        	new_id = "a";
        }
        if(new_id.length() > 15){
            new_id = removeLastDot(new_id.substring(0, 15));
        }
        while(new_id.length() < 3){
            new_id += new_id.charAt(new_id.length() - 1);
        }
        return new_id;
    }
    private String removeLastDot(String id){
        if(id.length() > 1 && id.charAt(id.length() - 1) == '.'){
            id = id.substring(0, id.length() - 1);
        }
        return id;
    }
}
