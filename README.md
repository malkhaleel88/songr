# songr

## Lab:11 - Spring for Full-Stack Web Apps

## Architecture
The programing languages used to build this project are Java, HTML and CSS.

## Overview
in this project, I Used the Spring Initializr to create a new application with artifact songr with Web and Thymeleaf and Devtools dependencies.
First I downloaded the zip file and extract the directory it contains. then added it to my repo, and statrted.

## Methods

in HelloController Class

First I used @Controller  to implement Web Application, its annotation indicates that a particular class serves the role of a controller.

#### I used @GetMapping to put the routes 

#### /hello

- String helloWorld() it Returns hello.html  in /hello route to show Hello World

#### capitalize/{name}

-  String capitalize() I used the @PathVariable annotation to extract the templated part of the URI, represented by the variable {name} and make the name toUpperCase.

#### /

-  In root route its return index.html by default and its return h1 and image tage with a little CSS.

#### /albums

- String albums () it has one parameter Model to return an array that contains three albums, and then displayed  those three on the page .

- In all pages you can see the navbar and this have all links to all pages.

--------------------------------------------------------------------------------------------------------------

## Lab:12 - Spring and REST

### Overview

The requirement for this lab is how the user can add album to the albums page by fill the forms.

### Router:

#### [http://localhost:8080/addAlbum](http://localhost:8080/albums)

* This route is for a page that contains a form that users fill in to add albums to the album page.

### Getting Started

To run the app you should follow the following steps:

* [Getting started with Spring](https://spring.io/guides/gs/serving-web-content/) : This website show you how to build an application by **Spring**.

    * This is the dependencies build.gradle    file
    ```
       dependencies {
	   implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	   runtimeOnly('org.postgresql:postgresql')
	   implementation 'org.springframework. boot:spring-boot-starter-thymeleaf'
	   implementation 'org.springframework.boot:spring-boot-starter-web'
	   developmentOnly 'org.springframework.boot:spring-boot-devtools'
	   testImplementation 'org.springframework.boot:spring-boot-starter-test'
       }
      ```
---------------------------------------------------------------------------------------------------------------

## Lab:12 - Related Resources and Integration Testing

Song model, has a title, a length, a trackNumber, and the album on which that song appears.
A user sees information about all the songs on the site.
A user is able to view a page with data about one particular album.
A user is able to add songs to an album.
A user is able to see the songs that belong to an album when looking at that album.

http://localhost:8080/addSong/{title} ->
will send you to the page that contains:

- songs on that album.
- form to add song on the album.