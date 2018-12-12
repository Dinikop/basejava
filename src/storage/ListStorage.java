package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    protected List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected boolean isContained(Object index) {
        return (int) index >= 0;
    }

    @Override
    protected void insertResume(Resume r, Object index) {
        storage.add(r);
    }

    @Override
    protected Resume retrieve(Object index) {
        return storage.get((int) index);
    }

    @Override
    protected void remove(Object index) {
        storage.remove((int) index);
    }

    @Override
    protected void replace(Resume r, Object index) {
        storage.set((int) index, r);
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
