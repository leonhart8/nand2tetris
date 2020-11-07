import java.util.LinkedList;

/**
 * Abstract class which defines behavior for pop commands
 */
public abstract class CommandPop extends CommandPushPop {

    /**
     * Constructor of a pop command, doesn't change from
     * the commandPushPop interface
     */
    public CommandPop(String segment, String index){
        super(segment, index);
    }

    /**
     * Gets the adress into which to pop
     */
    public abstract String getRef();

    /**
     * Writes the comment associated with the pop command
     */
    public String writeComment(){
        return "// pop " + this.segment + " " + this.index;
    }

}