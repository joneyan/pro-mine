package com.jone.pro.common.Excel.export;

import com.google.common.base.MoreObjects;
import com.jone.pro.common.enums.ExportEnums;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class Export2Excel {

    public static final Logger logger = Logger.getLogger(Export2Excel.class);


    public static final String COLS = "cols";  //列 keys
    public static final String CAPTIONS = "captions";  //列标题
    public static final String DATAS = "datas"; //数据列表


    /**
     * 通用 将信息写入空工作簿
     *
     * @param work
     * @param sheetName
     * @param exportData
     */
    public void creatTable(Workbook work, String sheetName, Date startDate, Date endDate,
                           Map<String, List> exportData) {


        List<String> captions = exportData.get(CAPTIONS);
        List<String> cols = exportData.get(COLS);
        List<Map<String, String>> datas = exportData.get(DATAS);

        Sheet sheet = work.createSheet(sheetName);
        sheet.autoSizeColumn(1, true);
        List<Integer> lengthList = new ArrayList<Integer>();
        int iStartRow = creatTableHead(work, sheet, startDate, endDate, captions, lengthList);
        creatTableBody(work, sheet, iStartRow, cols, datas, lengthList);

    }

    /**
     * 通用 设置表头
     *
     * @param work
     * @param sheet
     * @param captions
     * @param lengthList return  数据起始行号
     */
    public int creatTableHead(Workbook work, Sheet sheet, Date startDate, Date endDate, List<String> captions,
                              List<Integer> lengthList) {
        CellStyle hstyle = work.createCellStyle();
        hstyle.setAlignment(CellStyle.ALIGN_CENTER);
        hstyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        Row hRow = sheet.createRow(0);

        for (int i = 0; i < captions.size(); i++) {
            String caption = captions.get(i);
            Cell hCell = hRow.createCell(i);
            hCell.setCellStyle(hstyle);
            hCell.setCellValue(caption);

            sheet.setColumnWidth(i, caption.getBytes().length * 256);
            lengthList.add(caption.getBytes().length);
        }
        return 1;

    }

    /**
     * 通用 设置表体
     *
     * @param work
     * @param sheet
     * @param iStartRow    数据起始行，下标从 0 开始
     * @param cols
     * @param exportResult
     * @param lengthList
     */
    public void creatTableBody(Workbook work, Sheet sheet, int iStartRow, List<String> cols,
                               List<Map<String, String>> exportResult, List<Integer> lengthList
    ) {
        CellStyle hstyle = work.createCellStyle();
        hstyle.setAlignment(CellStyle.ALIGN_CENTER);
        hstyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        int iRow = iStartRow;
        for (Map<String, String> mapRow : exportResult) {

            Row hRow = sheet.createRow(iRow);

            for (int i = 0; i < cols.size(); i++) {
                String value = MoreObjects.firstNonNull(mapRow.get(cols.get(i)), "");

                Cell cell = hRow.createCell(i);
                cell.setCellStyle(hstyle);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(value);

                int valueSize = value.getBytes().length;
                if (valueSize > lengthList.get(i)) {
                    lengthList.set(i, valueSize);
                }
            }
            iRow++;
        }


        for (int j = 0; j < lengthList.size(); j++) {
//			sheet.setColumnWidth(j, lengthList.get(j) * 256);
            sheet.autoSizeColumn(j, true);
        }
    }


    /**
     * 导出文件 入口  处理类
     *
     * @param exportEnums
     * @param srcDatas
     * @param excelType
     * @param out
     */
    public <T> void export(ExportEnums exportEnums, Date startDate, Date endDate, List<T> srcDatas, String excelType, OutputStream out) {
        //---------------------------------------------------------------------
        logger.info("[exportExcel] 导出" + exportEnums.getRptModelName() + " begin");
        Workbook book  = new SXSSFWorkbook();

        try {
            Map<String, List> mResult = null;

            mResult = convert(srcDatas);

            creatTable(book, exportEnums.getRptModelName(), startDate, endDate, mResult);
            logger.info("[exportExcel] 导出" + exportEnums.getRptModelName() + " 创建excel完毕");

            book.write(out);
            out.flush();
            logger.info("[exportExcel] 导出" + exportEnums.getRptModelName() + " 导出成功");
        } catch (IOException e) {
            logger.info("[exportExcel] 导出" + exportEnums.getRptModelName() + " 导出异常", e);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                logger.error(e);
            }
        }
        logger.info("[exportExcel] 导出" + exportEnums.getRptModelName() + " end");
        //---------------------------------------------------------------------
    }


    /**
     *
     * @param srcDatas
     * @return
     */
    public abstract <T> Map<String, List> convert(List<T> srcDatas);

}
