package storage;

import model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_UUID_COMPARATOR =
            Comparator.comparing(Resume::getUuid);

    @Override
    protected Object getSearchedObject(String uuid) {
        Resume searchKey = new Resume(uuid, "fullName");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_UUID_COMPARATOR);
    }

    @Override
    protected void insertByIndex(Resume resume, Object index) {
        int insertionIndex = -(int) index - 1;
        System.arraycopy(storage, insertionIndex, storage, insertionIndex + 1, size - insertionIndex);
        storage[insertionIndex] = resume;
    }

    @Override
    protected void deleteByIndex(Object index) {
        System.arraycopy(storage, (int) index + 1, storage, (int) index, (size - 1) - (int) index);
    }

}
