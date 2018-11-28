package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public abstract class AbstractArrayStorageTest {

    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_DUMMY = "dummy";

    private static final Resume RESUME_UUID1 = new Resume(UUID_1);
    private static final Resume RESUME_UUID2 = new Resume(UUID_2);
    private static final Resume RESUME_UUID3 = new Resume(UUID_3);
    private static final Resume RESUME_DUMMY = new Resume(UUID_DUMMY);

    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_UUID1);
        storage.save(RESUME_UUID2);
        storage.save(RESUME_UUID3);
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
        storage.update(RESUME_UUID1);
        Assert.assertThat(RESUME_UUID1, is(storage.get(RESUME_UUID1.getUuid())));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistStorageException() {
        storage.update(RESUME_DUMMY);
    }

    @Test
    public void getAll() throws Exception {
        Resume[] resumes = new Resume[]{RESUME_UUID1, RESUME_UUID2, RESUME_UUID3};
        Assert.assertArrayEquals(resumes, storage.getAll());
        Assert.assertEquals(resumes.length, storage.getAll().length);
    }

    @Test
    public void save() throws Exception {
        Assert.assertEquals(RESUME_UUID1, storage.get(UUID_1));
        Assert.assertEquals(RESUME_UUID2, storage.get(UUID_2));
        Assert.assertEquals(RESUME_UUID3, storage.get(UUID_3));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExistStorageException() {
        storage.save(RESUME_UUID1);
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

    @Test
    public void delete() throws Exception {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
        Assert.assertEquals(RESUME_UUID2, storage.get(UUID_2));
        Assert.assertEquals(RESUME_UUID3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistStorageException() {
        storage.delete(UUID_DUMMY);
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(RESUME_UUID1, storage.get(UUID_1));
        Assert.assertEquals(RESUME_UUID2, storage.get(UUID_2));
        Assert.assertEquals(RESUME_UUID3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(UUID_DUMMY);
    }
}