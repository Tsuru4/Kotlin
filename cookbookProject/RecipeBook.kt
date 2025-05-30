


//https://www.w3schools.com/kotlin/kotlin_classes.php This is a class. It does not run by itself, as it has no main function, however, it can be implimented by my other programs.

//This particular class acts a recipe book. It contains all the information (known as properties) and functions (known inside of a class as a method) a recipe book should have. Every class should also contain atleast one constructor.

//In Kotlin, the primary constructor belongs in the header of the class declaration (the constructor is inside the parenthesis after the class is named).
public class RecipeBook(private var _filename: String, private var _recipeList:MutableList<Recipe> = mutableListOf() ) {
    

    //I had to use Google AI to understand how to create an empty list because none of the websites I searched for were giving instructions which I could understand. All of the other websites were telling me to use mutableListOf() or listOf(), neither of which were suitable for the situation in the line above. On the other hand, emptyList(), which is what Google AI told me to use, is perfect for creating a list as a property in a class. 

    public fun displayRecipeNames(){
        var i:Int = 0
        for (recipe in _recipeList)
        {
            i++
            var name:String = recipe.getName()
            println("$i $name")
        }
    }

    public fun displayRecipe(recipeID:String){
        for (recipe in _recipeList)
        {
            if (recipe.getName().lowercase() == recipeID.lowercase())
            {
                recipe.displayRecipe()
            }
        }
    }

    public fun displayRecipe(recipeID:Int){
        if (recipeID > 0 && recipeID <= _recipeList.size)
        _recipeList[recipeID - 1].displayRecipe()
    }

    public fun addRecipe(name:String, cookTime:Double, ingredientList:MutableList<Ingredient>, instructions:MutableList<String>){
        _recipeList.add(Recipe(name, cookTime, ingredientList, instructions))
    }

    public fun deleteRecipe(recipeID:String):Boolean
    {
        for (recipe in _recipeList)
        {
            if (recipe.getName().lowercase() == recipeID.lowercase())
            {
                _recipeList.remove(recipe)
                return true
            }
        }
        return false
    }

    public fun isEmpty():Boolean{
        return _recipeList.isEmpty()
    }

    public fun deleteRecipe(recipeID:Int):Boolean {
        if (_recipeList.size >= recipeID)
        {
            if (recipeID > 0)
            _recipeList.removeAt(recipeID - 1)
            return true
        }
        return false
    }

    //ToDo 
    public fun saveRecipeBook(){
    }

    public fun renameRecipeBook(filename:String){
        _filename = filename
    }

    public fun alphabetize(){
        _recipeList.sortBy{it.getName().lowercase()}
    }

    public fun orderByCookTime(){
        _recipeList.sortByDescending {it.getCookTime()}
    }

    public fun recipeSwap(oldID:Int, newID:Int):Boolean{
        if (oldID > _recipeList.size || newID > _recipeList.size)
        {
            return false
        }
        val placeHolderRecipe:Recipe = _recipeList[oldID-1]
        _recipeList.removeAt(oldID-1)
        _recipeList.add(newID-1, placeHolderRecipe)
        return true
    }

}