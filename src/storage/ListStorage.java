package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListStorage extends AbstractStorage {

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
    protected List<Resume> getStorage() {
        return new LinkedList<>(storage);
    }

    @Override
    protected boolean isContained(Object key) {
        return (int) key >= 0;
    }

    @Override
    protected void insertResume(Resume resume, Object key) {
        storage.add(resume);
    }

    @Override
    protected Resume retrieve(Object key) {
        return storage.get((int) key);
    }

    @Override
    protected void remove(Object key) {
        storage.remove((int) key);
    }

    @Override
    protected void replace(Resume resume, Object key) {
        storage.set((int) key, resume);
    }

    @Override
    protected Object getSearchedObject(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}
