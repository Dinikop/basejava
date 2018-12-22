package storage;

import exception.StorageException;
import model.Resume;

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
    protected List<Resume> getStorage() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    protected boolean isContained(Integer searchedKey) {
        return searchedKey >= 0;
    }

    @Override
    protected void insertResume(Resume resume, Integer searchedKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        insertByIndex(resume, searchedKey);
        size++;
    }

    @Override
    protected Resume retrieve(Integer searchedKey) {
        return storage[searchedKey];
    }

    @Override
    protected void remove(Integer searchedKey) {
        deleteByIndex(searchedKey);
        size--;
    }

    @Override
    protected void replace(Resume resume, Integer searchedKey) {
        storage[searchedKey] = resume;
    }

    protected abstract Integer getSearchedObject(String uuid);

    protected abstract void insertByIndex(Resume resume, Integer index);

    protected abstract void deleteByIndex(Integer index);
}
