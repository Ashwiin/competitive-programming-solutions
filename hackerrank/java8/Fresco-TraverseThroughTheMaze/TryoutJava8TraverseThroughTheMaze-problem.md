# Tryouts - Java 8 - Traverse through the Maze

A 2D string array represents a square maze and consists of `}{`, `{}`, `X`, and `O`.

- `}{` represents the entry of the maze.
- `{}` represents the exit of the maze.
- `X` represents walls.
- `O` represents valid path cells.

The maze can be traversed in four directions: up, down, left, and right.

You must write a program to enter the maze from `}{`, traverse through valid path cells, and exit through `{}`.

## Function Description

Implement the function `traverseMaze(int size, String[][] maze)` in class `Maze`.

### Requirements

- `size` is the size of the square maze.
- `maze` stores the maze contents.
- Start from the entry `}{`.
- Traverse through `O` cells.
- Exit at `{}`.

The function should return a string array with 2 elements:

1. Number of steps from entry `}{` to exit `{}`.
- Entry position is considered step `0`.
2. A string representing the path traversed from `}{` to `{}`.

Note: If the exit cannot be reached, return steps as `0`.

## Constraints

- Entry and exit positions are present only on the border of the maze.
- Only one path `O` emerges from the entry `}{`, then may branch.
- Branches are blocked by walls `X`.
- Exactly one unique valid path exists from `}{` to `{}` without crossing walls.

## Input Format For Custom Testing

- First line: integer `size` (size of the square maze).
- Next `size` lines: each line has `size` space-separated elements representing one row of `maze`.

## Sample Case 0

### Sample Input
```text
7
X X X X X }{ X
O O X O O O X
X X X X X O X
X O O O X O X
X O X O O O X
{} O X X O X O
X X O X X O X
```

### Sample Output
```text
12 steps are needed to reach the end of the maze.
The path traversed through the Maze is: }{ O O O O O O O O O O O {}
```

### Explanation

The unique path contains:
- one `}{`
- one `{}`
- eleven `O` cells

So, the number of steps is `12` (`0 + 1 + 11`).

## Sample Case 1

### Sample Input
```text
3
}{ X O
O X X
X X {}
```

### Sample Output
```text
The end of the maze could not be reached.
```

### Explanation

The path between entry `}{` and exit `{}` is blocked by walls `X`, so the maze end cannot be reached.
