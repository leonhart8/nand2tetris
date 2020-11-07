import java.util.LinkedList;

/**
 * A class which writes assembly code that pushes a value from a temp
 * register to the top of the stack
 */
public class CommandPushTemp extends CommandPush {

    // The starting adress of temporary registers
    private static final int tempRegistryLocation = 5;
    private String tempAddress;
    
    /**
     * Constructor of the CommandPushTemp class
     * requires no additional information as the temporary adress is computed
     * from the index
     */
    public CommandPushTemp(String index){
        super("temp", index);
        this.tempAddress = Integer.toString(Integer.parseInt(index) + tempRegistryLocation);
    }

    /**
     * To get an element from the temporary registry just get the
     * adress in the tempAddress attribute
     */
    public LinkedList<String> getElementToPush(){
        LinkedList<String> assembly = new LinkedList<String>();
        assembly.add("@" + this.tempAddress);
        assembly.add("D=M");
        return assembly;
    }


}