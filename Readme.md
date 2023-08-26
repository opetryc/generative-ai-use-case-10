# Project
This project is an experiemnt that was meant for verifying how effective generative AI is for everyday usage. In scope of this project a single utility function has been implemented. For this particular case the implementation was performed by hand without using GhatGPT or other AI based resources. The function performs regular expression check to verify the validity of the provided string.

# Regex implementation
Utility function consists of 3 components:
* Special characters string with all of the supported special characters;
* Special regex - a string of regex with ability to insert special characters string and limit for number of characters;
* String verification utility function - this function performs string verifications by constructing regex string, creating an instance of Regex and running verifications.

Regular expression consists of multiple groups of checks. Each one verifies the validity of the string. Groups are separated by parentheses:
* Fist, second and seventh groups verify that string has no whitespaces, new lines or tabs;
* Third group verifies presence of at least one digit;
* Fourth group verifies presence of at least one lowercase letter;
* Fifth group verifies presence of at least one uppercase letter;
* Sixth group verifies presence of at least one special symbol.
# How to run tests localy
1. For Unix based operating systems open terminal in the project folder and type **./gradlew test**
2. Open project in Android studio. On the left the **Project** tab, right click on the **com.softserve.opetryc (test)** package and select **Run Tests in the package**