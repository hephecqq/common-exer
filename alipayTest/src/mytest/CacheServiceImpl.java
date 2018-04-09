package mytest;

import java.util.Date;

/**
 * 
 * @author hephe
 *
 */
class CacheServiceImpl implements CacheService {

    @Override
    public String storeToCache(Object key, Object value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getLoginToken(String username, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getLoginToken(String username, String password, String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getLoginToken(String username, String password, String key, long expireTime) throws Exception {
        if (null == key || "".equals(key)) {
            key = GlobalConsts.CacheKey.CACHE_DEFAULT_GLOBAL_KEY;
        }
        if (0 > expireTime) {
            expireTime = GlobalConsts.CackeyExpireTime.CACHE_DEFAULT_EXPIRED_TIME;
        }
        // 从redis中获取token
        String token = getTokenFromCache(username, password);
        if (null == token || "".equals(token)) {
            generateTokenAndPutCache(username, password);
        }
        return token;
    }

    /**
     * 整个事务操作（控制事务属性）
     * 
     * @param username
     * @param password
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
    private boolean generateTokenAndPutCache(String username, String password) throws NoSuchMethodException, SecurityException {
        boolean cacheRetOp = true;
        // 根据username和password获取User信息存储json格式
        User user = getUserInfoFromDb(username, password);
        if (null == user) {
            // 数据未查到
        }
        String userJsonStr = JsonMapperUtils.toJson(user);

        String token = generateApiToken(username);
        String ret = CacheUtils.set(generateKey(username,token), userJsonStr);
        if (null == ret || "".equals(ret)) {
            cacheRetOp = false;
            throw new RuntimeException("ret");
        }
        return cacheRetOp;

    }

    /**
     * 根据token和username生成redis的key
     * 
     * @param username
     * @param token
     * @return
     */
    private Object generateKey(String username, String token) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 根据用户名生成token
     * 
     * @param username
     * @return
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
    private String generateApiToken(String username) throws NoSuchMethodException, SecurityException {
        /**
         * 接口token生成规则参考如下： api_token = md5 ('模块名' + '控制器名' + '方法名' +
         * '2013-12-18' + '加密密钥') = 770fed4ca2aabd20ae9a5dd77471
         */
        String packageStr = getClass().getPackage().getName();
        String className = getClass().getSimpleName();
        String methodName = getClass().getDeclaredMethod("generateApiToken", new Class[] {String.class}).getName();
        String token =  MD5Utils.md5(packageStr,className,methodName,new Date(),GlobalConsts.CacheToken.DEFAULT_TOKEN_KEY);
        if(null==token||"".equals(token)) {
            throw new RuntimeException();
        }
        return token;
    }

    /**
     * 
     * @param username
     * @param password
     */
    private User getUserInfoFromDb(String username, String password) {
        return null;
        // TODO Auto-generated method stub

    }

    /**
     * 
     * @param username
     * @param password
     * @return
     */
    private String getTokenFromCache(String username, String password) {
        // Jedis jedis = JedisPool.getInstance();
        // jedis.get(generateKey(username));

        return null;
    }

    /**
     * 根据username获取value
     * 
     * @param username
     * @return
     */
    private Object generateKey(String username) {
        // TODO Auto-generated method stub
        return null;
    }

}
