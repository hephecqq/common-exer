package com.alipay.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;

public class AlipayTest {
    public static final String pri = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKxB5hRPfOwkskLtEoNJjvPpa850jl9KwenvRHzJL9BNCR06+ZYndIbE6sIHT84YJ6duBn5FK6tRjcZXNPbylUscwDIstAf83DSMkZYwebZOBGv34Xa1krWJ36rBZqNClVy4P6cSFDahzmlIcLWHr9SbKy6xccFQHfrWtbZ5lCgDAgMBAAECgYAcEDxgsLaEblIQbzkl5HUCrdOfdgO/6JkA+LcqsUg14mcKuRHycYkdb7VjWPeadvr23wj1x2Ue6xFy78A0Pz8tEgk2q4++SzMrqIcmC8TKLSh1OJkdp7v5Z2x6AH9D0BvoOISrt75hw0QyEuiMDGB7L294P1I8LOrTHJ8IWWnB+QJBANwVf9ePr/887T+X0njgutX8+GqxMs2z1kYKLSjYTiK4OEO2JQsDntokE1HSwzoFWZuJjIW+AnlHGYubdJ/yGMUCQQDIXlZvXNYiRYNMPKuAq7WgMu+naTpd2F8A8Q2+slaT/XSHBpzxjiWosDnWCqiBNAuzTDAYICHuewAXw8w1mvonAkATrOxf9h2S4PyI2ebcHaM2bEY9K5hSIYi/fDtrUmMx4WxOSWNoZ6t07xK3FvOTJVVMfXCNqF4KP5v+CijT/83NAkBFwlpzgS3oVq1EwKaxMJcWhEVd0swIWkmRSVuQtgRgl9CXJh1EGEpSNbCdLa7G9PjR3serzpwhrF825utVCnTnAkEAxW7tfxFWqWqGdO/TAG3r673G2icmOI2u3wbi8f23kQRdf0CEbMeB9lMMUeguAPJ87Q2uLRsjo+S4Q8nhbEbLEQ==";
    public static void main(String[] args) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                "2016092601972945",
                pri,
                "RSA");
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{" +
        "    \"out_trade_no\":\"20171114110238177\"," +
        "    \"trade_no\":\"20171114110238177\"" +
        "  }");
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
        System.out.println("调用成功");
        } else {
        System.out.println("调用失败");
        }
    }
}
