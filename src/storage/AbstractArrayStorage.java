package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10_000;

    protected int size = 0;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected boolean isContained(int index) {
        return index >= 0;
    }

    @Override
    protected void insertResume(Resume r, int index) {
        insertByIndex(r, index);
    }

    @Override
    protected Resume retrieve(int index) {
        return storage[index];
    }

    @Override
    protected void remove(int index) {
        deleteByIndex(index);
    }

    @Override
    protected void replace(Resume r, int index) {
        storage[index] = r;
    }

    @Override
    protected void clean() {
        Arrays.fill(storage, 0, size, null);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertByIndex(Resume r, int index);

    protected abstract void deleteByIndex(int index);
}
