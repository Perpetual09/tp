package tp.acecs2103.storage;

import tp.acecs2103.commons.exceptions.DataConversionException;
import tp.acecs2103.model.ReadOnlyAddressBook;
import tp.acecs2103.model.TaskList;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public interface TaskListStorage {
    /**
     * Returns the file path of the data file.
     */
    Path getTaskListFilePath();

    /**
     * Returns TaskList data as a {@link tp.acecs2103.model.TaskList}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<TaskList> readTaskList() throws DataConversionException, IOException;

    /**
     * @see #getTaskListFilePath()
     */
    Optional<TaskList> readTaskList(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link TaskList} to the storage.
     * @param taskList cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveTaskList(TaskList taskList) throws IOException;

    /**
     * @see #saveTaskList(TaskList)
     */
    void saveTaskList(TaskList taskList, Path filePath) throws IOException;
}
