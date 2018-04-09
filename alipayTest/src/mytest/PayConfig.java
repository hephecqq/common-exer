package mytest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alipay.util.AlipaySubmit;
import com.sun.corba.se.impl.oa.poa.AOMEntry;

/**
 * 支付配置信息
 * 
 * @author hephe
 *
 */
public class PayConfig {

    private static String sysPropertyPath = "";
    private static Map<String, Object> configMap = new ConcurrentHashMap<String, Object>();
    static {
        configMap = initSysProperty(sysPropertyPath);
    }

    /**
     * 支付宝配置信息加载
     * 
     * @author hephe
     *
     */
    public static class AlipayConfig {
        private static Map<String, Object> alipayConfigMap = new ConcurrentHashMap<String, Object>();
        static {

            alipayConfigMap.put("charset", configMap.get("charset"));// 字符编码
            alipayConfigMap.put("signType", configMap.get("signType")); // 签名方式
            alipayConfigMap.put("payType", configMap.get("payType"));// 支付类型
            alipayConfigMap.put("platformKey", configMap.get("platformKey")); // 卖家支付宝用户号
            alipayConfigMap.put("platformId", configMap.get("platformId"));// 卖家密钥
            alipayConfigMap.put("interfaceName", configMap.get("interfaceName")); // 接口名称
            alipayConfigMap.put("interfaceUrl", configMap.get("interfaceUrl")); // 合作者身份ID
            alipayConfigMap.put("notifyUrl", configMap.get("notifyUrl")); // 服务器异步通知页面路径
            alipayConfigMap.put("gatewayUrl", configMap.get("getwayUrl")); // 页面跳转同步通知页面路径
            alipayConfigMap.put("timeout", configMap.get("timeout")); // 设置未付款交易的超时时间
            alipayConfigMap.put("scheduleTime", configMap.get("scheduleTime"));

        }

    }

    /**
     * 根据指定的路径读取配置文件
     * 
     * @param sysPropertyPath2
     * @return
     */
    private static Map<String, Object> initSysProperty(String sysPropertyPath2) {
        return configMap;
        // TODO Auto-generated method stub

    }

    /**
     * // 1.获取订单的参数 Map<String, String> orderParameters =
     * orderManager.getAlipayTradeParameters(orders); Map<String, String>
     * parameters = new HashMap<String, String>();
     * parameters.putAll(orderParameters);
     * 
     * Alipay alipay = (Alipay) PayModule.getInstance().getPay(site,
     * OrderNodeType.PayWay.ALIPAY); // 商户网站使用的编码格式
     * parameters.put("_input_charset", "utf-8"); // 签名方式 //
     * map.put("sign_type", payWay.getSignType()); // 支付类型
     * parameters.put("payment_type", alipay.getPaymentType()); // 卖家支付宝用户号
     * parameters.put("seller_id", alipay.getSellerId()); // 卖家密钥 //
     * map.put("key", payWay.getWebKey()); // 接口名称 parameters.put("service",
     * alipay.getService()); // 合作者身份ID parameters.put("partner",
     * alipay.getPartner()); // 服务器异步通知页面路径 parameters.put("notify_url",
     * alipay.getNotifyUrl()); // 页面跳转同步通知页面路径 parameters.put("return_url",
     * alipay.getReturnUrl());
     * 
     * // 设置未付款交易的超时时间 // 默认30分钟，一旦超时，该笔交易就会自动被关闭。 // 取值范围：1m～15d。 //
     * m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。 // 该参数数值不接受小数点，如1.5h，可转换为90m。
     * parameters.put("it_b_pay", alipay.getItbPay());
     * 
     * Map<String, String> payParameters =
     * AlipaySubmit.buildRequestPara(parameters, alipay, "");
     * alipay.setPayParameters(payParameters); return alipay;
     */
}
