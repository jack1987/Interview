//http://www.mitbbs.com/article_t/JobHunting/32505211.html: Original Question

// discussion: http://www.mitbbs.com/article_t/JobHunting/32496747.html
/*
 * 3. 编程问题：给一个由1， 0 和 ?组成的字符串，返回所有的matching strings， “
?” 可以 match 0 and 1, 比如说：
input : 1?? 
output: {100, 101, 110, 111}.


input: 100100?00?
output: {1001000000,1001000001,1001001000,1001001001}

关于这个，我用了递归函数，递归call 输入字符串的 substring(1, n)，但是发现空
间复杂度太大了， 因为每次递归函数返回以后， 我都重新建立新的set, 把递归返回
的 set中每一个字符串，append 1 or 0, or both(in case of ?), 然后加到新的 set
里面。。
 */
import java.util.*;

public class CharacterMatch {

    // use recursion to solve this question
    public ArrayList<String> findMatch(String testCase) {
        ArrayList<String> res = new ArrayList<String>();
        if (testCase == null || testCase.length() == 0) {
            return res;
        }

        // if the testCase do not contain the ? character, then just return the original string
        if (!testCase.contains("?")) {
            res.add(testCase);
            return res;
        }

        // do recusion, kind of depth first search
        findMatch(testCase, 0, "", res);

        return res;
    }

    public void findMatch(String testCase, int index, String re, ArrayList<
String> res) {
        // if index equals to the length of the testCase
        if (index == testCase.length()) {
            res.add(re);
            return;
        }

        // current character
        char cur = testCase.charAt(index);
        if (cur != '?') {
            findMatch(testCase, index + 1, (re + testCase.substring(index, 
index + 1)), res);
        } else {
            // two actions, substitute the ? with 1 and 0
            findMatch(testCase, index + 1, (re + "0"), res);
            findMatch(testCase, index + 1, (re + "1"), res);
        }
    }

    public static void main(String[] args) {
        String[] cases = {"1??", "100100?00?", "adg?b?dd?g"};
        // result
        // test case 1 : {100, 101, 110, 111}.
        // test case 2 : {1001000000,1001000001,1001001000,1001001001}
        CharacterMatch matcher = new CharacterMatch();
        for (String ca : cases) {
            System.out.println("TEST CASE : " + ca);
            ArrayList<String> res = matcher.findMatch(ca);
            System.out.println(res);
            System.out.println("\n\n");
        }

    }

}