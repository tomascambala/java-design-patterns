# INTENT

When internal state change allow an object to alter its behaviour. The object will appear to change its class.

## APPLICABILITY

- operations have large, multipart conditional statements that depend on the object's state, which is ussualy represented by one or more enumerated constants. Several operations contain often the same conditional structure. This pattern puts each branch of conditional in a separate class, which lets you treat the object's state as an object on its own right that can vary independently from other objects.