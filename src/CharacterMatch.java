//http://www.mitbbs.com/article_t/JobHunting/32505211.html: Original Question

// discussion: http://www.mitbbs.com/article_t/JobHunting/32496747.html
/*
 * 3. ������⣺��һ����1�� 0 �� ?��ɵ��ַ������������е�matching strings�� ��
?�� ���� match 0 and 1, ����˵��
input : 1?? 
output: {100, 101, 110, 111}.


input: 100100?00?
output: {1001000000,1001000001,1001001000,1001001001}

��������������˵ݹ麯�����ݹ�call �����ַ����� substring(1, n)�����Ƿ��ֿ�
�临�Ӷ�̫���ˣ� ��Ϊÿ�εݹ麯�������Ժ� �Ҷ����½����µ�set, �ѵݹ鷵��
�� set��ÿһ���ַ�����append 1 or 0, or both(in case of ?), Ȼ��ӵ��µ� set
���档��
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