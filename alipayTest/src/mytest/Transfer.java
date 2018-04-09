package mytest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据转换类
 * 
 * @author hephe
 *
 */
public class Transfer {

    private static interface TransferStatIndice{
        
        final String AVG = "AVG";//平均值
        final String MAX = "MAX";//最大值
        final String MIN = "MIN";//最小值
        final String NULL_COUNT = "NULL_COUNT";
        
        
    }
    
    public static Map<String,Double> transformStat = new HashMap<>();
    static {
        
    }
    
    /**
     * 初始化统计指标
     * 
     * @param transformStat
     */
    public static void initDataSet(Map<String,Double> transformStat) {
        
        if(!transformStat.isEmpty()||transformStat.size()>0) {
           transformStat = new HashMap<>();
          
        }
       
        //统计类型不匹配的数量
        
    }
    /**
     * 
     * @param len
     */
    public String truncateSpecLen(Collection<String> dataSet,int len) {
        int null_count = 0;
        for (String data : dataSet) {
            if(null==data||"".equals(data)) {
                null_count++;
                transformStat.put(Transfer.TransferStatIndice.NULL_COUNT,new Double(null_count));//统计空值的数量
            }
            
            
        }
        return "";
    }
    
}
