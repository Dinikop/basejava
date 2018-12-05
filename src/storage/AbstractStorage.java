package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10_000;

    protected int size = 0;

    @Override
    public void clear() {
        clean();
        updateSize();
    }

    @Override
    public void update(Resume r) {
        if (!isContained(r.getUuid())) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            replace(r);
        }
    }

    @Override
    public void save(Resume r) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            if (isContained(r.getUuid())) {
                throw new ExistStorageException(r.getUuid());
            } else {
                insertResume(r);
                updateSize();
            }
        }
    }

    @Override
    public Resume get(String uuid) {
        if (!isContained(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        return retrieve(uuid);
    }

    @Override
    public void delete(String uuid) {
        if (!isContained(uuid)) {
            throw new NotExistStorageException(uuid);
        } else {
            remove(uuid);
            updateSize();
        }
    }

    @Override
    public int size() {
        return size;
    }

    public abstract Resume[] getAll();

    protected abstract void updateSize();

    protected abstract boolean isContained(String uuid);

    protected abstract void insertResume(Resume r);

    protected abstract Resume retrieve(String uuid);

    protected abstract void remove(String uuid);

    protected abstract void replace(Resume r);

    protected abstract void clean();
}
