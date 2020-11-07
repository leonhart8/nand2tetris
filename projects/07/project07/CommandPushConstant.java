import java.util.LinkedList;

/**
 * Class used to push a specific value into the stack
 */
public class CommandPushConstant extends CommandPush {

    /**
     * Constructor for the push constant class which pushes
     * a specific integer value supplied by the .vm file
     * to the top of the stack
     */
    public CommandPushConstant(String index){
        super("constant", index);
    }

    /**
     * In the case of pushing from constant we just store
     * the value to push directly in the D register
     */
    public LinkedList<String> getElementToPush(){
        LinkedList<String> assembly = new LinkedList<String>();
        assembly.add("@" + this.index);
        assembly.add("D=A");
        return assembly;
    }


}