package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected static final Comparator<Resume> RESUME_COMPARATOR =
            Comparator.comparing(Resume::getFullName)
                    .thenComparing(Resume::getUuid);

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
    public List<Resume> getAllSorted() {
        List<Resume> storage = getStorage();
        storage.sort(RESUME_COMPARATOR);
        return storage;
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

    public abstract void clear();

    public abstract int size();

    protected abstract List<Resume> getStorage();

    protected abstract Object getSearchedObject(String uuid);

    protected abstract boolean isContained(Object index);

    protected abstract void insertResume(Resume r, Object index);

    protected abstract Resume retrieve(Object index);

    protected abstract void remove(Object index);

    protected abstract void replace(Resume r, Object index);
}
