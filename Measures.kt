package converter

enum class Type {
    LENGTH,
    WEIGHT,
    TEMPERATURE,
    OTHER
}

enum class Measure(val rate: Double, val type: Type, val symbol: String) {
    METER(1.0, Type.LENGTH, "meter"),
    KILOMETER(1000.0, Type.LENGTH, "kilometer"),
    CENTIMETER(0.01, Type.LENGTH, "centimeter"),
    MILLIMETER(0.001, Type.LENGTH, "millimeter"),
    MILE(1609.35, Type.LENGTH, "mile"),
    YARD(0.9144, Type.LENGTH, "yard"),
    FOOT(0.3048, Type.LENGTH, "foot"),
    INCH(0.0254, Type.LENGTH, "inch"),
    GRAM(1.0, Type.WEIGHT, "gram"),
    KILOGRAM(1000.0, Type.WEIGHT, "kilogram"),
    MILLIGRAM(0.001, Type.WEIGHT, "milligram"),
    POUND(453.592, Type.WEIGHT, "pound"),
    OUNCE(28.3495, Type.WEIGHT, "ounce"),
    KELVIN(0.0, Type.TEMPERATURE, "kelvin"),
    CELSIUS(0.0, Type.TEMPERATURE, "degree Celsius"),
    FAHRENHEIT(0.0, Type.TEMPERATURE, "degree Fahrenheit"),
    OTHER(0.0, Type.OTHER, "???");

    companion object {
        fun convert(number: Double, source: Measure, target: Measure): Double {
            return when {
                source == Measure.CELSIUS && target == Measure.CELSIUS -> number
                source == Measure.FAHRENHEIT && target == Measure.FAHRENHEIT -> number
                source == Measure.KELVIN && target == Measure.KELVIN -> number
                source == Measure.CELSIUS && target == Measure.FAHRENHEIT -> number * 9.0 / 5.0 + 32.0
                source == Measure.FAHRENHEIT && target == Measure.CELSIUS -> (number - 32.0) * 5.0 / 9.0
                source == Measure.CELSIUS && target == Measure.KELVIN -> number + 273.15
                source == Measure.KELVIN && target == Measure.CELSIUS -> number - 273.15
                source == Measure.KELVIN && target == Measure.FAHRENHEIT -> number * 9.0 / 5.0 - 459.67
                source == Measure.FAHRENHEIT && target == Measure.KELVIN -> (number + 459.67) * 5.0 / 9.0
                else -> number * source.rate / target.rate
            }
        }
    }
}