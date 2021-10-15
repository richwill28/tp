package seedu.duke.logic.commands.lesson;

import seedu.duke.DukeException;
import seedu.duke.logic.commands.DeleteCommand;
import seedu.duke.model.lesson.Lesson;
import seedu.duke.model.lesson.LessonList;
import seedu.duke.storage.Storage;
import seedu.duke.model.task.TaskList;
import seedu.duke.ui.Ui;

import java.io.IOException;

public class DeleteLessonCommand extends DeleteCommand {
    private int lessonIndex;

    public DeleteLessonCommand() {
        this.isDeleteAll = true;
    }

    public DeleteLessonCommand(int lessonIndex) {
        this.isDeleteAll = false;
        this.lessonIndex = lessonIndex;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList taskList, LessonList lessonList)
            throws DukeException, IOException {
        if (isDeleteAll) {
            lessonList.deleteAllLessons();
            assert lessonList.isEmpty() : Ui.PADDING + "Lesson list should be empty";
            ui.printMessage("All your lessons have been successfully removed.");
        } else {
            Lesson deletedLesson = lessonList.getLesson(lessonIndex);
            lessonList.deleteLesson(lessonIndex);
            ui.printLessonDeleted(deletedLesson, lessonList.getSize());
        }
        storage.saveData(taskList, lessonList);
    }
}