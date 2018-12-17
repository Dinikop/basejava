import model.Resume;
import storage.ArrayStorage;
import storage.Storage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume resume1 = new Resume("uuid1");
        Resume resume2 = new Resume("uuid2");
        Resume resume3 = new Resume("uuid3");
        Resume resume4 = new Resume("uuid3");

        ARRAY_STORAGE.save(resume1);
        ARRAY_STORAGE.save(resume2);
        ARRAY_STORAGE.save(resume3);

        System.out.println("Get resume1: " + ARRAY_STORAGE.get(resume1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();

        System.out.print("\ndelete(uuid1)");
        ARRAY_STORAGE.delete(resume1.getUuid());
        printAll();

        System.out.print("\nupdate(uuid3)");
        ARRAY_STORAGE.update(resume4);
        printAll();

        System.out.print("\nclear");
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("\nSize: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume resume : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(resume);
        }
    }
}
