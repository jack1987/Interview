/*recursion and backstrack delete

remeber to make new copy of object into result list, otherwise you will get all the same value*/

//http://www.mitbbs.com/article_t/JobHunting/32502465.html

// can treat as combination

import java.util.*;
import java.util.Map.Entry;

public class Recursion {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		dfs(res, temp, n, k, 1);
		return res;
	}

	void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int n,
			int k, int level) {
		if (temp.size() == k) {
			
			
			res.add(new ArrayList<Integer>(temp));
			//res.add(temp);
			
			return;
		}
		for (int i = level; i <= n; i++) {
			Integer obj = i;
			temp.add(obj);
			//res.add(new ArrayList<Integer>(temp));
			dfs(res, temp, n, k, i + 1);
			
			temp.remove(temp.size() - 1);
			//temp.remove(obj);
			//temp.remove(i);
			
			// 这个地方为什么要这样处理呢，

		}
	}

	public static void main(String[] args) {
		ArrayList<Map.Entry> result = new ArrayList<Map.Entry>();
		HashMap<String, StringBuilder> map = new HashMap<String, StringBuilder>();
		StringBuilder s1 = new StringBuilder("a");
		StringBuilder s2 = new StringBuilder("b");
		map.put("a", s1);
		map.put("b", s2);
		StringBuilder s3 = map.get("b");
		s3.append("test");
		for(Map.Entry en: map.entrySet()){
			result.add(en);
		}
		for(int i=0; i<result.size(); i++){
			System.out.println(result.get(i).getKey() + " Yahoo! " + result.get(i).getValue());
		}
		double good = Math.pow(2.0, 31);
		System.out.println(good + "*");
		Recursion test = new Recursion();
		ArrayList<ArrayList<Integer>> ar1 = test.combine(4, 4);
		for (ArrayList<Integer> t1 : ar1) {
			System.out.println(t1);
		}
	}
}