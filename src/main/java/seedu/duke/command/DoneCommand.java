package seedu.duke.command;

import seedu.duke.exception.DukeException;
import seedu.duke.lesson.LessonList;
import seedu.duke.storage.Storage;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Message;
import seedu.duke.ui.Ui;

import java.io.IOException;

public class DoneCommand extends Command {
    private int taskIndex;

    public DoneCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList taskList, LessonList lessonList)
            throws DukeException, IOException {
        Task task = taskList.getTask(taskIndex);
        if (task.isDone()) {
            throw new DukeException(Message.INFO_TASK_COMPLETED);
        }
        taskList.markTaskAsDone(taskIndex);
        ui.printTaskMarkedAsDone(taskList, task);
        storage.saveData(taskList, lessonList);
    }
}
