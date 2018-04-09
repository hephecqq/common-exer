package mytest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

import mytest.PayConfig.AlipayConfig;

/**
 * 支付宝异步通知处理器
 * 
 * @author hephe
 *
 */
public class AsynNotifyHandler {

    /**
     * 处理支付宝异步回调
     * 
     * @param request
     * @return
     * @throws AlipayApiException
     */
    public String handleRequest(HttpServletRequest request) throws AlipayApiException {
        Map paramsMap = new HashMap();
        paramsMap = request.getParameterMap();
        String valueStr = "";
        String tradeNo = (String) paramsMap.get("trade_no");// 支付宝的交易号
        String outTradeNo = (String) paramsMap.get("out_trade_no");// 商户订单号
        String tradeStatus = (String) paramsMap.get("trade_status");// 交易状态
        String gmtCreate = (String) paramsMap.get("gmt_create");// 交易创建时间
        String gmtPayment = (String) paramsMap.get("gmt_payment");// 交易付款时间
        //log.info("订单号-tradeNo:%s,商户订单号-outTradeNo:%s,支付号回调信息：%s",tradeNo,outTradeNo,JsonMapper.toJson(paramsMap));
        // 根据out_trade_no查询订单号是否存储
        // 如果out_trade_no订单号存在,则获取支付状态,如果订单已经支付或者取消支付等状态,则重复支付。
        Order order = orderService.getOrderInfoByPrimaryKey(outTradeNo);
        if(null==order) {
            //该订单不存在
            throw new RuntimeException("该订单不存在");
        }
        // 如果out_trade_no订单存在，支付状态为未支付，则获取支付宝回调tradeStatus,更新商户系统的订单状态。
        for (Iterator iterator = paramsMap.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            String[] values = (String[]) paramsMap.get(key);
            for (int i = 0; i < values.length; i++) {
                if (values.length == 1) {
                    valueStr = values.toString();
                } else {
                    valueStr = valueStr + values[i] + ",";
                }
            }
        }
        
        paramsMap.remove("sign_type");// 按照支付宝，去除sign和sign_type
        boolean checkRet = AlipaySignature.rsaCheckV2(paramsMap, com.alipay.config.AlipayConfig.alipay_public_key, "utf-8", com.alipay.config.AlipayConfig.sign_type);
        if (checkRet == false) {    
            // 验证签名失败
        } else {
                
            if (tradeStatus.equals(GlobalConsts.TradeStatus.TRADE_STATUS_TRADE_SUCCESS)) {
                // 交易成功,更新订单支付信息,调用商户服务,通知商家发货。
            }
            
        }
        return "";
    }
}
