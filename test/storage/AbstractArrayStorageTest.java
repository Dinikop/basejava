package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {

    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume resume = new Resume(UUID_1);
        storage.update(resume);
        Assert.assertEquals(resume, storage.get(UUID_1));
    }

    @Test
    public void getAll() throws Exception {
        Resume[] resumes = new Resume[]{new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        Assert.assertArrayEquals(resumes, storage.getAll());
    }

    @Test
    public void save() throws Exception {
        Assert.assertEquals(new Resume(UUID_1), storage.get(UUID_1));
        Assert.assertEquals(new Resume(UUID_2), storage.get(UUID_2));
        Assert.assertEquals(new Resume(UUID_3), storage.get(UUID_3));
    }

    @Test
    public void delete() throws Exception {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
        Assert.assertEquals(new Resume(UUID_2), storage.get(UUID_2));
        Assert.assertEquals(new Resume(UUID_3), storage.get(UUID_3));
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(new Resume(UUID_1), storage.get(UUID_1));
        Assert.assertEquals(new Resume(UUID_2), storage.get(UUID_2));
        Assert.assertEquals(new Resume(UUID_3), storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistStorageException() {
        storage.delete("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistStorageException() {
        storage.update(new Resume("dummy"));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExistStorageException() {
        storage.save(new Resume(UUID_1));
    }

    @Test(expected = StorageException.class)
    public void saveStorageOverflowException() {
        try {
            for (int i = 0; i < 10_000 - 3; i++) {
                storage.save(new Resume(String.valueOf(i)));
            }
        } catch (Exception e) {
            Assert.fail();
        }
        storage.save(new Resume("dummy"));
    }
}