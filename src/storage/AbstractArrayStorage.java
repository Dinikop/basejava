package storage;

import exception.StorageException;
import model.Resume;

import java.util.Arrays;
import java.util.List;

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
    public int size() {
        return size;
    }

    @Override
    protected List<Resume> getStorage() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    protected boolean isContained(Object key) {
        return (int) key >= 0;
    }

    @Override
    protected void insertResume(Resume resume, Object key) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        insertByIndex(resume, key);
        size++;
    }

    @Override
    protected Resume retrieve(Object key) {
        return storage[(int) key];
    }

    @Override
    protected void remove(Object key) {
        deleteByIndex(key);
        size--;
    }

    @Override
    protected void replace(Resume resume, Object key) {
        storage[(int) key] = resume;
    }

    protected abstract Object getSearchedObject(String uuid);

    protected abstract void insertByIndex(Resume resume, Object index);

    protected abstract void deleteByIndex(Object index);
}
