# INTENT

From implementation decouple an abstraction so that two can vary independently

## APPLICABILITY

 - when you share an implementation among multiple objects and its hidden for client
 - you have proliferation of classes and such hierarchy indicates the need for splitting an object into two parts. Called alsp 'nested generalizations'
 - when changes of implementation of an abstraction should have no impact on clients and their code should not have to be recompiled
 - this pattern lets combine different abstractions and implementations,extends them independently.Both the absttractions and their implementations should be extensible by subclassing
 - when you want to avoid permanent binding between an abstraction and its implementation. For example: implementation must be switched or selected at run-time
