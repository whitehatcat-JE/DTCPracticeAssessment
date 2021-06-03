/**
 * The child Profile class. This will manage displaying a given contacts
 * information.
 * 
 * @author Jayden
 * @version 3/06/2021
 */

public class Profile {
    // CONSTANTS
    // Positon of profile
    private final int XPOSITION = 0;
    private final int YPOSITION = 0;
    // Sizing of the image
    private final int IMGWIDTH = 100;
    private final int IMGHEIGHT = 100;
    // Position of the text
    private final int FONTSIZE = 12;
    private final int FONTX = 100;
    private final int FONTY = 100;
    private final int FONTSPACING = 10; // Distance between new lines

    // VARIABLES
    // Contact info
    private String file;
    private String name;
    private String number;

    // METHODS
    /**
     * Constructor for assigning profile information to the class.
     * @param profileFile  file location of the profile image.
     * @param profileName  name of the profile.
     * @param profileNumber  profile's phone number.
     */
    public Profile(String profileFile, String profileName, String profileNumber) {
        file = profileFile;
        name = profileName;
        number = profileNumber;
    }

    /**
     * Displays the entire profile's information onto the screen.
     */
    public void displayProfile() {

    }

    /**
     * Displays only the profile's image onto the screen.
     */
    public void displayImg() {
        
    } 
}