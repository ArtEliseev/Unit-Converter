package converter

import java.lang.NumberFormatException

fun main() {
    while (true) {
        println("Enter what you want to convert (or exit):")
        val primaryInput = readln().lowercase().replace("degrees ", "").replace("degree ", "")
        if (primaryInput == "exit") return
        else parseInput(primaryInput)
    }
}

fun parseInput(input: String) {
    val (stringNumber, sourceMeasure, middleWord, targetMeasure) = input.split(" ")
    val source = stringToEnumValue(sourceMeasure)
    val target = stringToEnumValue(targetMeasure)
    try {
        val number = stringNumber.toDouble()
        when (checkErrors(number, source, target)) {
            true -> return
            else -> {
                val result = Measure.convert(number, source, target)
                val sourceNumber = if (number == 1.0) source.symbol else makePlural(source.symbol)
                val targetNumber = if (result == 1.0) target.symbol else makePlural(target.symbol)
                println("$number $sourceNumber is $result $targetNumber")
            }
        }
    } catch (e: NumberFormatException) {
        println("Parse error")
        return
    }
}

fun checkErrors(number: Double, source: Measure, target: Measure): Boolean {
    if (source == Measure.OTHER || target == Measure.OTHER) {
        println("Conversion from ${makePlural(source.symbol)} to ${makePlural(target.symbol)} is impossible")
        return true
    } else if (source.type != target.type) {
        println("Conversion from ${makePlural(source.symbol)} to ${makePlural(target.symbol)} is impossible")
        return true
    } else if (number < 0.0) {
        if (source.type == Type.LENGTH) {
            println("Length shouldn't be negative")
            return true
        } else if (source.type == Type.WEIGHT) {
            println("Weight shouldn't be negative")
            return true
        }
    }
    return false
}

fun stringToEnumValue(string: String): Measure {
    return when (string) {
        "m", "meter", "meters" -> Measure.METER
        "km", "kilometer", "kilometers" -> Measure.KILOMETER
        "cm", "centimeter", "centimetres" -> Measure.CENTIMETER
        "mm", "millimeter", "millimeters" -> Measure.MILLIMETER
        "mi", "mile", "miles" -> Measure.MILE
        "yd", "yard", "yards" -> Measure.YARD
        "ft", "foot", "feet" -> Measure.FOOT
        "in", "inch", "inches" -> Measure.INCH
        "g", "gram", "grams" -> Measure.GRAM
        "kg", "kilogram", "kilograms" -> Measure.KILOGRAM
        "mg","milligram", "milligrams" -> Measure.MILLIGRAM
        "lb", "pound", "pounds" -> Measure.POUND
        "oz", "ounce", "ounces" -> Measure.OUNCE
        "k", "kelvin", "kelvins" -> Measure.KELVIN
        "celsius", "dc", "c" -> Measure.CELSIUS
        "fahrenheit", "df", "f" -> Measure.FAHRENHEIT
        else -> Measure.OTHER
    }
}

fun makePlural(measure: String): String {
    return when (measure) {
        "foot" -> "feet"
        "inch" -> "inches"
        "degree Celsius" -> "degrees Celsius"
        "degree Fahrenheit" -> "degrees Fahrenheit"
        "???" -> "???"
        else -> measure + "s"
    }
}