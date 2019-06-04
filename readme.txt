1. Install hava JDK8 and Maven
2. Setup Java and Maven system path
3. Configure the chromedriver.exe location in serenity.properties
4. Run cucumber test from command-line: mvn clean install -Dcucumber.options="--tags @view"
5. Run junit teset from command-line: mvn clean install -Dit.test=Student.java
6. Test report is located at target/site/serenity/index.html