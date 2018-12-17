package storage;

import model.Resume;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

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
    protected Object getSearchedObject(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected boolean isContained(Object searchedKey) {
        return searchedKey != null;
    }

    @Override
    protected void insertResume(Resume resume, Object searchedKey) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume retrieve(Object searchedKey) {
        return (Resume) searchedKey;
    }

    @Override
    protected void remove(Object searchedKey) {
        String uuid = ((Resume) searchedKey).getUuid();
        storage.remove(uuid);
    }

    @Override
    protected void replace(Resume resume, Object searchedKey) {
        String uuid = ((Resume) searchedKey).getUuid();
        storage.replace(uuid, resume);
    }
}
