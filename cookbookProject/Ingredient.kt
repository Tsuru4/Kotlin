

public class Ingredient(private val _name:String, private val _quantity:Double, private val _unitOfMeasurment:String = "cups") {
    
    //unit of measurement

    public fun getSummary():String
    {
        return "$_quantity $_unitOfMeasurment of $_name"
    }
}