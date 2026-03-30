# Coding - Array Challenge

For each element of an array, a counter is set to 0. The element is compared to each element to its left. If the element to the left is greater, the absolute difference is subtracted from the counter. If the element to the left is less, the absolute difference is added to the counter. For each element of the array, determine the value of the counter. These values should be stored in an array and returned.

## Example
Let `n = 3`, the number of elements  
`arr = [2, 4, 3]`

- For `arr[0] = 2`, counter starts at 0 and there are no elements to the left, so `counter = 0`.
- For `arr[1] = 4`, counter starts at 0 and then increases by `|4 - 2| = 2` at the first and only comparison: `counter = 2`.
- Testing `arr[2] = 3`, first against 2, `counter = 0 - |3 - 4| = -1`, and then against 2, `counter = -1 + |3 - 2| = 0`.

The answer array is `[0, 2, 0]`.

## Function Description
Complete the function `arrayChallenge` in the editor below.

`arrayChallenge` has the following parameter(s):
- `int arr[n]`: an array of integers

## Returns
- `int[n]`: an array of integers calculated as described

## Constraints
- `1 ≤ n ≤ 10^5`
- `1 ≤ arr[i] ≤ 10^9`

## Input Format For Custom Testing

### Sample Case 0

**Sample Input**
```
3
2
1
3
```

**Sample Output**
```
0
-1
3
```

**Explanation**
- The first element has none to its left, so `counter = 0`.
- The second element, `counter = 0 - |1 - 2| = -1`.
- The third element: first compare with 2, `counter = 0 + |3 - 2| = 1`, then compare with 1, `counter = 1 + |3 - 1| = 3`.

### Sample Case 1

**Sample Input**
```
4
1
2
2
3
```

**Sample Output**
```
0
1
1
4
```

## Task
Complete the 'arrayChallenge' function below. The function is expected to return a LONG_INTEGER_ARRAY. The function accepts INTEGER_ARRAY `arr` as a parameter.
