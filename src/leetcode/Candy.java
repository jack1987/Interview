//move from left to right, obey the rule, then reverse obeying the rule

package leetcode;
public class Candy {
	void printLoop(int start, int end) {
		System.out.println(start);
		if (start == end) return;
		printLoop(start + 1, end);
		System.out.println(start);
	}

    public static void main(String[] args){
    	Candy test = new Candy();
    	int Array1[] = new int[] {-4, -3, -2};
    	test.printLoop(1,10);
    }
}