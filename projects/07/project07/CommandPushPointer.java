import java.util.LinkedList;

/**
 * Class which defines pushing elements to the pointer segment,
 * the pointer segment contains references to this or that
 */
public class CommandPushPointer extends CommandPush {
    
    /**
     * Constructor of the command push pointer class, nothing
     * else is required
     */
    public CommandPushPointer(String index){
        super("pointer", index);
    }

    /**
     * Here the reference from which to push is determined
     * by the index supplied by the VM code
     */
    public LinkedList<String> getElementToPush(){
        LinkedList<String> assembly = new LinkedList<String>();
        if (this.index.equals("0")) {
            assembly.add("@THIS");
        }
        else {
            assembly.add("@THAT");
        }
        assembly.add("D=M");
        return assembly;
    }

}