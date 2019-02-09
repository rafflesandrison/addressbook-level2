package seedu.addressbook.commands;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_SORT = "List sorted by name!";

    @Override
    public CommandResult execute() {
        addressBook.sortList();
        return new CommandResult(MESSAGE_SORT);
    }

}
