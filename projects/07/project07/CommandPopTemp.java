/**
 * Class which gives the assembly code in order to pop into
 * the temp memory segment
 */
public class CommandPopTemp extends CommandPopDirectRef {

    private static final int tempRegistryAddress = 5;

    /**
     * Constructor of this pop static command
     */
    public CommandPopTemp(String index){
        super("temp", index);
    }

    /**
     * Defines the reference to the static segment
     */
    public String getRef(){
        return Integer.toString(Integer.parseInt(index) + tempRegistryAddress);
    }

}