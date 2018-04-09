package mytest;

import java.util.concurrent.TimeUnit;

/**
 * 缓存常量
 * 
 * @author hephe
 *
 */
public interface GlobalConsts {

    /**
     * 缓存默认键的常量
     * 
     * @author hephe
     *
     */
    public interface CacheKey {

        String CACHE_DEFAULT_GLOBAL_KEY = "DEFAULT_GLOBAL_CACHE_";// 默认系统全局缓存key
    }

    /**
     * 缓存默认过期时间常量
     * 
     * @author hephe
     *
     */
    public interface CackeyExpireTime {

        long CACHE_DEFAULT_EXPIRED_TIME = Long.MAX_VALUE;// 默认永不过期
    }

    /**
     * TOKEN相关常量
     * 
     * @author hephe
     *
     */
    public interface CacheToken {
        String DEFAULT_TOKEN_KEY = "DEFAULT_TOKEN_KEY";
    }

    /**
     * 交易状态说明
     * 
     * @author hephe
     *
     */
    public interface TradeStatus {
     
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";// 交易创建，等待买家付款
        String TRADE_STATUS_TRADE_CLOSED = "TRADE_CLOSED"; // 未付款交易超时关闭，或支付完成后全额退款
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS"; // 交易支付成功
        String TRADE_STATUS_TRADE_FINISHED = "TRADE_FINISHED"; // 交易结束，不可退款
    }
    
    /**
     * 支付渠道信息
     * 
     * @author hephe
     *
     */
    public interface PayChannel{
        
        String ALIPAY = "ALIPAY";
        String WXPAY  = "WXPAY";
        
    }
}
