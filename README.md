# Week 1: Arrays & Basic Hashing (Java)

Six patterns that show up constantly in coding interviews, with commented Java you can copy and run.

| # | Pattern | Use it when | Problems in this file |
|---|---------|-------------|-----------------------|
| 1 | Prefix Sum | Many range-sum queries | Range Sum, Product of Array Except Self |
| 2 | Two Pointer | Sorted array, pair/palindrome checks | Two Sum II, Palindrome |
| 3 | Sliding Window | Contiguous subarray or substring | Max Sum of Size K, Longest Unique Substring |
| 4 | HashMap | Need O(1) lookup | Two Sum, Subarray Sum Equals K, Longest Consecutive Sequence |
| 5 | Kadane's Algorithm | Max sum of contiguous subarray | Maximum Subarray, Best Time to Buy and Sell Stock |
| 6 | Binary Search | Sorted data, boundaries, kth element | Classic Search, First Occurrence |

## How to run

Save the code below as `DsaPatterns.java`, then run:

```bash
javac DsaPatterns.java && java DsaPatterns
```

## Code

```java
import java.util.*;

/**
 * WEEK 1 - ARRAYS & BASIC HASHING
 * Run: javac DsaPatterns.java && java DsaPatterns
 *
 * Patterns covered:
 *  1. Prefix Sum         -> range sum queries
 *  2. Two Pointer        -> sorted arrays
 *  3. Sliding Window     -> contiguous subarray / substring
 *  4. HashMap problems   -> Two Sum, Subarray Sum = K, Longest Consecutive
 *  5. Kadane's Algorithm -> max subarray, best time to buy/sell stock
 *  6. Binary Search      -> sorted data, kth / first occurrence
 */
public class DsaPatterns {

    // =====================================================================
    // 1. PREFIX SUM
    // Idea: precompute running totals once, then answer ANY range sum in O(1).
    // nums    = [2, 4, 6, 8]
    // prefix  = [0, 2, 6, 12, 20]   (prefix[i] = sum of first i elements)
    // sum(l..r) = prefix[r+1] - prefix[l]
    // =====================================================================
    static int[] buildPrefix(int[] nums) {
        int[] prefix = new int[nums.length + 1]; // extra slot so prefix[0] = 0
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i]; // running total
        }
        return prefix;
    }

    // Sum of nums[l..r] (both inclusive) using the prefix array
    static int rangeSum(int[] prefix, int l, int r) {
        // total up to r, minus the part before l
        return prefix[r + 1] - prefix[l];
    }

    // Must-solve: Product of Array Except Self (prefix idea with products)
    // result[i] = (product of everything LEFT of i) * (product of everything RIGHT of i)
    // No division used, O(n) time.
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Pass 1: result[i] holds the product of all elements to the left of i
        int left = 1;
        for (int i = 0; i < n; i++) {
            result[i] = left;  // product of everything before i
            left *= nums[i];   // include nums[i] for the next index
        }

        // Pass 2: multiply by the product of all elements to the right of i
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right; // combine left * right
            right *= nums[i];   // include nums[i] for the next index (going left)
        }
        return result;
    }

    // =====================================================================
    // 2. TWO POINTER (works when the array is SORTED)
    // Idea: one pointer at the start, one at the end. Look at their sum:
    //   too small -> move left pointer right (bigger number)
    //   too big   -> move right pointer left (smaller number)
    // O(n) instead of O(n^2) brute force.
    // =====================================================================
    static int[] twoSumSorted(int[] sorted, int target) {
        int left = 0;
        int right = sorted.length - 1;
        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum == target) {
                return new int[]{left, right}; // found the pair
            } else if (sum < target) {
                left++;   // need a bigger sum
            } else {
                right--;  // need a smaller sum
            }
        }
        return new int[]{-1, -1}; // no pair exists
    }

    // Palindrome check: compare characters from both ends moving inward
    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false; // mismatch
            left++;
            right--;
        }
        return true;
    }

    // =====================================================================
    // 3. SLIDING WINDOW (contiguous subarray / substring)
    // Idea: keep a "window" [start..end]. Slide it by adding the new element
    // on the right and removing the old element on the left, instead of
    // recalculating everything.
    // =====================================================================

    // Fixed-size window: max sum of any k consecutive elements
    static int maxSumOfSizeK(int[] nums, int k) {
        int windowSum = 0;
        // Sum of the very first window
        for (int i = 0; i < k; i++) windowSum += nums[i];
        int best = windowSum;

        // Slide: add the new right element, remove the element leaving on the left
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i];     // element entering the window
            windowSum -= nums[i - k]; // element leaving the window
            best = Math.max(best, windowSum);
        }
        return best;
    }

    // Variable-size window: longest substring with NO repeating characters
    // "abcabcbb" -> 3 ("abc")
    static int longestUniqueSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>(); // char -> last index
        int start = 0;  // left edge of window
        int best = 0;

        for (int end = 0; end < s.length(); end++) { // end = right edge
            char c = s.charAt(end);
            // If c is already inside the current window, jump start past it
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= start) {
                start = lastSeen.get(c) + 1;
            }
            lastSeen.put(c, end);                  // remember latest position
            best = Math.max(best, end - start + 1); // window length
        }
        return best;
    }

    // =====================================================================
    // 4. HASHMAP-BASED PROBLEMS
    // Idea: trade memory for speed. Lookup in a HashMap/HashSet is O(1).
    // =====================================================================

    // Two Sum (unsorted): return indices of two numbers adding to target
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // value -> index
        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];     // the partner we are looking for
            if (seen.containsKey(needed)) {
                return new int[]{seen.get(needed), i}; // partner was seen earlier
            }
            seen.put(nums[i], i);              // remember this number for later
        }
        return new int[]{-1, -1};
    }

    // Subarray Sum Equals K  (PREFIX SUM + HASHMAP, very common!)
    // If prefixSum(now) - K was seen before, then the elements between
    // that earlier point and now add up to exactly K.
    static int subarraySumEqualsK(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>(); // prefixSum -> times seen
        count.put(0, 1);   // empty prefix: lets subarrays starting at index 0 count
        int prefix = 0;
        int answer = 0;

        for (int num : nums) {
            prefix += num;                              // running sum
            // How many earlier prefixes equal (prefix - k)? Each = one valid subarray
            answer += count.getOrDefault(prefix - k, 0);
            count.put(prefix, count.getOrDefault(prefix, 0) + 1);
        }
        return answer;
    }

    // Longest Consecutive Sequence: [100, 4, 200, 1, 3, 2] -> 4 (1,2,3,4)
    // O(n): only start counting from the BEGINNING of a sequence.
    static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);   // put everything in a set

        int best = 0;
        for (int n : set) {
            // Only start when n-1 is missing, meaning n begins a sequence
            if (!set.contains(n - 1)) {
                int current = n;
                int length = 1;
                while (set.contains(current + 1)) { // walk forward
                    current++;
                    length++;
                }
                best = Math.max(best, length);
            }
        }
        return best;
    }

    // =====================================================================
    // 5. KADANE'S ALGORITHM
    // Idea: at each element decide: "extend the previous subarray" or
    // "start fresh from here". If the running sum goes negative, it only
    // hurts us, so we drop it.
    // =====================================================================

    // Maximum Subarray Sum: [-2,1,-3,4,-1,2,1,-5,4] -> 6 ([4,-1,2,1])
    static int maxSubArray(int[] nums) {
        int current = nums[0]; // best sum of a subarray ending at this index
        int best = nums[0];    // best sum seen anywhere
        for (int i = 1; i < nums.length; i++) {
            // Either extend the old subarray or start new at nums[i]
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }

    // Best Time to Buy and Sell Stock: [7,1,5,3,6,4] -> 5 (buy 1, sell 6)
    // Track the cheapest price so far; profit = today's price - cheapest.
    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // cheapest day so far
        int profit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);        // best day to buy so far
            profit = Math.max(profit, price - minPrice); // sell today?
        }
        return profit;
    }

    // =====================================================================
    // 6. BINARY SEARCH (sorted data only)
    // Idea: look at the middle, throw away the half that cannot contain the
    // answer. O(log n).
    // =====================================================================

    // Classic: return index of target, or -1
    static int binarySearch(int[] sorted, int target) {
        int low = 0, high = sorted.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // avoids int overflow of (low+high)
            if (sorted[mid] == target) return mid;
            else if (sorted[mid] < target) low = mid + 1; // go right
            else high = mid - 1;                          // go left
        }
        return -1;
    }

    // Variation: FIRST index of target when duplicates exist
    // [1,2,2,2,3], target 2 -> 1
    static int firstOccurrence(int[] sorted, int target) {
        int low = 0, high = sorted.length - 1;
        int answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sorted[mid] == target) {
                answer = mid;      // candidate found...
                high = mid - 1;    // ...but keep looking further LEFT
            } else if (sorted[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    // =====================================================================
    // MAIN: run everything and print results so you can verify
    // =====================================================================
    public static void main(String[] args) {
        // 1. Prefix sum
        int[] a = {2, 4, 6, 8};
        int[] prefix = buildPrefix(a);
        System.out.println("Range sum [1..3]: " + rangeSum(prefix, 1, 3)); // 18
        System.out.println("Product except self: "
                + Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4}))); // [24,12,8,6]

        // 2. Two pointer
        System.out.println("Two sum sorted: "
                + Arrays.toString(twoSumSorted(new int[]{1, 2, 4, 7, 11}, 9))); // [1,3]
        System.out.println("Palindrome 'racecar': " + isPalindrome("racecar")); // true

        // 3. Sliding window
        System.out.println("Max sum size 3: "
                + maxSumOfSizeK(new int[]{2, 1, 5, 1, 3, 2}, 3)); // 9
        System.out.println("Longest unique substring: "
                + longestUniqueSubstring("abcabcbb")); // 3

        // 4. HashMap
        System.out.println("Two sum: "
                + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [0,1]
        System.out.println("Subarray sum = K: "
                + subarraySumEqualsK(new int[]{1, 2, 3}, 3)); // 2 ([1,2] and [3])
        System.out.println("Longest consecutive: "
                + longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4

        // 5. Kadane
        System.out.println("Max subarray: "
                + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println("Max profit: "
                + maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5

        // 6. Binary search
        System.out.println("Binary search: "
                + binarySearch(new int[]{1, 3, 5, 7, 9}, 7)); // 3
        System.out.println("First occurrence: "
                + firstOccurrence(new int[]{1, 2, 2, 2, 3}, 2)); // 1
    }
}
```

## Practice plan

1. Read each method, then close the file and rewrite it from memory.
2. Dry-run `subarraySumEqualsK` on `[1,2,3]` with `k=3` using pen and paper.
3. Solve the LeetCode versions: #1 Two Sum, #121 Best Time to Buy and Sell Stock, #53 Maximum Subarray, #560 Subarray Sum Equals K, #128 Longest Consecutive Sequence, #238 Product of Array Except Self.
