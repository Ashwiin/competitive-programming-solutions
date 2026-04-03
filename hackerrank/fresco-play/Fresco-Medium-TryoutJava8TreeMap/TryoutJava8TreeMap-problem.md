# TRYOUT - JAVA 8 - TREE MAP

A website offers online streaming of web series and wants to create filters to improve customer experience.

You are given:
- `TreeMap<String, Web_Series> tmap`
- a query string `query`

In the map:
- key = web series name
- value = `Web_Series` object containing rating, status, and genre

You must implement one of the three filters depending on query type.

## Functions to Implement
In class `Web_SeriesBase`, implement:
- `filterByRatings(TreeMap<String, Web_Series> tmap, String query)`
- `filterByStatusAndGenre(TreeMap<String, Web_Series> tmap, String query)`
- `mostPopularGenre(TreeMap<String, Web_Series> tmap, String query)`

### 1) filterByRatings
Called when filter number is `1`.

Return `TreeMap<String, Web_Series>` containing all web series with **rating** `>= q1_rating`.

Query format:
- `q, q1_rating`

If none match, return an empty `TreeMap`.

### 2) filterByStatusAndGenre
Called when filter number is `2`.

Return `TreeMap<String, Float>` containing web series name and **rating** where:
- **status** matches `q2_status`
- **genre** matches `q2_genre`

Query format:
- `q, q2_status, q2_genre`

If none match, return an empty `TreeMap`.

### 3) mostPopularGenre
Called when filter number is `3`.

Return `TreeMap<String, Integer>` containing genre(s) with maximum count and their counts.

If multiple genres tie for maximum count, return all of them.

Query format:
- `q`

## Constraints
- 1 <= **q** <= 3
- 0.0 <= **rating** <= 10.0
- **status** in {Completed, Ongoing}
- **genre** in {Drama, Kids, Fantasy, Humour, Mystery, Romance, Sports}

## Input Format For Custom Testing
- First line: integer `n` (number of web series)
- Next `n` lines: `name - rating - status - genre`
- Last line: query string

Query patterns:
- If **q**=1: `<q>, <q1_rating>`
- If **q**=2: `<q>, <q2_status>, <q2_genre>`
- If **q**=3: `<q>`

## Sample Case 0 (Filter 1)

### Sample Input
```text
7
Brightest Star in the Sky - 8.9 - Completed - Drama
Hatim(2003) - 6.6 - Completed - Drama
Her Private Life - 9.2 - Ongoing - Romance
Tanhayian - 9.6 - Completed - Romance
My dear Bhootham - 6.1 - Completed - Kids
Legend of the Blue Sea - 9.5 - Completed - Fantasy
Kanaa Kaanum Kaalangal - 7.2 - Completed - Drama
1, 8.9
```

### Sample Output
```text
Brightest Star in the Sky - 8.9 - Completed - Drama
Her Private Life - 9.2 - Ongoing - Romance
Legend of the Blue Sea - 9.5 - Completed - Fantasy
Tanhayian - 9.6 - Completed - Romance
```

## Sample Case 1 (Filter 2)

### Sample Input
```text
5
Tanhayian - 9.6 - Completed - Romance
Honey, I shrunk the Kids - 8.2 - Ongoing - Kids
Her Private Life - 9.2 - Ongoing - Romance
The King's Avatar - 8.5 - Completed - Sports
Strong Woman Do Bong Soon - 9.7 - Completed - Romance
2, Completed, Romance
```

### Sample Output
```text
Strong Woman Do Bong Soon - 9.7
Tanhayian - 9.6
```

## Sample Case 2 (Filter 3)

### Sample Input
```text
9
Phineas and Ferb - 8.8 - Ongoing - Kids
Martin Mystery - 9.3 - Completed - Mystery
Legend of the Blue Sea - 9.5 - Completed - Fantasy
Kekkaishi - 7.3 - Ongoing - Fantasy
Hatim(2003) - 8.6 - Completed - Drama
Love o2o - 9.3 - Completed - Romance
Jackie Chan's Adventures - 9.1 - Ongoing - Kids
Kuroko No Basuke - 9.4 - Ongoing - Sports
Lollu Sabha - 8.7 - Completed - Humour
3
```

### Sample Output
```text
The Most Popular Genres are Fantasy and Kids as they each have 2 Web Series.
```
