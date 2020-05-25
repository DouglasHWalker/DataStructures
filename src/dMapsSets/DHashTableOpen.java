package dMapsSets;

public class DHashTableOpen<K, V> implements DMap<K, V> {

	private Entry<K, V>[] table;
	private static final int START_CAPACITY = 11;
	private final Entry<K, V> DELETED = new Entry<K, V>(null, null);
	private double LOAD_THRESHOLD = 0.75;
	private int numKeys;
	private int numDeletes;

	public DHashTableOpen() {
		table = new Entry[START_CAPACITY];
	}

	public int find(Object key) {
		// set the index to key.hashCode() % table.length
		int i = key.hashCode() % table.length;
		// if the index is negative, add table length
		if (i < 0) {
			i += table.length;
		}
		// while table[index[ is not empty and the key is not at table[index]
		while (table[i] != null && !key.equals(table[i].getKey())) {
			i++;
			// if the index is greater than or equal to table.length
			if (i >= table.length) {
				// set index to 0
				i = 0;
			}
		}
		return i;
	}

	public void rehash() {
		// ALLOCTE new hash table
		Entry<K, V>[] oldTable = table;
		table = new Entry[table.length * 2 - 1];
		// RESET the number of keys and number of deletions to 0
		numKeys = 0;
		numDeletes = 0;
		// REINSERT each table entry that has not been deleted in the new hash table.
		for (Entry<K, V> entry : oldTable) {
			if(entry != null && !entry.equals(DELETED)) {
				this.put(entry);
			}
		}
	}

	@Override
	public V get(Object key) {
		Entry<K, V> entry = table[find(key)];
		// if the table element contains a key
		if (entry != null) {
			return entry.getValue();
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if(numKeys == 0) {
			return true;
		}
		return false;
	}

	@Override
	public V put(K key, V value) {
		int index = find(key);
		Entry<K, V> entry = table[index];
		// if an empty element was found
		if (entry == null) {
			table[index] = new Entry<K, V>(key, value);
			numKeys++;
			// check for need to rehash
			if ((double)(numKeys + numDeletes) / table.length >= LOAD_THRESHOLD) {
				rehash();
			}
			// the item has been added and noting need to be replaced
			return null;
		}
		// Replace the value associated with this table element
		table[index].setValue(value);
		// and return the old value
		return entry.getValue();
	}
	
	private V put(Entry<K,V> entry) {
		return put(entry.getKey(), entry.getValue());
	}

	@Override
	public V remove(Object key) {
		// find the first table element that is empty or the table element that contains
		// the key
		int index = find(key);
		Entry<K, V> entry = table[index];
		// if an empty element was found
		if (entry == null) {
			return null;
		}
		// key was found. Remove this table element by setting it to reference DELETED
		// increment numDeletes and decrement numKys
		table[index] = DELETED;
		numDeletes++;
		numKeys--;
		// Return the value associated with this key
		return entry.getValue();
	}

	@Override
	public int size() {
		return this.numKeys;
	}

}
