import java.util.LinkedList;

/**
 * Interface of pop commands with a direct reference to an adress
 */
public abstract class CommandPopDirectRef extends CommandPop {

    /**
     * Constructor of a pop command with a direct reference
     * nothing changes from the super class
     */
    public CommandPopDirectRef(String segment, String index){
        super(segment, index);
    }

    /**
     * Translates this direct ref pop command
     */
    public LinkedList<String> translate(){
        LinkedList<String> assembly = new LinkedList<String>();
        assembly.add("@SP");
        assembly.add("AM=M-1");
        assembly.add("D=M");
        assembly.add("@" + this.getRef());
        assembly.add("M=D");
        return assembly;
    }

}