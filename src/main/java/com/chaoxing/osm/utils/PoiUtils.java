package com.chaoxing.osm.utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

import java.io.*;

/**
 * @ClassName PoiUtils
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-06-12 14:33
 */
public class PoiUtils {
    /**
     * 生成Excel文件
     * @param workbook
     * @param fileName
     * @return
     */
    public static File createExcelFile(Workbook workbook, String fileName) {
        OutputStream stream = null;
        File file = null;
        try {
            //用了createTempFile，这是创建临时文件，系统会自动给你的临时文件编号，所以后面有号码，你用createNewFile的话就完全按照你指定的名称来了
            file = File.createTempFile("111", ".xlsx");
            stream = new FileOutputStream(file.getAbsoluteFile());
            workbook.write(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //这里调用了IO工具包控制开关
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(stream);
        }
        return file;
    }
}
