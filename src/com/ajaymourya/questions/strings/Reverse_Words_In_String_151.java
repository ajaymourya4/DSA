package com.ajaymourya.questions.strings;

/**
 * Given an input string, reverse the string word by word.
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 */

class ReverseWordsInString {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        reverseWords(str, n);
        reverse(str, 0, n - 1);
        return cleanSpaces(str, n);
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

    private String cleanSpaces(char[] str, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && str[j] == ' ') j++;
            while (j < n && str[j] != ' ') str[i++] = str[j++];
            while (j < n && str[j] == ' ') j++;
            if (j < n) str[i++] = ' ';
        }
        return new String(str).substring(0, i);
    }
}
