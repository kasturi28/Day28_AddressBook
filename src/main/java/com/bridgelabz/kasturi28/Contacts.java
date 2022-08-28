package com.bridgelabz.kasturi28;

public class Contacts {
	/*
	 * Calling toString method
	 */
	@Override
    public String toString() {
        return "Contacts{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }

    private String firstName = " ";
    private String lastName = " ";
    private String address = " ";
    private String city = " ";
    private String state = " ";
    private int zip = 0;
    private long phoneNumber = 0;
    private String email = " ";
/*
 * Define construstor of contacts
 */
    Contacts(String firstName, String lastName, String address, String city, String state, int zip, long phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
/*
 * use getters and setters
 */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailId) {
        this.email = emailId;
    }

/*
 * call display method to print contacts
 */
    void display() {
        System.out.println("First name = " + firstName);
        System.out.println("Last name = " + lastName);
        System.out.println("Address = " + address);
        System.out.println("City = " + city);
        System.out.println("State = " + state);
        System.out.println("Zip = " + zip);
        System.out.println("Mobile number = " + phoneNumber);
        System.out.println("Email-Id = " + email);
    }
	
}