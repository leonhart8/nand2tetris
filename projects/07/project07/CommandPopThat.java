/**
 * Class which defines a pop into a field of that
 */
public class CommandPopThat extends CommandPopIndirectRef {

    /**
     * Constructor of the command pop that class, writes
     * assembly code which pops into the this segment
     */
    public CommandPopThat(String index){
        super("that", index);
    }

    /**
     * Returns the local segment assembly reference
     */
    public String getRef(){
        return "THAT";
    }

}