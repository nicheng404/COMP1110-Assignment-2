# Deliverable **D2C**

## Group Name: **tue12t**

## Criteria

##### Criteria for gaining 0.5 / 4

* The required admin files have been correctly filled in, committed and pushed, passing the CI compliance test.  **yes**
* The git log reveals healthy use of Git.  **yes**

##### Criteria for gaining 1.5 / 4

The previous criteria plus...
* Completion of the Pass level requirements for Part One of the game.  **yes**

##### Criteria for gaining 2.5 / 4

The previous criteria plus...
* Completion of the Credit level requirements for Part One of the game. **no**
* Your design shows evidence of modification or further reflection based on feedback received from your tutor for deliverable D2B.  **no**

##### Criteria for gaining 3 / 4

The previous criteria plus...
* Completion of the Distinction level requirements for Part One of the game.  **no**

##### Criteria for gaining 4 / 4

The previous criteria plus...
* The work is exceptional.  **no**

## Group Feedback

- Congratulations on completing up to Task 6 - I can see a lot of work has gone into the code.
- My feedback from D2B has not been incorporated into the game design. The game tasks are all implemented in the classes `Azul` and `ValidStates` using `String` and `char` representations, which makes the code much more complicated than it needs to be. I note that you have improved the design in comp1110.ass2.D2B - this should be used to actually implement the game rules.
- I don't think that converting the bag or discard substring to a single integer will make the job of implementing the rules easier (or the resulting code easier to understand). For example, given a bag integer value like b=1915161614, the number of c tiles is ((b % 1000000) / 1000) which really isn't intuitive for a reader of the code. Try parsing the string into multiple integer values (one for each tile type) and storing the resulting values in a `Bag` object.
- The Viewer is not implemented.

## Mark: **1.75/4**
