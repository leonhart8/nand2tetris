import java.util.LinkedList;

/**
 * Abstract interface which defines behavior for pop commands which must
 * be done in indirect references to addresses requiring a "memorization"
 * of an address
 */
public abstract class CommandPopIndirectRef extends CommandPop {

    /**
     * Constructor of a pop command with an indirect reference
     * nothing changes from the super class
     */
    public CommandPopIndirectRef(String segment, String index){
        super(segment, index);
    }

    /**
     * Translates this indirect ref pop command
     */
    public LinkedList<String> translate(){
        LinkedList<String> assembly = new LinkedList<String>();
        assembly.add(this.writeComment());
        assembly.add("@" + this.getRef());
        assembly.add("D=M");
        assembly.add("@" + this.index);
        assembly.add("D=D+A");
        assembly.add("@SP");
        assembly.add("AM=M-1");
        assembly.add("D=D+M");
        assembly.add("A=D-M");
        assembly.add("M=D-A");
        return assembly;
    }

}