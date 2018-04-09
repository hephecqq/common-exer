package crawler.tuliu;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import crawler.tuliu.threadPoolService.PicDownloaderExecutor;

/**
 * tuliu Crawler爬虫
 * 
 * @author hephe
 *
 */
public class TuliuCrawler {

    /**
     * 土地信息
     * 
     * @author hephe
     *
     */
    public class Land implements Serializable, Cloneable {

        private static final long serialVersionUID = 1893192694198286730L;
        public boolean isGood = false;// 是否是优质类型
        public boolean isChecked = false;// 是否现场核实
        public boolean isPhoned = false;// 是否电话核实
        public Date crawlDate = null;// 爬取时间
        public Date dbDate = null;// 入库时间
        public String publishTitle = "";// 发布标题信息
        public Double price;// 发布价格
        public Unit unit;// 发布单位
        public String proviceName;// 省级名字
        public int proviceCode;// 省级编码
        public String cityName;// 市级名字
        public int cityCode;// 市级编码
        public String zoneName;// 区域或者县级名称
        public int zoneCode;// 区域或者编码
        public int chanquan;// 产权年限
        public List<String> pics;// 图片列表
        
 
        public double area;// 面积

        public double getArea() {
            return area;
        }

        public void setArea(double area) {
            this.area = area;
        }

        /**
         * 克隆方式实现
         */
        @Override
        protected Land clone() throws CloneNotSupportedException {
            return (Land) super.clone();
        }

        public boolean isGood() {
            return isGood;
        }

        public void setGood(boolean isGood) {
            this.isGood = isGood;
        }

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean isChecked) {
            this.isChecked = isChecked;
        }

        public boolean isPhoned() {
            return isPhoned;
        }

        public void setPhoned(boolean isPhoned) {
            this.isPhoned = isPhoned;
        }

        public Date getCrawlDate() {
            return crawlDate;
        }

        public void setCrawlDate(Date crawlDate) {
            this.crawlDate = crawlDate;
        }

        public Date getDbDate() {
            return dbDate;
        }

        public void setDbDate(Date dbDate) {
            this.dbDate = dbDate;
        }

        public String getPublishTitle() {
            return publishTitle;
        }

        public void setPublishTitle(String publishTitle) {
            this.publishTitle = publishTitle;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Unit getUnit() {
            return unit;
        }

        public void setUnit(Unit unit) {
            this.unit = unit;
        }

        public String getProviceName() {
            return proviceName;
        }

        public void setProviceName(String proviceName) {
            this.proviceName = proviceName;
        }

        public int getProviceCode() {
            return proviceCode;
        }

        public void setProviceCode(int proviceCode) {
            this.proviceCode = proviceCode;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public int getCityCode() {
            return cityCode;
        }

        public void setCityCode(int cityCode) {
            this.cityCode = cityCode;
        }

        public String getZoneName() {
            return zoneName;
        }

        public void setZoneName(String zoneName) {
            this.zoneName = zoneName;
        }

        public int getZoneCode() {
            return zoneCode;
        }

        public void setZoneCode(int zoneCode) {
            this.zoneCode = zoneCode;
        }

        public int getChanquan() {
            return chanquan;
        }

        public void setChanquan(int chanquan) {
            this.chanquan = chanquan;
        }

        public List<String> getPics() {
            return pics;
        }

        public void setPics(List<String> pics) {
            this.pics = pics;
        }

    }

    /**
     * 
     * @throws MalformedURLException
     * @throws IOException
     */
    public void crawlHotClassification() throws MalformedURLException, IOException {
        Document doc = Jsoup.parse(new URL("SiteConsts.TULIU.URL_TULIU_INDEX"), SiteConsts.TULIU.TIMEOUTMIllIS);
        Element picChangeFangLands = doc.select("#pic_changfang_lands").get(0);
        Elements colmd34Elements = picChangeFangLands.select(".col-md-3 col-sm-4");
        // Map<String, List<Land>> landMap = new HashMap<String, List<Land>>();
        Map<String, List<Land>> landMap = Maps.newConcurrentMap();
        Map<String, String> picsMap = Maps.newConcurrentMap();
        String isGood = "";// 是否是优质类型
        String isChecked = "";// 是否现场核实
        String isPhoned = "";// 是否电话核实
        String crawlDate = null;// 爬取时间
        String dbDate = null;// 入库时间
        String publishTitle = "";// 发布标题信息
        String price;// 发布价格
        String unit;// 发布单位
        String proviceName;// 省级名字
        String proviceCode;// 省级编码
        String cityName;// 市级名字
        String cityCode;// 市级编码
        String zoneName;// 区域或者县级名称
        String zoneCode;// 区域或者编码
        String chanquan;// 产权年限
        String area;// 面积
        // Map<String, String> picsMap = new HashMap<String, String>();// 图片列表
        // 并发情况下考虑使用ConcurrentHashMap
        // ConcurrentHashMap<String, String> picsMap = new
        // ConcurrentHashMap<String,String>();//图片列表
        // 进一步使用guava优化

        String pczStr = "";// 省市区字符串
        if (colmd34Elements.size() > 0) {
            Iterator<Element> it = colmd34Elements.iterator();
            while (it.hasNext()) {
                // 获取每一个热门分类土地列表信息
                // 解析具体的字段信息
                Element ele = it.next();
                Element tagsList = ele.getElementsByClass(".tags-list").get(0);
                isChecked = tagsList.getElementsByClass("style-1").get(0).toString();// 是否现场核实
                isPhoned = tagsList.getElementsByClass("style-1").get(1).toString();// 电话核实
                Element aEle = ele.getElementsByClass("wow").get(0);
                publishTitle = aEle.attr("title");// 发布标题信息
                price = ele.getElementsByClass("txt-price text-warning font-16").get(0).text();// 获取价格信息
                area = ele.getElementsByClass("text-right").get(0).text();// 获取面积信息
                pczStr = ele.getElementsByClass("iconfont icon-dizhi").get(0).nextElementSibling().text();
                String[] str = pczStr.split("//");
                proviceName = str[0];// 省级名称
                cityName = str[1];// 市级名称
                zoneName = str[2];// 区或县及名称
                String[] mappingResult = Name2Code(proviceName, cityName, zoneName);
                proviceCode = mappingResult[0];
                cityCode = mappingResult[1];
                zoneCode = mappingResult[2];
                // 解析图片，名称，地址
                Element image = ele.getElementsByTag("img").get(0);
                String href = image.attr("href");
                String alt = image.attr("alt");
                String url = image.attr("src");
                picsMap.put("href", href);
                picsMap.put("alt", alt);
                picsMap.put("url", url);
            }

        }
    }

    /**
     * 将名称转换为对应省市县的区域编码
     * 
     * @param proviceName
     * @param cityName
     * @param zoneName
     */
    private String[] Name2Code(String proviceName, String cityName, String zoneName) {
        if (StringUtil.isBlank(proviceName) || StringUtil.isBlank(cityName) || StringUtil.isBlank(zoneName)) {
            throw new RuntimeException(String.format("proviceName:%s,cityName:%s,zoneName:%s", proviceName, cityName, zoneName).trim() + "异常");
        }
        // TODO 二期项目，加载配置文件做映射关联
        return null;
    }

    /**
     * 按照标签爬取土地数据-默认按照按照最新爬取土地数据
     * 
     * @param tagName
     *            标签名
     * @throws IOException
     */
    public void crawlByTagAndNews(String tagName) throws IOException {
        crawlByTagAndNews(tagName, CrawlStrategy.crawlQuery.QUERY_BY_NEWS);
    }

    /**
     * 按照标签爬取土地数据-按照爬取的策略选择爬取[爬虫爬取数据信息时，关键点未做日志]
     * 
     * @param tagName
     *            标签名
     * @param crawlStrategy
     *            爬策略
     * @throws IOException
     */
    public void crawlByTagAndNews(String tagName, String crawlStrategy) throws IOException {
        String crawlUrl = "";// 爬取网站地址链接
        if (crawlStrategy.equals(CrawlStrategy.crawlQuery.QUERY_BY_AREA)) {
            // 按照区域面积爬取
            crawlUrl = CrawlStrategy.crawlQuery.QUERY_BY_AREA_URL;
            Document doc = Jsoup.connect(crawlUrl).timeout(SiteConsts.TULIU.TIMEOUTMIllIS).userAgent(UserAgentUtils.USER_AGENTS.get(new Random().nextInt() * 5 + 1)).get();
            Element element = doc.getElementsByClass("v2-land-square-list").get(0);
            Elements colsm4s = element.getElementsByClass("col-sm-4");
            Iterator<Element> colsm4 = colsm4s.iterator();
            while (colsm4.hasNext()) {
                Element landInfo = colsm4.next().getElementsByClass("land-square-item").get(0);
                Element aEle = landInfo.getElementsByTag("a").get(0);
                String title = aEle.attr("title");
                String href = landInfo.getElementsByTag("img").get(0).attr("href");
                String imgAlt = landInfo.getElementsByTag("img").get(0).attr("alt");
                String src = landInfo.getElementsByTag("img").get(0).attr("src");
                List<String> srcs = Lists.newCopyOnWriteArrayList();
                srcs.add(src);
                pushToDownloadExecutor(srcs);
                String isValid = landInfo.getElementsByClass("style-1").get(0).text();// 现场核实
                String isPhoned = landInfo.getElementsByClass("style-2").get(0).text();// 电话核实
                String rentType = landInfo.getElementsByClass("type-1  style-2").get(0).text();
                String rentYear = landInfo.getElementsByClass("type-2  style-2").get(0).text();
                String price = landInfo.getElementsByClass("text-2-1").get(0).getElementsByTag("b").get(0).text();// 价格
                String unitInfo = landInfo.getElementsByClass("text-2-1").get(0).getElementsByTag("b").get(0).nextElementSibling().text();// 单位信息
                Pattern pattern = Pattern.compile("//");
                Matcher matcher = pattern.matcher(unitInfo);
                String[] unitInfoFormat = null;
                while (matcher.find()) {
                    int i = 0;
                    unitInfoFormat[i] = matcher.group(i);
                }
                // 解析耕地类型,TODO 需要进一步处理
                String gengdiType = landInfo.getElementsByClass("text-3-1 text-row pull-left").get(0).text();
                String types = landInfo.getElementsByClass("text-3-1 text-row pull-right").get(0).text();

            }

        } else if (crawlStrategy.equals(CrawlStrategy.crawlQuery.QUERY_BY_LIUZHUAN_YEAR)) {
            // 按照流转年限爬取数据
            crawlUrl = CrawlStrategy.crawlQuery.QUERY_BY_LIUZHUAN_YEAR_URL;

        } else if (crawlStrategy.equals(CrawlStrategy.crawlQuery.QUERY_BY_NEWS)) {
            // 按照最新类型爬取数据
            crawlUrl = CrawlStrategy.crawlQuery.QUERY_BY_NEWS_URL;

        } else if (crawlStrategy.equals(CrawlStrategy.crawlQuery.QUERY_BY_YOUZHI)) {
            // 按照优质类型爬取数据
            crawlUrl = CrawlStrategy.crawlQuery.QUERY_BY_YOUZHI_URL;

        } else if (crawlStrategy.equals(CrawlStrategy.crawlQuery.QUERY_BY_PRICE)) {
            // 按照价格类型爬取数据
            crawlUrl = CrawlStrategy.crawlQuery.QUERY_BY_PRICE_URL;

        }
    }

    /**
     * 推送图片地址到下载器中下载任务
     * 
     * @param srcs
     * @throws UnsupportedEncodingException
     */
    private void pushToDownloadExecutor(List<String> srcs) throws UnsupportedEncodingException {
        PicDownloaderExecutor.downImages(SiteConsts.DOWNLOADFILEPATH.filePath, srcs.get(0));
    }

}
