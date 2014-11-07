
import java.util.ArrayList;
import java.util.List;

public class CountArray {
	private int[] sol(int[] count) {
		int[] result = new int[count.length];
		List<Integer> a1 = new ArrayList<Integer>();
		for(int i = 0; i < count.length; i++){
			a1.add(i+1);
		}
		for (int i = 0; i < count.length; i++) {
			result[i] = a1.get(count[i]);
			a1.remove(count[i]);
		}
		return result;
	}
	
	public static void main(String[] args){
	    CountArray test1 = new CountArray();
	    int[] input = new int[]{2,0,1,0};
	    for(int i=0; i<4; i++){
	    System.out.print(input[i]+ " ");
	    }
	    System.out.println();
	    int[] output = new int[4];
	    System.out.println();
	    output = test1.sol(input);
	    for(int i=0; i<4; i++){
	    System.out.print(output[i]+ " ");
	    }
	    System.out.println();	    
	}
}