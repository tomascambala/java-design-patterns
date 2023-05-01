# Intent

Lets a class defer instantiantion to subclasses. Factory method define an interface an object, but let subclasses to decide which class to instantiate.

## Applicability

- classes delegate responsibility to one of several helper subclasses and you want to localize knowledge of which helper subclass is the delegate
- a class wants its subclasses to specify created objects
- a class can't anticipate the class of objects it must create