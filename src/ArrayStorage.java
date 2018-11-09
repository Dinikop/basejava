/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) break;
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (storage[storage.length - 1] != null) System.out.println("storage is full!!!");

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
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
                    size--;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] resumes = new Resume[size];
        System.arraycopy(storage, 0, resumes, 0, size);
        return resumes;
    }

    int size() {
        return size;
    }
}
