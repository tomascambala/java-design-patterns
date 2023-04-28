# INTENT

Also called Wrapper. Convert the interface of a class into another interface clients expect. This pattern lets classes work together that couldn't otherwise because of incompatible interfaces.

## Applicability

 - when its inpractical to adapt their interfaces by subclassing every one and you need to use several existing subclasess
 - you need to create a reusable class that cooperate with unforeseen or unrelated classes(dont have necessarily compatible interfaces)
 - when you need to use existing class and its interfaces doesnt not match the one you want