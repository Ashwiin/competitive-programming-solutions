# Java 8 - Lambda

This Java 8 challenge tests your knowledge of lambda expressions.

Write the following methods that return a lambda expression performing the specified action:

## Methods to Implement

### 1) `PerformOperation isOdd()`
The lambda expression must return `true` if a number is odd, or `false` if it is even.

### 2) `PerformOperation isPrime()`
The lambda expression must return `true` if a number is prime, or `false` if it is composite.

### 3) `PerformOperation isPalindrome()`
The lambda expression must return `true` if a number is a palindrome, or `false` if it is not.

## Input Format
Input is handled for you by the locked stub code in the editor.

- First line contains an integer `T` (number of test cases).
- Each of the next `T` lines contains two space-separated integers:
  - first integer specifies the condition:
    - `1` for Odd/Even check
    - `2` for Prime check
    - `3` for Palindrome check
  - second integer is the number to check

## Output Format
The locked stub code prints one output per test case.

## Sample Input
```text
5
1 4
2 5
3 898
1 3
2 12
```

## Sample Output
```text
EVEN
PRIME
PALINDROME
ODD
COMPOSITE
```
