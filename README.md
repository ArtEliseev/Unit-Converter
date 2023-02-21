# Unit-Converter
My tenth project in JetBrains Academy

Description
Our converter is really functional now, but there's still one thing missing: it can't work with temperature units. Let's extend the program by adding three units of temperature.

The main units of temperature used today are degrees Celsius (C), degrees Fahrenheit (F), and kelvins (K). The program should allow the following notations:

For degrees Celsius, the user can input "degree Celsius", "degrees Celsius", "celsius", "dc", or "c".
For degrees Fahrenheit, the user can input "degree Fahrenheit", "degrees Fahrenheit", "fahrenheit", "df", or "f".
For kelvins, the user can input "kelvin", "kelvins", or "k".
Note that converting units of temperature is different from working with length or weight. The problem is that 0 kelvin is not equal to 0 degrees Celsius or 0 degrees Fahrenheit, and neither is 0 degrees Celsius equal to 0 degrees Fahrenheit. This means that our conversion process will differ.

Let's consider the formulae for converting one unit of temperature to another.

Celsius to Fahrenheit or vice versa: formulae.

Try to rewrite your program using enums. The problem with representing measurement units as strings is that strings may take longer to process, especially since each unit has at least three different accepted string notations (such as “m”, “meter”, and “meters”).
If you represent each unit by a special enum value, your code becomes cleaner and more readable. Since comparing enum values is much faster than comparing strings, your code is also processed faster.

If the user wants to convert weight or length from one unit to another and inputs a negative amount, print Weight shouldn't be negative or Length shouldn't be negative, respectively.

If a query is bad, we should also handle this. Try to parse the following parts:

<number> +
<(unit name) or (degree + unit name) or (degrees + unit name)> +
<random word like "to" or "in"> +
<(unit name) or (degree + unit name) or (degrees + unit name)>
If there is an error, output Parse error.

Objectives
Rewrite your program using enums.
Your program should be able to convert values from any unit of length, weight, or temperature to any other appropriate unit.
The user input remains case insensitive.
Your program should be able to handle all the possible error types. In the error message, both measurement types should be written in plural, not singular.
After each unit conversion, use a break line.
The program should keep processing user input until they enter exit.
