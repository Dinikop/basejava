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
    protected boolean isContained(Object key) {
        return storage.containsKey((String) key);
    }

    @Override
    protected Object getSearchedObject(String uuid) {
        return uuid;
    }

    @Override
    protected void insertResume(Resume resume, Object key) {
        storage.put((String) key, resume);
    }

    @Override
    protected Resume retrieve(Object key) {
        return storage.get((String) key);
    }

    @Override
    protected void remove(Object key) {
        storage.remove((String) key);
    }

    @Override
    protected void replace(Resume resume, Object key) {
        storage.replace((String) key, resume);
    }
}
