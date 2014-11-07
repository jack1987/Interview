public class NeedleSearch {

	private final static char[] needle1 = "hdffi".toCharArray();
	
	private final static char[] needle2 = "lfl".toCharArray();
	
	private final static char[] needle3 = "ahw".toCharArray();

	private final static char[] needle4 = "sddl".toCharArray();

	private final static NeedleSearch search = new NeedleSearch(new char[][] {
			"hhydsfd".toCharArray(), "sdflddl".toCharArray(),
			"dfdfd".toCharArray(), "dfdl".toCharArray(),
			"uifddffdhc".toCharArray() });

	private final char[][] haystack;

	public NeedleSearch(char[][] haystack) {
		this.haystack = haystack;
		System.out.println(1<<4);
		System.out.println(haystack[4].length);
	}

	public static void main(String[] args) {
		
		System.out.println((search.find(needle1) ? "Yes" : "No") + " Found!!");
		System.out.println((search.find(needle2) ? "Yes" : "No") + " Found!!");
		System.out.println((search.find(needle3) ? "Yes" : "No") + " Found!!");
		System.out.println((search.find(needle4) ? "Yes" : "No") + " Found!!");
	}

	public boolean find(char[] niddle) {
		for (int j = 0; j < haystack.length - niddle.length + 1; j++) {
			for (int k = 0; k < haystack[j].length - niddle.length + 1; k++) {
				if (findInLine(j, k, 1, 0, niddle, 0)
						|| findInLine(j, k, 0, 1, niddle, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	protected boolean findInLine(int x, int y, int moveDown, int moveRight,
			char[] niddle, int i) {
		if (niddle.length == i) {// found needle, end of recursion
			return true;
		}

		if (x >= haystack.length || y >= haystack[x].length) { // reached edge,
																// end of
																// recursion
			return false;
		}

		if(haystack[x][y] == niddle[i])
			return findInLine(x + moveDown, y + moveRight, moveDown, moveRight,
					niddle, i + 1);
		return false;
		/*return haystack[x][y] == niddle[i]
				&& findInLine(x + moveDown, y + moveRight, moveDown, moveRight,
						niddle, i + 1);// dig deeper
*/	}

}