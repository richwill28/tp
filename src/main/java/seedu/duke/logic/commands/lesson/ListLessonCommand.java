package seedu.duke.logic.commands.lesson;

import seedu.duke.logic.commands.ListCommand;
import seedu.duke.model.lesson.LessonList;
import seedu.duke.storage.Storage;
import seedu.duke.model.task.TaskList;
import seedu.duke.ui.Ui;

public class ListLessonCommand extends ListCommand {
    public ListLessonCommand() {
        this.isListAll = true;
    }

    public ListLessonCommand(String period) {
        this.isListAll = false;
        this.period = period;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList taskList, LessonList lessonList) {
        if (isListAll) {
            ui.printLessonList(lessonList);
        } else {
            ui.printLessonsWithPeriod(lessonList, period);
        }
    }
}