package leetcode;
public class WildMatch {
    public String countAndSay(int n) {
        if(n==1) return "1";
        if(n<=0) return null;
        StringBuilder res = new StringBuilder("1");
        while(n-->1){
        	System.out.println("test");
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for(int i = 1; i<res.length(); i++){
                while(i<res.length() && res.charAt(i) == res.charAt(i-1)){
                    i++;
                    count++;
                }
                System.out.println(count + "*");
                temp.append(count);
                
                temp.append(res.charAt(i-1));
                System.out.println("this is temp: " +  temp.toString());
                count = 1;
            }

                res = temp;
            
        }
        return res.toString();
    }
    
    public static void main(String[] args){
    	WildMatch test = new WildMatch();
    	System.out.println(test.countAndSay(4));
    }
}