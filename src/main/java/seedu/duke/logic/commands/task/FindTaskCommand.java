package seedu.duke.logic.commands.task;

import seedu.duke.logic.commands.FindCommand;
import seedu.duke.model.lesson.LessonList;
import seedu.duke.storage.Storage;
import seedu.duke.model.task.TaskList;
import seedu.duke.ui.Ui;

public class FindTaskCommand extends FindCommand {
    public FindTaskCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList taskList, LessonList lessonList) {
        ui.printTasksWithKeyword(taskList, keyword);
    }
}