# Tryouts - Java 8 - Treasure Box Program

## Treasure Box Program

An archaeological team found a treasure box while excavating an ancient city. The treasure box comprises `(order * order)` number of grids with locks over it and resembles a riddle. The box opens only when all the locks are unlocked. The team found that each grid should be filled with an alphabet to unlock it.

Help the archaeological team open the treasure box and find the possible number of shortest ways to reach the `destinationLock` from the `sourceLock`.

An example of a solved treasure box is as follows.

![Treasure Box Diagram](treasure-box-diagram.jpg)

**Treasure Box diagram path:** `hackerrank/arrays/TreasureBoxProgram/treasure-box-diagram.jpg`

- `order`: 3
- `sourceRow`: 1
- `destinationRow`: 3
- `clue`: `A`
- `sourceLock`: `A`
- `destinationLock`: `G`

In this case, the treasure box contains `3 * 3` grids with locks in it. To unlock all locks, follow this pattern and fill the alphabets in each grid:

- The first row contains 3 grids:
  - first key is the clue itself: `A`
  - second key is `E` (3 alphabets skipped from previous key)
  - third key is `I` (3 alphabets skipped from previous key)
- The second row contains 3 grids:
  - first key is `M` (3 alphabets skipped from the third key in previous row)
  - second key is `Q` (3 alphabets skipped from previous key)
  - third key is `U` (3 alphabets skipped from previous key)
- The third row contains 3 grids:
  - first key is `Y` (3 alphabets skipped from the third key in previous row)
  - second key is `C` (3 alphabets skipped from previous key)
  - third key is `G` (3 alphabets skipped from previous key)

The possible number of shortest ways to reach `destinationLock (G)` from `sourceLock (A)` is **6**.

**Note:**
- If `order = 1`, fill keys skipping 1 alphabet.
- If `order = 2`, fill keys skipping 2 alphabets.
- If `order = 3`, fill keys skipping 3 alphabets.
- And so on.
- For shortest-way calculation, move one step at a time only in four directions: up, down, left, or right.
- `sourceRow` and `destinationRow` are 1-based indices.

## Function Description

Complete the functions `fillingKeys` and `possibleLockOrders`.

### `fillingKeys` parameters
- Integer `order`: order of grids in the treasure box
- Character `clue`

### `possibleLockOrders` parameters
- Character `sourceLock`
- Character `destinationLock`
- 2D char array `char[order][order]` returned by `fillingKeys`
- Integer `sourceRow`: source lock row
- Integer `destinationRow`: destination lock row

Write code to:
- fill correct keys in each grid to unlock all locks
- find number of possible shortest ways to reach `destinationLock` from `sourceLock`

### Returns
- `fillingKeys`: a 2D char array `char[order][order]`
- `possibleLockOrders`: an integer, number of possible shortest ways

## Input Format For Custom Testing

- First line: integer `order` (`1 <= order <= 10`)
- Second line: integer `sourceRow`
- Third line: integer `destinationRow`
- Last line: string `input` containing `clue`, `sourceLock`, and `destinationLock`
  - Format: exactly 3 uppercase letters without separators, in order: `clue + sourceLock + destinationLock`
  - Example: `TZW` means clue=`T`, sourceLock=`Z`, destinationLock=`W`

## Output Specifications

Output contains:
- A 2D char array containing all keys
  - keys are uppercase alphabets `A` to `Z`
  - after `Z`, sequence wraps back to `A`
- An integer denoting possible number of shortest ways from `sourceLock` to `destinationLock`
  - print `0` if source and destination locks are the same and in the same row

## Sample Case 0

### Sample Input
```text
2
2
1
TZW
```

### Sample Output
```text
T W
Z C
2
```

### Explanation

In this case, the treasure box contains `2 * 2` grids with locks in it.

- First row has 2 grids:
  - first key is clue `T`
  - second key is `W` (2 alphabets skipped from previous key)
- Second row has 2 grids:
  - first key is `Z` (2 alphabets skipped from second key in previous row)
  - second key is `C` (2 alphabets skipped from previous key)

The possible number of shortest ways to reach `destinationLock (W)` from `sourceLock (Z)` is **2**.

## Sample Case 1

### Sample Input
```text
4
3
2
YMH
```

### Sample Output
```text
Y D I N
S X C H
M R W B
G L Q V
4
```

### Explanation

In this case, the treasure box contains `4 * 4` grids with locks in it.

- First row:
  - `Y` (clue), `D`, `I`, `N` (each next key skips 4 alphabets)
- Second row:
  - `S`, `X`, `C`, `H` (first key skips 4 from previous row’s fourth key, then continue)
- Third row:
  - `M`, `R`, `W`, `B`
- Fourth row:
  - `G`, `L`, `Q`, `V`

The possible number of shortest ways to reach `destinationLock (H)` from `sourceLock (M)` is **4**.
