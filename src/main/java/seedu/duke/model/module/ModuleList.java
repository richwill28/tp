package seedu.duke.model.module;

import seedu.duke.DukeException;
import seedu.duke.commons.core.Messages;
import seedu.duke.model.module.exceptions.ModuleIndexException;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store and manipulate the user's list of modules that they can modify using command line
 * commands.
 */
public class ModuleList {
    private List<Module> userModuleList;

    public ModuleList() {
        userModuleList = new ArrayList<>();
    }

    public int getSize() {
        return userModuleList.size();
    }

    public Module getModule(int moduleIndex) throws DukeException {
        try {
            return userModuleList.get(moduleIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.ERROR_INVALID_INDEX);
        } catch (NumberFormatException e) {
            throw new DukeException(Messages.ERROR_INVALID_NUMBER);
        }
    }

    public boolean isEmpty() {
        return userModuleList.isEmpty();
    }

    public void addModule(Module newModule) {
        userModuleList.add(newModule);
    }

    public void deleteModule(int moduleIndex) throws ModuleIndexException {
        try {
            userModuleList.remove(moduleIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new ModuleIndexException(Messages.ERROR_INVALID_INDEX);
        } catch (NumberFormatException e) {
            throw new ModuleIndexException(Messages.ERROR_INVALID_NUMBER);
        }
    }

    public void deleteAllModules() {
        userModuleList.clear();
    }
}