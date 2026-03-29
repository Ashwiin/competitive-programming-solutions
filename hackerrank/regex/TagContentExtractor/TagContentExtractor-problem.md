# Tag Content Extractor

**Platform**: HackerRank  
**Difficulty**: Medium  
**Link**: [https://www.hackerrank.com/challenges/tag-content-extractor/](https://www.hackerrank.com/challenges/tag-content-extractor/)

## Problem Statement

In a tag-based language like XML or HTML, contents are enclosed between a start tag and an end tag like `<tag>contents</tag>`. Note that the corresponding end tag starts with a `/`.

Given a string of text in a tag-based language, parse this text and retrieve the contents enclosed within sequences of well-organized tags meeting the following criterion:

1. The name of the start and end tags must be same. The HTML code `<h1>Hello World</h2>` is not valid, because the text starts with an h1 tag and ends with a non-matching h2 tag.

2. Tags can be nested, but content between nested tags is considered not valid. For example, in `<h1><a>contents</a>invalid</h1>`, `contents` is valid but `invalid` is not valid.

3. Tags can consist of any printable characters.

## Input Format

The first line of input contains a single integer, `n` (the number of lines).
The `n` subsequent lines each contain a line of text.

## Constraints

- `1 <= n <= 100`
- Each line contains a maximum of `10^4` printable characters.
- The total number of characters in all test cases will not exceed `10^6`.

## Output Format

For each line, print the content enclosed within valid tags.
- If a line contains multiple instances of valid content, print out each instance of valid content on a new line
- If no valid content is found, print `None`

## Sample Input

```
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>
```

## Sample Output

```
Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush
```

## Explanation

1. **Line 1**: `<h1>Nayeem loves counseling</h1>`
   - Valid tags with matching start `<h1>` and end `</h1>`
   - Output: "Nayeem loves counseling"

2. **Line 2**: `<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>`
   - First valid content: `<h1>Sanjay has no watch</h1>` (the inner h1 tags)
   - Second valid content: `<par>So wait for a while</par>`
   - The outer h1 tags contain nested tags, so only the innermost content is considered valid

3. **Line 3**: `<Amee>safat codes like a ninja</amee>`
   - Tags don't match (case-sensitive): `Amee` vs `amee`
   - Output: "None"

4. **Line 4**: `<SA premium>Imtiaz has a secret crush</SA premium>`
   - Valid tags with matching start and end (tags can have spaces)
   - Output: "Imtiaz has a secret crush"

## Approach

### Strategy:

1. Use regex to find all matching tag pairs
2. For each tag, capture:
   - The tag name (including spaces and any printable characters)
   - The content between start and end tags
3. Use backreferences to ensure start and end tags match
4. Handle nested tags by extracting only the innermost content

### Regex Pattern Components:

- `<([^>]+)>` - Matches opening tag and captures tag name
- `([^<]+)` - Captures content (non-greedy to handle nested tags)
- `</\1>` - Matches closing tag using backreference to ensure it matches the opening tag

### Pattern Structure:
```
<(.+?)>([^<]+)</\1>
```

Breaking it down:
- `<` - Match opening bracket
- `(.+?)` - Capture tag name (non-greedy, any character except >)
- `>` - Match closing bracket of start tag
- `([^<]+)` - Capture content (anything that's not an opening bracket)
- `</` - Match start of closing tag
- `\1` - Backreference to the captured tag name
- `>` - Match closing bracket of end tag

### Implementation Notes:

- Tags are case-sensitive
- Content must not be empty (not just whitespace)
- Multiple valid tags on the same line should each print on a new line
- If no valid content found, print "None"

## Solution

See [TagContentExtractor.java](TagContentExtractor.java) for the implementation.
