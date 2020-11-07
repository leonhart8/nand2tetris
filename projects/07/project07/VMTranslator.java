import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.lang.Integer;
import java.util.LinkedList;

public class VMTranslator {

    private static final int succeedSkips = 14;
    private static final int notSucceedSkips = 17;

    /**
     * Method which returns a filename without its extension
     */
    private static String filenameWithoutExtension(String outFilename){
        return outFilename.split("\\.")[0];
    }

    /**
     * Method which translates a single vm file into asm
     * @param pathname String pathname of the file to assemble
     * @param writer, CodeWriter used to write in files
     */
    private static void translate(String pathname){
        Parser parser = new Parser(pathname);
        CodeWriter writer = new CodeWriter(pathname);
        String filenameWithoutExtension = VMTranslator.filenameWithoutExtension(writer.getCurrentFilename());
        int jumpIfSucceeds = writer.getCurrentLine() + succeedSkips;
        int jumpIfNotSucceed = writer.getCurrentLine() + notSucceedSkips;
        while (parser.hasMoreCommands()){
            if (!parser.isComment()){
                Command command = CommandFactory.buildCommand(parser.getTokenized(), filenameWithoutExtension, jumpIfSucceeds, jumpIfNotSucceed);
                LinkedList<String> assembly = command.translate();
                writer.writeCommand(assembly);
            }
            parser.advance();
        }
        parser.closeStream();
        writer.close();
    }

    /**
     * Method which translates all vm files in a given directory into asm
     * @param pathnames String[] pathnames of all files in a given directory
     * @param writer CodeWriter used to write in asm files
     */
    private static void translateDirectory(String[] pathnames){
        for (int i = 0; i < pathnames.length; i++){
            if (VMTranslator.checkIfVm(pathnames[i])){
                VMTranslator.translate(pathnames[i]);
            }
        }
    }

    /**
     * Method which checks if a given file is indeed a .vm file
     * @param pathname String pathname of a file
     * @return boolean, True if the file is a .vm file
     *                  False otherwise
     */
    private static boolean checkIfVm(String pathname){
        String[] splitted = pathname.split("/");
        splitted = splitted[splitted.length - 1].split("\\.");
        return splitted[splitted.length - 1].equals("vm");
    }
    
    public static void main(String[] args){

        File f = new File(args[0]);

        if (f.isDirectory()){
            VMTranslator.translateDirectory(f.list());
        }
        else if (VMTranslator.checkIfVm(args[0])){
            VMTranslator.translate(args[0]);
        }
        
    }
}