# COMP122-Java-Labs
All the Lab exercises for the COMP122 Module on Java and OOP from 20.02.18 till May 2018

We had a module on JAVA in the university, as a part of which we had to do lab exercises and assignments. While I can't release the assignments, I can publish some of the solutions of lab exercises.

BirdGame.java and its User class is basically a hangman game, but for birds. There is an array of birds defined and then we randomize it to chose one bird that must be guessed!

Pancakes.java, Pancakes.input and Pancakes.output -
This problem takes inspiration from the only paper BILL GATES wrote - on prefix reversal sorting, where you can sort a whole stack of pancakes in ascending order of their diameter by find the largest pancake in the stack and flipping all the pancakes above this pancake.Then find the second largest pancake and flip all till that and so on...
Pancakes.input contains a set of inputs. ON CMD do:

  ` javac Pancakes.java
    java Pancakes < Pancakes.input`

The 4 files : Buffer.java, Producer.java, Consumer.java and Prodcon.java constitute the famous PRODUCER-CONSUMER PROBLEM. It deals with concurrent programming and java threads.
In cocnurrent programming, we often do many things at once parallely, and thus there is a problem of "shared resouce" and condition of "mutual exclusion" must then be met, to stop other threads from accessing the resource, when one of the threads is using it.
Following is a description of the producer-consumer problem:
[Taken from my lecture notes:-]
A producer process (eg Secretary) and a consumer process (eg Manager) communicate via a buffer (letter tray) [Say a secretary prints/types letters, puts it in the tray and the manager takes it to sign it]
  • Producer Cycle:
    –  produce item e.g. type letter)
    – deposit in buffer (e.g. put in tray)
  • Consumer cycle
    – extract item from buffer (e.g. take letter)
    – consume item (e.g. sign it)
  • May have many producers & consumers
  • Many real-world examples
    – Compiler producing assembly language to be processed by assembler
    – Program producing output to be sent to printer
    
 THERE ARE SEVERAL PROBLEMS TO SOLVE HERE:
  • We have to ensure that:
    – producer cannot put items in buffer if it is full
    – consumer cannot extract items from buffer if it is empty
    – buffer is not accessed by two threads simultaneously
 
I have incorporated the use of semaphores. In Buffer.java, one finds synchronized functions and a "volatile" flag variable. 
This buffer can hold one item!
