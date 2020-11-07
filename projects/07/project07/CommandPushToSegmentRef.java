import java.util.LinkedList;

/**
 * Abstract class which defines a common interface for classes which
 * generates assembly in order to : retrieve a value from an index referenced
 * by a specific segment with a reference in assembly, and pushes it to the stack
 */
public abstract class CommandPushToSegmentRef extends CommandPush {

    /**
     * Constructor of the command push to segment ref, exact same
     * as in super class
     */
    public CommandPushToSegmentRef(String segment, String index){
        super(segment, index);
    }

    /**
     * Method used to generate assembly which gets the element to push
     * from the local segment to the stack
     */
    public LinkedList<String> getElementToPush(){
        LinkedList<String> assembly = new LinkedList<String>();
        assembly.add("@" + index);
        assembly.add("D=A");
        assembly.add("@" + this.getSegmentRef());
        assembly.add("A=M+D");
        assembly.add("D=M");
        return assembly;
    }

    /**
     * Method which returns the assembly reference to the memory segment 
     * from which we want to push
     */
    public abstract String getSegmentRef();

}