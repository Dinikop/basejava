package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    protected List<Resume> storage = new ArrayList<>();

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[size]);
    }

    @Override
    protected void updateSize() {
        size = storage.size();
    }

    @Override
    protected boolean isContained(String uuid) {
        return storage.contains(new Resume(uuid));
    }

    @Override
    protected void insertResume(Resume r) {
        storage.add(r);
    }

    @Override
    protected Resume retrieve(String uuid) {
        return storage.get(storage.indexOf(new Resume(uuid)));
    }

    @Override
    protected void remove(String uuid) {
        storage.remove(new Resume(uuid));
    }

    @Override
    protected void replace(Resume r) {
        storage.add(r);
    }

    @Override
    protected void clean() {
        storage.clear();
    }
}
