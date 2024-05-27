class Solution {
    public String orderlyQueue(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        String result = new String(temp);
        
        String s1 = s;
        
        if (k == 1) {
            String cal = s;
            for (int i = 0; i < s.length(); i++) {
                String str = "";
                str = s1.substring(1, s.length());
                str += Character.toString(s1.charAt(0));
                
                if (str.compareTo(cal) < 0) cal = str;
                s1 = str;
                System.out.println(str);
            }
            result = cal;
        }
        
        return result;
    }
}