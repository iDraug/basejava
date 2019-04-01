package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deletePosition(int index) {
        if (index < size - 1) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        }
    }

    @Override
    protected void savePosition(Resume resume, int index) {
        int localPosition = -index - 1;
        if (localPosition < size) {
            System.arraycopy(storage, localPosition, storage, localPosition + 1, size - localPosition);
        }
        storage[localPosition] = resume;
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}