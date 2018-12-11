package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Object getSearchedObject(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertByIndex(Resume r, Object index) {
        storage[size] = r;
    }

    @Override
    protected void deleteByIndex(Object index) {
        storage[(int) index] = storage[size - 1];
    }
}
