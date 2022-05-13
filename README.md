## Algorithm kata

#### anagrams
- 같은 알파벳을 재조합한 단어. e.g. cinema, iceman.
- Q: 애너그램끼리 그룹핑하라
```java
List<String> strList = List.of("eat", "tea", "tan", "ate", "nat", "bat");
```
- E
```java
[[eat, tea, ate], [bat], [tan, nat]]
```
- S
  - 결과값을 담을 변수로 Map<String, List<String>> 사용
  - 문자 단위로 쪼개서 정렬하고 다시 조인
  - 정렬된 단어를 key로 하여, 원본 문자열을 value 리스트에 추가
  - @see [dev.appkr.algorithm.anagrams.Anagrams](/java/src/main/java/dev/appkr/algorithm/anagrams/Anagrams.java)
  - @see [dev.appkr.algorithm.anagrams.Anagrams2](/java/src/main/java/dev/appkr/algorithm/anagrams/Anagrams.java)

#### print binary
- Q: 주어진 자연수를 이진수로 출력하라
- S: @see [dev.appkr.algorithm.printBinary.PrintBinary](/java/src/main/java/dev/appkr/algorithm/printBinary/PrintBinary.java)

#### factorial
- 주어진 숫자부터 1까지의 숫자의 곱. e.g. factorial(4) = 4 * 3 * 2 * 1 = 24
- Q: factorial 함수를 구현하라
- S1: recursion
  - 입력값이 1이면, 1을 반환
  - 입력값이 1이 아니면, factorial(입력값 - 1) * 입력값을 반환
  - factorial(15) takes **453_045ns**
- S2: loop
  - 결과를 담을 변수 p = 1로 초기화
  - i = 1 ~ 입력값까지 순회하면서, p = p * i 
  - factorial(15) takes **158_601ns** (recursion보다 3배 빠름)
- @see [dev.appkr.algorithm.factorial.Factorial](/java/src/main/java/dev/appkr/factorial/Factorial.java)

#### fibonacci
- 직전 두 개 숫자의 합이 현재 값이 되는 수열. e.g. 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
- Q: n 번째 피보나치 값을 구하는 fibonacci 함수를 구현하라
- S1: recursion
  - 입력값이 0 또는 1이면 0을 반환한다
  - 입력값이 2이면 1을 반환한다
  - 다른 값이면, fibonacci(n - 1) + fibonacci(n - 2) 값을 반환 
  - **NOTE** fibonacci(48) 이상은 int 범위를 벗어남
  - fibonacci(47) takes **7542ms**
  - @see [dev.appkr.algorithm.fibonacci.Fibonacci](/java/src/main/java/dev/appkr/algorithm/fibonacci/Fibonacci.java)
- S2: loop
  - n==1, n==2 인 경우는 이미 처리했으므로, 3부터 루프 시작
  - fibonacci(47) takes **0ms**
  - @see [dev.appkr.algorithm.fibonacci.Fibonacci2](/java/src/main/java/dev/appkr/algorithm/fibonacci/Fibonacci2.java)
- NOTE
  - memoization: recursion을 사용할 때, 캐시를 둬서 이미 계산한 값을 꺼내 쓰는 방법
  - bottom up: loop를 사용할 때, 캐시를 둬서 캐시에 최종 저장된 값을 반환하는 방법
  - @see https://www.youtube.com/watch?v=vYquumk4nWw

#### greatest common factor (최대공약수)
- 두 수의 약수중에 가장 큰 수 e.g. (10, 5) -> 5, (10, 6) -> 2
- Q: gcd 함수를 구현하라
- S: Euclid method @see [dev.appkr.algorithm.gcd.GreatestCommonFactor](/java/src/main/java/dev/appkr/algorithm/gcd/GreatestCommonFactor.java)

#### maze (미로 찾기)
- Q: 아래 8 by 8 미로에서 길 찾기를 하라. 출발점은 (0, 0) 끝점은 (8, 8). 찾은 길은 3으로 표시한다 
```java
// 통로는 0, 벽은 1로 표시
static int[][] maze = {
        {0, 0, 0, 0, 0, 0, 0, 1},
        {0, 1, 1, 0, 1, 1, 0, 1},
        {0, 0, 0, 1, 0, 0, 0, 1},
        {0, 1, 0, 0, 1, 1, 0, 0},
        {0, 1, 1, 1, 0, 0, 1, 1},
        {0, 1, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 1, 0, 0, 0, 1},
        {0, 1, 1, 1, 0, 1, 0, 0}
        };

// 기대 값, 3으로 표시함, 2는 방문 기록
static int[][] maze = {
        {3, 2, 2, 2, 2, 2, 2, 1},
        {3, 1, 1, 2, 1, 1, 2, 1},
        {3, 2, 2, 1, 2, 2, 2, 1},
        {3, 1, 2, 2, 1, 1, 2, 2},
        {3, 1, 1, 1, 2, 2, 1, 1},
        {3, 1, 3, 3, 3, 1, 2, 1},
        {3, 3, 3, 1, 3, 3, 3, 1},
        {0, 1, 1, 1, 0, 1, 3, 3}
        };
``` 
- S
  - find(x: int, y: int): boolean
  - (x, y)가 미로의 범위를 벗어나면 false 반환
  - (x, y)가 통로가 아니면 false 반환
  - (7, 7)이면, maze[7][7]을 솔루션으로 표시하고 ture 반환
  - 현재 위치의 위쪽이 true이거나,오른쪽이 true이거나, 아래쪽이 true이거나, 왼쪽이 true이면, maze[x][y]를 솔루션으로 표시하고 true 반환
  - 상하좌우를 검사했을 때, false이면, 막다른 골목이므로 꽝으로 표시하고 false를 반환
  - @see [dev.appkr.algorithm.maze.Maze](/java/src/main/java/dev/appkr/algorithm/maze/Maze.java)

#### most common word
- Q: "hit"을 제외하고 가장 많이 등장하는 단어를 찾아라
```java
"Bob hit a ball, the hit BALL flew far after it was hit."
```
- S
  - 문장 전체를 소문자로 치환
  - 특수 문자 제거
  - 단어로 쪼개서 배열 구하기
  - 결과를 담을 변수 Map<String, Integer>
  - 단어가 담긴 배열을 순회하면서
    - 금지어 "hit"이면 continue
    - 맵에 단어를 키로 단어의 출현 빈도를 값으로 기록
  - 최대 값을 가진 entry를 구하고, 키를 반환한다
  - @see [dev.appkr.algorithm.mostCommonWord.MostCommonWord](/java/src/main/java/dev/appkr/algorithm/mostCommonWord/MostCommonWord.java)

#### palindrome
- 문자열을 완전히 뒤집어도 원본과 같은 단어
- Q: isPalindrome 함수를 구현하라
- S1
  - 문자열을 뒤집어서, 원본 문자열과 같으면 true 반환
  - @see [dev.appkr.algorithm.palindrome.Palindrome](/java/src/main/java/dev/appkr/algorithm/palindrome/Palindrome.java)
- S2: List API 이용
  - 문자열을 쪼개서 리스트에 담는다
  - 리스트를 순회하면서
    - 리스트의 첫번째 원소를 shift하고, 마지막 원소를 pop해서 값이 다르면 false를 반환 (`list.remove(int)` API 이용)
  - @see [dev.appkr.algorithm.palindrome.Palindrome2](/java/src/main/java/dev/appkr/algorithm/palindrome/Palindrome2.java)
- S3: 투 포인터 이용
  - l = 0; r = (문자열의 길이 - 1) 두 개 포인터 선언
  - l <= r 조건을 충족하는 동안 루프
    - l번째 문자와 r번째 문자가 서로 다르면 false 반환
    - l++; r--
  - @see [dev.appkr.algorithm.palindrome.Palindrome3](/java/src/main/java/dev/appkr/algorithm/palindrome/Palindrome3.java) 

#### prime number (소수)
- 1과 자기 자신으로만 나눌 수 있는 자연수 (1은 제외)
- Q: 소수를 판별하는 isPrime 함수를 구현하라
- S
  - 입력값이 1이하이면 false 반환
  - i = 2부터 입력값의 제곱근까지 순회하면서
    - 입력값을 i로 나눈 나머지가 0이면 false 반환 <- 0과 자기자신 사이에 나눌 수 있는 자연수가 있으므로
  - @see [dev.appkr.algorithm.prime.PrimeNumber](/java/src/main/java/dev/appkr/algorithm/prime/PrimeNumber.java)

> *에라토스테네스의 체 ([Youtube](https://www.youtube.com/watch?v=fdTzyaDPhdo?t=15m41s), [나무위키](https://namu.wiki/w/소인수분해))*
>
> 3개 이상의 소수로 구성된 합성수는 그 수의 제곱근보다 작거나 같은 약수를 갖는다.
>
> n을 합성수라 하자. 그러면 n = a * b, 1 < a, b < n 이다. 만약 a, b가 둘 다 sqrt(n)보다 크다면, (n = sqrt(n) * sqrt(n)) < (a * b = n)이 되어 모순이다. 따라서 a, b중 적어도 하나는 sqrt(n)보다 작다.
>
> e.g. 187을 합성수라 하자. 그러면 187 = 11 * 17, 1 < 11, 17 < 187이다. 만약 11, 17 둘 다 sqrt(187) = 13.67 보다 크다면, (187 = sqrt(187) * sqrt(187)) < (11 * 17 = 187)이 되어 모순이다. 따라서, 11, 17중 적어도 하나는 sqrt(187) = 13.67보다 작다.
>
> [합성수(合成數, Composite Number)](https://namu.wiki/w/합성수): 여러 소수(素數)들이 곱셈으로 합쳐져서 이루어진 수를 말한다. 즉 임의의 자연수 n에 대해 1과 자기 자신을 제외한 다른 약수가 존재할 때, 이 수를 합성수라고 한다.

#### prime factor (소인수 분해)
- Q: 매개변수로 주어진 자연수 n을 소수로 약분하여, n을 구성하는 소수의 집합을 반환하는 factorize 함수를 구현하라 e.g. 100 = [2, 2, 5, 5]
- S: 이중 루프
  - divider = 2를 초기 값으로, 입력값 n이 1보다 클동안, divider를 1씩 증가시키면서 루프
    - 입력값 n을 divider로 나눈 나머지가 0이 나올 때까지, n을 divider로 나눈다
    - 조건을 충족하면 divider 값이 소인수이다
  - @see [dev.appkr.algorithm.prime.PrimeFactor](/java/src/main/java/dev/appkr/algorithm/prime/PrimeFactor.java)

n = 100|n|divider|n % divider|n/divider|note
---|---|---|---|---|---
inner 1st|100|2|0|50|
inner 2nd|50|2|0|25|
inner 3rd|25|2|1|12|exit inner
inner 4th|25|3|1|8|exit inner
inner 5th|25|4|1|6|exit inner
inner 6th|25|5|0|5
inner 7th|5|5|0|1

#### power (승수)
- Q: x를 밑으로 하고, n을 승수라 할 때 결과를 구하는 함수
- S: @see [dev.appkr.algorithm.power.Power](/java/src/main/java/dev/appkr/algorithm/power/Power.java)

#### search
- Q: 중복이 없고, 오름차순으로 정렬된 a~z 문자열에서 입력 문자 "w"의 인덱스를 구하라. 없으면 -1을 반환한다
- S1: linear search
  - loop count = 23 -> `O(n)` 
  - @see [dev.appkr.algorithm.search.LinearSearch](/java/src/main/java/dev/appkr/algorithm/search/LinearSearch.java)
- S2: binary search 
  - loop count = 3 -> `O(log n)`
  - @see [dev.appkr.algorithm.search.BinarySearch](/java/src/main/java/dev/appkr/algorithm/search/BinarySearch.java)

#### sort
- Q: 오름차순으로 정렬하라
```java
int[] in = { 15, 23, 16, 21, 6, 8, 46, 40, 37, 43, 8, 3, 33 };
```
- S1: bubble sort
  - 인접한 두 개를 비교하고 스왑; 작은 수를 왼쪽으로 하나씩 옮기고, 큰 수를 오른쪽으로 하나씩 옮긴다
  - loop count = 37 -> `O(n^2)`
  - @see [dev.appkr.algorithm.sort.BubbleSort](/java/src/main/java/dev/appkr/algorithm/sort/BubbleSort.java)
  - @see [https://visualgo.net/en/sorting](https://visualgo.net/en/sorting)
- S2: quick sort
  - TODO

#### compression
- Q: 문자열을 압축하라
```java
"aabbccca"
```
- E
```java
"a2b2c3a1"
```
- S: @see [dev.appkr.algorithm.compression.Compression](/java/src/main/java/dev/appkr/algorithm/compression/Compression.java)

#### masking
- Q: 주어진 문자열의 첫 문자, 마지막 문자를 제외한 문자를 *로 마스킹하라
```java
"ewXsZeUo40xNHNCOpLl76ahX1NJWmZj3"
```
- E
```java
"e******************************3"
```
- S: @see [dev.appkr.algorithm.masking.Masking](/java/src/main/java/dev/appkr/algorithm/masking/Masking.java)

#### hex
- Q: 랜던 64bit hex를 생성하는 generate 함수를 구현하라
- S
  - 16은 2^4이므로, 16진수 하나가 4bit를 표현함; 64bit / 4bit = 16
  - 16진수 16자리를 만들어야 함
  - @see [dev.appkr.algorithm.random.RandomHex](/java/src/main/java/dev/appkr/algorithm/random/RandomHex.java)

#### sum of linked list
- Q: 길이가 같은 연결 리스트를 구현하고, 합을 구하라; 합한 값이 10 이상이면, 앞 Node로 올림한다
```java
h1 = [1, 2, 3]
h2 = [6, 7, 8]
```
- E
```java
[8, 0, 1]
```
- S: @see [dev.appkr.algorithm.list.SumOfLinkedList](/java/src/main/java/dev/appkr/algorithm/list/SumOfLinkedList.java)

#### password strength checker
- TODO https://www.youtube.com/watch?v=6Vt-wKPBbuc

---

### Leetcode

No| Question|Solution
---|---|---
1|[Two Sum](https://leetcode.com/problems/two-sum/)|[dev.appkr.leetcode.TwoSum](/java/src/main/java/dev/appkr/leetcode/TwoSum.java)
2|[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)|[dev.appkr.leetcode.AddTwoNumbers](/java/src/main/java/dev/appkr/leetcode/AddTwoNumbers.java)
3|[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)|[dev.appkr.leetcode.LongestSubstring](/java/src/main/java/dev/appkr/leetcode/LongestSubstring.java)
4|[Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)|[dev.appkr.leetcode.MedianOfArray](/java/src/main/java/dev/appkr/leetcode/MedianOfArray.java)
5|[Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)|[dev.appkr.leetcode.PalindromicSubstring](/java/src/main/java/dev/appkr/leetcode/PalindromicSubstring.java)
7|[Reverse Integer](https://leetcode.com/problems/reverse-integer/)|[dev.appkr.leetcode.ReverseInteger](/java/src/main/java/dev/appkr/leetcode/ReverseInteger.java)
8|[String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/)|[dev.appkr.leetcode.StringToInteger](/java/src/main/java/dev/appkr/leetcode/StringToInteger.java)
9|[Palindrome Number](https://leetcode.com/problems/palindrome-number/)|[dev.appkr.algorithm.palindrome.Palindrome3](/java/src/main/java/dev/appkr/algorithm/palindrome/Palindrome3.java)
11|[Container With Most Water](https://leetcode.com/problems/container-with-most-water/)|[dev.appkr.leetcode.ContainerWithMostWater](/java/src/main/java/dev/appkr/leetcode/ContainerWithMostWater.java)
12|[Integer to Roman](https://leetcode.com/problems/integer-to-roman/)|[dev.appkr.leetcode.IntToRoman](/java/src/main/java/dev/appkr/leetcode/IntToRoman.java)
13|[Roman to Integer](https://leetcode.com/problems/roman-to-integer/)|[dev.appkr.leetcode.RomanToInt](/java/src/main/java/dev/appkr/leetcode/RomanToInt.java)
14|[Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)|[dev.appkr.leetcode.LongestCommonPrefix](/java/src/main/java/dev/appkr/leetcode/LongestCommonPrefix.java)
15|[3Sum](https://leetcode.com/problems/3sum/)|[dev.appkr.leetcode.ThreeSum](/java/src/main/java/dev/appkr/leetcode/ThreeSum.java)
17|[Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)|[dev.appkr.leetcode.LetterCombination](/java/src/main/java/dev/appkr/leetcode/LetterCombination.java)
19|[Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)|[dev.appkr.leetcode.RemoveNthNode](/java/src/main/java/dev/appkr/leetcode/RemoveNthNode.java)
20|[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)|[dev.appkr.leetcode.ValidParentheses](/java/src/main/java/dev/appkr/leetcode/ValidParentheses.java)
26|[Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)|[dev.appkr.leetcode.RemoveDuplicateElement](/java/src/main/java/dev/appkr/leetcode/RemoveDuplicateElement.java)
27|[Remove Element](https://leetcode.com/problems/remove-element/)|[dev.appkr.leetcode.RemoveElement](/java/src/main/java/dev/appkr/leetcode/RemoveElement.java)
28|[Implement strStr()](https://leetcode.com/problems/implement-strstr/)|[dev.appkr.leetcode.Strstr](/java/src/main/java/dev/appkr/leetcode/Strstr.java)
33|[Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)|[dev.appkr.leetcode.SearchInRotated](/java/src/main/java/dev/appkr/leetcode/SearchInRotated.java)
34|[Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)|[dev.appkr.leetcode.SearchRange](/java/src/main/java/dev/appkr/leetcode/SearchRange.java)
35|[Search Insert Position](https://leetcode.com/problems/search-insert-position/)|[dev.appkr.leetcode.SearchInsertPosition](/java/src/main/java/dev/appkr/leetcode/SearchInsertPosition.java)
53|[Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)|[dev.appkr.leetcode.MaximumSubArray](/java/src/main/java/dev/appkr/leetcode/MaximumSubArray.java)
58|[Length of Last Word](https://leetcode.com/problems/length-of-last-word/)|[dev.appkr.leetcode.LengthOfLastWord](/java/src/main/java/dev/appkr/leetcode/LengthOfLastWord.java)
66|[Plus One](https://leetcode.com/problems/plus-one/)|[dev.appkr.leetcode.PlusOne](/java/src/main/java/dev/appkr/leetcode/PlusOne.java)
83|[Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)|[dev.appkr.leetcode.RemoveDuplicateLink](/java/src/main/java/dev/appkr/leetcode/RemoveDuplicateLink.java)
88|[Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)|[dev.appkr.leetcode.MergeSortedArray](/java/src/main/java/dev/appkr/leetcode/MergeSortedArray.java)
94|[Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)|[dev.appkr.leetcode.InOrderTraversal](/java/src/main/java/dev/appkr/leetcode/InOrderTraversal.java)

---

### HackerRank

Question|Solution
---|---
[HourGlass](https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays)|[dev.appkr.hackerrank.HourGlass](/java/dev/appkr/hackerrank/HourGlass.java)
[LeftRotation](https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays)|[dev.appkr.hackerrank.LeftRotation](/java/dev/appkr/hackerrank/LeftRotation.java)
[New Year Chaos](https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays)|[dev.appkr.hackerrank.NewYearChaos](/java/dev/appkr/hackerrank/NewYearChaos.java)
[Mininum Swap](https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays)|[dev.appkr.hackerrank.MinimumSwap](/java/dev/appkr/hackerrank/MinimumSwap.java)
[RansomeNote](https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps)|[dev.appkr.hackerrank.RansomNote](/java/dev/appkr/hackerrank/RansomNote.java)
[Two Strings](https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps)|[dev.appkr.hackerrank.TwoStrings](/java/dev/appkr/hackerrank/TwoStrings.java)
[Making Anagrams](https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings)|
[Alternating Characters](https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings)|
[Sherlock and the Valid String](https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings)|
