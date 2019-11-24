# AI_Rockstar
Applitools Visual AI Rockstar Hackathon Instructions. The challenge is to write five (5) automated tests for both versions of the app:  One suite using your preferred traditional functional testing approach Another suite which covers the same tests but uses visual AI testing with Applitools

To run traditional tests:
	- runTraditionalTestsSuite.sh
	
Test report will be saved into {project}/target/site/surefire-report.html


!Add API_KEY variable into Operating System Environment variables.

To run applitools tests:
	- runVisualAITests.sh
	
To change url from V2 to V1 open the following base classes:
{project}\src\test\java\applitoolsTests\BaseTests.java
{project}\src\test\java\applitoolsTests\EyesBase.java
	