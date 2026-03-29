# Java Regex 2 - Duplicate Words

**Platform**: HackerRank  
**Difficulty**: Medium  
**Link**: [https://www.hackerrank.com/challenges/duplicate-word/](https://www.hackerrank.com/challenges/duplicate-word/)

## Problem Statement

In this challenge, we use regular expressions (RegEx) to remove instances of words that are repeated more than once, but retain the first occurrence of any case-insensitive repeated word. 

For example, the words "love" and "to" are repeated in the sentence "I love Love to To tO code". Can you complete the code in the editor so it will turn "I love Love to To tO code" into "I love to code"?

## Task

To solve this challenge, complete the following three lines:

1. Write a RegEx that will match any repeated word.
2. Complete the second compile argument so that the compiled RegEx is case-insensitive.
3. Write the two necessary arguments for replaceAll such that each repeated word is replaced with the very first instance the word found in the sentence. It must be the exact first occurrence of the word, as the expected output is case-sensitive.

## Input Format

The first line contains an integer, `n`, denoting the number of sentences.
Each of the `n` subsequent lines contains a single sentence consisting of English alphabetic letters and whitespace characters.

## Constraints

- `1 <= n <= 100`
- Each sentence consists of at most `10^4` English alphabetic letters and whitespaces.

## Output Format

The modified string must be a modified version of the initial sentence where all repeat occurrences of each word are removed.

## Sample Input

```
5
Goodbye bye bye world world world
Sam went went to to to his business
Reya is is the the best player in eye eye game
in inthe
Hello hello Ab aB
```

## Sample Output

```
Goodbye bye world
Sam went to his business
Reya is the best player in eye game
in inthe
Hello Ab
```

## Explanation

1. We remove the second occurrence of "bye" and the second and third occurrences of "world" from "Goodbye bye bye world world world" to get "Goodbye bye world".

2. We remove the second occurrence of "went" and the second and third occurrences of "to" from "Sam went went to to to his business" to get "Sam went to his business".

3. We remove the second occurrence of "is", the second occurrence of "the", and the second occurrence of "eye" from "Reya is is the the best player in eye eye game" to get "Reya is the best player in eye game".

4. The sentence "in inthe" has no repeated words, so we do not modify it.

5. We remove the second occurrence of "ab" from "Hello hello Ab aB" to get "Hello Ab". It's important to note that our matching is case-insensitive, and we specifically retained the first occurrence of the matched word in our final string.

## Approach

### Regex Pattern Components:

1. **Word Boundary**: `\b` - Ensures we match complete words, not parts of words
2. **Capture Group**: `(\w+)` - Captures the first occurrence of a word
3. **Whitespace**: `\s+` - Matches one or more spaces between words
4. **Backreference**: `\1` - Refers back to the first captured group
5. **Repetition**: `+` - Matches one or more occurrences of the duplicate pattern

### Pattern Structure:
```
\b(\w+)(?:\s+\1\b)+
```

Breaking it down:
- `\b` - Start at word boundary
- `(\w+)` - Capture a word (group 1)
- `(?:...)` - Non-capturing group for the duplicates
- `\s+` - One or more whitespace characters
- `\1` - Backreference to the captured word
- `\b` - End at word boundary
- `+` - Match one or more repetitions of the duplicate

### Case-Insensitive Matching:
Use `Pattern.CASE_INSENSITIVE` flag when compiling the pattern.

### Replacement:
Use `$1` to replace the entire match (word + all duplicates) with just the first captured word.

## Important Notes

- The matching is **case-insensitive**
- The replacement preserves the **exact case** of the first occurrence
- Words like "in" and "inthe" are considered different (word boundaries matter)

## Solution

See [DuplicateWords.java](DuplicateWords.java) for the implementation.
