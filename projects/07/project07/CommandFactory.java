/**
 * Class CommandFactory, used to create instances of commands dynamically
 * through file data
 */
public class CommandFactory {

    /**
     * Builds the appropriate command instance given a line in the .vm file
     * @param command String[], the tokenized vm command
     * @param filenameWithoutExtension the name of the file being written into without its extension
     * @return Command, the command associated to the input
     */
    public Command buildCommand(String[] tokens, String filenameWithoutExtension, int jumpIfSucceeds, int jumpIfNotSucceed) throws IllegalArgumentException {
        if (tokens.length == 3){
            switch (tokens[0]) {
                case "push":
                    switch (tokens[1]) {
                        case "local":
                            return new CommandPushLocal(tokens[2]);
                        case "argument":
                            return new CommandPushArgument(tokens[2]);
                        case "this":
                            return new CommandPushThis(tokens[2]);
                        case "that":
                            return new CommandPushThat(tokens[2]);
                        case "constant":
                            return new CommandPushConstant(tokens[2]);
                        case "static":
                            return new CommandPushStatic(tokens[2], filenameWithoutExtension);
                        case "temp":
                            return new CommandPushTemp(tokens[2]);
                        default:
                            throw new IllegalArgumentException("Memory segment " + tokens[1] + "not handled");
                    }
                case "pop":
                    switch (tokens[1]) {
                        case "local":
                            return new CommandPopLocal(tokens[2]);
                        case "argument":
                            return new CommandPopArgument(tokens[2]);
                        case "this":
                            return new CommandPopThis(tokens[2]);
                        case "that":
                            return new CommandPopThat(tokens[2]);
                        case "static":
                            return new CommandPopStatic(tokens[2], filenameWithoutExtension);
                        case "temp":
                            return new CommandPopTemp(tokens[2]);
                        default:
                            throw new IllegalArgumentException("Memory segment " + tokens[1] + "not handled");
                    }
                default:
                    throw new IllegalArgumentException("Command type " + tokens[0] + " not handled by translator");
            }
        }
        else if (tokens.length == 1){
            switch (tokens[0]) {
                case "add":
                    return new CommandAdd();
                case "sub":
                    return new CommandSub();
                case "neg":
                    return new CommandNeg();
                case "eq":
                    return new CommandEq(jumpIfSucceeds, jumpIfNotSucceed);
                case "gt":
                    return new CommandGt(jumpIfSucceeds, jumpIfNotSucceed);
                case "lt":
                    return new CommandLt(jumpIfSucceeds, jumpIfNotSucceed);
                case "and":
                    return new CommandAnd();
                case "or":
                    return new CommandOr();
                default:
                    throw new IllegalArgumentException("Command type " + tokens[0] + " not handled");
            }
        }
        else {
            throw new IllegalArgumentException("VM command length does not correspond to any known command");
        }
    } 

}