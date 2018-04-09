package crawler.tuliu;

/**
 * 爬取地址列表
 * 
 * @author hephe
 *
 */
public interface SiteConsts {

    /**
     * 土流网URL常量
     * 
     * @author hephe
     *
     */
    public interface TULIU {

        public static final String URL_TULIU_INDEX = "http://www.tuliu.com/";

        public static final int TIMEOUTMIllIS = 1000 * 10;
    }

    /**
     * 图片下载保存的地址
     * 
     * @author hephe
     *
     */
    public interface DOWNLOADFILEPATH {

        public static final String filePath = "d://crawler/";
    }

    /**
     * 热门分类常量
     * 
     * @author hephe
     *
     */
    public interface HostClassification {

        public static final String TYPE_GENGDI = "gengdi";// 耕地
        public static final String TYPE_LINDI = "lindi";// 林地
        public static final String TYPE_NONDCHANG = "nongchang";// 农场
        public static final String TYPE_ZAIJIDI = "zaijidi";// 宅基地
        public static final String TYPE_CHANGFANG = "changfang";// 厂房
        public static final String TYPE_OTHERS = "others";// 其他

    }

    /**
     * 土地标签
     * 
     * @author hephe
     *
     */
    public interface LandTags {
        public static final String XIAOMI = "xiaomi";// 小米
        public static final String KUIHUA = "kuihua";//
        public static final String TAOZI = "taozi";//
        public static final String YU = "yu";//
        public static final String QIUKUI = "qiukui";//
        public static final String YINTAO = "yintao";//
        public static final String DASUAN = "dasuan";//
        public static final String CAOMEI = "caomei";//
        public static final String JI = "ji";//
        public static final String PUTAO = "putao";//
        public static final String GUANGFUYONGDI = "guangfuyongdi";//
        public static final String XIAOMAI = "xiaomai";//
        public static final String HETAO = "tetao";//
        public static final String HUOLONGGUO = "huolonguo";//
        public static final String GUOQI = "guoqi";//
        public static final String MIANHUA = "mianhua";//
        public static final String HAUSHENG = "huasheng";//
        public static final String HUAJIAO = "huajiao";//
        public static final String LI = "li";//
    }

}
