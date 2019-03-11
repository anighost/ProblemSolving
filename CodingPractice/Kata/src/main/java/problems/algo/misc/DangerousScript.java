package problems.algo.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DangerousScript {

	final static Pattern PATTERN = Pattern.compile("^[a-z]{1}[a-z0-9:]*\\/[a-z0-9]+\\\\[a-z]+$");

	public static List<Integer> commandCount(List<String> commands) {
		// Write your code here
		List<Integer> commandCountList = new ArrayList<>();

		for (int i = 0; i < commands.size(); i++) {

			String str = commands.get(i);
			int count = 0;
			int length = str.length();

			for (int j = 0; j < length; j++) {
				for(int k = 5; k <= length - j; k++) {
					String sub = str.substring(j, j+k);
					if (!sub.contains("/")) {
						continue;
					}
					if (!sub.contains("\\")) {
						continue;
					}
					if (sub.length() < 5) {
						continue;
					}
					if(findRegexMatch(sub) ) {
						System.out.println(sub);
						count++;
					}
				}
			}		
			commandCountList.add(count);
		}

		return commandCountList;
	}

	private static boolean findRegexMatch(String str) {
		boolean isMatch = false;
		Matcher m = PATTERN.matcher(str);
		while (m.find()) {
			isMatch = true;
		}
		return isMatch;
	}
	public static void main(String[] args) {
		String str = "w:/a\\bc::/12\\xyz";
		System.out.println(str);
		List<String> strList = new ArrayList<String>();
		strList.add(str);

		List<Integer> intList = commandCount(strList);
		for (int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}

	}
}
