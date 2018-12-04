# RecipeManager

Steps to run the spring boot application

Build the project using the following command:

1) mvn clean compile install

2) Execute the following command to deploy and start the Spring boot server

3) mvn spring-boot:run -Dspring.profiles.active=local -Dserver.address='your ip'



Steps to run the angular code

1) Go to constant.service.ts and replace the value of url to the ip where the services are running

2) Go to the command prompt and exceute the command ng serve --open to launch the app in your default browser.
