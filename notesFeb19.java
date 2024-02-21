public class notesFeb19 {
    
}

/*
 * Factory design pattern------
 * Creational pattern, most commong. encapsulates logic of creating an object
 * Fact pattern allows you to create many complex objects if given a set of 
 * parameters
 * 
 * complex object - one of its attributes is a separate object
 * 
 * Factory object creates the objects when given an array
 * Uses interfaces to prevent client from using specific sub-class names
 * 
 * Factory class creates factory object -> all creationary methods (abstract) 
 * come from the factory object.
 * 
 * Recognizable by a static method that returns an object that is a subclass or 
 * implementation of an interface
 * 
 * typical method names:
 * getInstance()
 * newInstance()
 * 
 * Comparable - is an interface:
 * used for whenever you have a need to compare two objects of a particular type
 * 
 * Implemented by parent class (Employee class)
 * Must implement method compareTo(Employee E), must return an integer:
 * - E is greater than
 * + E is less than 
 * 0 are equal
 * 
 * Singleton Pattern -----
 * Primarily for object creation
 * Only 1 object of an entity
 * 
 * Reporting Singleton - all error types processed and managed by it
 * DB traffic controller - responsible for managing and directing all ingress and egress of
 * data in and out of the application
 * 
 * Constructor for singleton object is made private
 * Not creating an object, but rather giving back a single report object
 * 
 * lazy initilization - objects are not initilized until told to do so
 * Eager initilization - when application starts, singleton objects are created right away
 * ^critical thing for singleton objects
 * Cannot overwrite , everything is private
 * 
 * Builder Pattern ------
 * A configuration pattern, typically used for GUI, creates windows
 * Builder object may be given a set of parameters and it returns a complex
 * layered object.
 * Uses setters to create objects
 * 
 * Similar to factory pattern, but has a telescoping constructor.
 * Telescoping constructor is one where an object can be instantiated in multiple ways
 * 
 * Alleviates responsibilty of client from having to be aware of all constructors
 * 
 * DAO & DTO Design Pattern ------
 * Data Access Object:
 * Purpose is to put a layer of abstraction between business layer and persistance layer of an 
 * application that performs CRUD
 *      ^Persistance layer = where data resides
 * Allow data access mechanism to change as the type of storage requirements changes with no impacts
 * to application code that 'uses' the data.
 * Used to fetch data from DB and feed data to business layer
 * 
 * Benefits of incorporating DAO objects in your application architecture:
 * Easy to unit test since the tests are directed only to DAO in a targeted manner
 * If database changes, only need to modify DAO object
 * 
 * Data Transfer Object:
 * An object that acts are a data store and carries business object data between layers
 * Not necessary but is beneficial to have.
 * DTO object communicates with DAO object, which then gets info from DB
 * Single most important task is to get business object data and 'transfer' it
 * to an entity for persistance.
 * 
 * 
 * 
 */