class Solution {
    int remainK, sequ, n;
    StringBuilder sb = new StringBuilder();
    boolean[] visited;
    int th = 0;
    String answer = "";
    
    public String getPermutation(int n, int k) {
        this.n = n;
        visited = new boolean[n+1];
        int term1 = 1;
        sequ = 0; // 가장 큰 자리수의 숫자
        
        // 자릿수의 숫자 정해짐에 따른 경우의수 팩토리얼 계산 
        for (int i = n-1; i >0; i--) {
            term1 *= i;
        }

        int cnt = 0; // 채워진 자리수
        int num = 0; // 묶음 
        
        // 가장 큰 자리부터 자리수의 숫자 구하기
        outer:
        while(true) {
            for (int i =1; i <= n; i++) { // 가능한 숫자 
                if (term1 * num > k) break outer;

                if (visited[i]) {
                    continue;
                }
                
                num++;
                if(term1 * num >= k) {
                    // System.out.println(num);
                    cnt++;
                    visited[i] = true;
                    sb.append(String.valueOf(i)); 
                    k -= (term1*(num-1));
                    
                    if (k == 1) {
                        for (int t = 1;t <= n; t++) {
                            if (visited[t]) continue;
                            sb.append(t);
                            visited[t] = true;
                        }
                        k = 0;
                        break outer;
                    }
                     // System.out.println(k);
                    if (n-cnt == 0) break outer;
                    term1 /= (n-cnt);
                    System.out.println("te: " + term1);
                    num = 0;
                    break;
                }
            }
            // System.out.println(sb);
        }



        if (k == 0) {
            answer = sb.toString();
        } else {
            back(cnt);
        }
        return answer;
    }
    
    public void back(int cnt) { 
        if (cnt == n) {
            th++;
            if (remainK == th) {
                answer = sb.toString();
                return;
            }
            return;
        }
        // System.out.println(n);
        for (int i = 1; i <=n; i++) {
            if (visited[i]) {
                continue;
            }
            
            sb.append(i);
            visited[i] = true;
            
            back(cnt+1);
            
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }
}