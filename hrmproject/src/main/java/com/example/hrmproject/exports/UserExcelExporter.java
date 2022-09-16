package com.example.hrmproject.exports;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.hrmproject.model.DemoEmployee;

public class UserExcelExporter {
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet xssfSheet;
    private List<DemoEmployee> lEmployees;
    
    public UserExcelExporter(List<DemoEmployee> lEmployees) {
        this.lEmployees = lEmployees;
        xssfWorkbook = new XSSFWorkbook();
    }
    
    private void createCell(Row row, int columnCount, Object value, CellStyle style){
        xssfSheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if(value instanceof Integer){
            cell.setCellValue((Integer) value);
        }else if (value instanceof Boolean){
            cell.setCellValue((Boolean) value);
        }else{
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeHeaderLine(){
        xssfSheet = xssfWorkbook.createSheet("Demo Employee");
        Row row = xssfSheet.createRow(0);
        CellStyle cellStyle = xssfWorkbook.createCellStyle();
        XSSFFont xssfFont = xssfWorkbook.createFont();
        xssfFont.setBold(true);
        xssfFont.setFontHeight(16);
        cellStyle.setFont(xssfFont);

        createCell(row, 0, "Employee ID", cellStyle);
        createCell(row, 1, "Employee Name", cellStyle);
    }

    private void writeDataLines(){
        int rowCount = 1;

        CellStyle cellStyle = xssfWorkbook.createCellStyle();
        XSSFFont font = xssfWorkbook.createFont();
        font.setFontHeight(14);
        cellStyle.setFont(font);

        for(DemoEmployee demoEmployee: lEmployees){
            Row row = xssfSheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, demoEmployee.getId(), cellStyle);
            createCell(row, columnCount++, demoEmployee.getName(), cellStyle);
        }
    }

    public void export(HttpServletResponse response) throws IOException{
        writeHeaderLine();
        writeDataLines();
        
        ServletOutputStream sos = response.getOutputStream();
        xssfWorkbook.write(sos);
        xssfWorkbook.close();

        sos.close();
    }
}
