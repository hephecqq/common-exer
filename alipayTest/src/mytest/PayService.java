package mytest;

public interface PayService {

    /**
     * 根据支付房还是获取
     * @param payWayCode
     */
    public PayConfig getPayConfig(int payWayCode);
}
