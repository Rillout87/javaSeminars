public class Main {

    public static void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;


        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {


                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }


        int last = length_ - possibleDups;


        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
    
    public static int removeElement(int[] nums, int val) {
        int curNumb = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] != val){
                nums[curNumb] = nums[i];
                curNumb++;
            }
        }
        return curNumb;
    }
    
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int wordStart = 0;
        int wordEnd = 0;
        
        for (int i = s.length()-1; i >= 0; i--){
            if (s.charAt(i) != ' '){
                if (!result.isEmpty()) result.append(" ");
                wordEnd = i;
                for (int j = wordEnd; j >= 0; j--){
                    
                    if (j==0 && s.charAt(j) != ' '){
                        wordStart = j;
                        result.append(s.substring(wordStart,wordEnd+1));
                        i = j;
                        break;
                    }
                    if (s.charAt(j) == ' '){
                        wordStart = j + 1;
                        result.append(s.substring(wordStart,wordEnd+1));
                        i = j;
                        break;
                    }
                    
                }
            }
        }
        return result.toString();
    }
    
    

    public static void main(String[] args) {
        int [] arr = [1,0,2,3,0,4,5,0];
        System.out.println(arr);
    }
}
