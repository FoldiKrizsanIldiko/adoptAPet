# adoptAPet

run from terminal: 
enter the correct folder
cd .\FontendTests\adoptAPetFrontend

run all tests : 
mvn clean test    
(it might throw error for registering)

run only tagged tests: 

mvn test -Dtags="@workflow"
or:
mvn test -D"cucumber.filter.tags=@workflow"

If you want to add more test to workflow, just put tag @workflow before Feature or Scenario



running the application from https://github.com/EviBera/adopt-a-pet

