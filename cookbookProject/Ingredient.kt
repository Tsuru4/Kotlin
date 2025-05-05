

public class Ingredient(private val _name:String, private val _quantity:Double) {
    
    //unit of measurement

    public fun getName():String {
        return _name
    }
    public fun getQuantity():Double {
        return _quantity
    }
}