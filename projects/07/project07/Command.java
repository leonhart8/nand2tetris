import java.util.LinkedList;

/**
 * Interface of the commands type. Commands are lines of a VM file which contains instructions
 * that can be translated into assembly
 */
public interface Command {

  /**
   * Method which translates a command into assembly 
   * @return String[] an array of fun
   */
  public LinkedList<String> translate();

}