class Solution {
    public boolean isVowel(char ch){
        return ch =='a' || ch =='A' || ch=='e' || ch=='E'  || ch =='i' || ch=='I' || ch=='o'
        || ch =='O' || ch=='u' || ch=='U';
    }
    public String reverseVowels(String s) {
        if(s.length()==0 || s.length()==1)
        return s;
        int i=0, j=s.length()-1;
        char[] ch = s.toCharArray();
       while(i<j){
          while(i<s.length() && !isVowel(ch[i])){
              i++;
          }
          while(j>=0 && !isVowel(ch[j])){
              j--;
          }
          if(i<j){
              char c = ch[i];
              ch[i]=ch[j];
              ch[j]=c;
          }
          i++; j--;
       }
       return String.valueOf(ch);
    }
}