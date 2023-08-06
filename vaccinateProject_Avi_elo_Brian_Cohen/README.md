## Authors
* Name: Avi Elo
*	Email: aviel@edu.hac.ac.il
*	Id: 302950894

* Name: Erez Kalifa
*	Email: erezka@edu.hac.ac.il
*	Id: 305580326

## Description

The Website topic is a course registration system.

THe website combining the Spring technology taught in the course:

* SpringBoot MVC(Model,View,Controller)
* thymeleaf view engine
* Beans,dependencyinjection
* All of the logic is server side (Spring)
* Storing persistent data with JPA-mySQL
* Springsecurity (authentication and authorization) to secure some functionality.


### Functionality

* admin can create courses with maximum number of participants.
* citizens can register to one (or X) cours(es).
* Admin can browsw/edit/delete courses and participants.
* citizens do not need register for the site, they can join to a course by clicking the chosen course, then clickig the "join" button will take them to the join-form and by entering their email they will be joined the course.
* Each course includes the following details: name, some overview description, teacher, credits, max participants and current participants
* The option for Join to a course will not be visible if the course is already full, "Course is full" text will be display instead.
* list of participants table (visible only for admin) will not be visible if current participants is 0, "No participant yet!" text will be display instead.


  #### Secure Functionality:
  
  * Admin can Login to the web site by entering citizen name and password, and than more actions will be visible for him:
    1. Create new course
    2. Edit the details of a course: name, maximum participants, descripton, credits and the teacher of the course.
    3. Acsses to the participants list of a course, including the option to remove citizens.
    4. Add citizen to a course
    5. Delete course
     

### General information

#### Validations:

* User Can't join to the same course if already he is part of him. if he will try - he will be directed to an error page with appropiate message about the error
* Admin Can't edit the maximum participants of a course to be less than the current participant in that course. if he will try, he will be directed to an error page with appropiate message about the error.
* Admin Can't set/edit the maximun participants of a course to be a negative number.
* Admin Can't set/edit the credits of a course to be a negative number.
* name of a course can't be more than 32 characters.
* All of the fields is mandatory

 
## Initialize the website:

1. Open Mamp and click on start for run the db server
2. Run Ex5TemplateApplication file from the project.
3. Open the url localhost/8080


## Useful information

* spring.datasource.url=jdbc:mysql://localhost:8889/ex5?serverTimezone=UTC

#### credentials:
For admin login:
citizen name: admin
password: Aa123456


# vaccinateProject_Avi_Elo_Brian_Cohen
