package HashTable;

import java.util.Arrays;
import java.util.Objects;

public class HashTable {
    private static final int INITIAL_SIZE = 16;
    private HashEntry[] table;

    public HashTable() {
        table = new HashEntry[INITIAL_SIZE];
        for (int i = 0; i < INITIAL_SIZE; i++) {
            table[i] = null; // one null key bit multiple null values
        }
    }

    private int getHash(String key) {
        // String class has a solid hash code
        return key.hashCode() % INITIAL_SIZE;
    }

    public String get(String key) {
        HashEntry entry = getHashEntry(key);
        if (entry == null) return null;
        return entry.getValue();
    }

    // testing
    public HashEntry getEntry(String key) {
        HashEntry entry = getHashEntry(key);
        if (entry == null) return null;
        return entry;
    }

    private HashEntry getHashEntry(String key) {
        int hash = getHash(key);
        HashEntry entry = table[hash];
        if (entry == null) {
            return null;
        }

        while (!entry.getKey().equals(key) && entry.getNext() != null) {
            entry = entry.getNext();
        }
        return entry;
    }

    public void put(String key, String value) {
        int hash = getHash(key);

        HashEntry entry = table[hash];
        final HashEntry hashEntry = new HashEntry(key, value);
        if (entry == null) {
            table[hash] = hashEntry;
        } else {
            while (entry.getNext() != null) {
                entry = entry.getNext();
            }
            entry.setNext(hashEntry);
        }
    }

    public void remove(String key) {
        int hash = getHash(key);

        HashEntry entry = table[hash];
        if (entry == null) {
            return;
        }

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                table[hash] = table[hash].getNext();
                return;
            }
            entry = entry.getNext();
        }
    }

    // for testing
    public int getNonNullEntryCount() {
        return (int) Arrays.stream(table).filter(Objects::nonNull).count();
    }
}
