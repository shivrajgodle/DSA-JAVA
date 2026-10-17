# Week 1: Arrays & Basic Hashing (Java)

Each problem below follows the same format:

1. **Question**: the problem in plain words
2. **Input / Output**: a concrete example
3. **Idea**: the trick, in simple language
4. **Step-by-step walkthrough**: what happens to the example, one step at a time
5. **Code**: commented Java
6. **Complexity**: time and extra space

All methods are `static` and go inside one class (see "How to run" at the end).

---

## Pattern 1: Prefix Sum

**When to use:** you are asked for sums of ranges many times. Instead of adding the numbers again and again, add them once and reuse the result.

**Real-life picture:** think of a bank passbook. The balance after each transaction is stored. To know how much you spent between transaction 3 and 7, you subtract two balances instead of adding 5 transactions.

### 1.1 Range Sum Query

**Question:** Given an array, you will be asked many times: "what is the sum of elements from index `l` to index `r`?" Answer each query fast.

| | |
|---|---|
| **Input** | `nums = [2, 4, 6, 8]`, query `l = 1, r = 3` |
| **Output** | `18` (because 4 + 6 + 8) |

**Idea:** Build a `prefix` array where `prefix[i]` = sum of the first `i` elements. Then `sum(l..r) = prefix[r+1] - prefix[l]`.

**Walkthrough:**

```
nums   = [2, 4, 6, 8]
prefix = [0, 2, 6, 12, 20]
          ^  ^  ^   ^   ^
          |  |  |   |   2+4+6+8
          |  |  |   2+4+6
          |  |  2+4
          |  2
          nothing added yet

Query l=1, r=3:
  prefix[r+1] - prefix[l] = prefix[4] - prefix[1] = 20 - 2 = 18
  (total up to index 3, minus the part before index 1)
```

```java
// Step 1: build the prefix array once
static int[] buildPrefix(int[] nums) {
    // one extra slot at the start so prefix[0] = 0 (sum of nothing)
    int[] prefix = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
        // total up to i+1 = total up to i + current number
        prefix[i + 1] = prefix[i] + nums[i];
    }
    return prefix;
}

// Step 2: answer any query in O(1)
static int rangeSum(int[] prefix, int l, int r) {
    // everything up to r, minus everything before l
    return prefix[r + 1] - prefix[l];
}
```

**Complexity:** build O(n), each query O(1), space O(n).

### 1.2 Product of Array Except Self

**Question:** Given an array `nums`, return an array `result` where `result[i]` is the product of all elements except `nums[i]`. Do not use division.

| | |
|---|---|
| **Input** | `nums = [1, 2, 3, 4]` |
| **Output** | `[24, 12, 8, 6]` |

**Idea:** For each position, the answer = (product of everything on its left) x (product of everything on its right). Do one pass left to right and one pass right to left.

**Walkthrough:**

```
nums = [1, 2, 3, 4]

Pass 1 (left to right): store product of everything LEFT of i
  i=0: nothing on left -> 1
  i=1: left is [1]       -> 1
  i=2: left is [1,2]     -> 2
  i=3: left is [1,2,3]   -> 6
  result = [1, 1, 2, 6]

Pass 2 (right to left): multiply by product of everything RIGHT of i
  i=3: nothing on right -> result[3] = 6 * 1  = 6
  i=2: right is [4]     -> result[2] = 2 * 4  = 8
  i=1: right is [3,4]   -> result[1] = 1 * 12 = 12
  i=0: right is [2,3,4] -> result[0] = 1 * 24 = 24
  result = [24, 12, 8, 6]
```

```java
static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    // Pass 1: result[i] = product of all elements to the LEFT of i
    int left = 1;                  // product of nothing is 1
    for (int i = 0; i < n; i++) {
        result[i] = left;          // save the left product for index i
        left *= nums[i];           // include nums[i] for the next index
    }

    // Pass 2: multiply by the product of all elements to the RIGHT of i
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        result[i] *= right;        // combine left product * right product
        right *= nums[i];          // include nums[i] for the next index (moving left)
    }
    return result;
}
```

**Complexity:** time O(n), extra space O(1) (the output array does not count).

---

## Pattern 2: Two Pointer

**When to use:** the array is **sorted** and you need a pair, or you compare things from both ends.

**Real-life picture:** two people start at opposite ends of a bookshelf sorted by price and walk toward each other until their two books add up to your budget.

### 2.1 Two Sum in a Sorted Array

**Question:** Given a sorted array and a `target`, find two numbers that add up to `target`. Return their indices.

| | |
|---|---|
| **Input** | `sorted = [1, 2, 4, 7, 11]`, `target = 9` |
| **Output** | `[1, 3]` (because 2 + 7 = 9) |

**Idea:** Put `left` at the smallest number and `right` at the largest. If the sum is too small, move `left` right (bigger number). If too big, move `right` left (smaller number).

**Walkthrough:**

```
sorted = [1, 2, 4, 7, 11], target = 9

left=0 (1), right=4 (11): sum = 12 > 9  -> too big,   right--
left=0 (1), right=3 (7):  sum = 8  < 9  -> too small, left++
left=1 (2), right=3 (7):  sum = 9 == 9  -> found! return [1, 3]
```

```java
static int[] twoSumSorted(int[] sorted, int target) {
    int left = 0;                        // points to the smallest number
    int right = sorted.length - 1;       // points to the largest number

    while (left < right) {               // stop when pointers meet
        int sum = sorted[left] + sorted[right];
        if (sum == target) {
            return new int[]{left, right};   // found the pair
        } else if (sum < target) {
            left++;                      // need a bigger sum, move to a larger number
        } else {
            right--;                     // need a smaller sum, move to a smaller number
        }
    }
    return new int[]{-1, -1};            // no pair adds up to target
}
```

**Complexity:** time O(n), space O(1).

### 2.2 Valid Palindrome

**Question:** Check whether a string reads the same forwards and backwards.

| | |
|---|---|
| **Input** | `"racecar"` |
| **Output** | `true` |
| **Input** | `"hello"` |
| **Output** | `false` (`h` != `o`) |

**Idea:** Compare the first and last characters, then move both inward.

**Walkthrough for "racecar":**

```
left=0 'r' vs right=6 'r' -> match, move inward
left=1 'a' vs right=5 'a' -> match, move inward
left=2 'c' vs right=4 'c' -> match, move inward
left=3 == right=3 -> pointers met, all matched -> true
```

```java
static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;                // one mismatch is enough to say "not a palindrome"
        }
        left++;                          // move both pointers toward the middle
        right--;
    }
    return true;                         // every pair matched
}
```

**Complexity:** time O(n), space O(1).

---

## Pattern 3: Sliding Window

**When to use:** the problem talks about a **contiguous** part of an array or string (a subarray or substring) and asks for max, min, longest or shortest.

**Real-life picture:** a window on a moving train. Each second one new thing enters on the right and one old thing leaves on the left. You do not re-look at the whole view, you only update what changed.

### 3.1 Maximum Sum of Size K (fixed window)

**Question:** Find the maximum sum of any `k` consecutive elements.

| | |
|---|---|
| **Input** | `nums = [2, 1, 5, 1, 3, 2]`, `k = 3` |
| **Output** | `9` (the window `[5, 1, 3]`) |

**Idea:** Compute the first window's sum. Then for each slide, add the new element and subtract the element that left.

**Walkthrough:**

```
Window [2,1,5] = 8            (first window, computed directly)
Slide: +1 (new) -2 (old) = 7  -> window [1,5,1]
Slide: +3 (new) -1 (old) = 9  -> window [5,1,3]   <- best so far
Slide: +2 (new) -5 (old) = 6  -> window [1,3,2]
Answer = 9
```

```java
static int maxSumOfSizeK(int[] nums, int k) {
    int windowSum = 0;
    // sum of the very first window (first k elements)
    for (int i = 0; i < k; i++) {
        windowSum += nums[i];
    }
    int best = windowSum;

    // slide the window one step at a time
    for (int i = k; i < nums.length; i++) {
        windowSum += nums[i];            // element entering on the right
        windowSum -= nums[i - k];        // element leaving on the left
        best = Math.max(best, windowSum);
    }
    return best;
}
```

**Complexity:** time O(n), space O(1). (Brute force would be O(n x k).)

### 3.2 Longest Substring Without Repeating Characters (variable window)

**Question:** Find the length of the longest substring that has no repeated character.

| | |
|---|---|
| **Input** | `"abcabcbb"` |
| **Output** | `3` (the substring `"abc"`) |

**Idea:** Keep a window `[start..end]` with all unique characters. Move `end` forward. If the new character is already inside the window, move `start` just past its previous position. Remember the last index of every character in a HashMap.

**Walkthrough:**

```
s = "abcabcbb"
end=0 'a' -> window "a"    len 1
end=1 'b' -> window "ab"   len 2
end=2 'c' -> window "abc"  len 3   <- best
end=3 'a' -> 'a' seen at 0 (inside window) -> start=1, window "bca"  len 3
end=4 'b' -> 'b' seen at 1 (inside window) -> start=2, window "cab"  len 3
end=5 'c' -> 'c' seen at 2 (inside window) -> start=3, window "abc"  len 3
end=6 'b' -> 'b' seen at 4 (inside window) -> start=5, window "cb"   len 2
end=7 'b' -> 'b' seen at 6 (inside window) -> start=7, window "b"    len 1
Answer = 3
```

```java
static int longestUniqueSubstring(String s) {
    Map<Character, Integer> lastSeen = new HashMap<>(); // character -> last index it appeared
    int start = 0;                       // left edge of the window
    int best = 0;

    for (int end = 0; end < s.length(); end++) {   // end = right edge of the window
        char c = s.charAt(end);

        // if c is already inside the current window, shrink from the left
        if (lastSeen.containsKey(c) && lastSeen.get(c) >= start) {
            start = lastSeen.get(c) + 1;           // jump just past the old copy
        }

        lastSeen.put(c, end);                      // remember the latest position of c
        best = Math.max(best, end - start + 1);    // current window length
    }
    return best;
}
```

**Complexity:** time O(n), space O(min(n, alphabet size)).

---

## Pattern 4: HashMap-Based Problems

**When to use:** you keep asking "have I seen this value before?" A HashMap or HashSet answers that in O(1), so a nested O(n^2) loop becomes a single O(n) loop.

### 4.1 Two Sum (unsorted)

**Question:** Given an array and a `target`, return the indices of the two numbers that add up to `target`.

| | |
|---|---|
| **Input** | `nums = [2, 7, 11, 15]`, `target = 9` |
| **Output** | `[0, 1]` (2 + 7 = 9) |

**Idea:** For each number, the partner you need is `target - number`. Check if that partner was already seen. If not, store the current number and move on.

**Walkthrough:**

```
i=0, num=2: need 9-2=7. map is empty -> not found. store {2:0}
i=1, num=7: need 9-7=2. map has 2 at index 0 -> found! return [0, 1]
```

```java
static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> seen = new HashMap<>();   // number -> its index

    for (int i = 0; i < nums.length; i++) {
        int needed = target - nums[i];              // the partner we are looking for

        if (seen.containsKey(needed)) {
            return new int[]{seen.get(needed), i};  // partner was seen earlier
        }
        seen.put(nums[i], i);                       // remember this number for later
    }
    return new int[]{-1, -1};                       // no pair found
}
```

**Complexity:** time O(n), space O(n).

### 4.2 Subarray Sum Equals K

**Question:** Count how many contiguous subarrays have a sum exactly equal to `k`.

| | |
|---|---|
| **Input** | `nums = [1, 2, 3]`, `k = 3` |
| **Output** | `2` (the subarrays `[1, 2]` and `[3]`) |

**Idea:** Keep a running sum (prefix). If `currentPrefix - k` was seen before, then the elements between that earlier point and now add up to exactly `k`. A HashMap stores how many times each prefix sum has appeared.

**Walkthrough:**

```
count = {0:1}   (an "empty prefix" so subarrays starting at index 0 are counted)
answer = 0

num=1: prefix=1. look for 1-3 = -2 -> not in map. count = {0:1, 1:1}
num=2: prefix=3. look for 3-3 =  0 -> found 1 time -> answer=1  (subarray [1,2])
                 count = {0:1, 1:1, 3:1}
num=3: prefix=6. look for 6-3 =  3 -> found 1 time -> answer=2  (subarray [3])
                 count = {0:1, 1:1, 3:1, 6:1}

Answer = 2
```

```java
static int subarraySumEqualsK(int[] nums, int k) {
    Map<Integer, Integer> count = new HashMap<>();  // prefix sum -> how many times seen
    count.put(0, 1);        // empty prefix, so subarrays starting at index 0 work
    int prefix = 0;         // running sum
    int answer = 0;

    for (int num : nums) {
        prefix += num;                               // update running sum

        // every earlier prefix equal to (prefix - k) gives one valid subarray
        answer += count.getOrDefault(prefix - k, 0);

        // record the current prefix for future elements
        count.put(prefix, count.getOrDefault(prefix, 0) + 1);
    }
    return answer;
}
```

**Complexity:** time O(n), space O(n).

### 4.3 Longest Consecutive Sequence

**Question:** Given an unsorted array, find the length of the longest run of consecutive numbers (like 1, 2, 3, 4). Order in the array does not matter.

| | |
|---|---|
| **Input** | `nums = [100, 4, 200, 1, 3, 2]` |
| **Output** | `4` (the run `1, 2, 3, 4`) |

**Idea:** Put all numbers in a HashSet. Only start counting at a number whose previous number (`n - 1`) is **not** in the set, because that number is the start of a run. Then walk forward while `n + 1` exists.

**Walkthrough:**

```
set = {100, 4, 200, 1, 3, 2}

100: is 99 in set? No  -> start of a run. is 101 in set? No -> length 1
4:   is 3 in set?  Yes -> not a start, skip
200: is 199 in set? No -> start. 201? No -> length 1
1:   is 0 in set?  No  -> start. 2 yes, 3 yes, 4 yes, 5 no -> length 4  <- best
3:   is 2 in set?  Yes -> skip
2:   is 1 in set?  Yes -> skip

Answer = 4
```

```java
static int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
        set.add(n);                      // put every number in a set for O(1) lookup
    }

    int best = 0;
    for (int n : set) {
        // only begin counting if n is the START of a run (n-1 is missing)
        if (!set.contains(n - 1)) {
            int current = n;
            int length = 1;
            while (set.contains(current + 1)) {   // walk forward through the run
                current++;
                length++;
            }
            best = Math.max(best, length);
        }
    }
    return best;
}
```

**Complexity:** time O(n) (each number is visited at most twice), space O(n).

---

## Pattern 5: Kadane's Algorithm

**When to use:** "maximum sum of a contiguous subarray", or any problem that reduces to it.

**Real-life picture:** you are tracking profit over days. If your running total becomes negative, carrying it forward only hurts you, so you throw it away and start fresh.

### 5.1 Maximum Subarray Sum

**Question:** Find the contiguous subarray with the largest sum and return that sum.

| | |
|---|---|
| **Input** | `nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]` |
| **Output** | `6` (the subarray `[4, -1, 2, 1]`) |

**Idea:** At each element choose the better of: (a) extend the previous subarray, or (b) start a new subarray here.

**Walkthrough:**

| Number | current = max(num, current + num) | best so far |
|---|---|---|
| -2 | -2 (start) | -2 |
| 1 | max(1, -2+1) = 1 | 1 |
| -3 | max(-3, 1-3) = -2 | 1 |
| 4 | max(4, -2+4) = 4 | 4 |
| -1 | max(-1, 4-1) = 3 | 4 |
| 2 | max(2, 3+2) = 5 | 5 |
| 1 | max(1, 5+1) = 6 | **6** |
| -5 | max(-5, 6-5) = 1 | 6 |
| 4 | max(4, 1+4) = 5 | 6 |

```java
static int maxSubArray(int[] nums) {
    int current = nums[0];   // best sum of a subarray that ENDS at this index
    int best = nums[0];      // best sum found anywhere so far

    for (int i = 1; i < nums.length; i++) {
        // extend the old subarray, or start fresh from nums[i], whichever is bigger
        current = Math.max(nums[i], current + nums[i]);
        best = Math.max(best, current);
    }
    return best;
}
```

**Complexity:** time O(n), space O(1).

### 5.2 Best Time to Buy and Sell Stock

**Question:** `prices[i]` is the stock price on day `i`. You may buy once and sell once later. Return the maximum profit (0 if no profit is possible).

| | |
|---|---|
| **Input** | `prices = [7, 1, 5, 3, 6, 4]` |
| **Output** | `5` (buy at 1, sell at 6) |

**Idea:** While scanning, remember the cheapest price so far. The best profit if you sell today = `today's price - cheapest price so far`.

**Walkthrough:**

| Price | cheapest so far | profit if sold today | best profit |
|---|---|---|---|
| 7 | 7 | 0 | 0 |
| 1 | 1 | 0 | 0 |
| 5 | 1 | 4 | 4 |
| 3 | 1 | 2 | 4 |
| 6 | 1 | 5 | **5** |
| 4 | 1 | 3 | 5 |

```java
static int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;   // cheapest price seen so far (best day to buy)
    int profit = 0;                     // best profit found so far

    for (int price : prices) {
        minPrice = Math.min(minPrice, price);          // update the cheapest buy price
        profit = Math.max(profit, price - minPrice);   // what if I sell today?
    }
    return profit;
}
```

**Complexity:** time O(n), space O(1).

---

## Pattern 6: Binary Search

**When to use:** the data is **sorted** (or has a sorted-like yes/no property), and you want to find something fast. Each step throws away half of the remaining search area.

**Real-life picture:** guessing a number from 1 to 100. You say 50, hear "higher", and now only 51 to 100 remain.

### 6.1 Classic Binary Search

**Question:** Given a sorted array and a `target`, return the index of `target`, or `-1` if it is not present.

| | |
|---|---|
| **Input** | `sorted = [1, 3, 5, 7, 9]`, `target = 7` |
| **Output** | `3` |

**Walkthrough:**

```
low=0, high=4 -> mid=2, value 5 < 7  -> target must be on the right, low = 3
low=3, high=4 -> mid=3, value 7 == 7 -> found! return 3
```

```java
static int binarySearch(int[] sorted, int target) {
    int low = 0;
    int high = sorted.length - 1;

    while (low <= high) {
        // low + (high - low) / 2 avoids integer overflow of (low + high) / 2
        int mid = low + (high - low) / 2;

        if (sorted[mid] == target) {
            return mid;                  // found it
        } else if (sorted[mid] < target) {
            low = mid + 1;               // target is in the right half
        } else {
            high = mid - 1;              // target is in the left half
        }
    }
    return -1;                           // not present
}
```

**Complexity:** time O(log n), space O(1).

### 6.2 First Occurrence of a Number (with duplicates)

**Question:** In a sorted array with duplicates, return the index of the **first** occurrence of `target`, or `-1`. This is the base of many "kth element" and "boundary" problems.

| | |
|---|---|
| **Input** | `sorted = [1, 2, 2, 2, 3]`, `target = 2` |
| **Output** | `1` |

**Idea:** When you find the target, do not stop. Save the index and keep searching on the LEFT side for an earlier copy.

**Walkthrough:**

```
low=0, high=4 -> mid=2, value 2 == 2 -> save answer=2, search left: high=1
low=0, high=1 -> mid=0, value 1 <  2 -> go right: low=1
low=1, high=1 -> mid=1, value 2 == 2 -> save answer=1, search left: high=0
low=1 > high=0 -> stop. Answer = 1
```

```java
static int firstOccurrence(int[] sorted, int target) {
    int low = 0;
    int high = sorted.length - 1;
    int answer = -1;                     // stays -1 if target never appears

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (sorted[mid] == target) {
            answer = mid;                // candidate found
            high = mid - 1;              // but keep looking on the LEFT for an earlier one
        } else if (sorted[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return answer;
}
```

**Complexity:** time O(log n), space O(1).

---

## How to run

Put all the methods inside one class and add a `main`:

```java
import java.util.*;

public class DsaPatterns {

    // paste all the static methods from above here

    public static void main(String[] args) {
        System.out.println(rangeSum(buildPrefix(new int[]{2, 4, 6, 8}), 1, 3));       // 18
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4}))); // [24, 12, 8, 6]
        System.out.println(Arrays.toString(twoSumSorted(new int[]{1, 2, 4, 7, 11}, 9))); // [1, 3]
        System.out.println(isPalindrome("racecar"));                                  // true
        System.out.println(maxSumOfSizeK(new int[]{2, 1, 5, 1, 3, 2}, 3));            // 9
        System.out.println(longestUniqueSubstring("abcabcbb"));                       // 3
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));      // [0, 1]
        System.out.println(subarraySumEqualsK(new int[]{1, 2, 3}, 3));                // 2
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));      // 4
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));    // 6
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));                   // 5
        System.out.println(binarySearch(new int[]{1, 3, 5, 7, 9}, 7));                // 3
        System.out.println(firstOccurrence(new int[]{1, 2, 2, 2, 3}, 2));             // 1
    }
}
```

```bash
javac DsaPatterns.java && java DsaPatterns
```

---

## Practice plan

1. Read the question and the walkthrough, then **try to code it yourself** before looking at the solution.
2. After that, re-type the solution from memory the next day.
3. Solve the LeetCode versions: #1 Two Sum, #121 Best Time to Buy and Sell Stock, #53 Maximum Subarray, #560 Subarray Sum Equals K, #128 Longest Consecutive Sequence, #238 Product of Array Except Self.
4. Pattern check: before coding, say out loud which pattern the question belongs to and why (sorted? contiguous? need fast lookup? range sums?).
