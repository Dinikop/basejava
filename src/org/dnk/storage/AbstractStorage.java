package org.dnk.storage;

import org.dnk.exception.ExistStorageException;
import org.dnk.exception.NotExistStorageException;
import org.dnk.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Comparator<Resume> RESUME_COMPARATOR =
            Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    protected abstract List<Resume> doCopyAll();

    protected abstract SK getSearchedObject(String uuid);

    protected abstract boolean isExist(SK searchedKey);

    protected abstract void doSave(Resume resume, SK searchedKey);

    protected abstract Resume doGet(SK searchedKey);

    protected abstract void doDelete(SK searchedKey);

    protected abstract void doUpdate(Resume resume, SK searchedKey);

    @Override
    public void update(Resume resume) {
        SK searchedKey = getExistedSearchKey(resume.getUuid());
        doUpdate(resume, searchedKey);
    }

    @Override
    public void save(Resume resume) {
        SK searchedKey = getNotExistedSearchKey(resume.getUuid());
        doSave(resume, searchedKey);
    }

    @Override
    public Resume get(String uuid) {
        SK searchedKey = getExistedSearchKey(uuid);
        return doGet(searchedKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> storage = doCopyAll();
        storage.sort(RESUME_COMPARATOR);
        return storage;
    }

    @Override
    public void delete(String uuid) {
        SK searchedKey = getExistedSearchKey(uuid);
        doDelete(searchedKey);
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchedObject = getSearchedObject(uuid);
        if (!isExist(searchedObject)) {
            throw new NotExistStorageException(uuid);
        }
        return searchedObject;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchedObject = getSearchedObject(uuid);
        if (isExist(searchedObject)) {
            throw new ExistStorageException(uuid);
        }
        return searchedObject;
    }
}
