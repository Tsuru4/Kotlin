



//This is my first major project in the Kotlin language. 
//This program is like a cookbook; the user can use it to add cooking recipes, delete them, display them, save them to a file, and load them.
//I have included several comments to document my code. While the comments may be excessive, my purpose in writing these comments is so that not just myself, but anyone unfamiliar with Kotlin but at least somewhat familiar with basic programming concepts can easily learn about Kotlin by reading my code.


//This is the main function. Any good program (to my knowledge) requires a main function. In some languages, main functions require parameters inside the parethesis to go with the main function. Fortunately, Kotlin was updated with a feature which does not require parameters inside the main function, making it simple for me and allowing me to leave the inside of the parenthesis empty.
//All other functions are simply appendanges to a main function. They do not run unless the main function calls them. A program begins and ends with its main program.
fun main() {
    
    //I want my main function to be very simple and easy to read, so instead of writing lots of code, I delegate whatever I can to other functions.
    welcome() //This is the call statement for the welcome function. It introduces the user to my program.
    
    //After the welcome message, my menu runs next. For the purposes of this particular program, most of my code is called from within the menu function.
    menu()

}


fun menu() {
    //"While loop" setup begins here. A while loop repeats itself as long its statement is true.
    //First, I want to set up the conditions for my loop. To do that, I need to set up the condition first.
    //It seems that kotlin uess both values and variables. Values seem to be Kotlin's version of immutable variables. 
    //Obviously, an immutable value would be a terrible idea for a while loop condition (otherwise the loop would never end). So, I will use a variable, not a value.
    //For some reason, it seems that data types in Kotlin can be implicitly cast. I am not sure why that would be useful; it sounds like it could set me up for trouble later, so I am going to avoid implict casting for now.
    //So, I need a mutable boolean variable.
    //var stands for variable, and val stands for value.
    //Kotlin naming convention seems to be camelCase. Don't use spaces when naming things. The first letter of a custom named variable or function is always lowercase, but the first letter of every following word in the name is always capitalized. 
    
    var menuKeepGoing : Boolean = true
    //I have explicitly cased this variable as a Boolean. It seems data types need to be capitalized.
    //I am now noticing that Kotlin does not use punctuation. I don't like this, but whatever. 

    var recipeBook1 = RecipeBook(_filename = "test_recipe_book")

    generateTestRecipes(recipeBook1)

    //The setup for the while loop is done. Now I want to run the actual loop. The loop will make up the bulk of the menu.
    //This is actually a do while loop, not a while loop. I wanted an opprotunity to demonstrate a do while loop, and this particular scenario fits naturally.
    do{
        //Here I give the user instructions on how to use the menu.
        println("\nEnter the corresponding number to access the feature.")
        println("1: Display the list of recipes.")
        println("2: Add a new recipe to the list.")
        println("3: Delete a recipe from the list.")
        println("4: Rearrange recipes in the list.")
        println("5: Save cookbook to file. (This feature is still in development)")//Todo
        println("6: Load cookbook from file. (This feature is still in development)")//ToDo
        println("Enter 0 to quit.")

        //https://kotlinlang.org/docs/read-standard-input.html I read this page to learn how to obtain input in Kotlin.
        var menuInput: Int = try {
            readln().toInt()
        }
        catch (e:NumberFormatException)
        {
            -1
        }
        //I explicitly cast this variable, menuInput, as an integer (Int). It would probable work just fine (or possibly even better) if I left the data type a String, but having it as an integer is easier for my mindset, and it makes the "when" statement I am about to use easier to for me to read.
        
        // * Because I am casting the user input as an integer, this means there will be a fatal error if the user inputs anything besides an integer. I am going to ignore this problem for now; the worst case scenario, the user just has to restart the program. The user will have lost any unsaved progress, so I should probably address potential crash eventually, but it isn't a high priority for me at this time.

        // * https://youtu.be/Si8rN5J249M?si=t3GapkX09KvXxmlR I had a problem in setting up the above input statement. This video helped solve the problem. This problem is not related to the actual code, but the development environment extentions (Code Runner). To any users having issues with getting input through this program, check this video.

        //https://www.tutorialspoint.com/how-to-implement-switch-case-statement-in-kotlin
        
        println()//This creates an empty line for the sake of user readability. I wanted to clear the entire screen, but it seems that Kotlin does not have a simple way to do this.

        //I originally wanted to use switch case to address the user response. Kotlin apparently doesn't use switch case, but it uses the keyword "when", which is even better for me, in my opinion, because I am familiar with pattern matching from my experience with Erlang and Rust. 
        //The core features, or functions, of the menu are called from inside this "when" statement based on the user input gathered earlier.
        when (menuInput)
        {
            //This pattern matching is similar to Erlang and Rust, though it was a new concept for me when I first learned Erlang.
            //The syntac with pattern matching basically means "When menu Input equals whatever is on the left side of the ->, do whatever is after ->". Pattern matching will skips all following patterns after it finds the first pattern it matches with, so it is important to list the most specific cases first, and the most general cases last. In my particular case, all of these values are extremely specific (except for else, which is as generic as you can get.) It is good practice to always have an else clause when writing "when". 
            0 -> {
                println("Goodbye!")
                menuKeepGoing = false
            }
            1 -> displayRecipeList(recipeBook1)
            2 -> addRecipe(recipeBook1)
            3 -> deleteRecipe(recipeBook1)
            4 -> reorganizeRecipeList(recipeBook1)
            5 -> saveRecipeList()//ToDo
            6 -> loadRecipeList()//ToDO
            else -> {
                println("Error, unexpected input. Exiting menu as if user had entered 0.)")
                menuKeepGoing = false
            }

            //This is the end of the when loop. At this point, it goes back to the beginning, and checks to see if the initial condition(menuKeepGoing) it still true. If menuKeepGoing is still true, the loop restarts.
        }
        
    } while (menuKeepGoing)

}


//https://kotlinlang.org/docs/kotlin-doc.html#kdoc-syntax DocStrings are convenient ways to crate internal labels for function in many progamming languages. The comment below one line is a doc string. It is convenient because anything written inside the doc string is displayed when a programmer hovers the mouse over the name of the function. 

/**
 * Displays the names of all recipes in the list, then optionally displays details on a recipe of the user's choosing.
 */
fun displayRecipeList(recipeBook:RecipeBook) {
    println("Here are all the recipes.")
    recipeBook.displayRecipeNames()
    println("Which recipe do you want to view?")
    
    //Todo optionally cast this as an integer
    //To cast it as an integer, in the way I want it, I would first need to understand how try catch works in Kotlin.
    val recipeID: String = readln() 
    
    recipeBook.displayRecipe(recipeID)
    
}


//ToDo this function is too long, and thus difficult to read. Break it up into smaller functions.
fun addRecipe(recipeBook:RecipeBook) {

    println("Please enter the new recipe name:")
    val name:String = readln()

    println("Please enter the total cook time (in minutes):")
    val cookTime:Double = try {
    readln().toDouble()
    }
    catch (e: NumberFormatException) {
        -1.0
    }
    if(cookTime < 0.0)
    {
        println("Error, invalid input detected. \nCook time must be a number greater than 0. Words and negative numbers are not permitted \nReturning to main menu.")
        return
    }

    println("Enter the ingredient name. (Enter 0 if there are no ingredients):")
    var ingredientList:MutableList<Ingredient> = mutableListOf()
    var ingredientName = readln()
    while (ingredientName != "0" && ingredientName != "")
    {
        println("Enter the unit of measurement:")
        var unitOfMeasurement = readln()
        println("Enter the quantity:")
        var quantity = try {
            readln().toDouble()
        }
        catch (e: NumberFormatException)
        {
            -1.0
        }
        if (quantity < 0.0)
        {
            println("Error, invalid input detected. \nCook time must be a number greater then 0. Words and negative numbers are not permitted. \nThrowing our ingredient from recipe. Please reenter this ingredient.")
        }
        else
        {
        ingredientList.add(Ingredient(ingredientName, quantity, unitOfMeasurement))
        }
        println("Enter the next ingredient name. (Enter 0 if there are no more ingredients):")
        ingredientName = readln()
    }
    
    println("Enter some cooking instructions. Multiple lines are allowed. Enter a line with just 0 when done.")
    var instruction = readln()
    var instructions:MutableList<String> = mutableListOf()
    while (instruction != "0" && instruction != "")
    {
        instructions.add(instruction)
        println("Enter some cooking instructions. Multiple lines are allowed. Enter a line with just 0 when done.")
        instruction = readln()
    }
    recipeBook.addRecipe(name, cookTime, ingredientList, instructions)
    println("Recipe recorded successfully.")
}

fun deleteRecipe(recipeBook:RecipeBook) {//ToDo
    if (recipeBook.isEmpty())
    {
        println("There are no recipes to delete.")
    }
    else
    {
        println("Which recipe do you want deleted? (If there are multiple recipes of the same name, only the first recipe will be deleted.)")
        val recipeID:String = readln()
        if (recipeBook.deleteRecipe(recipeID))
        {
            println("Deleted $recipeID successfully.")
        }
        else
        {
            println("Recipe with the name $recipeID was not found, and thus could not be deleted.")
        }
    }
}

fun reorganizeRecipeList(recipeBook:RecipeBook){
    println("The recipes are currently in this order:")
    recipeBook.displayRecipeNames()
    println("How would you like to organize the recipes in this cookbook?")
    println("1: Alphabetize.")
    println("2: Cooktime.")
    println("3: Custom.")
    println("0: Nevermind.")

    val menuInput:Int = try {
        readln().toInt()
    }
    catch (e: NumberFormatException)
    {
        -1
    }

    println()

    //this is a demonstation of "else if", though "when" works better for me in this situations like this where there is only one variable being compared.
    if (menuInput == 1)
    {
        recipeBook.alphabetize()
    }
    else if (menuInput == 2)
    {
        recipeBook.orderByCookTime()
    }
    else if (menuInput == 3)
    {
        customSwap(recipeBook)
    }
    else if (menuInput != 0)
    {
        println("Inproper input detected. Please only use numbers when navigating the menu unless prompted otherwise.")
    }
}

fun customSwap(recipeBook:RecipeBook)
{
    println("Custom Swap: we will move one recipe at a time. First, choose a recipe number.")
    recipeBook.displayRecipeNames()
    val recipeID = try {
        readln().toInt()
    }
    catch (e: NumberFormatException)
    {
        -1
    }
    println("Next, please enter the new index number for this recipe. (All recipes numbers between the old and new location will be shifted by one.)")
    val newRecipeID = try {
        readln().toInt()
    }
    catch (e: NumberFormatException)
    {
        -1
    }
    if (recipeID < 1 || newRecipeID < 1)
    {
        println("Error, incorrect input detected.\n All input should be numbers greater than 0. \nReturning to main menu.")
        return
    }
    if (!recipeBook.recipeSwap(recipeID, newRecipeID))
    {
        println("Error, input was out of range. Do not use input greater than the actual size of the recipe list.")
    }
}

fun loadRecipeList() {//Todo

}

fun saveRecipeList() {//Todo
    //ToDo have an option to rename the recipebook filename.
}


//ToDo create features to load recipes from a second recipe book and copy and/or merge them with the contents from the first book.

fun welcome() {
    println("Hello! Welcome to my recipe display program!")
}


fun generateTestRecipes(recipeBook:RecipeBook)
{
    recipeBook.addRecipe("Pizza", 10.0, mutableListOf(Ingredient("Flour", 2.5), Ingredient("Water", 1.0)), mutableListOf("Bake"))
    recipeBook.addRecipe("Banana Bread", 55.0, mutableListOf(Ingredient("Flour", 1.3), Ingredient("Water", 0.3)), mutableListOf("Bake"))
    recipeBook.addRecipe("Dinner Rolls", 10.0, mutableListOf(Ingredient("Flour", 2.0), Ingredient("Water", 3.0)), mutableListOf("Bake"))
}