package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private static final int STORAGE_LIMIT = 10_000;

    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int i = getResumeIndex(r.getUuid());
        if (i == -1) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[i] = r;
        }
    }

    public void save(Resume r) {
        if (getResumeIndex(r.getUuid()) >= 0) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int i = getResumeIndex(uuid);
        if (i == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        } else {
            return storage[i];
        }
    }

    public void delete(String uuid) {
        int i = getResumeIndex(uuid);
        if (i == -1) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            storage[i] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int getResumeIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
