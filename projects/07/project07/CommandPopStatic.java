/**
 * Class which gives the assembly code in order to pop into
 * a static field
 */
public class CommandPopStatic extends CommandPopDirectRef {

    private String filenameWithoutExtension;

    /**
     * Constructor of this pop static command
     */
    public CommandPopStatic(String index, String filenameWithoutExtension){
        super("static", index);
        this.filenameWithoutExtension = filenameWithoutExtension;
    }

    /**
     * Defines the reference to the static segment
     */
    public String getRef(){
        return this.filenameWithoutExtension + "." + this.index;
    }

}