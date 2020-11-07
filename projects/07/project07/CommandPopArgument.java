/**
 * Class which defines a pop argument command
 */
public class CommandPopArgument extends CommandPopIndirectRef {

    /**
     * Constructor of the command pop argument class, writes
     * assembly code which pops into the local segment
     */
    public CommandPopArgument(String index){
        super("argument", index);
    }

    /**
     * Returns the local segment assembly reference
     */
    public String getRef(){
        return "ARG";
    }

}