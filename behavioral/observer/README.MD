## INTENT

When one object changes state, all it's dependants are notified and updated automatically. Observer defines a one-to-many dependancy between object.

## Applicability
 - when you don't know how many objects need to be changed and change to one one object require changing others
 - when you dont want the objects be coupled. Object should be able to notify other objects without making assumptions who these objects are.
 - when you need to have abstraction with 2 aspects, one dependant on others and encapsulating these aspects in separate object lets you vary and reuse them independently