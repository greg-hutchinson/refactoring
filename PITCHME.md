---?image=assets/img/refactoring-background.png

---
## Outline
- Why Refactor
- Definition of Clean Code
- Alignment on Criteria
- Definition of Refactoring
- Different types of Refactorings

---?image=assets/img/whyRefactor.jpg
---
## Why Refactor
@snap[west span-45 text-center text-07]
@box[bg-purple  text-left text-white] (Question)
@box[bg-purple  text-left text-white] (Who are we refactoring for?)
@box[bg-purple  text-left text-white] (With what intent?)
@snapend

---
## Why Refactor
@snap[west span-45 text-center text-07]
@box[bg-purple  text-left text-white] (Question)
@box[bg-purple  text-left text-white] (Who are we refactoring for?)
@box[bg-purple  text-left text-white] (With what intent?)
@snapend

@snap[east span-45 text-center text-07]
@box[bg-purple  text-left text-white] (Answer)
@box[bg-purple  text-left text-white] (The reader of the code)
@box[bg-purple  text-left text-white] (That it is easily understandable)
@snapend




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
## What does Ward Mean?
@snap[west text-07 span-90]
- Assume we are writing a Blackjack playing application.
- We have designed a class called BlackjackHand which will evaluate what the total of the current cards in the hand are.
- It also needs to know if the current cards in the hand consistute a "Blackjack" since a "Blackjack" pays 3:2.
- A blackJack is when there is only 2 cards and the total is 21 (Ace and a Face card)
@snapend
---
```Java
public boolean isBlackJack() {
    if (cards.size() == 2) {
        int value = 0;
        for (Card card : cards) {
            int temp = card.getIntValue();
            if (temp >= 10)   //10, J, Q, K
                temp = 10;
            if (temp == 1)   //Ace
                temp =  11;
            value += temp;
        }
        return value == 21;
    }
    else 
        return false;
}
```
---
```Java
public boolean isBlackJack() {
    if (cards.size() != 2)
        return false;
    Card card1 = cards.get(0);
    Card card2 = cards.get(1);
    if (card1.isAce() == 1)  
        if (card2.isFace()) { 
            return true;
        }
    if ((card1.isFace()) && (card2.isAce()))
        return true;
    return false;
}
```
@[2-3](short-circuit whenever possible<br> as it removes one level of indentation)
---
```Java
// You can call it beautiful code when the code also
// makes it look like the language was made for the problem.
// I.e. A blackJack is when there is
// only 2 cards and when the total is 21

public boolean isBlackJack() {
    return getNumberOfCards() == 2 && getTotal() == 21;
}
```

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

#### The goal of refactoring is easier to understand when we acknowledge the following...
@snap[West text-06 text-left span-100 ]
@ul[list-spaced-bullets]
- Methods with fewer parameters are easier to understand than those with more parameters
  - Niladic, monadic, dyadic, triadic, polyadic
- Methods with less lines of code are easier to understand than methods with more lines of code
- Methods with no conditional logic are easier to understand than methods with conditional logic
- Methods with no loops are easier to understand than methods with loops
- Methods that follow a naming pattern are easier to understand than ones that are unique (Example - getters)
@ulend
@snapend
---

## General Guidelines
### Naming
Use meaningful names for ***everything***.

(Classes, Methods, Variables, Temporary Variables, Method Arguments, etc.)

---
### Naming - AntiPattern
- txRt, dysYr, chsBrd
---
## Functions/Methods (Guideline)
- Should do one and only one thing
- Should contain the same level of abstraction
---

```java
public void doSomething() {
	initializeSomething();
	for (int i = 0;i<7;i++)
		if (i == 3)
			if (get ....
			else {....
	}
	cleanUpSomething();
}
```
@[3-7](Different level of abstraction)
---

```java
public void doSomething() {
	initializeSomething();
	processSomething()
	cleanUpSomething();
}

public void processSomething() {
	for (int i = 0;i<7;i++)
		if (i == 3)
			if (get ....
			else {....
	}
}
```
@[2-4, 8-11](Same level of abstraction)
---
## Function/Method size
### Rule 1 - Small !!!

- How many Lines of Code in a function?
  - 10?
  - Should fit easily on one screen
  - Horizontal scrolling is not allowed

---
@snap[north span-80 text-left text-07]
@box[bg-purple  text-left text-white] (Temporary Variables)
@box[bg-purple  text-left text-white] (Declare them just before they are needed. Minimize scope.)
@box[bg-purple  text-left text-white] (Helps to understand where the variable is being used.)
@box[bg-purple  text-left text-white] (Facilitates better Refactoring)
@snapend

@snap[midpoint text-06 text-left span-80 ]
<br>
<br>
@box[bg-purple  text-left text-white] (Anti Pattern)
@box[bg-purple  text-left text-white] (Declare all variables at the top of the method giving method scope)
@snapend
---
## Name some of the Common Refactorings

---
## Names of Common Refactorings
- Rename (Class, File, Method, Variable)
- Extract Method
- Change Method Signature
- Extract Class, Superclass, Interface
- Pull Up, Push Down

---
## Refactoring - Extract Method
- To turn part of a larger method into it's own method.
- This is the most used refactoring tool
- Keeps code at the same level of abstraction.
- Use it everytime you feel like documenting the internals of a method (I.e

//These next 5 lines calculate the net pay
---
## Candidates for Extract Method
- if then else statements
- Loops
- Loop bodies (streams tend to invalidate this statement)

---
```java
    public double getAmount() {
	    // Some code here calculate base and other stuff.
        // ...
	    double premium;
	    if (age < 16)
	        premium = 1.5;
	    else 
	        premium = 1.0
	    return premium * base;
}

```
@[5-8](Make getter)
---
---
```java
    public double getAmount() {
	    // Some code here calculate other stuff.
        // ...
	    double premium = getPremium();
	    return premium * base;
    }

    private double getPremium() {
        if (age < 16)
	        return 1.5;
        return premium = 1.0;
    }
```
@[9-11](Note: no else)
---
## Comments
@snap[west text-08 span-90]
@quote[The proper use of comments is to compensate for our failure to express ourself in code](Robert Martin - Author "Clean Code")
@snapend
---
## Unit Tests
@snap[West text-06 text-left span-100 ]
@ul[list-spaced-bullets]
- To help ensure the system works
- Documentation on how to use the API
- Design tool
@ulend
@snapend

---
@snap[north-east span-25 text-05  text-left text-yellow]
Why does this "Smell"?
@snapend
@snap[north-west span-75]
```java
public class RookTest {
    @BeforeEach
    void initialize() {
        chessboard = new Chessboard();
        rook  = new Rook(chessboard, White);
        chessboard.putPieceAt(rook, 1,1);
    }
    @Test
    void moveToNonHorizontalOrNonVerticalSpot() {
        assertFalse(rook.moveTo(2,2));
    }
```
@[6](Mental Gymnastics - where is this on the board?)
@snapend

---
@img[north span-65](assets/img/chessboard.png)
---
@snap[north-east span-25 text-05  text-left text-yellow]
Use "Domain Language" whenever possible
@snapend
@snap[north-west span-75]
```java
public class RookTest {
    @BeforeEach
    void initialize() {
        chessboard = new Chessboard();
        rook  = new Rook(chessboard, White);
        chessboard.putPieceAt(rook, 'a',1);
    }
    @Test
    void moveToNonHorizontalOrVerticalSpot() {
        assertFalse(rook.moveTo('b',9));
    }
```
@[6](Definitely better - any downsides?)
@[10](Need to check for IllegalArguments)
@snapend

---
@snap[north-east span-25 text-05  text-left text-yellow]
Use "Domain Language" whenever possible
@snapend
@snap[north-west span-75]
```java
public class RookTest {
    @BeforeEach
    void initialize() {
        chessboard = new Chessboard();
        rook  = new Rook(chessboard, White);
        chessboard.putPieceAt(rook, A1);
    }
    @Test
    void moveToNonHorizontalOrVerticalSpot() {
        assertFalse(rook.moveTo(C3));
    }
```
@[6](How would this be possible?)
@[10](Compiler enforced values)
@[10](And we have captured the concept of a "Position" in one argument)
@snapend

