import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.Integer;

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
     * Writes the assembly associated with the given arithmetic command
     * @param command, String the type of the given arithmetic command 
     */
    public void writeArithmetic(String command){
        switch (command) {
            case "add":
                this.writeComment("// add ");
                this.writeLine("@SP");
                this.writeLine("AM=M-1");
                this.writeLine("D=M");
                this.writeLine("A=A-1");
                this.writeLine("M=M+D");
                break;
            case "sub":
                this.writeComment("// sub ");
                this.writeLine("@SP");
                this.writeLine("AM=M-1");
                this.writeLine("D=M");
                this.writeLine("A=A-1");
                this.writeLine("M=M-D");
                break;
            case "neg":
                this.writeComment("// neg");
                this.writeLine("@SP");
                this.writeLine("A=M-1");
                this.writeLine("M=-M");
                break;
            case "eq":
                this.writeComment("// eq");
                this.writeLine("@SP");
                this.writeLine("AM=M-1");
                this.writeLine("D=M");
                this.writeLine("A=A-1");
                this.writeLine("D=M-D");
                this.writeLine("@" + Integer.toString(this.currentLine + 7));
                this.writeLine("D;JEQ");
                this.writeLine("@SP");
                this.writeLine("A=M-1");
                this.writeLine("M=0");
                this.writeLine("@" + Integer.toString(this.currentLine + 5));
                this.writeLine("0;JMP");
                this.writeLine("@SP");
                this.writeLine("A=M-1");
                this.writeLine("M=-1");
                break;
            case "gt":
                this.writeComment("// gt");
                this.writeLine("@SP");
                this.writeLine("AM=M-1");
                this.writeLine("D=M");
                this.writeLine("A=A-1");
                this.writeLine("D=M-D");
                this.writeLine("@" + Integer.toString(this.currentLine + 7));
                this.writeLine("D;JGT");
                this.writeLine("@SP");
                this.writeLine("A=M-1");
                this.writeLine("M=0");
                this.writeLine("@" + Integer.toString(this.currentLine + 5));
                this.writeLine("0;JMP");
                this.writeLine("@SP");
                this.writeLine("A=M-1");
                this.writeLine("M=-1");
                break;
            case "lt":
                this.writeComment("// lt");
                this.writeLine("@SP");
                this.writeLine("AM=M-1");
                this.writeLine("D=M");
                this.writeLine("A=A-1");
                this.writeLine("D=M-D");
                this.writeLine("@" + Integer.toString(this.currentLine + 7));
                this.writeLine("D;JLT");
                this.writeLine("@SP");
                this.writeLine("A=M-1");
                this.writeLine("M=0");
                this.writeLine("@" + Integer.toString(this.currentLine + 5));
                this.writeLine("0;JMP");
                this.writeLine("@SP");
                this.writeLine("A=M-1");
                this.writeLine("M=-1");
                break;
            case "and":
                this.writeComment("// and ");
                this.writeLine("@SP");
                this.writeLine("AM=M-1");
                this.writeLine("D=M");
                this.writeLine("A=A-1");
                this.writeLine("M=M&D");
                break;
            case "or":
                this.writeComment("// add ");
                this.writeLine("@SP");
                this.writeLine("AM=M-1");
                this.writeLine("D=M");
                this.writeLine("A=A-1");
                this.writeLine("M=M|D");
                break;
            default:
                this.writeComment("// not");
                this.writeLine("@SP");
                this.writeLine("A=M-1");
                this.writeLine("M=!M");
                break;
        }
    }

    /**
     * Writes the push or pop assembly code associated with the given command
     * @param command CommandTypes, the type of the given command
     * @param segment String, the segment from which to push or into which to pop
     * @param index int, the index into which to push or from which to pop
     */
    public void writePushPop(CommandTypes command, String segment, int index){
        String indexString = Integer.toString(index);
        if (command == CommandTypes.C_PUSH){
            switch (segment) {
                case "local":
                case "argument":
                case "this":
                case "that":
                    switch (segment) {
                        case "local":
                            this.writeComment("// push local " + indexString);
                            this.writeLine("@" + indexString);
                            this.writeLine("D=A");
                            this.writeLine("@LCL");
                            break;
                        case "argument":
                            this.writeComment("// push argument " + indexString);
                            this.writeLine("@" + indexString);
                            this.writeLine("D=A");
                            this.writeLine("@ARG");
                            break;
                        case "this":
                            this.writeComment("// push this " + indexString);
                            this.writeLine("@" + indexString);
                            this.writeLine("D=A");
                            this.writeLine("@THIS");
                            break;
                        default:
                            this.writeComment("// push that " + indexString);
                            this.writeLine("@" + indexString);
                            this.writeLine("D=A");
                            this.writeLine("@THAT");
                            break;
                    }
                    this.writeLine("A=M+D");
                    this.writeLine("D=M");
                    this.writeLine("@SP");
                    this.writeLine("A=M");
                    this.writeLine("M=D");
                    this.writeLine("@SP");
                    this.writeLine("M=M+1");
                    break;
                case "constant":
                    this.writeComment("// push constant " + indexString);
                    this.writeLine("@" + indexString);
                    this.writeLine("D=A");
                    this.writeLine("@SP");
                    this.writeLine("A=M");
                    this.writeLine("M=D");
                    this.writeLine("@SP");
                    this.writeLine("M=M+1");
                    break;
                case "static":
                    String fileWOextension = this.currentFilename.split("\\.")[0];
                    this.writeComment("// push static " + indexString);
                    this.writeLine("@" + fileWOextension + "." + indexString);
                    this.writeLine("D=M");
                    this.writeLine("@SP");
                    this.writeLine("A=M");
                    this.writeLine("M=D");
                    this.writeLine("@SP");
                    this.writeLine("M=M+1");
                    break;
                case "temp":
                    this.writeComment("// push temp " + indexString);
                    String tempIndexString = Integer.toString(index + 5);
                    this.writeLine("@" + tempIndexString);
                    this.writeLine("D=M");
                    this.writeLine("@SP");
                    this.writeLine("A=M");
                    this.writeLine("M=D");
                    this.writeLine("@SP");
                    this.writeLine("M=M+1");
                    break;
                default:
                    this.writeComment("// push pointer " + indexString);
                    if (index == 0) {
                        this.writeLine("@THIS");
                    }
                    else {
                        this.writeLine("@THAT");
                    }
                    this.writeLine("D=M");
                    this.writeLine("@SP");
                    this.writeLine("A=M");
                    this.writeLine("M=D");
                    this.writeLine("@SP");
                    this.writeLine("M=M+1");
                    break;
            }
        }
        else {
            switch (segment) {
                case "local":
                case "argument":
                case "this":
                case "that":
                    switch (segment) {
                        case "local":
                            this.writeComment("// pop local " + indexString);
                            break;
                        case "argument":
                            this.writeComment("// pop argument " + indexString);
                            break;
                        case "this":
                            this.writeComment("// pop this " + indexString);
                            break;
                        default:
                            this.writeComment("// pop that " + indexString);
                            break;
                    }
                    switch (segment) {
                        case "local":
                            this.writeLine("@LCL");
                            break;
                        case "argument":
                            this.writeLine("@ARG");
                            break;
                        case "this":
                            this.writeLine("@THIS");
                            break;
                        default:
                            this.writeLine("@THAT");
                            break;
                    }
                    this.writeLine("D=M");
                    this.writeLine("@" + indexString);
                    this.writeLine("D=D+A");
                    this.writeLine("@SP");
                    this.writeLine("AM=M-1");
                    this.writeLine("D=D+M");
                    this.writeLine("A=D-M");
                    this.writeLine("M=D-A");
                    break;
                case "static":
                    String fileWOextension = this.currentFilename.split("\\.")[0];
                    this.writeComment("// pop static " + indexString);
                    this.writeLine("@SP");
                    this.writeLine("AM=M-1");
                    this.writeLine("D=M");
                    this.writeLine("@" + fileWOextension + "." + indexString);
                    this.writeLine("M=D");
                    break;
                case "temp":
                    this.writeComment("// pop temp " + indexString);
                    this.writeLine("@SP");
                    this.writeLine("AM=M-1");
                    this.writeLine("D=M");
                    String tempIndexString = Integer.toString(index + 5);
                    this.writeLine("@" + tempIndexString);
                    this.writeLine("M=D");
                    break;
                default:
                    this.writeComment("// pop pointer " + indexString);
                    this.writeLine("@SP");
                    this.writeLine("AM=M-1");
                    this.writeLine("D=M");
                    if (index == 0) {
                        this.writeLine("@THIS");
                    }
                    else {
                        this.writeLine("@THAT");
                    }
                    this.writeLine("M=D");
                    break;
            }
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
        this.currentLine += 1;
    }

    private void writeComment(String line){
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
    }

}