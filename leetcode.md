leetcode

## 1. Two Sum
https://leetcode.com/problems/two-sum/

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                res[0] = i;
                res[1] = map.get(diff);
                break;
            }
            map.put(nums[i], i);
        }
        
        return res;
// Time Limit Exceeded
//         int[] res = new int[2];
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i+1; j < nums.length; j++) {
//                 System.out.println(String.format("[%d,%d]=%d, %d", i, j, nums[i], nums[j]));
//                 int sum = nums[i] + nums[j];
//                 if (sum == target) {
//                     res[0] = i;
//                     res[1] = j;
//                     break;
//                 }
//             }
//         }
        
//         return res;
    }
}
```

## 2. Add Two Numbers
https://leetcode.com/problems/add-two-numbers/

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;
            
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            
            cur = cur.next;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        
        return dummy.next;
    }
}
```

## 3. Longest Substring Without Repeating Characters

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> q = new LinkedList<>();
        
        int max = 0;
        for (char c : s.toCharArray()) {
            while(q.contains(c)) {
                q.poll();
            }
            
            q.add(c);    
            max = Math.max(max,q.size());     
            System.out.println(String.format("c=%s, max=%d, q=%s", c, max, q));
        }
        
       return max;
    }
}
```

## 4. Median of Two Sorted Arrays
https://leetcode.com/problems/median-of-two-sorted-arrays/

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        System.arraycopy(nums1, 0, merged, 0, m);
        System.arraycopy(nums2, 0, merged, m, n);
        Arrays.sort(merged);
        System.out.println(Arrays.toString(merged));
        
        boolean isEven = (merged.length % 2 == 0);
        
        double res;
        if (isEven) {
            System.out.println("even");
            int first = merged.length / 2 - 1;
            int second = first + 1;
            System.out.println(String.format("first=%d, second=%d", first, second));
            res = ((double)merged[first] + merged[second]) / 2;
        } else {
            System.out.println("odd");
            int mid = merged.length / 2;
            System.out.println(mid);
            res = merged[mid] * 1.0;
        }
        
        return res;
        
    }
}
```

## 5. Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/

```java
class Solution {
    public String longestPalindrome(String s) {

        String res = "";
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > max) {
                    res = s.substring(l, r + 1);
                    max = r - l + 1;
                }
                l--; r++;
            }
            
            l = i; r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > max) {
                    res = s.substring(l, r + 1);
                    max = r - l + 1;
                }
                l--; r++;
            }
        }            
        
        
        return res;
        
        
        // Time Limit Exceeded
//         if (s == null) {
//             return "";
//         }
//         if (s.length() == 1) {
//             return s;
//         }
        
        
//         String res = "";
//         int max = 0;
//         for (int i = 0; i < s.length(); i++) {
//             for (int j = i; j < s.length()+1; j++) {
//                 String ss = s.substring(i, j);
//                 if (isPalindrome(ss)) {
//                     if (ss.length() > max) {
//                         max = ss.length();
//                         res = ss;
//                     }
//                 }
//                 // System.out.println(String.format("i=%d, j=%d, ss=%s, p=%s max=%d", 
//                 //                                  i, j, isPalindrome(ss), ss, max));
//             }
//         }
        
//         return res;
//     }
    
//     boolean isPalindrome(String s) {
//         if (s == null) {
//             return false;
//         }
//         if (s.length() == 1) {
//             return true;
//         }
//         return new StringBuilder(s).reverse().toString().equals(s);
    }
        
}
```

## 7. Reverse Integer
https://leetcode.com/problems/reverse-integer/

```java
class Solution {
    public int reverse(int x) {
        boolean minus = false;
        if (x < 0) minus = true;
        
        x = Math.abs(x);
        String y = String.valueOf(x);
        y = new StringBuilder(y).reverse().toString();
        
        int res;
        try {
            res = Integer.parseInt(y);    
        } catch (Exception e) {
            return 0;
        }
        
        if (minus) res = res * -1;
        
        // if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
        //     return 0;
        // }
        
        return res;
    }
}
```

## 8. String to Integer (atoi)
https://leetcode.com/problems/string-to-integer-atoi/

```java
class Solution {
    public int myAtoi(String s) {
        int i = 0;
        boolean isNeg = false;
        double num = 0;
        
		//ignore spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            ++i;
        }
		//identify sign
        if (i < s.length() && s.charAt(i) == '-') {
            isNeg = true;
            ++i;
        } else if (i < s.length() && s.charAt(i) == '+') {
            ++i;
        }
        
		//generate integer number from the string
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = (num * 10) + (s.charAt(i) - '0');
            ++i;
        }
        
        if (num == 0)
            return 0;
        else if (isNeg) {//apply sign
            num = num * -1;
        }
		//return the number clamped to the required range.
        return (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, num));       
    }
}
```

## 9. Palindrome Number
https://leetcode.com/problems/palindrome-number/

```java
class Solution {
    public boolean isPalindrome(int x) {
        String strX = String.valueOf(x);
        String strY = new StringBuffer(strX).reverse().toString();
        return strX.equals(strY);
    }
}
```

## 11. Container With Most Water
https://leetcode.com/problems/container-with-most-water/

```java
class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(res, area);
            
            if (height[l] < height[r]) {
                l += 1;
            } else {
                r -= 1;
            }
        }
        
        return res;
        
        // Time Limit Exceeded
//         int max = 0;
//         int n = height.length;
//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 int x = j - i;
//                 int y = Math.min(height[j], height[i]);
//                 int area = x * y;
//                 if (area > max) {
//                     max = area;
//                 }
                
//                 System.out.println(String.format(
//                     "i=%d, j=%d, x=%d, y=%d, area=%d, max=%d", i, j, x, y, area, max));
//             }
//         }
        
//         return max;
    }
}
```

## 12. Integer to Roman
https://leetcode.com/problems/integer-to-roman/

```java
class Solution {
    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9 ,5, 4, 1};
        String[] code = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();        
        for(int i = 0; i < value.length; i++){
            while(value[i] <= num){            
                sb.append(code[i]);
                num -= value[i];
                System.out.println(String.format(
                    "i=%d, value=%d, code=%s, num=%d", i, value[i], code[i], num));
            }
        }                                    
        return sb.toString();
    }
}
```

## 13. Roman to Integer
https://leetcode.com/problems/roman-to-integer/

```java
class Solution {
  public int romanToInt(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int res = 0;

    for (int i = 0; i < s.length(); i++) {
      if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
        res -= map.get(s.charAt(i)); // IV -> res - 1 + 5
      } else {
        res += map.get(s.charAt(i)); // XIII -> res + 10 + 1 + 1 + 1
      }
    }

    return res;
  }
}
```

## 14. Longest Common Prefix
https://leetcode.com/problems/longest-common-prefix/

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
      if (strs.length == 0)
        return "";
      String prefix = strs[0];
      for (int i = 1; i < strs.length; i++) {
        while (strs[i].indexOf(prefix) != 0) {
          prefix = prefix.substring(0, prefix.length() - 1);
          System.out.println("prefix=" + prefix);
          if (prefix.isEmpty())
            return "";
        }
      }

      return prefix;
    }
}
```

## 15. 3Sum
https://leetcode.com/problems/3sum/

```java
// Time Limit Exceed
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums)); // [-1,0,1,2,-1,-4]    

    for (int i = 0; i < n; i++) {
      if (i > 0 && nums[i] == nums[i-1]) {
        continue;
      }

      int l = i + 1, r = n - 1;

      while (l < r) {
        int threeSum = nums[i] + nums[l] + nums[r];
        System.out.println(String.format(
            "i=%d, l=%d, r=%d, nums[i]=%d, nums[l]=%d, nums[r]=%d, sum=%d",
            i, l, r, nums[i], nums[l], nums[r], threeSum));

        if (threeSum > 0) {
          r -= 1;
        } else if (threeSum < 0) {
          l += 1;
        } else {
          res.add(new ArrayList(Arrays.asList(nums[i], nums[l], nums[r])));
          l += 1;
        }
      }
    }

    return res;
  }
}
```

## 17. Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

```java
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        result.add("");
        for (char d : digits.toCharArray()) {
            List<String> list = new ArrayList<>();
            for (String comb : result) {
                for (char c : mappings[d - '0'].toCharArray()) {
                    list.add(comb + c);
                    System.out.println(String.format(
                        "comb=%s, c=%s, list=%s", comb, c, list));
                }
            }

            result = list;
        }
        

        return result;
    }
}
```

## 19. Remove Nth Node From End of List
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //find length of linked list
        
        int count = 0;
        ListNode tmp = head;
        while (tmp != null){
            count++;
            tmp = tmp.next;
        }

        //reuse count for index of element to be removed
        count -= n;
        
        ListNode prev = null;
        tmp = head;
        
        // iterating to the element , while keeping track of prev node
        while (count != 0){
            prev = tmp;
            tmp = tmp.next;
            count--;
            System.out.println(String.format("prev=%d, tmp=%d, count=%d", prev.val, tmp.val, count));
        }
        
        if (prev == null){
            head = tmp.next;
            return head;
        }else if (tmp.next == null){
            prev.next = null;
            return head;
        }else {
            prev.next = tmp.next;
            tmp.next = null;
            return head;
        }
    }
}
```

## 20. Valid Parentheses
https://leetcode.com/problemset/all/

```java
class Solution {
    public boolean isValid(String s) {
      Map<Character, Character> map = new HashMap<>();
      map.put(')', '(');
      map.put('}', '{');
      map.put(']', '[');

      Stack<Character> stack = new Stack();

      for (Character c : s.toCharArray()) {
        if (!map.containsKey(c)) {
          stack.push(c);
        } else {
          if (stack.isEmpty()) {
            return false;
          }
          if (stack.peek() == map.get(c)) {
            stack.pop();
          } else {
            return false;
          }
        }
      }

      return stack.size() == 0 ? true : false;
    }
}
```

## 26. Remove Duplicates from Sorted Array
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

```java
class Solution {
    public int removeDuplicates(int[] nums) {
      int n = nums.length;
      int res = 1;
      for (int i = 1; i < n; i++) {
        if (nums[i] != nums[res - 1]) {
          nums[res] = nums[i];
          res++;
        }
      }

      return res;
    }
}
```

## 27. Remove Element
https://leetcode.com/problems/remove-element/

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        
        return pointer;
    }
}
```

## 28. Implement strStr()
https://leetcode.com/problems/implement-strstr/

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        
        if (n == 0) {
            return 0;
        }
        
        if (n > h) {
            return -1;
        }
        
        
        for (int i = 0; i <= h - n; i++) {
            String part = haystack.substring(i, i + n);
            if (part.equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}
```

## 33. Search in Rotated Sorted Array
https://leetcode.com/problems/search-in-rotated-sorted-array/

```java
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        
        return -1;
    }
}
```

## 34. Find First and Last Position of Element in Sorted Array
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        
        int[] res = {-1, -1};
        
        for (int i = 0; i < n; i++) {
            if (nums[l] < target) {
                l++;
            } else if (nums[l] == target) {
                res[0] = l;
            }
            
            if (nums[r] > target) {
                r--;
            } else if (nums[r] == target) {
                res[1] = r;
            }
        }
        
        return res;
    }
}
```

## 35. Search Insert Position
https://leetcode.com/problems/search-insert-position/

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        
        if (target == 0) {
            return 0;
        }
        
        if (target > nums[n-1]) {
            return n;
        }
        
        for (int i = 0; i < n; i++) {
            if (target == nums[i]) {
                return i;
            }
            if (target > nums[i] && target < nums[i+1]) {
                return i+1;
            }
        }
        
        return 0;
    }
}
```

## 53. Maximum Subarray
https://leetcode.com/problems/maximum-subarray/

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSub = nums[0];
        int curSum = 0;
        
        for (int i = 0; i < n; i++) {
            if (curSum < 0) {
                curSum = 0;
            }
            
            curSum += nums[i];
            maxSub = Math.max(maxSub, curSum);
        }
        
        return maxSub;
    }
}
```

## 58. Length of Last Word
https://leetcode.com/problems/length-of-last-word/

```java
class Solution {
    public int lengthOfLastWord(String s) {
        String[] parts = s.split("\\s+");
        String lastWord = parts[parts.length - 1];
        return lastWord.length();
    }
}
```

## 66. Plus One
https://leetcode.com/problems/plus-one/

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int pointer = digits.length - 1;
        if (digits[pointer] != 9) {
            digits[pointer] += 1;
            return digits;
        }
        
        while (pointer >= 0 && digits[pointer] != 9) {
            digits[pointer] = 0;
            pointer--;
        }

        if (pointer >= 0) {
            digits[pointer] += 1;
        } else {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;

            return newDigits;
        }
        
        return digits;
    }
}
```

## 83. Remove Duplicates from Sorted List
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> counter = new HashMap<>();
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
}
```

## 88. Merge Sorted Array
https://leetcode.com/problems/merge-sorted-array/

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // System.arraycopy(nums2,0,nums1,m,n);
        // Arrays.sort(nums1);
        int position = m + n - 1;

        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[position] = nums1[m - 1];
                m--;
            } else {
                nums1[position] = nums2[n - 1];
                n--;
            }

            position--;
        }

        while (m-- > 0) {
            nums1[position--] = nums1[m];
        }

        while (n-- > 0) {
            nums1[position--] = nums2[n];
        }
    }
}
```

## 94. Binary Tree Inorder Traversal
https://leetcode.com/problems/binary-tree-inorder-traversal/

```java
class Solution {
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        
        return list;
    }
}
```
