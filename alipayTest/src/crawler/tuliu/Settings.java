package crawler.tuliu;

public class Settings {

    static {
        System.setProperty("http.maxRedirects","50");
        System.setProperty("proxySet", "true");
        //如果不设置，只要代理ip和代理端口正确，此项不设置也可以
        String ip = "";
        System.getProperties().setProperty("http.proxyHost", ip);
        System.getProperties().setProperty("http.proxyPort", "80");
    }
    
    public static void main(String[] args) {
        System.out.println("xxx");
    }
}
