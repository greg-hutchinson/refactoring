---?image=assets/img/Intro.png

---
## Outline
- Why Refactor
- Definition of Clean Code
- Alignment on Criteria
- Definition of Refactoring
- Different types of Refactorings
- Examples
---
### Where does the term Re-factor come from?
---
## Factor (from Mathematics)
@img[midpoint span-70](assets/img/factor.png)
---
## Why Refactor?
@ul[list-spaced-bullets]
- Easier to read (understand)
- Easier to Maintain
- Easier to Enhance
- Going for ***Clean Code***
- It's for the next reader
@ulend

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
- Classes are
    - Deck, Card, BlackjackHand
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
@[1-15](this is ***coding*** <br>It works but everything is detailed)
---
```Java
public boolean isBlackJack() {
    if (cards.size() != 2)
        return false;
    Card card1 = cards.get(0);
    Card card2 = cards.get(1);
    if (card1.isAce())  
        if (card2.isFace()) {
            return true;
        }
    if ((card1.isFace()) && (card2.isAce()))
        return true;
    return false;
}
```
@[1-12](Who thinks this is better<br>and why?)
@[2-3](short-circuit whenever possible<br> as it removes one level of indentation)
@[6-7](Delegate some details to the Card class)
@[10-12](this smells - why?)
---
```Java
// You can call it beautiful code when the code ...

public boolean isBlackJack() {
    return getNumberOfCards() == 2 && getTotal() == 21;
}
```
@[7-7](Beautiful code - ...the language was made for the problem)

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
Noun: a change made to the internal structure of software to make it ***easier to understand*** and cheaper to modify without changing its observable behavior.

<br>
Verb: to restructure software by applying a series of refactorings without changing its observable behavior.
@snapend

---
#### If the goal of refactoring is to make code ***easier to understand*** then we need to agree on what that means
@snap[West text-06 text-left span-100 ]
@ul[list-spaced-bullets]
- Methods with ***fewer parameters*** are easier to understand than those with more parameters - Niladic, monadic, dyadic, triadic, polyadic
- Methods with ***less lines of code*** are easier to understand than methods with more lines of code
- Methods with ***no conditional logic*** are easier to understand than methods with conditional logic
- Methods with ***no loops*** are easier to understand than methods with loops
- Methods with ***shorter lines*** are easier to understand than longer lines
- Methods that follow a ***naming pattern*** are easier to understand than ones that are unique (Example - getters)
@ulend
@snapend
---
## Properly Factored Code will:
@snap[midpoint text-09 text-center span-100 ]
- never have more than 1 level of indentation
- have <= 3 parameters in every method
- be <= 10 lines of code
- not be ***wider*** than 100 characters
- follow good naming patterns
- and ideally - will read like the language was designed for the problem
@snapend
@snap[south text-06 text-center span-100 ]
Remember - these are ***guidelines***
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
  - <= 10?
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
- Move instance method

---
## Refactoring - Extract Method
@snap[West text-06 text-left span-100 ]
- To turn part of a large method into it's own method.
- This is the most used refactoring tool
- Use it every time you feel like documenting the internals of a method (I.e
<br><br>
```java
     // These next 5 lines calculate the net pay
        deductions = ...;
        taxes = ...;
        pension = ...;
        gross = ...;
        netPay = gross - (deductions + taxes + pension);
```
@snapend
---
## Benefits of Extract Method
@snap[West text-06 text-left span-100 ]
- Keeps code at the same level of abstraction.
- Usually removes 1 level of indentation. This is a ***key*** point.
  - This is what enables code to only have 1 level of indentation.
@snapend
---
## Candidates for Extract Method
- Duplicate code
- if then else statements
- Chunks of code within a method that do a piece of work
- Loops
- Loop bodies (streams tend to invalidate this statement a bit)
---
## Watch for these code smells
- Methods don't look like valid verbs for this object.
- too many parameters to a method - Consider extract class
- making decisions in one class based on the data of another class
  - Not DTO's of course.
- superclass bloat - it is easy to reuse these methods, so let's put them in a superclass
- Utility classes
- Method names (usually verbs) don't seem to make sense in context of the Class (noun)
---
## Candidates for Extract Class
- Duplicate code
- Many methods that are only there to support one public API.
  - This can happen after you refactor a public API into many smaller methods.
- The same parameter being passed down throughout the same method chain.
- Too many parameters to a method


---
@snap[north-east span-25 text-05  text-left text-yellow]
Consider if then else
@snapend
@snap[north-west span-75]
```java
public double getAmount() {
    // Some code here to calculate base and other stuff.
    // ...
    // ...
	double premium;
	if (age < 16)
	    premium = 1.5;
	else
	    premium = 1.0
	return premium * base;
}

```
@[6-9](extract this into a method)
@snapend
---
```java
public double getAmount() {
    // Some code here to calculate other stuff.
    // ...
    // ...
	double premium = getPremium();
	return premium * base;
}

private double getPremium() {
    if (age < 16)
	    return 1.5;
    return 1.0;
}
```
@[10-12](Note: no else)
---
@snap[north-east span-10 text-05  text-left text-yellow]
Consider loops and loop bodies
@snapend
@snap[north-west span-90]
```java
public class Customer {
private List<Account> accounts;
public double getBalance() {
  double balance = 0.0;
  for (Account account: accounts) {
    for (Transaction transaction: account.getTransactions()){
      if (transaction.getType().equals("CREDIT"))
        balance -= transaction.getAmount();
      else
        balance += transaction.getAmount();
    }
  }
  return balance;
}
```
@[6-11](extract this loop and pass an account)
@snapend

---
@snap[north-east span-10 text-05  text-left text-yellow]
Consider loops and loop bodies
@snapend
@snap[north-west span-90]
```java
public class Customer {
private List<Account> accounts;
public double getBalance() {
    double balance = 0.0;
    for (Account account: accounts) {
        balance += getBalanceFor(account);
    }
    return balance;
}
public double getBalanceFor(Account account) {
    double balance = 0.0;
    for (Transaction transaction: account.getTransactions())
        balance += getBalanceFor(transaction)
    return balance;
}
public double getBalanceFor(Transaction transaction) {
    if (transaction.getType().equals("CREDIT"))
      return -transaction.getAmount();
    return transaction.getAmount();
}
```
@[10, 16](This is better but it still smells.)
@[12](We treat the Account class like data)
@[17-19](We treat the Transaction class like data)
@[17](Constant that should be called CREDIT_TRANSACTION)
@snapend
---
# Heuristic
If you are using the class only for its data, consider delegating to the class itself

---
@snap[north-east span-10 text-05 text-left text-yellow]
Delegate the behavior to where it belongs
@snapend
@snap[north-west text-06 span-90]
```java
public class Customer {
    public double getBalance() {
      double balance = 0.0;
      for (Account account: accounts)
          balance += account.getBalance();
      return balance;
}
public class Account {
    List<Transaction> transactions;
    public double getBalance() {
      double balance = 0.0;
      for (Transaction transaction: transactions)
          balance += transaction.getBalance();
      return balance;
    }  // ...
public class Transaction {
    public double getBalance() {
      double balance = 0.0;
      if (getType().equals("CREDIT"))
        return -getAmount();
      return getAmount();
    }
```
@[2,10,17](These all turned into polymorphic GETTERS )
@[4-6](Customer knows nothing about what makes up the balance of an account )
@[12-14](Account knows nothing about what makes up the balance of a Transaction)
@[19-21](The logic that makes up a balance of a Transaction is encapsulated where it should be)
@snapend
---
## Comments
@snap[west text-08 span-90]
@quote[The proper use of comments is to compensate for our ***failure*** to express ourself in code](Robert Martin - Author "Clean Code")
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

---
## And Lastly, Please Remember
- Refactoring is a practiced skill. So practice. Try something. Not all refactors work out.
- Refactoring of code is not an absolute term. In theory, you can always do more. So no when to quit.
- One refactor will quite often lead to other ideas about refactoring.

---
### Summary (And/Or Experiment)
@snap[West text-07 text-left span-100 ]
@ul[list-spaced-bullets]
- Try and write methods with only 1 level of indentation
- Methods that have the same level of abstraction
- Method size <=10 lines of code
- No method takes more that 3 parameters (and less is better)
- No duplicate code
- ***Code reads like the language was designed for the problem***
@ulend
@snapend
---
Exercise
@snap[West text-06 text-left span-100 ]
- Clone the repo at
    - https://github.com/greg-hutchinson/refactoring-exercise.git
- Make a branch using your name as the branch name
- Run the test cases in RookTest - make sure they all pass.
- Understand all of the move... tests in RookTest.
- Refactor the method moveTo in class Rook - Use the guidelines from previous slide
    - After each refactor ***commit*** to show your thought process.
    - Make sure the tests still run
    - Push when you are done, I will provide feedback
    - Now create Test cases for Bishop and implement the required methods
    - Now create Test cases for Knight and implement the required methods
    - After you are done, see if you need to refactor again
- You can do as much or as little as you want. Since ...
@snapend
---
<br><br>
```java
  public boolean wasSuccessfulRefactor() {
      return madeChanges() && easierToUnderstand();
  }
```
<br><br>
@snap[midpoint text-09 text-center span-100 ]
# Thank You
@snapend

---
So imagine the following dialog between a Developer and a Chessmaster

Developer: Tell me at a high level how pieces move in the game of chess.

Chessmaster: Well, if it is a valid move for the piece, the piece is moved to the new position.

Developer: ok, now add some details. What is a valid move for a piece?

Chessmaster: That depends on each piece. For example, if the piece is a
- Rook - then a valid move is if it is Horizontal or Vertical
- Bishop - then a valid move is if it is a diagonal direction
- Knight - then a valid move is if it is an L shaped move. 1 Diagonal Square and 1 horizontal or 1 Vertical
Don Mayer - Olivia
