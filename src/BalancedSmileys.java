/*
 * Your friend John uses a lot of emoticons when you talk to him on Messenger. In addition to being a person who likes to express himself through emoticons, he hates unbalanced parenthesis so much that it makes him go :(

Sometimes he puts emoticons within parentheses, and you find it hard to tell if a parenthesis really is a parenthesis or part of an emoticon.

A message has balanced parentheses if it consists of one of the following:

An empty string ""
One or more of the following characters: 'a' to 'z', ' ' (a space) or ':' (a colon)
An open parenthesis '(', followed by a message with balanced parentheses, followed by a close parenthesis ')'.
A message with balanced parentheses followed by another message with balanced parentheses.
A smiley face ":)" or a frowny face ":("
Write a program that determines if there is a way to interpret his message while leaving the parentheses balanced.
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class BalancedSmileys {

	private boolean isParenthese(char c) {
		return c == '(' || c == ')';
	}

	private boolean isNonParentheses(char c) {
		return (c >= 'a' && c <= 'z') || c == ' ' || c == ':';
	}

	private boolean isBalanced(String s, int left) {
		if (s.length() == 0 && left == 0)
			return true;
		else if (s.length() == 0)
			return false;

		boolean res = false;
		if (s.charAt(0) == ':' && s.length() > 1 && isParenthese(s.charAt(1)))
			res |= isBalanced(s.substring(2), left);
		if (s.charAt(0) == '(')
			res |= isBalanced(s.substring(1), left + 1);
		else if (s.charAt(0) == ')' && left > 0)
			res |= isBalanced(s.substring(1), left - 1);
		else if (isNonParentheses(s.charAt(0)))
			res |= isBalanced(s.substring(1), left);
		return res;
	}

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(
							"C:\\Users\\Jack\\Downloads\\balanced_smileys_example_input.txt"));
			int m = Integer.parseInt(br.readLine());
			BalancedSmileys b = new BalancedSmileys();
			for (int i = 1; i <= m; i++) {
				System.out.println("Case #" + i + ": "
						+ (b.isBalanced(br.readLine(), 0) ? "YES" : "NO"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}