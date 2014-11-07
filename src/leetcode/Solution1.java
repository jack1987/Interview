package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(Arrays.asList("a", "aa", "aaa"));
		list.remove(0);
		System.out.println("*"+ list);
		Set<String> dict = new TreeSet<String>(list);
		Solution1 test = new Solution1();
		System.out.println(test.wordBreak(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaasss", dict));

	}

	public boolean wordBreak(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		Hashtable<String, Boolean> memo = new Hashtable<String, Boolean>();
		return wordBreak1(s, dict, memo);
	}

	public boolean wordBreak1(String s, Set<String> dict,
			Hashtable<String, Boolean> memo) {
		if (dict.contains(s) || memo.contains(s))
			return true;
		for (int i = 1; i < s.length(); i++) {
			System.out.println(i);
			String prefix = s.substring(0, i);
			if (dict.contains(prefix)) {
				memo.put(prefix, true);
				String postfix = s.substring(i, s.length());
				if (wordBreak1(postfix, dict, memo))
					return true;
			}
		}
		return false;
	}
}