### Task3
The first line of input contains a positive number `n`, next `n` lines contains pairs of positive integers, where each pair identifies a connection between two vertices in a graph. Please provide a working code that will give us the answer for the following questions: how many separated graphs are in the input.

Sample:

For the input:

```
3
4 3
1 4
5 6
```

expected output is:

```
2
```

#### Explanaintion
The task input defines connection between vertices, so:

```
3
1 2
2 3
4 5
```

such input means we have 3 connections (and we know about 5 different vertices according to connection definition), which could visually look like:

```
[1]-[2]-[3]

[4]-[5]
```

So, in the example there are two separated groups of connected vertices (so `2` is a valid answer). If for example we would add fourth connection to this example, between `3` and `4` we would have only one separated group of vertices (`1` will be the answer for the extended example).

As for the input, the first line will define a number (let's call it `n`) and then in next `n` lines you will have always 2 numbers (let's call them `a` and `b`) - that's a definition of a connection between vertex `a` and `b`.

