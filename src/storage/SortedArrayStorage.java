package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = -(findIndex(resume.getUuid())) - 1;
        if (index < 0) {
            System.out.println("Resume " + resume.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            if (index < size) {
                System.arraycopy(storage, index, storage, index + 1, size - index);
            }
            storage[index] = resume;
            size++;
        }
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
