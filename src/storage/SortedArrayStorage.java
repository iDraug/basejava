package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    public void save(Resume resume) {
        int index = -(Arrays.binarySearch(storage, 0, size, resume)) - 1;
        if (index < 0) {
            System.out.println("Resume " + resume.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else if (index <= size) {
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = resume;
            size++;
        } else {
            storage[index] = resume;
            size++;
        }
    }


    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Error. Can't delete this uuid.");
        } else if (index == STORAGE_LIMIT) {
            storage[index] = null;
        } else {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
    }

    public int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
