package com.ajaymourya.questions.strings;

/**
 * Given a string, you need to reverse the order of characters in each word within
 * a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Note: In the string, each word is separated by single space
 * and there will not be any extra space in the string.
 */

class ReverseWordsInString557 {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        reverseWords(str, n);
        return new String(str);
    }

    private void reverseWords(char[] str, int n) {
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (str[j] == ' ') {
                reverse(str, i, j - 1);
                i = j + 1;
            }
        }
        reverse(str, i, n - 1);
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }
}
