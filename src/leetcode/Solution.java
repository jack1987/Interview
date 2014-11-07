package leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

public class Solution {
	public static void main(String[] args) {
		Solution test = new Solution();
		String test1 = "fuck you";
		String testrev = test1.toUpperCase();
		System.out.println( test1 + " " + testrev);
		String s = "aa";
		String t = "aa";
		System.out.println(test.minWindow(s, t));
	}

	public String minWindow(String S, String T) {
		if (S.length() < T.length())
			return "";
		HashMap<String, Integer> sMap = new HashMap<String, Integer>();
		HashMap<String, Integer> tMap = new HashMap<String, Integer>();
		for (int i = 0; i < T.length(); i++) {
			String tempString = T.substring(i, i + 1);
			if (tMap.containsKey(tempString))
				tMap.put(tempString, tMap.get(tempString) + 1);
			else
				tMap.put(tempString, 1);
		}

		for (Entry<String, Integer> entry : tMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());

		}

		int tSize = tMap.size();
		int sSize = 0;
		int start = 0, end = 0, startIdx = 0, endIdx = 0;
		int minLength = Integer.MAX_VALUE;

		while (end < S.length()) {
			while (sSize < tSize && end < S.length()) {
				int count = 0;
				int std;
				if (sMap.containsKey(S.substring(end, end + 1))) {
					count = sMap.get(S.substring(end, end + 1));
					sMap.put(S.substring(end, end + 1), count + 1);
				} else
					sMap.put(S.substring(end, end + 1), 1);

				if (tMap.containsKey(S.substring(end, end + 1))) {
					std = tMap.get(S.substring(end, end + 1));
					if (count + 1 == std)
						sSize++;
				}

				end++;
				// System.out.println(end);
			}

			while (sSize == tSize) {
				if (end - start < minLength) {

					minLength = end - start;
					startIdx = start;
					endIdx = end;
				}

				String temp = S.substring(start, start + 1);
				int count = sMap.get(temp);
				if (tMap.containsKey(temp)) {
					if (count == tMap.get(temp))
						sSize--;
				}
				sMap.put(temp, count - 1);
				start++;
				// System.out.println(start + "*");

			}

		}

		return minLength == 10000 ? "" : S.substring(startIdx, endIdx);

	}
}