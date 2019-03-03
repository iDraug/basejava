package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 2;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("Error. Can't update this uuid.");
        } else {
            storage[index] = resume;
        }
    }

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Error. Can't delete this uuid.");
        } else {
            for (int i = 0; i < size - 1; i++) {
                storage[index] = storage[index + 1];
            }
            storage[size - 1] = null;
            size--;
        }
    }

    public abstract void save(Resume resume);

    protected abstract int findIndex(String uuid);
}
