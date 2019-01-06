package org.dnk.storage;

import org.dnk.exception.StorageException;
import org.dnk.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

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
    protected List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    protected boolean isExist(Integer searchedKey) {
        return searchedKey >= 0;
    }

    @Override
    protected void doSave(Resume resume, Integer searchedKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        insertByIndex(resume, searchedKey);
        size++;
    }

    @Override
    protected Resume doGet(Integer searchedKey) {
        return storage[searchedKey];
    }

    @Override
    protected void doDelete(Integer searchedKey) {
        deleteByIndex(searchedKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void doUpdate(Resume resume, Integer searchedKey) {
        storage[searchedKey] = resume;
    }

    protected abstract Integer getSearchedKey(String uuid);

    protected abstract void insertByIndex(Resume resume, Integer index);

    protected abstract void deleteByIndex(Integer index);
}
