import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        Integer i = findIndex(resume.getUuid());
        if (i != null || size < storage.length) {
            storage[size] = resume;
            size++;
        } else {
            System.out.println("Error. Can't save this uuid.");
        }
    }

    public Resume get(String uuid) {
        Integer i = findIndex(uuid);
        if (i != null) {
            return storage[i];
        } else {
            noUuid();
        }
        return null;
    }

    public void update(Resume resume) {
        Integer i = findIndex(resume.getUuid());
        if (i != null) {
            storage[i] = resume;
        } else {
            noUuid();
        }
    }

    public void delete(String uuid) {
        Integer i = findIndex(uuid);
        if (i != null) {
            storage[i] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            noUuid();
        }
    }

    public Integer findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return null;
    }

    public void noUuid() {
        System.out.println("Error. Uuid not found.");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
