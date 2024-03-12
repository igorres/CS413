/*************************************************
File: CustomerAddress.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates an Address business object, which 
            allows the user to modify 
*************************************************/
package Assignment2;

public class CustomerAddress {
    int number;
    String street;
    String city;
    String state;
    int zip;

    public CustomerAddress(int num, String str, String cty, String st, int z) {

        street = str;
        number = num;
        city = cty;
        state = st;
        zip = z;
    }

    public int getNumber()
    {
    return number;
    }
    public String getStreet()
    {
    return street;
    }
    public String getCity()
    {
    return city;
    }
    public String getState()
    {
    return state;
    }
    public int getZip()
    {
    return zip;
    }

    public void setNumber( int number)
    {
    this.number=number;
    }
    public void setStreet( String street)
    {
    this.street=street;
    }
    public void setCity( String city)
    {
    this.city=city;
    }
    public void setState( String state)
    {
    this.state=state;
    }
    public void setZip( int zip)
    {
    this.zip=zip;
    }
    // defining printAddress() function to print full address of current customer
    public String toString()
    
    {
        String add = "";
        
        add += "Number --> " + this.number + "\nStreet --> " + this.street
                    + "\nCity --> " + this.city + "\nState --> " + this.state + "\nZip --> " + this.zip;
        
        return add;
    }
}
