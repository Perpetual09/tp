package tp.acecs2103.logic.commands;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import tp.acecs2103.model.Model;
import tp.acecs2103.model.task.Index;

public class DeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";

    public static final String MESSAGE_SUCCESS = "Modified deadline for the required task";

    private final Index targetIndex;
    private final LocalDate newDeadline;

    /**
     * Creates a {@code DeadlineCommand} with given index and newDeadline
     */
    public DeadlineCommand(Index targetIndex, LocalDate newDeadline) {
        requireNonNull(targetIndex);
        requireNonNull(newDeadline);
        this.targetIndex = targetIndex;
        this.newDeadline = newDeadline;
    }

    public Index getTargetIndex() {
        return targetIndex;
    }

    public LocalDate getNewDeadline() {
        return newDeadline;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.deadlineTask(targetIndex.toString(), newDeadline);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
