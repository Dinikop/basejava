package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    protected List<Resume> storage = new ArrayList<>();

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected boolean isContained(int index) {
        return index >= 0;
    }

    @Override
    protected void insertResume(Resume r, int index) {
        storage.add(r);
    }

    @Override
    protected Resume retrieve(int index) {
        return storage.get(index);
    }

    @Override
    protected void remove(int index) {
        storage.remove(index);
    }

    @Override
    protected void replace(Resume r, int index) {
        storage.set(index, r);
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void clean() {
        storage.clear();
    }

    public static void main(String[] args) {
        Storage listStorage = new ListStorage();
        listStorage.save(new Resume("uuid1"));
    }
}
