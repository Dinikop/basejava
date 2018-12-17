package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    private static final Comparator<Resume> RESUME_COMPARATOR =
            Comparator.comparing(Resume::getUuid).thenComparing(Resume::getFullName);

    protected abstract List<Resume> getStorage();

    protected abstract Object getSearchedObject(String uuid);

    protected abstract boolean isContained(Object searchedKey);

    protected abstract void insertResume(Resume resume, Object searchedKey);

    protected abstract Resume retrieve(Object searchedKey);

    protected abstract void remove(Object searchedKey);

    protected abstract void replace(Resume resume, Object searchedKey);

    @Override
    public void update(Resume resume) {
        Object searchedKey = getExistedSearchKey(resume.getUuid());
        replace(resume, searchedKey);
    }

    @Override
    public void save(Resume resume) {
        Object searchedKey = getNotExistedSearchKey(resume.getUuid());
        insertResume(resume, searchedKey);
    }

    @Override
    public Resume get(String uuid) {
        Object searchedKey = getExistedSearchKey(uuid);
        return retrieve(searchedKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> storage = getStorage();
        storage.sort(RESUME_COMPARATOR);
        return storage;
    }

    @Override
    public void delete(String uuid) {
        Object searchedKey = getExistedSearchKey(uuid);
        remove(searchedKey);
    }

    private Object getExistedSearchKey(String uuid) {
        Object index = getSearchedObject(uuid);
        if (!isContained(index)) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object index = getSearchedObject(uuid);
        if (isContained(index)) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }
}
