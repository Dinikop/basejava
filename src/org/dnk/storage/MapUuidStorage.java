package org.dnk.storage;

import org.dnk.model.Resume;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {

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
    protected List<Resume> doCopyAll() {
        return new LinkedList<>(storage.values());
    }

    @Override
    protected boolean isExist(String searchedKey) {
        return storage.containsKey(searchedKey);
    }

    @Override
    protected String getSearchedObject(String uuid) {
        return uuid;
    }

    @Override
    protected void doSave(Resume resume, String searchedKey) {
        storage.put(searchedKey, resume);
    }

    @Override
    protected Resume doGet(String searchedKey) {
        return storage.get(searchedKey);
    }

    @Override
    protected void doDelete(String searchedKey) {
        storage.remove(searchedKey);
    }

    @Override
    protected void doUpdate(Resume resume, String searchedKey) {
        storage.replace(searchedKey, resume);
    }
}
