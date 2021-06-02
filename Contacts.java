/**
 * The main Contacts class. This script stores all the contact information
 * and manages the GUI used to interface with said information.
 * 
 * @author Jayden
 * @version 3/06/2021
 */

public class Contacts {
    // CONSTANTS


    // VARIABLES


    // METHODS
    /**
     * Capitalizes each word in a given string
     * @param name  the string to be capitalized
     * @return capName  the capitalized variation of the string
     */
    public String capitalize(String name) {

    }

    /**
     * Checks if the given name has already been added to the contacts
     * list.
     * @param name  the name to check
     * @return exists  returns True if the name has previously been added.
     */
    public Boolean duplicate(String name) {

    }

    /**
     * Checks if the given filename points to an actual and compatible file.
     * @param fileSpace  the given filename
     * @return compatible  returns True if filename points to a working file.
     */
    public Boolean checkFile(String fileSpace) {

    }

    /**
     * Adds a given name, number and pic to the contacts list.
     * @param file  the filename for the profile image
     * @param name  contact's name
     * @param number  contact's phone number (NOTE: String since " " and "-"
     *      exist inside of phone numbers)
     */
    public void addContact(String file, String name, String number) {

    }

    /**
     * Finds a contact's info when given their name.
     * @param name  contact's name
     * @return [number, fileName]  the contact's info
     */
    public ArrayList<String> getContact(String name) { // NOTE: NOT SURE IF ARRAYLIST IS CORRECT

    }

    /**
     * Sifts through every contact in the list and displays them all in the GUI.
     * However, since I am going for a non-scrollable approach, this means that
     * I will have to implement a hard limit on the amount of contacts someone
     * can add (Likely around a couple dozen)
     */
    public void displayAll() {

    }

    /**
     * Clears all information on the screen, except for any profile images.
     */
    public void hideInfo() {

    }

    // MAIN ROUTINE
    /**
     * Manages the contacts list, allowing for adding/retrieving of contacts.
     */
    public static void main(String[] args) {

    }

}