# INTENT
The visitor pattern represents an operation to be performed on elements of objects structure. It lets define a new operation without changing operating classes of the elements.

## Applicability
- you want often to define new operations over the structure and the classes defining the object rarely changes. It is potentionally costly to define. If the object structure change often, then it;s probably better to define the operations in those classes
- you want to perform operation on classes which depends on their concrete classes and an object structure contains many classes of objects with differing interfaces
- you want to avoid "polluting" their classes with these operations, many distinct and unrelated operations need to be performed on objects in an object structure. The pattern lets keep related operations together by defining them in one class. When the object structure is shared by many applications, it's good idea to use visitor pattern to put operation in just those applications