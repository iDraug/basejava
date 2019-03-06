package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deletePosition(int index) {
        int localPosition = size - 1;
        if (index < localPosition) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
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
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
