import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume resume) {
        if (size == 9999) System.out.println("Error. Storage is full.");
        else {
            if (find(resume) == null) storage[size] = resume;
            size++;
        }
    }

    Resume get(String uuid) {
        if (find(uuid) != null) {
            return storage[find(uuid)];
        } else System.out.println("Error. Uuid not found.");
        return null;
    }

    void update(Resume resume) {
        if (find(resume) != null) {
            storage[find(resume)] = resume;
        } else System.out.println("Error. Resume not found.");
    }

    void delete(String uuid) {
        if (find(uuid) != null) {
            storage[(find(uuid))] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else System.out.println("Error. Uuid not found.");
    }

    Integer find(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume == storage[i]) return i;
        }
        return null;
    }

    Integer find(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].uuid) return i;
        }
        return null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = Arrays.copyOf(storage, size);
        return result;
    }

    int size() {
        return size;
    }
}
