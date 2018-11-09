/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) break;
            storage[i] = null;
        }
    }

    void save(Resume r) {
        if (storage[storage.length - 1] != null) System.out.println("storage is full!!!");

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }


    }

    Resume get(String uuid) {
        for (Resume resume : storage)
            if (resume != null && resume.uuid.equals(uuid)) return resume;
        return null;
    }

    void delete(String uuid) {
        boolean moveElements = false;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) break;

            if (moveElements) {
                storage[i - 1] = storage[i];
                storage[i] = null;
            } else {
                if (storage[i].uuid.equals(uuid)) {
                    moveElements = true;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int length = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                length = i;
                break;
            }
        }

        Resume[] resumes = new Resume[length];
        System.arraycopy(storage, 0, resumes, 0, length);
        return resumes;
    }

    int size() {
        return this.getAll().length;
    }
}
