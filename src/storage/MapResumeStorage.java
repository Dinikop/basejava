package storage;

import model.Resume;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

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
    protected List<Resume> getStorage() {
        return new LinkedList<>(storage.values());
    }

    @Override
    protected Object getSearchedObject(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected boolean isContained(Object searchedResume) {
        return searchedResume != null;
    }

    @Override
    protected void insertResume(Resume r, Object searchedResume) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume retrieve(Object searchedResume) {
        return (Resume) searchedResume;
    }

    @Override
    protected void remove(Object searchedResume) {
        String uuid = ((Resume) searchedResume).getUuid();
        storage.remove(uuid);
    }

    @Override
    protected void replace(Resume r, Object searchedResume) {
        String uuid = ((Resume) searchedResume).getUuid();
        storage.replace(uuid, r);
    }
}
