# TimeFormatter
Example Code Demonstrating a Way to Format Time.

This is a Gradle project. You will find the source code under the `src/main` directory and the
test code under the `src/test` directory.

# Problem Statement
Without using any built-in date or time functions, write a function or method that accepts two
mandatory arguments: the first argument is a 12-hour time string with the format "[H]H:MM
{AM|PM}", and the second argument is a (signed) integer. The second argument is the number of
minutes to add to the time of day represented by the first argument. The return value should be a
string of the same format as the first argument. For example, AddMinutes("9:13 AM", 200) would
return "12:33 PM". The exercise isn't meant to be too hard or take very long; we just want to see how
you code. Use any mainstream language you want, though Java, Javascript (ES2017), Ruby, Swift,
Python, C++ or C# are particularly relevant to us. Please include any test cases that you write. 

# Solution
The source code for the solution is located in the `src/main/java/com/example/TimeFormatter.java` file.

# Run the Test Cases
From the project directory run the following command.

`./gradlew clean test --info`

This will run the tests and create a report in the `$PROJECT_DIR/build/reports/tests/test` directory.

# IDEA Support

If you want to import this project into IntelliJ IDEA select `Open Project` and navigate to
the `build.gradle` file.

To run the test file make sure the `src/test/groovy` directory is marked as a test source
then right click on the `src/test/groovy/com/example/TimeFormatterSpec` file in the Project window
and select `Run TimeFormatterSpec`.

