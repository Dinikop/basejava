package storage;

import model.Resume;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected List<Resume> getStorage() {
        return new LinkedList<>(storage.values());
    }

    @Override
    protected Resume getSearchedObject(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected boolean isContained(Resume searchedKey) {
        return searchedKey != null;
    }

    @Override
    protected void insertResume(Resume resume, Resume searchedKey) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume retrieve(Resume searchedKey) {
        return searchedKey;
    }

    @Override
    protected void remove(Resume searchedKey) {
        String uuid = (searchedKey).getUuid();
        storage.remove(uuid);
    }

    @Override
    protected void replace(Resume resume, Resume searchedKey) {
        String uuid = (searchedKey).getUuid();
        storage.replace(uuid, resume);
    }
}
