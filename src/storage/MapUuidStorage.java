package storage;

import model.Resume;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {

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
    protected boolean isContained(Object searchedKey) {
        return storage.containsKey((String) searchedKey);
    }

    @Override
    protected Object getSearchedObject(String uuid) {
        return uuid;
    }

    @Override
    protected void insertResume(Resume resume, Object searchedKey) {
        storage.put((String) searchedKey, resume);
    }

    @Override
    protected Resume retrieve(Object searchedKey) {
        return storage.get((String) searchedKey);
    }

    @Override
    protected void remove(Object searchedKey) {
        storage.remove((String) searchedKey);
    }

    @Override
    protected void replace(Resume resume, Object searchedKey) {
        storage.replace((String) searchedKey, resume);
    }
}
