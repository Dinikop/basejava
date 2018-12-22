package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Comparator<Resume> RESUME_COMPARATOR =
            Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    protected abstract List<Resume> getStorage();

    protected abstract SK getSearchedObject(String uuid);

    protected abstract boolean isContained(SK searchedKey);

    protected abstract void insertResume(Resume resume, SK searchedKey);

    protected abstract Resume retrieve(SK searchedKey);

    protected abstract void remove(SK searchedKey);

    protected abstract void replace(Resume resume, SK searchedKey);

    @Override
    public void update(Resume resume) {
        SK searchedKey = getExistedSearchKey(resume.getUuid());
        replace(resume, searchedKey);
    }

    @Override
    public void save(Resume resume) {
        SK searchedKey = getNotExistedSearchKey(resume.getUuid());
        insertResume(resume, searchedKey);
    }

    @Override
    public Resume get(String uuid) {
        SK searchedKey = getExistedSearchKey(uuid);
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
        SK searchedKey = getExistedSearchKey(uuid);
        remove(searchedKey);
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchedObject = getSearchedObject(uuid);
        if (!isContained(searchedObject)) {
            throw new NotExistStorageException(uuid);
        }
        return searchedObject;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchedObject = getSearchedObject(uuid);
        if (isContained(searchedObject)) {
            throw new ExistStorageException(uuid);
        }
        return searchedObject;
    }
}
