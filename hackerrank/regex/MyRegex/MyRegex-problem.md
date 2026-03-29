# Java Regex - IP Address Validation

**Platform**: HackerRank  
**Difficulty**: Medium  
**Link**: [https://www.hackerrank.com/challenges/java-regex/](https://www.hackerrank.com/challenges/java-regex/)

## Problem Statement

Write a class called `MyRegex` which will contain a string pattern. You need to write a regular expression and assign it to the pattern such that it can be used to validate an IP address.

Use the following definition of an IP address:

IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from **0 to 255**. Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.

## Valid IP Examples

```
000.12.12.034
121.234.12.12
23.45.12.56
```

## Invalid IP Examples

```
000.12.234.23.23    (5 segments instead of 4)
666.666.23.23       (666 > 255)
.213.123.23.32      (starts with a dot)
23.45.22.32.        (ends with a dot)
I.Am.not.an.ip      (non-numeric segments)
```

## Requirements

- Write the `MyRegex` class which contains a `String pattern`
- The string should contain the correct regular expression
- **MyRegex class MUST NOT be public**

## Sample Input

```
000.12.12.034
121.234.12.12
23.45.12.56
00.12.123.123123.123
122.23
Hello.IP
```

## Sample Output

```
true
true
true
false
false
false
```

## Constraints

In this problem you will be provided strings containing any combination of ASCII characters. You have to write a regular expression to find the valid IPs.

## Approach

To validate an IP address with the given rules:

1. **Format**: Must be exactly 4 segments separated by dots (A.B.C.D)
2. **Each segment must**:
   - Be numeric
   - Have 1-3 digits (no more than 3)
   - Have value between 0-255

### Breaking Down the Regex Pattern:

For each segment (0-255 with max 3 digits):
- `[0-9]` - Single digit (0-9)
- `[0-9][0-9]` - Two digits (00-99)
- `[01][0-9][0-9]` - Three digits starting with 0 or 1 (000-199)
- `2[0-4][0-9]` - Three digits: 200-249
- `25[0-5]` - Three digits: 250-255

### Final Pattern Structure:
- Use `^` to match start of string
- Match segment pattern 3 times followed by a dot
- Match one final segment (no dot after)
- Use `$` to match end of string

## Solution

See [MyRegex.java](MyRegex.java) for the implementation.
