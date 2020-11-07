import java.util.LinkedList;

/**
 * Abstract class which defines the behavior of both push and pop commands
 */
public abstract class CommandPushPop implements Command {

    // The name of the segment from which to push or into which to pop
    protected String segment;
    // The index from which to push or into which to pop
    protected String index;

    /**
     * Push and pop commands both take the same kind of arguments
     */
    public CommandPushPop(String segment, String index){
        this.segment = segment;
        this.index = index;
    }

    /**
     * The translation method will vary between push and pop
     * commands
     */
    public abstract LinkedList<String> translate();

}