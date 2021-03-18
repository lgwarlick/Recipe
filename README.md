[![CircleCI](https://circleci.com/gh/lgwarlick/Recipe.svg?style=svg)](https://circleci.com/gh/lgwarlick/Recipe)

# Recipe

A web based application that allows users to create and store recipies including the ingredients and their related amounts, information such as prep time and number of servings, and images. These recipies are then persisted in either and H2 or MySql database depending on which Spring profile is being used (H2 is set as default profile). Out of the box the application comes with two complete recipies included via a bootstrap loading class. 

<h2>Back end:</h2>
<p> Written in Java and built using Maven
<p> Showcasing dependency injection
<p> Full use of CRUD capabilities (via Spring CrudRepository interface)
<p> Spring profiles allow data persistence in either H2 database or MySQL database

<h2>Front end:</h2>
<p> Bootstrap used for CSS formatting
<p> jQuery used for mouse-over effects
<p> Thymeleaf used for template rendering
