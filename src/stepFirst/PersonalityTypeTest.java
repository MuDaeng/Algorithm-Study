package stepFirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PersonalityTypeTest {
	public String solution(String[] survey, int[] choices) {
		List<Map<String, Integer>> persTypesList = personalityTypesInitialize(new ArrayList<Map<String,Integer>>());
		return testPersonalityType(persTypesList, survey, choices)
				.getPersonalityTypeResult(persTypesList);
	}
	
	private List<Map<String, Integer>> personalityTypesInitialize(List<Map<String, Integer>> types) {
		Type[] typesEnum = Type.values();
		for (Type type : typesEnum) {
			Map<String, Integer> persType = new HashMap<String, Integer>();
			for (char personal : type.name().toCharArray()) {
				persType.put("" + personal, 0);
			}
			types.add(persType);
		}
		return types;
	}
	private PersonalityTypeTest testPersonalityType(List<Map<String, Integer>> persTypesList, String[] survey,
			int[] choices){
		for(int i = 0; i < survey.length; i++) {
			testSurvey(persTypesList, survey[i], choices[i]);
		}
		return new PersonalityTypeTest();
	}
	private void testSurvey(List<Map<String, Integer>> persTypesList, String survey,
			int choice) {
		int standardScore = 4;
		char[] persTypes = survey.toCharArray();
		int choiceStandard = 0;
		if (choice > 4) {
			choiceStandard = 1;
		}
		char[] surveyCharArr = survey.toCharArray();
		Arrays.sort(surveyCharArr);
		String surveySorted = new String(surveyCharArr);
		int typeIndex = Type.valueOf(surveySorted).ordinal();
		Map<String,Integer> curPersType = persTypesList.get(typeIndex);
		curPersType.put("" + persTypes[choiceStandard],
				curPersType.get("" + persTypes[choiceStandard]) + Math.abs(choice - standardScore));
	}
	private String getPersonalityTypeResult (List<Map<String, Integer>> persTypesList) {
		String result = "";
		for(Map<String, Integer> persType : persTypesList) {
			int score = 0;
			String type = "";
			for(Entry<String, Integer> entry : persType.entrySet()) {
				if(entry.getValue() > score || type.equals("")) {
					type = entry.getKey();
					score = entry.getValue();
				}
			}
			result += type;
		}
		return result;
	}
}
enum Type {
	RT, CF, JM, AN;
}