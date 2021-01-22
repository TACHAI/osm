package com.chaoxing.osm.utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName ExcelUtils
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-06-16 13:39
 */
public class ExcelUtils {

    public static List readFileData(Workbook wb, String[] head){
        Sheet sheet = wb.getSheetAt(0);
        Row titleRow = sheet.getRow(0);

        int rowNum = sheet.getPhysicalNumberOfRows();
        int cellNum = titleRow.getPhysicalNumberOfCells();

        List resultList = new ArrayList();

        for(int i=1;i<=rowNum; i++){
            Row row = sheet.getRow(i);
            if(row!=null){
                Map map = new HashMap<>();
                for(int j=0;j<cellNum;j++){
                    Cell cell = row.getCell(j);
                    String key = head [j];
                    cell.setCellType(CellType.STRING);
                    String cellValue = cell.getStringCellValue();
                    map.put(key,cellValue);
                }
                resultList.add(map);
            }
        }
        return resultList;
    }


    /**
     * 判断数据类型
     * @param cell
     * @return
     */
    private static  String getStringCellValue(Cell cell) {

        String  cellValue ="";

        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    cellValue = "";
                    break;
                case NUMERIC: // 数字
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        cellValue = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                        break;
                    }
                    DecimalFormat df = new DecimalFormat("#");
                    cellValue =df.format(Double.valueOf(cell.getNumericCellValue()));
                    break;
                default:
                    cellValue = "";
                    break;
            }

        }else {
            cellValue = "";
        }

        return cellValue;
    }
}
