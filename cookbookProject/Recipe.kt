

public class Recipe (private val _name: String, private val _cookTime: Double, private val _ingredientList: MutableList<Ingredient> = mutableListOf(), private val _instructions: MutableList<String> = mutableListOf(),) {
    
    public fun displayRecipe(){
        //ToDo
        println(_name)
        println()
        println("Cooktime $_cookTime")
        println()
        println("Ingredients:")
        for (ingredient in _ingredientList)
        {
            println(ingredient.getSummary())
        }
        println()
        for (instruction in _instructions)
        {
            println(instruction)
        }
        println()
        println()
    }

    public fun getName():String
    {
        return _name
    }

    public fun getCookTime():Double
    {
        return _cookTime
    }


}