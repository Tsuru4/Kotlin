fun main() {
    
    //Introductory message goes here. It should only run once.
    welcome()
    //The menu runs next.
    menu()

}


fun menu() {
    //"While loop" setup begins here.
    //First, I want to set up the conditions for my loop. To do that, I need to set up the condition first.
    //It seems that kotlin uess both values and variables. Values seem to be Kotlin's version of immutable variables. 
    //Obviously, an immutable value would be a terrible idea for a while loop condition. So, I will use a variable instead.
    //For some reason, it seems that data types in Kotlin can be implicitly cast. I am not sure why that would be useful; it sounds like it could set me up for trouble later, so I am going to avoid implict casting for now.
    //So, I need a mutable boolean variable.
    //Kotlin naming convention seems to be camelCase.
    var menuKeepGoing : Boolean = true

    //I am now noticing that Kotlin does not use punctuation. I don't like this, but whatever. 

    //The setup is done. Now I want to run the actual while loop, which will make up the main part of the menu.

    while (menuKeepGoing) //I want this menu to repeat itself until the user asks to quit, which is why the bulk of the menu is inside a while loop.
    {
        println("Enter 1 to display the list of recipes.")
        println("Enter 0 to quit.")

        //https://kotlinlang.org/docs/read-standard-input.html I read this page to learn how to obtain input in Kotlin.
        var menuInput: Int = readln().toInt()
        //https://youtu.be/Si8rN5J249M?si=t3GapkX09KvXxmlR I had a problem in setting up the above input statement. This video helped solve the problem.

        //https://www.tutorialspoint.com/how-to-implement-switch-case-statement-in-kotlin
        //Now I want to use switch case to address the user response. Kotlin apparently doesn't use switch case, but it uses the keyword "when", which is even better, in my opinion. 
        when (menuInput)
        {
            0 -> menuKeepGoing = false
            1 -> displayRecipeList()
            else -> println("Error, unfamiliar input. Please try again.")
        }
        
    }

}

fun displayRecipeList() {

}

fun welcome() {
    println("Hello! Welcome to my recipe display program!")
}