package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchedObject(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertByIndex(Resume resume, Integer index) {
        storage[size] = resume;
    }

    @Override
    protected void deleteByIndex(Integer index) {
        storage[index] = storage[size - 1];
    }
}
