package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[size]);
    }

    @Override
    protected void updateSize() {
        size = storage.size();
    }

    @Override
    protected boolean isContained(String uuid) {
        return storage.containsKey(uuid);
    }

    @Override
    protected void insertResume(Resume r) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume retrieve(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void remove(String uuid) {
        storage.remove(uuid);
    }

    @Override
    protected void replace(Resume r) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected void clean() {
        storage.clear();
    }
}
