# INTENT
The pattern lets subclasses redefine subclasses redefine certain steps of an algorithm without changing algorithm's structure. Template Method define the skeleton of an algorithm in an operation, deffering some steps to subclasses.

## Applicability
 - you can define a template method that call "hook" operations at specific point, thereby permitting extension only at those points to control subclassess
 - if you want to implement invariant part of an algorithm once and leave it up to subclasses to implement the behavior that can vary
 - if you want common beavior among subclasses should be localized and factored in a common class to avoid code duplication. You first identify the differences in the existing code and then separate the differences into new operations. In the end yyou replace the differing code a tempalte method that calls one of these new operations