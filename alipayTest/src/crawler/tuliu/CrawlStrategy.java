package crawler.tuliu;

public interface CrawlStrategy {

    /**
     * 爬取策略选择
     * 
     * @author hephe
     *
     */
    public interface crawlQuery{
        
        public static final String QUERY_BY_NEWS = "query_by_news";//按照最新爬取[默认爬取方式]
        public static final String QUERY_BY_NEWS_URL ="http://www.tuliu.com/gongying/w_bq109/";
        
        public static final String QUERY_BY_YOUZHI = "query_by_youzhi";//按照优质
        public static final String QUERY_BY_YOUZHI_URL = "http://www.tuliu.com/gongying/w_bq109/list-o1mtime-o20.html";//按照优质URL
        
        
        public static final String QUERY_BY_AREA = "query_by_news";//按照面积
        public static final String QUERY_BY_AREA_URL = "http://www.tuliu.com/gongying/w_bq109/list-o1mj-o20.html";//按照面积URL
        
        public static final String QUERY_BY_LIUZHUAN_YEAR = "query_by_liuzhuang_year";//按照流转年限
        public static final String QUERY_BY_LIUZHUAN_YEAR_URL = "http://www.tuliu.com/gongying/w_bq109/list-o1year-o20.html";//按照流转年限URL
        
        public static final String QUERY_BY_PRICE = "query_by_price";//按照价格
        public static final String QUERY_BY_PRICE_URL = "http://www.tuliu.com/gongying/w_bq109/list-o1price-o20.html";//按照价格URL
        
        
    }
    
}
