import java.util.LinkedList;

/**
 * Class used to define the interface of push commands
 */
public abstract class CommandPush extends CommandPushPop {

    /**
     * All push commands will have at some point or another define
     * a segment and an index
     */
    public CommandPush(String segment, String index){
        super(segment, index);
    }

    /**
     * Translates a push command into assembly code
     * @return LinkedList<String> a list of assembly commands to write
     */
    public LinkedList<String> translate(){
        LinkedList<String> assembly = new LinkedList<String>();

        // Build the commands that make up the entire push
        String comment = buildComment();
        LinkedList<String> getElementToPush = this.getElementToPush();
        LinkedList<String> pushElement = this.pushElement();

        // Link these commands together
        assembly.add(comment);
        for (String line : getElementToPush){
            assembly.add(line);
        }
        for (String line : pushElement){
            assembly.add(line);
        }

        return assembly;
    } 

    /**
     * Writes the comment associated with the command
     * @return String, the comment associated with the command
     */
    public String buildComment(){
        return "// push " + this.segment + " " + this.index;
    }

    /**
     * Writes the assembly code of a push where an element is taken from a specific
     * adress to add to the stack
     * @return LinkedList<String> the sequence of commands generated
     */
    public abstract LinkedList<String> getElementToPush();

    /**
     * Writes the assembly code necessary to add an element stored in the D
     * register to the top of the stack and increments it
     */
    public LinkedList<String> pushElement(){
        LinkedList<String> assembly = new LinkedList<String>();
        assembly.add("@SP");
        assembly.add("A=M");
        assembly.add("M=D");
        assembly.add("@SP");
        assembly.add("M=M+1");
        return assembly;
    }

}