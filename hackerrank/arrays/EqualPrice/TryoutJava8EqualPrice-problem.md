# Coding - Equal Price

A shop in HackerLand contains `n` items where the price of the `i`th item is `price[i]`.
In one operation, the price of any one item can be increased or decreased by `1`.

Given `q` queries denoted by `query[]`, find the minimum number of operations required to make the price of all items equal to each `query[i]`.

Each query is independent, so original prices are restored before the next query.

## Example
`n = 3`, `q = 4`
`price = [1, 2, 3]`
`query = [3, 2, 1, 5]`

- For `3`: operations are `[2, 1, 0]`, total = `3`
- For `2`: operations are `[1, 0, 1]`, total = `2`
- For `1`: operations are `[0, 1, 2]`, total = `3`
- For `5`: operations are `[4, 3, 2]`, total = `9`

Answer: `[3, 2, 3, 9]`.

## Function Description
Complete the function `countMinimumOperations`.

### Parameters
- `int price[n]`: original prices
- `int query[q]`: query values

### Returns
- `long_int[q]`: minimum operations for each query in input order

## Constraints
- `1 <= n <= 2 * 10^5`
- `1 <= price[i] <= 10^9`
- `1 <= q <= 2 * 10^5`
- `1 <= query[i] <= 10^9`

## Input Format For Custom Testing
- First line: integer `n`
- Next `n` lines: `price[i]`
- Next line: integer `q`
- Next `q` lines: `query[i]`

## Sample Case 0

### Sample Input
```text
3
2
5
1
3
8
4
3
```

### Sample Output
```text
16
6
5
```

### Explanation
- For `8`: operations are `[6, 3, 7]`, total = `16`
- For `4`: operations are `[2, 1, 3]`, total = `6`
- For `3`: operations are `[1, 2, 2]`, total = `5`

## Sample Case 1

### Sample Input
```text
1
2
5
8
4
3
10
6
```

### Sample Output
```text
6
2
1
8
4
```

### Explanation
- For `8`: operations are `[6]`
- For `4`: operations are `[2]`
- For `3`: operations are `[1]`
- For `10`: operations are `[8]`
- For `6`: operations are `[4]`
 