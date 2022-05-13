package dev.appkr.hackerrank;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use only whole words available in the magazine. He cannot use substrings or concatenation to create the words he needs.
 * Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
 *
 * Example
 * magazine = "attack at dawn", note = "Attack at dawn"
 * The magazine has all the right words, but there is a case mismatch. The answer is .
 *
 * Function Description
 * Complete the checkMagazine function in the editor below. It must print  if the note can be formed using the magazine, or .
 *
 * checkMagazine has the following parameters:
 *    string magazine[m]: the words in the magazine
 *    string note[n]: the words in the ransom note
 *
 * Prints
 *    string: either  or , no return value is expected
 *
 * Input Format
 *    The first line contains two space-separated integers,  and , the numbers of words in the  and the , respectively.
 *    The second line contains  space-separated strings, each .
 *    The third line contains  space-separated strings, each .
 *
 * Constraints
 *    1 <= m,n <= 30,000
 *    1 <= lengths of magazine[i] and note[i] <= 5
 *    Each word consists of English alphabetic letters (i.e.,  to  and  to ).
 *
 * Sample Input 0
 * 6 4
 * give me one grand today night
 * give one grand today
 *
 * Sample Output 0
 * Yes
 *
 * Sample Input 1
 * 6 5
 * two times three is not four
 * two times two is four
 *
 * Sample Output 1
 * No
 *
 * Explanation 1
 * 'two' only occurs once in the magazine.
 *
 * Sample Input 2
 * 7 4
 * ive got a lovely bunch of coconuts
 * ive got some coconuts
 *
 * Sample Output 2
 * No
 *
 * Explanation 2
 * Harold's magazine is missing the word .
 */
public class RansomNote {

  public static void main(String[] args) {
    List<String> magazine = new ArrayList(asList("give", "me", "one", "grand", "today", "night"));
    List<String> note = new ArrayList(asList("give", "one", "grand", "today"));
    Result.checkMagazine(magazine, note);
  }

  static class Result {

    public static void checkMagazine(List<String> magazine, List<String> note) {
      Collections.sort(magazine);
      Collections.sort(note);

      boolean failFlag = false;
      for (String word : note) {
        if (!magazine.remove(word)) {
          failFlag = true;
          System.out.println("No");
          break;
        }
      }

      if (!failFlag) {
        System.out.println("Yes");
      }
    }
  }
}
