package storage;

import model.Resume;

import java.util.ArrayList;


public class ListStorage extends AbstractStorage {
    protected ArrayList<Resume> storage = new ArrayList<Resume>();

    @Override
    public void save(Resume r) {
        storage.add(r);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void delete(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                storage.remove(r);
                break;
            }
        }
    }

    @Override
    public Resume[] getAll() {
        return (Resume[])storage.toArray();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected int findIndex(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                return storage.indexOf(r);
            }
        }
        return -1;
    }

}
