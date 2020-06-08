# Refactoring to Clean Code
---
## Outline
- Definition of Clean Code
- Alignment on Criteria
- Definition of Refactoring
- Different types of Refactorings

---
## Definition of Clean Code
@img[south-east span-40](assets/img/dave-thomas.png)
@snap[west text-08 span-40]
@quote[Clean code can be read and enhanced by a developer other than its original Author](Dave Thomas - OTI, godfather of the Eclipse Strategy)
@snapend

---
## Definition of Clean Code
@img[south-east span-50](assets/img/grady-booch.png)
@snap[west text-08 span-40]
@quote[Clean code reads like well-written prose](Grady Booch - Author of Object Oriented Analysis and Design with Applications)
@snapend


---
## Definition of Clean Code
@img[south-east span-40](assets/img/ward-cunningham.png)
@snap[west text-07 span-50]
@quote[You know you are working on clean code when each routine you read turns out to be pretty much what you expected. You can call it beautiful code when the code also makes it look like the language was made for the problem.](Ward Cunningham - Inventor of Wiki, Coinventor of eXtreme Programming)
@snapend
---
## Definition of Clean Code
@img[south-east span-40](assets/img/greg-hutchinson.png)
@snap[west text-07 span-50]
@quote[A team has achieved clean code when all classes appear as though they have been written by the same developer.](Author Unknown)
@emoji[smiley]
@snapend

---
@snap[north text-07 span-80]
@quote[Refactoring is a disciplined technique for restructuring an existing body of code, altering its internal structure without changing its external behavior.](Martin Fowler - author Refactoring)
@snapend

@snap[midpoint text-08 text-left span-85]
Noun: a change made to the internal structure of software to make it easier to understand and cheaper to modify without changing its observable behavior.

<br>
Verb: to restructure software by applying a series of refactorings without changing its observable behavior.
@snapend

---

## Code is easier to understand when ...
@snap[West text-06 text-left span-100 ]
@ul[list-spaced-bullets]
- Methods with fewer parameters are easier to understand than those with more parameters
- Methods with less lines of code are easier to understand than Methods with more lines of code
- Methods with no conditional logic are easier to understand than methods with conditional logic
- Methods with no loops are easier to understand than methods with loops
- Methods that follow a naming pattern are easier to understand than ones that are unique (Example - getters)
@ulend
@snapend
