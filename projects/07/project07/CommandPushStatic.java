import java.util.LinkedList;

/**
 * Class which specifies a command in assembly that pushes en element
 * to the static segment
 */
public class CommandPushStatic extends CommandPush {
    
    private String filenameWithoutExtension;

    /**
     * Constructor of the static command, this command
     * requires the vm filename from which to determine
     * the static adress
     */
    public CommandPushStatic(String index, String filenameWithoutExtension){
        super("static", index);
        this.filenameWithoutExtension = filenameWithoutExtension;
    }

    /**
     * The adress of the segment to access is determined by both the index and the
     * filename
     */
    public LinkedList<String> getElementToPush(){
        LinkedList<String> assembly = new LinkedList<String>();
        assembly.add("@" + this.filenameWithoutExtension + "." + this.index);
        assembly.add("D=M");
        return assembly;
    }

}