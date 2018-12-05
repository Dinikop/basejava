package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertByIndex(Resume r, int index) {
        storage[size] = r;
    }

    @Override
    protected void deleteByIndex(int index) {
        storage[index] = storage[size - 1];
    }
}
