import kotlin.test.assertTrue

fun main() {
    /**
     * Loop to continue doing calculations
     */
    var keepRunning = true
    while (keepRunning) {
        val result = getUserInput()
        println("${result.initialAmount} ${result.unit} is equal to ${result.amount} ${result.unitConverted}")
        print("Press 'enter' to convert another value. Press any other key then enter to stop")
        var doAgain = readLine()
        if (doAgain != "") keepRunning = false
    }
}

/**
 * Grabbing user input
 */
fun getUserInput(): Convert {
    var amountValid = false
    var unitValid = false
    var amount = ""
    var amountFinal = 0.0
    var unit = ""
    var result = 0.0
    var unitConverted = ""

    print("Please enter in the amount to convert: ")
    amount = readLine().toString()

    while (!amountValid) {
        if (amount.toDoubleOrNull() != null) {
            amountValid = true
        } else {
            println("Please enter a valid amount")
            amount = readLine().toString()
        }
    }
    //converting input to a double
    amountFinal = amount.toDouble()

    /**
     * grabbing the type of conversion to do and making sure it's valid
     */

    println("                 conversion units")
    println("===================================================")
    println("centimetres->inches (cm), inches->centimetres (in)")
    println("celsius->Fahrenheit (c), Fahrenheit->Celsius (f)")
    println("millilitres->ounces (ml), ounces->millimetres (oz)")
    println("grams->ounces (gm), ounces->grams (og)")
    println("Kilograms->pounds (kg), pounds->kilograms (lb)")
    println("")
    print("Please enter in the unit you want to convert from: ")
    unit = readLine().toString().lowercase()
    while (!unitValid) {
        when (unit) {
            "c" -> {
                // Celsius to Fahrenheit
                unit = "Celsius"
                unitConverted = "Fahrenheit"
                result = (1.8 * amountFinal + 32.0)
                println("Amount = $amountFinal, $result")
                unitValid = true
            }
            "f" -> {
                // Fahrenheit --> Celsius
                unit = "Fahrenheit"
                unitConverted = "Celsius"
                result = .55555 * (amountFinal - 32)
                unitValid = true
            }
            "cm" -> {
                // centimetres -> inches
                unit = "centimetres"
                unitConverted = "inches"
                result = amountFinal / 2.54
                unitValid = true
            }
            "in" -> {
                // inches to centimetres
                unit = "inches"
                unitConverted = "centimetres"
                result = 2.54 * amountFinal
                unitValid = true
            }
            "ml" -> {
                // millimetres -> ounces
                unit = "millimetres"
                unitConverted = "ounces"
                result = amountFinal / 29.5737
                unitValid = true
            }
            "gm" -> {
                // grams -> ounces
                unit = "grams"
                unitConverted = "ounces"
                result = amountFinal * 0.03527
                unitValid = true
            }
            "oz" -> {
                // ounces -> millilitres
                unit = "ounces"
                unitConverted = "millilitres"
                result = amountFinal * 29.5737
                unitValid = true
            }
            "og" -> {
                // ounces -> grams
                unit = "ounces"
                unitConverted = "grams"
                result = amountFinal * 28.349
                unitValid = true
            }
            "lb" -> {
                // pounds -> kilogram
                unit = "pounds"
                unitConverted = "kilograms"
                result = amountFinal * 0.45359237
                unitValid = true
            }
            "kg" -> {
                // kilogram -> pounds
                unit = "kilograms"
                unitConverted = "pounds"
                result = amountFinal * 2.204623
                unitValid = true
            }
            "mi" -> {
                // mile -> kilometre
                unit = "miles"
                unitConverted = "kilometres"
                result = amountFinal * 1.609344
                unitValid = true
            }
            "km" -> {
                // kilometre -> mile
                unit = "kilometres"
                unitConverted = "miles"
                result = amountFinal / 1.609344
                unitValid = true
            }
            else -> {
                println("You didn't choose one that I recognize")
                print("Please enter the Unit of conversion: ")
                unit = readLine().toString().lowercase()
            }
        }
    }
    //round result to 1 decimal point
    val rounded = String.format("%.1f", result)
    return Convert(unit, unitConverted, amountFinal, rounded.toDouble())
}
