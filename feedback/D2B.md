# Deliverable **D2B**

## Group Name: **tue12t**

## Criteria

### Criteria for gaining 0.5 / 3 **yes**
* The required admin files have been correctly filled in, committed
  and pushed, passing the CI compliance test. **yes**

### Criteria for gaining 1.5 / 3 **yes**
* The previous criteria plus… **yes**
* The Git log or other material provides evidence of healthy teamwork. **yes**
* Your skeleton version of the game is appropriately designed. **yes**

### Criteria for gaining 2.5 / 3 **no**
* The previous criteria plus… **no**
* The skeleton version of the game has well-selected class, method and
  field names. **no**
* Fields and methods are included in all of the classes. **no**

### Criteria for gaining 3 / 3 **no**
* The previous criteria plus… **yes**
* Your design is outstanding. **no**

## Group Feedback

* It's good to see all of the main elements of the game represented as fields on `CommonArea` and `Player`. However, there is too much reliance on `char` to represent the elements of the game. While we use characters and Strings in the representation of the game we provide to you for testing purposes, there is no need to restrict yourself to only character representations in your internal game design. (In fact, I think this will make your programming task much harder.) You should use classes and enums where appropriate to provide a rich representation of the state and behaviour of the game elements. For example, tile colour could be an enum type to ensure it can't take on an invalid value like 'x'. The factories, bag, etc. could be represented as classes with methods that implement the important operations on these entities.
* Some of the method names don't make immediate sense, and there's no Javadoc to explain what they do. For example, `CommonArea.operateDiscard`. Use more descriptive verb phrases to indicate what the method does e.g. `transferDiscardToBag` or `moveFromFactoryToDiscard`.
* It's not clear what the interfaces `Move` and `Rules` are for. Interfaces are definitions of pure behaviour, so an interface doesn't really make sense unless there's at least one method defined on it. Flesh out your design by defining methods on your interfaces, and indicating where objects of class types that implement these interfaces will be used as fields or parameters.

## Mark: **1.5/3**
