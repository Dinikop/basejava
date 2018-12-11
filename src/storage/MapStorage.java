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
    protected boolean isContained(int index) {
        return true;
    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    protected void insertResume(Resume r, int index) {

    }

    @Override
    protected Resume retrieve(int index) {
        return null;
    }

    @Override
    protected void remove(int index) {

    }

    @Override
    protected void replace(Resume r, int index) {

    }

    @Override
    protected void clean() {
        storage.clear();
    }
}
