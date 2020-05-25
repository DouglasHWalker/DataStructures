package dMapsSets;

public interface DMap<K, V> {

	/**
	 * Return the value associated with the specified key, Returns null if the key
	 * is not present
	 * 
	 * @param key the given key
	 * @return the value associated with the key
	 */
	public V get(Object key);

	/**
	 * Check if the map is empty
	 * 
	 * @return Returns true if this map contains no key-value mappings
	 */
	public boolean isEmpty();

	/**
	 * Associates the specified value with the specified key in this map (optional
	 * operation) Returns the previous value associated with the specified key, or
	 * null if there was no mapping for the key)
	 * 
	 * @param key   the given key to associate the value with
	 * @param value the given value to associate the key with
	 * @return previous value associated or null if there has been none
	 */
	public V put(K key, V value);

	/**
	 * Removes the mapping for this key from this map if it is present (optional
	 * operation). Return the previous value associated with the specified key, or
	 * null if there was no mapping for the key
	 * 
	 * @param key the key to remove
	 * @return previous value associated, or null if there was no mapping
	 */
	public V remove(Object key);

	/**
	 * Gets the number of key-value mappings
	 * @return Returns the number of key-value mappings in this map
	 */
	public int size();
}
