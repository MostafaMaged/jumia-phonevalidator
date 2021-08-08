## About the project:
Customersinfo is a single page application in Java that uses Sqlite database to list and categorize country phone numbers. That are categorized by country, state (valid or not valid), country code and number
                                                                  
## Prerequisite:
 - Having docker installed on your machine.
 - Making sure that docker daemon is up and running.

## Running Steps:
 1. Clone the repo in any directory
 2. Open cmd and cd to that directory and run this command **"docker-compose up --build"** ( it will take a while :D)
 3. Open **localhost:4200** in your browser to access the front end

## Postman collection:
 - Open postman and press import then select Customersinfo.postman_collection.json file, You will find a collection named **Customersinfo**, Open it and try the requests. 
 - In order to access the enpoints from your browser :
      - http://localhost:8081/jumia-customers/phone-numbers
      - http://localhost:8081/jumia-customers/phone-numbers?pageNum=2&pageSize=10
      - http://localhost:8081/jumia-customers/phone-numbers?state=NOT_VALID
      - http://localhost:8081/jumia-customers/phone-numbers?country=Cameroon
      - http://localhost:8081/jumia-customers/phone-numbers?state=VALID&country=Uganda

## Used Technologies: 
- **Spring-Boot:** For Backend
- **Angular:** For Frontend
