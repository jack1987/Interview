package leetcode;

import java.util.ArrayList;

public class PalindromePartition {
	public static void main(String[] args) {
		String s = "aabbaa";
		PalindromePartition test = new PalindromePartition(s);
		ArrayList<ArrayList<String>> ar1 = test.combine();
		for (ArrayList<String> t1 : ar1) {
			System.out.println(t1);
		}
	}

	String input;

	public PalindromePartition(String in) {
		this.input = in;
	}

	private boolean isPalin(String s) {
		int length = s.length();
		char[] arr = s.toCharArray();
		for (int i = 0; i < length / 2; i++) {
			if (arr[i] == arr[length - 1 - i])
				continue;
			else
				return false;
		}
		return true;
	}

	private ArrayList<ArrayList<String>> combine() {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> res = new ArrayList<String>();
		dfs(result, res, 0);
		return result;
	}

	private void dfs(ArrayList<ArrayList<String>> result,
			ArrayList<String> res, int level) {
		int length = input.length();
		

		if (level == length) {
			result.add(new ArrayList<String>(res));
			return;
		}

		for (int i = 1; i+level <= length; i++) {
			if (isPalin(input.substring(level, level + i))) {
				res.add(input.substring(level, level + i));
				dfs(result, res, level+i);
				res.remove(res.size() - 1);
			}

		}
	}
}