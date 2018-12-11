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
        Object index = getSearchedObject(r.getUuid());
        if (!isContained(index)) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            replace(r, index);
        }
    }

    @Override
    public void save(Resume r) {
        Object index = getSearchedObject(r.getUuid());
        if (isContained(index)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            insertResume(r, index);
        }

    }

    @Override
    public Resume get(String uuid) {
        Object index = getSearchedObject(uuid);
        if (!isContained(index)) {
            throw new NotExistStorageException(uuid);
        }
        return retrieve(index);
    }

    @Override
    public void delete(String uuid) {
        Object index = getSearchedObject(uuid);
        if (!isContained(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            remove(index);
        }
    }

    public abstract int size();

    public abstract Resume[] getAll();

    protected abstract Object getSearchedObject(String uuid);

    protected abstract boolean isContained(Object index);

    protected abstract void insertResume(Resume r, Object index);

    protected abstract Resume retrieve(Object index);

    protected abstract void remove(Object index);

    protected abstract void replace(Resume r, Object index);

    protected abstract void clean();
}
