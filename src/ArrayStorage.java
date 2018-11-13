import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void update(Resume resume) {
        int i = findResume(resume.getUuid());
        if (i == -1) {
            System.out.println("ERROR: Resume not found!");
        } else {
            storage[i] = resume;
        }
    }

    void save(Resume r) {
        if (storage[storage.length - 1] != null) {
            System.out.println("ERROR: Storage is full!");
            return;
        }
        if (findResume(r.getUuid()) >= 0) {
            System.out.println("ERROR: Resume already in storage");
            return;
        }
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        int i = findResume(uuid);
        if (i == -1) {
            System.out.println("ERROR: Resume not found!");
            return null;
        } else {
            return storage[i];
        }
    }

    void delete(String uuid) {
        int i = findResume(uuid);
        if (i == -1) {
            System.out.println("ERROR: Resume not found!");
        } else {
            storage[i] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }

    private int findResume(String uuid) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
