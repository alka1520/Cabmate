# CabMate (Online Cab Booking)
# REST API for an Online Cab Booking Application

* We have developed this REST API for an Online Cab Booking application. This API performs all the fundamental CRUD operations of any Online Cab Booking platform with user validation at every step.
* This project is developed by team of 4 Back-end Developers . 

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

------------------------------------------------------------------------------
## Modules
------------------------------------------------------------------------------
* Login, Logout Module
* Driver Module
* Customer Module
* Admin Module
* TripBooking Module

---------------------------------------------------------------------------------
## Features

---------------------------------------------------------------------------------
* Customer, Driver and Admin authentication & validation with usersession's sessionid.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid sessionid can add/update/delete driver or customer from main database
    * Admin can access the details of different customers, drivers and trip bookings
* Customer Features:
    * Registering themselves with application, and logging in to get the valid sessionid.
    * Viewing list of available cabs and booking a trip.
    * Only logged in user can access his trip history, profile updation and other features.

--------------------------------------------------------------------------------
## Contributors
--------------------------------------------------------------------------------
*<a href="https://github.com/alka1520">Alka Singh</a>
<br>
*<a href="https://github.com/mynkgupta22">Mayank Gupta</a>
<br>
*<a href="https://github.com/AshishGupta189">Ashish Gupta</a>
<br>
*<a href="https://github.com/prasannaj-15">Prasanna Jadhav</a>


## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](CabMate\src\main\resources\application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8088
    spring.datasource.url=jdbc:mysql://localhost:3306/cabmatedb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

## API Root Endpoint

`https://localhost:8088/`

`http://localhost:8088/swagger-ui.html`


## API Module Endpoints

### Customer Module


* `POST /customer/customerlogin` : Logging in customer with valid mobile number & password
*  `POST /customer/customer` : register customer by providing valid details
* `GET /customer/customer/{sessionid}` : Getting the details of customers through sessionid
* `PUT /customer/update/{sessionid}` : Updates customer details based on sessionid
* `PUT /customer/updatepassword` : Updates customer's password based on the given mobile number
* `POST /customer/logout` : Logging out customer based on sessionid
* `DELETE /customer/delete` : Deletes logged in user 
* `POST /customer/verify` : verify by email and otp



### Admin Module

* `POST /admin/registeradmin` : Register a new admin with proper data validation
* `POST /admin/login` : Admin can login with mobile number and password provided at the time of registation
* `GET /admin/logout` : Logging out admin based on sessionid
* `POST /driver/register` : Register a new driver with proper data validation and admin session
* `POST /driver/login` : Driver can login with mobile number and password provided at the time of registation
* `GET /admin/listoftripsbycustomer` : Get list of trips of by a customer id
* `GET /admin/listoftrips` : Get list of trips of all the trips
* `GET /admin/listocustomers` : Get list of all the customers
* `GET /admin/listodrivers` : Get list of all the drivers
* `PUT /admin/update/{username}` : Updates admin detaisl by passed user name
* `DELETE /admin/delete` : Deletes the admin with passed id


### Driver Module

* `POST /driver/register` : Register a new driver with proper data validation and admin session
* `POST /driver/login` : Driver can login with mobile number and password provided at the time of registation
* `POST /driver/status/{?}` : Changes the status of the driver either Online or Offline
* `GET /driver/logout` : Logging out driver based on session token
* `GET /driver/driverlist` : Gets list of all the drivers
* `GET /driver/bestdriver` : Gets the best driver whose rating is over 4.5
* `PUT /driver/update` : Updates the driver details
