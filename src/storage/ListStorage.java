package storage;

import model.Resume;

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
    protected List<Resume> getStorage() {
        return new ArrayList<>(storage);
    }

    @Override
    protected boolean isContained(Integer searchedKey) {
        return searchedKey >= 0;
    }

    @Override
    protected void insertResume(Resume resume, Integer searchedKey) {
        storage.add(resume);
    }

    @Override
    protected Resume retrieve(Integer searchedKey) {
        return storage.get(searchedKey);
    }

    @Override
    protected void remove(Integer searchedKey) {
        storage.remove((int) searchedKey);
    }

    @Override
    protected void replace(Resume resume, Integer searchedKey) {
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
