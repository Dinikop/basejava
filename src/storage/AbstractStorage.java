package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected static final Comparator<Resume> RESUME_COMPARATOR =
            Comparator.comparing(Resume::getUuid);

    @Override
    public void update(Resume resume) {
        Object key = getSearchedObject(resume.getUuid());
        if (!isContained(key)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            replace(resume, key);
        }
    }

    @Override
    public void save(Resume resume) {
        Object index = getSearchedObject(resume.getUuid());
        if (isContained(index)) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            insertResume(resume, index);
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

    protected abstract boolean isContained(Object key);

    protected abstract void insertResume(Resume resume, Object key);

    protected abstract Resume retrieve(Object key);

    protected abstract void remove(Object key);

    protected abstract void replace(Resume resume, Object key);
}
