## Overview

**Project Title**: 
Recipe Organizer

**Project Description**: 
A program which can store and display cooking recipes from a list.
 * [Youtube Demonstration](https://youtu.be/D-pmMfKCimU)

**Project Goals**: 
* [x] Learn how to write in Kotlin.
* [x] Learn how to use mutable and immutable variables. (Done)

* [x] Program will have a menu (To practice loops).
* [x] Program will store cooking recipes (as a class) inside a list.
* [x] Program can display these recipes on user request.

(The following goals are lower priority and will be added as time allows.)
* [x] User can add new recipes to the list.
* [ ] User can request adjustments to the recipe display based on batch size.

## Instructions for Build and Use

Steps to build and/or run the software:

1. Open the terminal.
2. Ensure the directory is set to this cookbookProject folder using the cd command (the exact path will vary depending on where you are keeping this folder).
3. Compile the program using the command: kotlinc *.kt -include-runtime -d output.jar
4. Run the compiled code using the command: java -jar output.jar

Instructions for using the software:

1. Follow the menu prompts in the terminal.

## Development Environment 

To recreate the development environment, you need the following software and/or libraries with the specified versions:

* Visual Studio Code
* Java Development Kit (Installed through the Oracle website.)
* Kotlin Extension (Found in the Visual Studio Code extensions.)
* Code Runner Extension (Also found in VSC extensions. Not necessary, but it may be helpful at times.)

## Useful Websites to Learn More

I found these websites useful in developing this software:

* [Kotlin Lang](https://kotlinlang.org/docs/home.html)
* [User Input in VS Code with Code Runner!](https://youtu.be/Si8rN5J249M?si=t3GapkX09KvXxmlR)
* [Tutorialspoint](https://www.tutorialspoint.com/how-to-implement-switch-case-statement-in-kotlin)
* [GeeksforGeeks](https://www.geeksforgeeks.org/kotlin-list-listof/)
* [Kotlintutorial](https://kotlintutorial.io/packages-and-import-in-kotlin/)
* [Baeldung](https://www.baeldung.com/kotlin/sort)

## Future Work

The following items I plan to fix, improve, and/or add to this project in the future:

* [ ] Edit main program to be able to recognize difference between Int and String and adapt accordingly when displaying or deleting recipes.
* [ ] Add the ability to read and write files to save and load recipe books.
* [ ] Add the ability to load from multiple recipe books and merge them into a single recipe book.
* [ ] Add the ability to display custom sized batches.