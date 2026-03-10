package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Adds a note to a person in PowerRoster.
 */
public class NoteCommand extends Command {

    public static final String COMMAND_WORD = "note";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a note to the specified person by index number used in the last person listing.\n"
            + "Existing notes will be overwritten.\n"
            + "Parameters: INDEX (must be a positive integer) " + PREFIX_NOTE + "NOTE_CONTENT\n"
            + "Example: " + COMMAND_WORD + " 1 Focuses on strength more.";

    public static final String MESSAGE_SUCCESS = "Note added to person: %1$s";
    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Remark: %2$s";

    private final Index index;
    private final String noteContent;

    /**
     * Creates an NoteCommand to add the specified {@code noteContent} to the person at the
     * specified {@code index}.
     *
     * @param index of the person in the last person list to edit the note
     * @param noteContent of the person to be updated to
     */
    public NoteCommand(Index index, String noteContent) {
        requireNonNull(index, noteContent);

        this.index = index;
        this.noteContent = noteContent;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        // Implementation for executing the command goes here
        throw new CommandException(
                String.format(MESSAGE_ARGUMENTS, this.index.getOneBased(), this.noteContent));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof NoteCommand)) {
            return false;
        }

        NoteCommand otherNoteCommand = (NoteCommand) other;
        return index.equals(otherNoteCommand.index)
                && noteContent.equals(otherNoteCommand.noteContent);
    }

}
