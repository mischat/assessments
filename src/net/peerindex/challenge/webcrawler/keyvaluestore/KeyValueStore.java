package net.peerindex.challenge.webcrawler.keyvaluestore;

/**
 * A store of String values retrievable by a String key.
 * 
 * The contains method and get method should execute in O(1) time regardless of the
 * number of key,value pairs in the store.
 */
public interface KeyValueStore {

    /**
     * Return true if store contains a value for the key.
     *
     * @param key key.
     * @return true if store contains a value for the key.
     * @throws IllegalArgumentException if key is null.
     */
    public boolean contains(String key);

    /**
     * Return value.
     *
     * @param key key.
     * @return value for the key or null if value does not exist.
     * @throws IllegalArgumentException if key is null.
     */
    public String get(String key);

    /**
     * Create or replace value.
     *
     * @param key key
     * @param value value
     * @return true if value was created, false if it was replaced.
     * @throws IllegalArgumentException if key is null or value is null
     */
    public boolean put(String key, String value);

    /**
     * Delete value.
     *
     * @param key key
     * @return true if value delete, false if no value associated with a key.
     * @throws IllegalArgumentException if key is null.
     */
    public boolean delete(String key);
    
}
