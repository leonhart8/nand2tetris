import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Parser {

    private BufferedReader file;
    private String command;
    private String[] tokenized;

    /**
     * Constructor of the Parser class, takes the input file pathname
     * opens a file stream and gets ready to parse it
     * @param pathname a String that is the input file's pathname
     * @return nothing, constructor
     */
    public Parser(String pathname){

        FileReader f = null;

        try {
            f = new FileReader(pathname);
        } catch (IOException e) {
            System.out.println("IO exception while opening file " + pathname);
        }
        
        BufferedReader in = new BufferedReader(f);
        this.file = in;
        this.command = "";
        this.tokenized = null;
    }

    /**
     * Get the current tokenized command
     * @return String[], the current tokenized command
     */
    public String[] getTokenized(){
        return this.tokenized;
    }

    /**
     * Get the current command
     * @return String, the current command
     */
    public String getCommand(){
        return this.command;
    }
    
    /**
     * Checks if there are any more commands to parse
     * @return Boolean, True if there are still comands to parse
     *                  False otherwise
     */
    public boolean hasMoreCommands(){
        if (this.getCommand() == null){
            return false;
        }
        else
            return true;
    }

    /**
     * Closes this Parser's file stream
     */
    public void closeStream(){
        try {
            this.file.close();
        } catch (IOException e){
            System.out.println("IOException, bobo, aïe");
        }
    }

    /**
     * Advances to the next command, can be only done after a call to hasMoreCommands
     */
    public void advance(){
        try {
            this.command = this.file.readLine();
            if (this.command != null){
                this.tokenized = this.command.split("\\s+");
            }
        } catch (IOException e) {
            System.out.println("IOException while reading line");
        }
    }

    /**
     * Checks if the current line is actually a comment or an empty line
     * @return boolean, true if the current line is a comment or an empty line
     *                 false otherwise
     */
    public boolean isComment(){
        return this.getCommand().length() == 0 || this.getTokenized()[0].equals("//");
    }
}