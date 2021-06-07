/**
 * The main Contacts class. This script stores all the contact information
 * and manages the GUI used to interface with said information.
 * 
 * @author Jayden
 * @version 3/06/2021
 */
import java.util.HashMap;
import ecs100.*;
import java.io.File;
import java.io.IOException;

public class Contacts {
    // CONSTANTS
    // Contacts
    private final int CONTACTLENGTH = 2;
    private final int MAXCONTACTS = 10;
    private final String DEFAULTNAME = "George Washington";
    private final String DEFAULTFILE = "defProfile.png"; // NEED TO ADD IMAGE FILE
    private final String DEFAULTNUM = "0210210211"; // CUSTOMIZE PHONE NUMBER BETTER
    // All contacts display
    private final int DISPLAYALLX = 100;
    private final int DISPLAYALLY = 100;
    private final int DISPLAYALLSPACING = 10;
    // Screen positioning
    private final int SCREENX = 1000;
    private final int SCREENY = 1000;

    // VARIABLES
    // Contact Info
    // Hashmap Layout - Name:[Number, File]
    private HashMap<String, String[]> contacts = new HashMap<String, String[]>();
    private Boolean isDisplayingProfile = false;
    private Profile currentProfile = new Profile(DEFAULTFILE, DEFAULTNAME, DEFAULTNUM);

    // METHODS
    private String newContactName = DEFAULTNAME;
    private String newContactNumber = DEFAULTNUM;
    private String newContactFile = DEFAULTFILE;
    
    private String searchName = DEFAULTNAME;

    // CAPITALIZATION SCRIPT WILL BE LEFT TO EXTENTION
    /**
     * Capitalizes each word in a given string
     * @param name  the string to be capitalized
     * @return capName  the capitalized variation of the string
     */
    public String capitalize(String name) {
        String capName = name;
        return capName;
    }

    /**
     * Checks if the given name has already been added to the contacts
     * list.
     * @param name  the name to check
     * @return exists  returns True if the name has previously been added.
     */
    public Boolean duplicate(String name) {
        // Loops incrementally over each contact to check if name matches
        for (String contact : contacts.keySet()) {
            if (contact.equals(name)) {
                return true; // Breaks out of loop
            }
        }
        return false;
    }

    /**
     * Checks if the given filename points to an actual file.
     * @param fileSpace  the given filename
     * @return compatible  returns True if filename points to a working file.
     */
    public Boolean checkFile(String fileSpace) {
        File testFile = new File(fileSpace);
        if (testFile.exists()) { // Doesn't check if filetype is correct
            return true;
        }
        return false;
    }

    /**
     * Adds a given name, number and pic to the contacts list.
     * @param file  the filename for the profile image
     * @param name  contact's name
     * @param number  contact's phone number (NOTE: String since " " and "-"
     *      exist inside of phone numbers)
     */
    public void addContact(String file, String name, String number) {
        if (!duplicate(name)) { // Checks if name already exists
            // Creates contact info array
            String[] contactInfo = new String[CONTACTLENGTH];
            contactInfo[0] = number;

            if (checkFile(file)) {
                contactInfo[1] = file;
            } else {
                contactInfo[1] = DEFAULTFILE;
            }

            // Adds contact to contactList
            contacts.put(name, contactInfo);

        } else {
            System.out.println("Sorry, this name has already been taken");
        }
    }

    /**
     * Finds a contact's info when given their name.
     * @param name  contact's name
     * @return [number, fileName]  the contact's info
     */
    public String[] getContact(String name) {
        if (duplicate(name)) { // Checks if name in contacts
            return contacts.get(name);
        } else {
            System.out.println("Sorry, this name doesn't exist");
            
            // Constructs a fake contact as to not crash whatever script called getContact
            String[] defContact = new String[CONTACTLENGTH];
            defContact[0] = DEFAULTNUM;
            defContact[1] = DEFAULTFILE;
            
            return defContact;
        }
    }

    /**
     * Displays a given contact onto the GUI
     * @param name  name of contact
     * @param contactInfo number/file of contact
     */
    public void displayContact(String name, String[] contactInfo) {
        // Seperates String Array
        String number = contactInfo[0];
        String file = contactInfo[1];
        // Displays contact
        currentProfile = new Profile(name, number, file);
        currentProfile.displayProfile();
    }

    // BUTTON METHODS
    /**
     * Sifts through every contact in the list and displays them all in the GUI.
     * However, since I am going for a non-scrollable approach, this means that
     * I will have to implement a hard limit on the amount of contacts someone
     * can add (Likely around a couple dozen)
     */
    public void displayAll() {
        int contactCount = 0;
        for (String contactName : contacts.keySet()) {
            UI.drawString(contactName, DISPLAYALLX, DISPLAYALLY + DISPLAYALLSPACING * contactCount);
            contactCount++;
            UI.drawString(contacts.get(contactName)[0], DISPLAYALLX, DISPLAYALLY + DISPLAYALLSPACING * contactCount);
            contactCount++;
        }
    }

    /**
     * Clears all information on the screen, except for any profile images.
     */
    public void hideInfo() {
        // Clears UI
        UI.eraseRect(0, 0, SCREENX, SCREENY);
        
        if (isDisplayingProfile) {
            // Displays profile img
            currentProfile.displayImg();
        }

    }
    
    /**
     * Searches and displays the searched name
     */
    public void search() {
        // Retrieves input text name
        String query = capitalize(searchName);

        Boolean foundContact = false; // Error tracking
        for (String existingContact : contacts.keySet()) {
            if (query.equals(existingContact)) {
                String[] queryResult = getContact(query);
                displayContact(query, queryResult);
                foundContact = true;
            }
        }

        if (!foundContact) {
            System.out.println("Unable to find contact");
        }
    }

    /**
     * Stores the currently inputted search name
     * @param newSearch  text from the searchName text field
     */
    public void storeSearchName(String newSearch) {
        searchName = newSearch;
    }

    /**
     * Stores the currently inputted new name
     * @param newName  text from the adding name text field
     */
    public void storeNewName(String newName) {
        newContactName = newName;
    }

    /**
     * Stores the currently inputted new number
     * @param newNumber  text from the adding number text field
     */
    public void storeNewNumber(String newNumber) {
        newContactNumber = newNumber;
    }

    /**
     * Stores the currently inputted new filename
     * @param newFilename  text from the adding filename text field
     */
    public void storeNewFilename(String newFilename) {
        newContactFile = newFilename;
    }

    /**
     * Adds the new contact
     */
    public void addContact() {
        if (contacts.size() < MAXCONTACTS) {
           addContact(newContactName, newContactNumber, newContactFile);
        } else {
            System.out.println("Sorry, you have reached the maximum amount of contacts");
        }
    }



    // MAIN ROUTINE
    /**
     * Manages the contacts list, allowing for adding/retrieving of contacts.
     */
    public static void main(String[] args) {
        // Class initializations
        Contacts c = new Contacts(); // Main routine class

        // Buttons/text fields to interact with contacts
        UI.addTextField("Name", c::storeNewName);
        UI.addTextField("Number", c::storeNewNumber);
        UI.addTextField("Filename", c::storeNewFilename);
        
        UI.addButton("Add contact", c::addContact);

        UI.addTextField("Name", c::storeSearchName);
        UI.addButton("Search", c::search);

        UI.addButton("Display all", c::displayAll);
        UI.addButton("Hide details", c::hideInfo);
    }

}