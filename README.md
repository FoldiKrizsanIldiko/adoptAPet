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

make a database in Docker container
----------------------------------
clone the repo

Intall Docker Desctop
Run a container : docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=yourStrong(!)Password" -p 1433:1433 -d mcr.microsoft.com/mssql/server

Install ? : dotnet tool install --global dotnet-ef --version 7.0.14
dotnet add package Microsoft.EntityFrameworkCore.Design -v 7.0.14


create appsettings.json in ../OfferOasisBackend\OfferOasisBackend\bin\Debug\net6.0\appsettings.json

{
"Logging": {
"LogLevel": {
"Default": "Information",
"Microsoft.AspNetCore": "Warning"
}
},
"AllowedHosts": "*",
"ConnectionStrings": {
"Oasis": "Server=localhost,1433;Database=OfferOasisDB;User Id=sa;Password=<yourStrong(!)Password>;TrustServerCertificate=True;"
}
}

Migration: dotnet ef migrations add InitialCreate
dotnet ef database update
dotnet ef migrations list

run backend

on frontend npm i
npm start
-----------------------
in appsettings.json: 
the username and password should be yours
"ConnectionStrings": {
"DefaultConnection": "Host=localhost;Port=5433;Database=AdoptAPet;Username=postgres;Password=<yourStrong(!)Password>;TrustServerCertificate=True"
}

do the migration

run frontend:
cd .\frontend\AdoptAPet\
ng serve -o

run backend:
cd .\backend\AdoptAPet\
dotnet run
