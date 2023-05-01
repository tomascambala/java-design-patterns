# INTENT

Specify the kinds of objects to create using a prototypical instance and by copying create new objects

## Applicabillity

- to avoid building a class hierarchy of factories that parallels the class hierarchy of products or when instances of class can have of only a few different combinations of state. It's more convenient to install a corresponding number of prototypes and clone them than instantianting the clas manually, every time with the appropriate state
- tha classes to instantiate are specified at run time(such as "Dynamic loading")