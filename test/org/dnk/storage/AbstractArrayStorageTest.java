package org.dnk.storage;

import org.dnk.exception.StorageException;
import org.dnk.model.Resume;
import org.junit.Test;

import static org.junit.Assert.fail;

public class AbstractArrayStorageTest extends AbstractStorageTest {
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveStorageOverflowException() {
        storage.clear();
        try {
            for (int i = 0; i < ArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume(String.valueOf(i)));
            }
        } catch (StorageException e) {
            fail("org.dnk.storage is not overflow yet");
        }
        storage.save(new Resume("fullName"));
    }
}