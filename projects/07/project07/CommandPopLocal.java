/**
 * Class which defines a pop local command
 */
public class CommandPopLocal extends CommandPopIndirectRef{

    /**
     * Constructor of the command pop local class, writes
     * assembly code which pops into the local segment
     */
    public CommandPopLocal(String index){
        super("local", index);
    }

    /**
     * Returns the local segment assembly reference
     */
    public String getRef(){
        return "LCL";
    }

}