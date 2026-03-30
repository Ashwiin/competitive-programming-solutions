# Coding - Freelancing Platform

A customer has posted several web development projects on a freelancing platform, and developers have placed bids for those projects.

Given bid amounts and their corresponding projects, find the minimum amount the customer must pay to complete all projects.

If any project has no bids, return `-1`.

## Example
`numProjects = 3`

`projectId = [2, 0, 1, 2]`
`bid = [8, 7, 6, 9]`

`projectId[i]` aligns with `bid[i]`:
- Bidder 1 bids `8` for project `2`
- Bidder 2 bids `7` for project `0`
- Bidder 3 bids `6` for project `1`
- Bidder 4 bids `9` for project `2`

Minimum per project:
- Project `0` -> `7`
- Project `1` -> `6`
- Project `2` -> `8`

Total = `7 + 6 + 8 = 21`.

If instead `numProjects = 4`, answer is `-1` because project `3` has no bids.

## Function Description
Complete the function `minCost`.

### Parameters
- `int numProjects`: total projects labeled from `0` to `numProjects - 1`
- `int projectId[n]`: project index for each bid
- `int bid[n]`: bid amount for each entry

### Returns
- `long`: minimum total cost to complete all projects, or `-1` if any project has no bids

## Constraints
- `1 <= numProjects <= 5 * 10^5`
- `1 <= n <= 5 * 10^5`
- `0 <= projectId[i] < numProjects`
- `1 <= bid[i] <= 10^9`

## Input Format For Custom Testing
- First line: `numProjects`
- Second line: size `n` of `projectId`
- Next `n` lines: `projectId[i]`
- Next line: size `n` of `bid`
- Next `n` lines: `bid[i]`

## Sample Case 0

### Sample Input
```text
2
5
0
1
0
1
1
5
4
74
47
744
7
```

### Sample Output
```text
11
```

### Explanation
Project-wise bids:
- Project `0`: `4`, `47` -> minimum is `4`
- Project `1`: `74`, `744`, `7` -> minimum is `7`

Total minimum cost = `4 + 7 = 11`.

## Sample Case 1

### Sample Input
```text
2
2
1
1
2
4
7
```

### Sample Output
```text
-1
```

### Explanation
There are no bids for project `0`, so it is impossible to complete all projects.
