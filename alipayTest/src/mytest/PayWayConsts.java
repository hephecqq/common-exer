package mytest;

/**
 * 
 * @author hephe
 *
 */
public interface PayWayConsts {

    /**
     * 已有的支付方式
     * 
     * @author hephe
     *
     */
    public interface PayWayService{       
        public int alipay = 1;
        public int wxpay = 2;
        public int bankpay = 3;
        
    }
}
