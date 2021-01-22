package com.chaoxing.osm.utils;



import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.common.cons.ExceptionCons;
import com.chaoxing.osm.common.cons.FileCons;
import com.chaoxing.osm.common.cons.FileType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FileUtil
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2019-06-11 10:23
 **/
@Component
public class FileUtil {

    private static String localDir;

    private static String path;

    public static final String SEPARATOR = "/";

    @Value("${file.localDir}")
    public void setLocalDir(String localDir){
        FileUtil.localDir=localDir;
    }
    @Value("${fore.path}")
    public void setPath(String path){
        FileUtil.path =path;
    }

    /**
     * 从文件中读取内容
     * @param filePath
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String readFileBanner(String filePath) throws FileNotFoundException, IOException {
        String banner = FileUtil.readFileBanner(new FileInputStream(filePath));
        return banner;
    }

    /**
     * 从文件中读取内容
     * @param file
     * @return
     * @throws IOException
     */
    public static String readFileBanner(File file) throws IOException {
        String banner = FileUtil.readFileBanner(new FileInputStream(file));
        return banner;
    }

    /**
     * 从文件中读取内容
     * @param fileInputStream
     * @return
     * @throws IOException
     */
    public static String readFileBanner(FileInputStream fileInputStream) throws IOException {
        StringBuilder banner = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, ResponseString.DEFAULT_CHARSET));

        String line = bufferedReader.readLine();

        while (null != line) {
            banner.append(line);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();

        return banner.toString();
    }




    /**
     * 覆盖文件内容
     * @param filePath
     * @param banner
     * @throws IOException
     */
    public static void updateFileBanner(String filePath, String banner) throws IOException {
        String sysFilePath = FilePathUtil.getWebProjectRootFilePath() + filePath;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sysFilePath)));
        bufferedWriter.write(banner);
        bufferedWriter.flush();
        bufferedWriter.close();
    }


    /**
     * 根据给出的路径，删除文件
     * @param filePath
     */
    public static void deleteFile(String filePath) {
        String sysFilePath = FilePathUtil.getWebProjectRootFilePath() + filePath;

        File file = new File(sysFilePath);

        if (!file.exists()) {
            return ;
        }

        file.delete();
    }


    /**
     * 上传单一文件处理方法
     * @param file
     * @param fileType
     * @return
     * @throws IOException
     */
    public static ServerResponse<String> uploadFile(MultipartFile file, FileType fileType, String realPath)  {
        // 若上传文件为空或文件类型为空，返回错误信息

        if (null == file || file.isEmpty() || null == fileType) {
            return ServerResponse.createByErrorMessage(ExceptionCons.UPLOAD_FILE_IS_EMPTY);
        }

        String suffix = FileUtil.getSuffix( file.getOriginalFilename());
        String fileName = file.getOriginalFilename().replace(suffix,"");
        String newFileName =fileName +DateUtil.dateToStr(new Date(),DateUtil.DATENAME_FORMAT)+ suffix;
        String webProjectRootFilePath = localDir;
        StringBuilder pathStringBuilder = new StringBuilder(webProjectRootFilePath);
        StringBuilder pathStringBuilder2 = new StringBuilder(path);
        pathStringBuilder.append(realPath);

        switch (fileType) {
            case Txt:
                pathStringBuilder.append(FileCons.TXT_UPLOAD_FILE_PATH);
                pathStringBuilder2.append(FileCons.TXT_UPLOAD_FILE_PATH);
                break;
            case Book:
                pathStringBuilder.append(FileCons.BOOK_UPLOAD_FILE_PATH);
                pathStringBuilder2.append(FileCons.BOOK_UPLOAD_FILE_PATH);
                break;
            case Image:
                pathStringBuilder.append(FileCons.IMAGE_UPLOAD_FILE_PATH);
                pathStringBuilder2.append(FileCons.IMAGE_UPLOAD_FILE_PATH);
                break;
            case Video:
                pathStringBuilder.append(FileCons.VIDEO_UPLOAD_FILE_PATH);
                pathStringBuilder2.append(FileCons.VIDEO_UPLOAD_FILE_PATH);
                break;
            default:
                pathStringBuilder.append(FileCons.DEFAULT_UPLOAD_FILE_PATH);
                pathStringBuilder2.append(FileCons.DEFAULT_UPLOAD_FILE_PATH);
                break;
        }

        pathStringBuilder.append(FileUtil.SEPARATOR);
        pathStringBuilder.append(newFileName);
        pathStringBuilder2.append(FileUtil.SEPARATOR);
        pathStringBuilder2.append(newFileName);

        // 如果不存在就新建目录
        File realFile = new File(pathStringBuilder.toString());
        File fileParent = realFile.getParentFile();
        if(!fileParent.exists()){
         fileParent.mkdirs();
        }

        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(realFile));
            InputStream in = file.getInputStream();
            byte[] buff = new byte[2048];
            int bytesRead=0;
            while ((bytesRead=in.read(buff))>0) {
                bufferedOutputStream.write(buff, 0, bytesRead);
            }
            in.close();
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取异常:"+e.getMessage());
        }finally {

        }

        return ServerResponse.uploadBySuccess(ResponseString.UPLOAD_FILE_SUCCESS, pathStringBuilder2.toString());

    }


    // msg
    // status 0失败1成功
    // url
    public static Map<String,Object> uploadFile(MultipartFile file){
        Map<String, Object> map = new HashMap<>();

        if (null == file || file.isEmpty() ) {
            map.put("status",0);
            map.put("msg",ExceptionCons.UPLOAD_FILE_IS_EMPTY);
            return map;
        }

        String suffix = FileUtil.getSuffix( file.getOriginalFilename());
        String fileName = file.getOriginalFilename().replace(suffix,"");
        String newFileName =fileName +DateUtil.dateToStr(new Date(),DateUtil.DATENAME_FORMAT)+ suffix;
        String webProjectRootFilePath = localDir;
        StringBuilder pathStringBuilder = new StringBuilder(webProjectRootFilePath);
        StringBuilder pathStringBuilder2 = new StringBuilder(path);

        pathStringBuilder.append(FileCons.DEFAULT_UPLOAD_FILE_PATH);
        pathStringBuilder2.append(FileCons.DEFAULT_UPLOAD_FILE_PATH);

        pathStringBuilder.append(FileUtil.SEPARATOR);
        pathStringBuilder.append(newFileName);
        pathStringBuilder2.append(FileUtil.SEPARATOR);
        pathStringBuilder2.append(newFileName);

        // 如果不存在就新建目录
        File realFile = new File(pathStringBuilder.toString());
        File fileParent = realFile.getParentFile();
        if(!fileParent.exists()){
            fileParent.mkdirs();
        }

        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(realFile));
            InputStream in = file.getInputStream();
            byte[] buff = new byte[2048];
            int bytesRead=0;
            while ((bytesRead=in.read(buff))>0) {
                bufferedOutputStream.write(buff, 0, bytesRead);
            }
            in.close();
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取异常:"+e.getMessage());
        }finally {

        }
        map.put("status",1);
        map.put("url",pathStringBuilder2.toString());
        return map;
    }



    /**
     * 下载文件
     * @param response
     * @param file
     * @param newFileName
     */
    public static void downloadFile(HttpServletResponse response, File file, String newFileName) {
        try {
            //response.setContentType("application/x-download");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(newFileName.getBytes("ISO-8859-1"), "UTF-8"));
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            InputStream is = new FileInputStream(file.getAbsolutePath());
            BufferedInputStream bis = new BufferedInputStream(is);
            int length = 0;
            byte[] temp = new byte[1 * 1024 * 10];
            while ((length = bis.read(temp)) != -1) {
                bos.write(temp, 0, length);
            }
            bos.flush();
            bis.close();
            bos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    /**
     * 获取文件的后缀名
     * @param str
     * @return
     */
    public static String getSuffix(String str) {
        if(str.contains(".")) {
            String temp = str.substring(str.lastIndexOf("."));
            return temp;
        }
       return "";
    }


    /**
     * 获取文件名（去除后缀名）
     * @param fileName
     * @return
     */
    public static String getFileNameDelSuffix(String fileName) {
        String name = fileName.substring(0, fileName.lastIndexOf("."));
        return name;
    }

}
