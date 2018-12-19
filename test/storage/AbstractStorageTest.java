package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public abstract class AbstractStorageTest {

    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_DUMMY = "dummy";

    private static final Resume RESUME_UUID1 = new Resume(UUID_1, "fullName1");
    private static final Resume RESUME_UUID2 = new Resume(UUID_2, "fullName2");
    private static final Resume RESUME_UUID3 = new Resume(UUID_3, "fullName3");
    private static final Resume RESUME_DUMMY = new Resume(UUID_DUMMY, "fullName4");

    protected AbstractStorageTest(Storage storage) {
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
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_1, "fullNameUpdated");
        storage.update(resume);
        assertSame(resume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistStorageException() {
        storage.update(RESUME_DUMMY);
    }

    @Test
    public void save() {
        int originalSize = storage.size();
        storage.save(RESUME_DUMMY);
        assertSame(RESUME_DUMMY, storage.get(UUID_DUMMY));
        assertEquals(originalSize + 1, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExistStorageException() {
        storage.save(RESUME_UUID1);
    }

    @Test
    public void get() {
        assertEquals(RESUME_UUID1, storage.get(UUID_1));
        assertEquals(RESUME_UUID2, storage.get(UUID_2));
        assertEquals(RESUME_UUID3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(UUID_DUMMY);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        int originalSize = storage.size();
        storage.delete(UUID_1);
        assertEquals(originalSize - 1, storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistStorageException() {
        storage.delete(UUID_DUMMY);
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void getAllSorted() {
        List<Resume> expectedResumes = Arrays.asList(RESUME_UUID1, RESUME_UUID2, RESUME_UUID3);
        List<Resume> actualResumes = storage.getAllSorted();
        assertThat(expectedResumes, is(actualResumes));
        assertEquals(expectedResumes.size(), actualResumes.size());
    }
}