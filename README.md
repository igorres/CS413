# Introduction
This banking application is slowly coming to life. Currently have business objects for Customers, Admin, and Bank Accounts.
Using DAO, DTO and DataConnections, this application is able to store business objects in a SQL database, and retrieve
them for Log In verification purposes. The GUI has been made with Java Swing, and is tied to the database.

# Instructions for use
First step is to connect the DataConnection.java pages to your SQL database by changing URL, USERNAME and PASSWORD.
    -must be done for AdminDataConnection.java, CheckingAccountDataConnection.java, CustomerDataConnection.java, SavingAccountDataConnection.java
Next step is to run AdminFrame.java and create a new Admin user to be saved to the database. 
Once that is done, exit, and run LandingPage.java and sign in with the new Admin credentials. 
Once logged in to Admin, page will redirect to AdminHomePage.java and you will be able to create new Customers.

