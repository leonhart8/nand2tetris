import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.Integer;
import java.util.LinkedList;

public class CodeWriter {

    private BufferedWriter out;
    private String currentFile;
    private String currentFilename;
    private int currentLine;

    /**
     * Constructor of the CodeWriter class, an object that handles the
     * creation
     * @param filename String, the filename of the output file
     */
    public CodeWriter(String filename){
        String[] splitted = filename.split("/");
        String outFilename = splitted[splitted.length - 1].split("\\.")[0] + ".asm";
        splitted[splitted.length - 1] = outFilename;
        filename = String.join("/", splitted);
        FileWriter f = null;
        try {
            f = new FileWriter(filename);
        }
        catch (IOException e) {
            System.out.println("IOException while opening output stream " + outFilename);
        }
        this.out = new BufferedWriter(f);
        this.currentFile = filename;
        this.currentFilename = outFilename;
        this.currentLine = 0;
    }

    /**
     * Get the name of the file being written into
     */
    public String getCurrentFilename(){
        return this.currentFilename;
    }

    /**
     * Get the current number of lines 
     */
    public int getCurrentLine(){
        return this.currentLine;
    }

    /**
     * Sets a new output stream into which to write code
     * @param filename String, the filename of the new output file
     */
    public void setFileName(String filename){
        String[] splitted = filename.split("/");
        String outFilename = splitted[splitted.length - 1].split("\\.")[0] + ".asm";
        splitted[splitted.length - 1] = outFilename;
        filename = String.join("/", splitted);
        FileWriter f = null;
        try {
            f = new FileWriter(filename);
        }
        catch (IOException e) {
            System.out.println("IOException while opening output stream " + outFilename);
        }
        System.out.println(filename);
        this.out = new BufferedWriter(f);
        this.currentFile = filename;
        this.currentFilename = outFilename;
        this.currentLine = 0;
    }

    /**
     * Writes a given serie of assembly lines in the outfile
     */
    public void writeCommand(LinkedList<String> assembly){
        for (String line : assembly){
            this.writeLine(line);
        }
    }

    /**
     * Closes this CodeWriter object's output stream
     */
    public void close(){
        try {
            this.out.close();
        } catch (IOException e){
            System.out.println("IO error while trying to close the output file stream of file " + this.currentFile);
        }
    }

    /**
     * Method which writes a given line given a string and ends with a newline
     * @param line, String, the line to write
     */
    private void writeLine(String line){
        try {
            this.out.write(line, 0, line.length());
        } catch (IOException e) {
            System.out.println("IO exception while trying to write line " + line);
        }
        try {
            this.out.newLine();
        } catch (IOException e) {
            System.out.println("IO exception while trying to add newline caracter to line " + line);
        }
        
        if (!line.substring(0,2).equals("//")){
            this.currentLine += 1;
        }
    }

}