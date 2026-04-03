# Java 8 - Filtering

This Java 8 challenge tests your knowledge of lambda expressions.

Write the following methods that return lambda expressions performing the specified actions:

## Methods to Implement

### 1) `ReadInput readInput()`
The lambda expression must:
- read the input,
- convert it into a list of lists of integers,
- return the resulting structure.

### 2) `FilterData filterData()`
The lambda expression must:
- take the list of lists returned by `readInput`,
- filter each inner list by deleting numbers that end with the trailing number,
- square the filtered integers,
- return the result in the same list-of-lists format.

## Input Format
Input must be handled by you inside the `readInput` method.

- The first line contains an integer `t` (the trailing number).
- The subsequent lines each contain integers separated by spaces.
- Each such line corresponds to one inner list.

## Output Format
The locked stub code prints the output lines.

## Sample Input
```text
3
1 43 5
2 5 3
8 1 4 1
```

## Sample Output
```text
1
25
4
25
64
1
16
1
```

## Explanation
Input is converted into:

```text
[[1, 43, 5], [2, 5, 3], [8, 1, 4, 1]]
```

The trailing number is `3`, so values ending with `3` are removed:

```text
[[1, 5], [2, 5], [8, 1, 4, 1]]
```

Now each remaining value is squared:

```text
[[1, 25], [4, 25], [64, 1, 16, 1]]
```

This transformed list is returned by `filterData`.
