# Coding - Chairs Requirement

Determine the minimum number of chairs that must be purchased for each simulation.
Initially, there are no chairs in the workroom.

Each simulation string consists of these characters:
- `C`: A new employee arrives in the workroom.
  - If a chair is available, they take it.
  - Otherwise, a new chair is purchased.
- `R`: An employee goes to a meeting room, freeing a chair.
- `U`: An employee returns from a meeting room.
  - If a chair is available, they take it.
  - Otherwise, a new chair is purchased.
- `L`: An employee leaves the workroom, freeing a chair.

## Example
Given:
`simulations = ["CRUL"]`

Processing `CRUL`:
- Start: purchased = 0, available = 0
- `C`: no available chair, purchase 1 -> purchased = 1, available = 0
- `R`: free one chair -> available = 1
- `U`: use one available chair -> available = 0
- `L`: free one chair -> available = 1

Minimum chairs purchased for this simulation = `1`.
Result = `[1]`.

## Function Description
Complete the function `minChairs`.

### Parameters
- `string simulations[n]`: an array of simulation strings

### Returns
- `int[n]`: minimal number of chairs required for each simulation

## Constraints
- `1 <= n <= 100`
- `1 <= length(simulations[i]) <= 10000`

## Input Format For Custom Testing
- First line: integer `n`, number of simulations
- Next `n` lines: one simulation string per line

## Sample Case 0

### Sample Input
```text
3
CCRUCL
CRUC
CCC
```

### Sample Output
```text
3
2
3
```

### Explanation
- `CCRUCL` -> needs 3 chairs
- `CRUC` -> needs 2 chairs
- `CCC` -> needs 3 chairs

## Sample Case 1

### Sample Input
```text
3
CCCRRR
CC
CCRURC
```

### Sample Output
```text
3
2
2
```

### Explanation
- `CCCRRR` -> 3 chairs
- `CC` -> 2 chairs
- `CCRURC` -> 2 chairs
