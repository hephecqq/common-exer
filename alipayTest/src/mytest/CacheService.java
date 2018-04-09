package mytest;

/**
 * 
 * @author hephe
 *
 */
public interface CacheService {

    /**
     * 
     * @param key
     * @param value
     * @return
     */
    public String storeToCache(Object key, Object value);

    /**
     * 
     * @param username
     * @param password
     * @return
     */
    public String getLoginToken(String username, String password) throws Exception;

    /**
     * 
     * @param username
     * @param password
     * @param key
     * @return
     */
    public String getLoginToken(String username, String password, String key);

    /**
     * 
     * @param username
     * @param password
     * @param key
     * @param expireTime
     * @return
     * @throws Exception 
     */
    public String getLoginToken(String username, String password, String key, long expireTime) throws Exception;
}
