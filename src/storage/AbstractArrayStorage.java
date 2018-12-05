package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected boolean isContained(String uuid) {
        return getIndex(uuid) >= 0;
    }

    @Override
    protected void insertResume(Resume r) {
        insertByIndex(r, getIndex(r.getUuid()));
    }

    @Override
    protected Resume retrieve(String uuid) {
        return storage[getIndex(uuid)];
    }

    @Override
    protected void remove(String uuid) {
        deleteByIndex(getIndex(uuid));
    }

    @Override
    protected void replace(Resume r) {
        storage[getIndex(r.getUuid())] = r;
    }

    @Override
    protected void clean() {
        Arrays.fill(storage, 0, size, null);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertByIndex(Resume r, int index);

    protected abstract void deleteByIndex(int index);
}
