package storage;

import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    protected Resume[] storage;

    @Override
    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            storage[index] = resume;
        }
    }

    public abstract void save(Resume r);

    @Override
    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public abstract void clear();

    public abstract void delete(String uuid);

    public abstract Resume[] getAll();

    protected abstract int findIndex(String uuid);
}
