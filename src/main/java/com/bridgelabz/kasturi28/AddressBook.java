package com.bridgelabz.kasturi28;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

public class AddressBook {
	
	 private static final ArrayList<Contacts> list = new ArrayList<Contacts>();
	 
	 
	 public static void writeFile() throws Exception {
	        JSONArray arr = new JSONArray();
	        FileWriter writer = new FileWriter(new File("C:\\Users\\kastu\\eclipse-workspace\\kasturi28\\JSON.txt"));
	        try {
	            for (Contacts c : list) {
	                JSONObject jsonObject = new JSONObject();
	                jsonObject.put("First Name:: ", c.getFirstName());
	                jsonObject.put("Last Name:: ", c.getLastName());
	                jsonObject.put("Email:: ", c.getEmail());
	                jsonObject.put("Address:: ", c.getAddress());
	                jsonObject.put("City :: ", c.getCity());
	                jsonObject.put("State :: ", c.getState());
	                jsonObject.put("Zip Code:: ", c.getZip());
	                jsonObject.put("Phone Number:: ", c.getPhoneNumber());
	                arr.put(jsonObject);
	            }
	            writer.write(String.valueOf(arr));
	            writer.close();
	        } catch (Exception e) {
	            e.getMessage();
	        }
	    }


	    /*
	     * Read CSV file for contact details
	     * @throws IOException
	     */
	    public static void readCSVFile() throws Exception {
	        try {
	            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\kastu\\eclipse-workspace\\D28_AddressBook\\Contact_Details.txt"));
	            String line;
	            while ((line = br.readLine()) != null) {
	                if (line.isEmpty()) {
	                    break;
	                }
	                System.out.println(line);
	            }
	            br.close();
	            System.out.println(line.toString());
	        } catch (NullPointerException e) {
	            e.getMessage();
	        }
	    }

	    /**
	     * Write CSV file for contact details
	     * @throws IOException
	     */
	    public static void writeCSVFile() throws IOException {
	        PrintWriter pw = new PrintWriter(new File("C:\\Users\\kastu\\eclipse-workspace\\D28_AddressBook\\Contact_Details.txt"));
	        StringBuilder sb = new StringBuilder();
	        sb.append("Sr.No");
	        sb.append(",");
	        sb.append("Firstname");
	        sb.append(",");
	        sb.append("Lastname");
	        sb.append(",");
	        sb.append("Address");
	        sb.append(",");
	        sb.append("City");
	        sb.append(",");
	        sb.append("State");
	        sb.append(",");
	        sb.append("Zip");
	        sb.append(",");
	        sb.append("Phone Number");
	        sb.append("\r\n");
	        int count = 1;
	        for (Contacts details : list) {
	            sb.append(count++);
	            sb.append(",");
	            sb.append(details.getFirstName());
	            sb.append(",");
	            sb.append(details.getLastName());
	            sb.append(",");
	            sb.append(details.getAddress());
	            sb.append(",");
	            sb.append(details.getCity());
	            sb.append(",");
	            sb.append(details.getState());
	            sb.append(",");
	            sb.append(details.getZip());
	            sb.append(",");
	            sb.append(details.getPhoneNumber());
	            sb.append("\r\n");
	        }
	        pw.write(sb.toString());
	        pw.close();
	    }

	    /**
	     * Call method to sort entry in contact by city
	     */
	    private void sortByCity() {
	        List<Contacts> check = list.stream().sorted(Comparator.comparing(str -> str.getCity())).collect(Collectors.toList());
	        ;
	        check.forEach(str -> System.out.println(str.toString()));
	    }

	    /**
	     * Call method to sort entry in contact by firstname
	     */
	    private void sortByFirstname() {
	        List<Contacts> check = list.stream().sorted(Comparator.comparing(str -> str.getFirstName())).collect(Collectors.toList());
	        check.forEach(str -> System.out.println(str.toString()));
	    }

	    /**
	     * Call method to count entry in contact by city
	     */
	    private void getCountByCity() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter city to get count of entry in Contacts: ");
	        String city = sc.nextLine();
	        long check = list.stream().filter(i -> i.getCity().equals(city)).count();
	        System.out.println("Count of contacts in address book by city is " + check);
	    }

	    /**
	     * Call method to check entry in contact by searching state
	     */
	    private void searchPersonByState() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter state to check entry in Contacts: ");
	        String state = sc.nextLine();
	        Stream<Contacts> check = list.stream().filter(i -> i.getState().equals(state));
	        check.forEach(str -> System.out.println(str.toString()));
	    }

	    /**
	     * Call method to check entry in contact by searching city
	     */
	    private void searchPersonByCity() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter city to check entry in Contacts: ");
	        String city = sc.nextLine();
	        Stream<Contacts> check = list.stream().filter(i -> i.getCity().equals(city));
	        check.forEach(str -> System.out.println(str.toString()));
	    }

	    /**
	     * Call method to check duplicate entry
	     */
	    private void checkDuplicateEntry() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter firstname to Check duplicate entry Contact: ");
	        String name = sc.nextLine();
	        Stream<Contacts> check = list.stream().filter(i -> i.getFirstName().equals(name));
	        check.forEach(str -> System.out.println(str.toString()));
	    }

	    /**
	     * Call method to delete contact by searching firstname in contact list
	     */
	    private void deleteContact() throws ConcurrentModificationException {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter firstname to Delete Contact: ");
	        String name = sc.nextLine();
	        try {
	            for (Contacts search : list) {
	                if (name.equalsIgnoreCase(search.getFirstName())) {
	                    System.out.println("Entered name found in the Address Book, deleting contact");
	                    list.remove(search);
	                } else {
	                    System.out.println("Entered name not found in the Address Book");
	                }
	            }
	        } catch (ConcurrentModificationException e) {
	            System.out.println("Exception is " + e.toString());
	        }
	    }

	    /**
	     * Call method to edit the contact by searching firstname
	     */
	    private void editContact() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter firstname to edit contact: ");
	        String name = sc.nextLine();
	        for (Contacts search : list) {
	            if (name.equalsIgnoreCase(search.getFirstName())) {
	                System.out.println("Entered name found in the Contacts");
	                System.out.println("Enter the updated first name");
	                String firstName = sc.next();
	                search.setFirstName(firstName);
	                System.out.println("Enter the updated last name");
	                String lastName = sc.next();
	                search.setLastName(lastName);
	                System.out.println("Enter the updated address");
	                String address = sc.next();
	                search.setAddress(address);
	                System.out.println("Enter the updated city");
	                String city = sc.next();
	                search.setCity(city);
	                System.out.println("Enter the updated state");
	                String state = sc.next();
	                search.setState(state);
	                System.out.println("Enter the updated zipcode");
	                int zip = sc.nextInt();
	                search.setZip(zip);
	                System.out.println("Enter the updated phoneNumber");
	                long phoneNumber = sc.nextInt();
	                search.setPhoneNumber(phoneNumber);
	                System.out.println("Enter the updated emailID");
	                String email = sc.next();
	                search.setEmail(email);
	                search.toString();
	            } else {
	                System.out.println("Entered name not found in the AddressBook");
	            }
	        }
	    }

	    /*
	     * Call method to add contacts in ArrayList
	     * Create object and add details in it and put it in that list
	     */
	    public void AddContactsDetails() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("First Name = ");
	        String firstName = sc.nextLine();
	        System.out.println("Last Name = ");
	        String lastName = sc.nextLine();
	        System.out.println("Address = ");
	        String address = sc.nextLine();
	        System.out.println("City = ");
	        String city = sc.nextLine();
	        System.out.println("State = ");
	        String state = sc.nextLine();
	        System.out.println("Zip Code = ");
	        int zip = sc.nextInt();
	        System.out.println("Phone Number = ");
	        long phoneNumber = sc.nextLong();
	        System.out.println("Email = ");
	        String email = sc.next();
	        Contacts person = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
	        list.add(person);
	        person.toString();
	    }

	    public static void main(String[] args) throws Exception {

	        Scanner sc = new Scanner(System.in);
	        HashMap<String, com.bridgelabz.kasturi28.AddressBook> addressBooks = new HashMap<>();
	        com.bridgelabz.kasturi28.AddressBook book1 = new com.bridgelabz.kasturi28.AddressBook();
	        com.bridgelabz.kasturi28.AddressBook book2 = new com.bridgelabz.kasturi28.AddressBook();
	        com.bridgelabz.kasturi28.AddressBook book3 = new com.bridgelabz.kasturi28.AddressBook();
	        addressBooks.put("AddressBook1", book1);
	        addressBooks.put("AddressBook2", book2);
	        addressBooks.put("AddressBook3", book3);
	        System.out.println("Choose Address Book");
	        System.out.println("1. AddressBook 1");
	        System.out.println("2. AddressBook 2");
	        System.out.println("3. AddressBook 3");
	        int chooseAddressBook = sc.nextInt();
	        System.out.println("Choose What to do in this Address Book");
	        while (chooseAddressBook >= 1) {
	            System.out.println("1. Add Contacts");
	            System.out.println("2. Edit Contacts");
	            System.out.println("3. Delete Contacts");
	            System.out.println("4. check duplicate entry");
	            System.out.println("5. Search entry by city");
	            System.out.println("6. Search entry by state");
	            System.out.println("7. Get count by city");
	            System.out.println("8. sort by firstname");
	            System.out.println("9. sort by city");
	            System.out.println("Enter Your Choice");
	            int choice = sc.nextInt();
	            switch (chooseAddressBook) {
	                case 1:
	                    if (choice == 1) {
	                        book1.AddContactsDetails();
	                        writeCSVFile();
	                        readCSVFile();
	                    } else if (choice == 2) {
	                        book1.editContact();
	                    } else if (choice == 3) {
	                        book1.deleteContact();
	                    } else if (choice == 4) {
	                        book1.checkDuplicateEntry();
	                    } else if (choice == 5) {
	                        book1.searchPersonByCity();
	                    } else if (choice == 6) {
	                        book1.searchPersonByState();
	                    } else if (choice == 7) {
	                        book1.getCountByCity();
	                    } else if (choice == 8) {
	                        book1.sortByFirstname();
	                    }
	                    break;
	                case 2:
	                    if (choice == 1) {
	                        book2.AddContactsDetails();
	                    } else if (choice == 2) {
	                        book2.editContact();
	                    } else if (choice == 3) {
	                        book2.deleteContact();
	                    } else if (choice == 4) {
	                        book2.checkDuplicateEntry();
	                    } else if (choice == 5) {
	                        book2.searchPersonByCity();
	                    } else if (choice == 6) {
	                        book2.searchPersonByState();
	                    } else if (choice == 7) {
	                        book2.getCountByCity();
	                    }
	                    break;
	                case 3:
	                    if (choice == 1) {
	                        book3.AddContactsDetails();
	                    } else if (choice == 2) {
	                        book3.editContact();
	                    } else if (choice == 3) {
	                        book3.deleteContact();
	                    } else if (choice == 4) {
	                        book3.checkDuplicateEntry();
	                    } else if (choice == 5) {
	                        book3.searchPersonByCity();
	                    } else if (choice == 6) {
	                        book3.searchPersonByState();
	                    } else if (choice == 7) {
	                        book3.getCountByCity();
	                    }
	                    break;
	                default:
	                    System.out.println("Invalid input");
	                    break;
	            }
	            System.out.println("1. AddressBook 1");
	            System.out.println("2. AddressBook 2");
	            System.out.println("3. AddressBook 3");
	            System.out.println("0. Exit");
	            chooseAddressBook = sc.nextInt();
	        }
	        System.out.println("The Program End");
	    }

}
