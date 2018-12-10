package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {


    @Override
    public void clear() {
        clean();
    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (!isContained(index)) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            replace(r, index);
        }
    }

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (isContained(index)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            insertResume(r, index);
        }

    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (!isContained(index)) {
            throw new NotExistStorageException(uuid);
        }
        return retrieve(index);
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (!isContained(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            remove(index);
        }
    }

    public abstract int size();

    public abstract Resume[] getAll();

    protected abstract int getIndex(String uuid);

    protected abstract boolean isContained(int index);

    protected abstract void insertResume(Resume r, int index);

    protected abstract Resume retrieve(int index);

    protected abstract void remove(int index);

    protected abstract void replace(Resume r, int index);

    protected abstract void clean();
}
