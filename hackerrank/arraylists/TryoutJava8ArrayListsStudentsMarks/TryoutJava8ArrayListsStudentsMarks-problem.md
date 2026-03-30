# Tryout - Java 8 - ArrayLists (Students Marks)

"ABC" school has conducted a monthly test. The school needs all class teachers to report:
- subject average
- highest mark in each subject
- lowest mark in each subject
- number of failures in each subject

In seventh standard, there are `n` students. Their marks for five subjects are given:
- Tamil
- English
- Mathematics
- Science
- Social

## Function Description
Complete the function `performance`.

### Parameters
- `tamil`: integer array of length `n`
- `english`: integer array of length `n`
- `maths`: integer array of length `n`
- `science`: integer array of length `n`
- `social`: integer array of length `n`

### Return
Return an integer array list of size 20 in this exact order:

1. First 5 values: average marks (Tamil, English, Mathematics, Science, Social)
1. Next 5 values: highest marks (Tamil, English, Mathematics, Science, Social)
1. Next 5 values: lowest marks (Tamil, English, Mathematics, Science, Social)
1. Last 5 values: number of failed students (Tamil, English, Mathematics, Science, Social)

Failure condition: mark `< 35`.

## Constraints
- `1 <= n < 20`
- `0 <= marks[i] <= 100`

## Input Format For Custom Testing
- First line: integer `n`
- Next `n` lines: Tamil marks
- Next `n` lines: English marks
- Next `n` lines: Mathematics marks
- Next `n` lines: Science marks
- Next `n` lines: Social marks

## Sample Case 0

### Sample Input
```text
10
87
96
23
45
75
98
64
88
99
95
96
98
35
48
35
30
23
88
78
66
100
96
98
93
95
100
78
20
10
89
66
84
75
55
54
26
13
89
96
45
56
76
48
33
35
99
34
78
33
5
```

### Sample Output
```text
77
59
77
60
49
99
98
100
96
99
23
23
10
13
5
1
2
2
2
4
```

## Sample Case 1

### Sample Input
```text
7
94
66
73
21
45
0
47
96
93
78
51
22
47
93
75
99
64
88
99
100
37
88
65
45
28
54
17
66
36
65
14
23
15
98
68
```

### Sample Output
```text
49
68
80
51
45
94
96
100
88
98
0
22
37
17
14
2
1
0
2
3
```
