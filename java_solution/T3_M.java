import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class T3_M {
    public int lengthOfLongestSubstring2(String s) {
        if (s == null){
            return 0;
        }
        if (hasNoDumplicate(s)){
            return s.length();
        }
        int N1 = lengthOfLongestSubstring2(s.substring(1,s.length()));
        int N2 = lengthOfLongestSubstring2(s.substring(0,s.length()-1));
        return Math.max(N1, N2);
    }
    public boolean hasNoDumplicate(String s){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))){
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    public int lengthOfLongestSubstring3(String s) {
        int MaxSubLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int maxSubLenthFromHead = getMaxSubLenthFromHead(s.substring(i));
            MaxSubLength = Math.max(MaxSubLength, maxSubLenthFromHead);
            if (s.length()-i-1 <= MaxSubLength){
                break;
            }
        }
        return MaxSubLength;
    }

    public int getMaxSubLenthFromHead(String s){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))){
                return i;
            }
            set.add(s.charAt(i));
        }
        return s.length();
    }

    public int lengthOfLongestSubstring(String s) {
        int point = -1;
        int MaxLength = 0;
        Set<Character> mySet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                mySet.remove(s.charAt(i - 1));
            }
            while (point + 1 < s.length() && !mySet.contains(s.charAt(point + 1))) {
                mySet.add(s.charAt(point+1));
                point++;
            }
            MaxLength = Math.max(MaxLength, point - i + 1);
        }
        return MaxLength;
    }

    @Test
    public void Test(){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("yqgyewoketumimwzbkcbuouc"));
    }
}
