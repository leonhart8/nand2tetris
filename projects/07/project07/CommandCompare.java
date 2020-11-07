import java.util.LinkedList;

/**
 * An abstract class which defines a common interface for comparison
 * commands
 */
public abstract class CommandCompare extends CommandArithmetic {

    // Attributes 
    protected int jumpIfCompareSucceeds;
    protected int jumpIfCompareNotSucceed; 

    /**
     * Constructor for this comparison command
     */
    public CommandCompare(String name, int jumpIfCompareSucceeds, int jumpIfCompareNotSucceed){
        super(name);
        this.jumpIfCompareNotSucceed = jumpIfCompareNotSucceed;
        this.jumpIfCompareSucceeds = jumpIfCompareSucceeds;
    }

    /**
     * Translates this comparison command in assembly
     */
    public LinkedList<String> translate(){
        LinkedList<String> assembly = super.translate();
        assembly.add("@SP");
        assembly.add("AM=M-A");
        assembly.add("D=M");
        assembly.add("A=A-1");
        assembly.add("D=M-D");
        assembly.add("@" + this.jumpIfCompareSucceeds);
        assembly.add("D;" + this.getOp());
        assembly.add("@SP");
        assembly.add("A=M-1");
        assembly.add("M=0");
        assembly.add("@" + this.jumpIfCompareNotSucceed);
        assembly.add("0;JMP");
        assembly.add("@SP");
        assembly.add("A=M-1");
        assembly.add("M=-1");
        return assembly;
    }

}