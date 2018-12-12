package storage;

import exception.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10_000;

    protected int size = 0;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected boolean isContained(Object index) {
        return (int) index >= 0;
    }

    @Override
    protected void insertResume(Resume r, Object index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        }
        insertByIndex(r, index);
        size++;
    }

    @Override
    protected Resume retrieve(Object index) {
        return storage[(int) index];
    }

    @Override
    protected void remove(Object index) {
        deleteByIndex(index);
        size--;
    }

    @Override
    protected void replace(Resume r, Object index) {
        storage[(int) index] = r;
    }

    protected abstract Object getSearchedObject(String uuid);

    protected abstract void insertByIndex(Resume r, Object index);

    protected abstract void deleteByIndex(Object index);
}
