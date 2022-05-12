# CoursesManagementApp

### SQL configuration

```mysql
CREATE DATABASE courses_management;
SHOW DATABASES;
CREATE USER 'coursesmanager'@localhost IDENTIFIED BY 'c0ursesmanager';
SELECT User FROM mysql.user;
GRANT ALL PRIVILEGES ON *.* TO 'coursesmanager'@localhost IDENTIFIED BY 'c0ursesmanager';
FLUSH PRIVILEGES;
```
### Database configuration

```mysql
CREATE DATABASE courses_management;
SHOW DATABASES;
CREATE USER 'coursesmanager'@localhost IDENTIFIED BY 'c0ursesmanager';
SELECT User FROM mysql.user;
GRANT ALL PRIVILEGES ON *.* TO 'coursesmanager'@localhost IDENTIFIED BY 'c0ursesmanager';
FLUSH PRIVILEGES;
```

### Guides

The following guides illustrate how to use some features concretely:

* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

