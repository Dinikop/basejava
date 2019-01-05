package org.dnk.storage;

import org.dnk.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

    protected List<Resume> storage = new ArrayList<>();

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
        return new ArrayList<>(storage);
    }

    @Override
    protected boolean isExist(Integer searchedKey) {
        return searchedKey >= 0;
    }

    @Override
    protected void doSave(Resume resume, Integer searchedKey) {
        storage.add(resume);
    }

    @Override
    protected Resume doGet(Integer searchedKey) {
        return storage.get(searchedKey);
    }

    @Override
    protected void doDelete(Integer searchedKey) {
        storage.remove((int) searchedKey);
    }

    @Override
    protected void doUpdate(Resume resume, Integer searchedKey) {
        storage.set(searchedKey, resume);
    }

    @Override
    protected Integer getSearchedObject(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}
