package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected boolean isContained(Object index) {
        return storage.containsKey((String) index);
    }

    @Override
    protected Object getSearchedObject(String uuid) {
        return uuid;
    }

    @Override
    protected void insertResume(Resume r, Object index) {
        storage.put((String) index, r);
    }

    @Override
    protected Resume retrieve(Object index) {
        return storage.get((String) index);
    }

    @Override
    protected void remove(Object index) {
        storage.remove((String) index);
    }

    @Override
    protected void replace(Resume r, Object index) {
        storage.replace((String) index, r);
    }

    @Override
    protected void clean() {
        storage.clear();
    }
}
