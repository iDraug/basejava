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
        Integer resumeIndex = findIndex(resume.getUuid());
        if (resumeIndex == null) {
            if (size >= storage.length) {
                System.out.println("Error. Storage is full.");
            } else {
                storage[size] = resume;
                size++;
            }
        } else {
            System.out.println("Error. This uuid already in storage.");
        }
    }

    public Resume get(String uuid) {
        Integer resumeIndex = findIndex(uuid);
        if (resumeIndex != null) {
            return storage[resumeIndex];
        } else {
            System.out.println("Error. Can't get this uuid.");
            return null;
        }
    }

    public void update(Resume resume) {
        Integer resumeIndex = findIndex(resume.getUuid());
        if (resumeIndex != null) {
            storage[resumeIndex] = resume;
        } else {
            System.out.println("Error. Can't update this uuid.");
        }
    }

    public void delete(String uuid) {
        Integer resumeIndex = findIndex(uuid);
        if (resumeIndex != null) {
            storage[resumeIndex] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Error. Can't delete this uuid.");
        }
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

    private Integer findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return null;
    }
}
