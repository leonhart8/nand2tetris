/**
 * Class which defines a pop into a field of this
 */
public class CommandPopThis extends CommandPopIndirectRef {

    /**
     * Constructor of the command pop this class, writes
     * assembly code which pops into the this segment
     */
    public CommandPopThis(String index){
        super("this", index);
    }

    /**
     * Returns the local segment assembly reference
     */
    public String getRef(){
        return "THIS";
    }

}