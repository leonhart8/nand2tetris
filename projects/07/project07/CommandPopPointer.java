/**
 * Class which gives the assembly code in order to pop into
 * the pointer memory registries
 */
public class CommandPopPointer extends CommandPopDirectRef {

    /**
     * Constructor of this pop pointer command
     */
    public CommandPopPointer(String index){
        super("pointer", index);
    }

    /**
     * Defines the reference to the pointer segment
     */
    public String getRef(){
        if (this.index.equals("0")){
            return "THIS";
        }
        else {
            return "THAT";
        }
    }

}