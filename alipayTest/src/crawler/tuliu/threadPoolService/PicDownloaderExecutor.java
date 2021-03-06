package crawler.tuliu.threadPoolService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import crawler.tuliu.SiteConsts;

/**
 * 图片下载器
 * 
 * @author hephe
 *
 */
public class PicDownloaderExecutor {

    static {
        init();
    }
    // 线程管理器
    private static ThreadPoolManager threadPoolManager;

    public static void init() {
        threadPoolManager = ThreadPoolManager.newInstance();
    }

    /**
     * 
     * @param urls
     * @param timeout
     * @return
     */
    public boolean executeDownload(List<String> urls,int timeout) {
        threadPoolManager.addExecuteTask(new Runnable() {
            int count = urls.size();
            @Override
            public void run() {
                while(count>=0) {
                    try {
                        downImages(SiteConsts.DOWNLOADFILEPATH.filePath,urls.get(count));
                    } catch (UnsupportedEncodingException e) {
                        //TODO 日志记录
                    }
                }
            }
        });
        return false;
    }
    
    /**
     * 下载图片
     * 
     * @param filePath 文件下载的路径
     * @param imgUrl 图片url地址
     * @throws UnsupportedEncodingException 
     */
    public static void downImages(String filePath,String imgUrl) throws UnsupportedEncodingException {
      //图片url中的前面部分：例如"http://images.csdn.net/"  
        String beforeUrl = imgUrl.substring(0,imgUrl.lastIndexOf("/")+1);  
        //图片url中的后面部分：例如“20150529/PP6A7429_副本1.jpg”  
        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/")+1);  
        //编码之后的fileName，空格会变成字符"+"  
        String newFileName = URLEncoder.encode(fileName, "UTF-8");  
        //把编码之后的fileName中的字符"+"，替换为UTF-8中的空格表示："%20"  
        newFileName = newFileName.replaceAll("\\+", "\\%20");  
        //编码之后的url  
        imgUrl = beforeUrl + newFileName;  
          
        try {  
            //创建文件目录  
            File files = new File(filePath);  
            if (!files.exists()) {  
                files.mkdirs();  
            }  
            //获取下载地址  
            URL url = new URL(imgUrl);  
            //链接网络地址  
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();  
            //获取链接的输出流  
            InputStream is = connection.getInputStream();  
            //创建文件，fileName为编码之前的文件名  
            File file = new File(filePath + fileName);  
            //根据输入流写入文件  
            FileOutputStream out = new FileOutputStream(file);  
            int i = 0;  
            while((i = is.read()) != -1){  
                out.write(i);  
            }  
            out.close();  
            is.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
}
