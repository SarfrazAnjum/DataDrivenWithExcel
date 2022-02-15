import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadExcel {
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ReadExcel(String excelPath, String sheetName) {
        try {
            this.workbook = new XSSFWorkbook(excelPath);
            this.sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getRowCount(){
        int rowCount = 0;
        try {
            rowCount = sheet.getPhysicalNumberOfRows();
        }catch (Exception exp){
            System.out.println(exp.getMessage());
        }
        return rowCount;
    }

    public int getColCount(){
        int colCount = 0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        }catch(Exception exp){
            System.out.println(exp.getMessage());
        }
        return colCount;
    }

    public void getCellData(){
        try {
            int rowCount = getRowCount();
            int colCount = getColCount();
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rowCount-1; i++) {
                for (int j = 0; j < colCount; j++) {
                    Object cellValue = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                    System.out.println("cellValue = " + cellValue);

                }
                System.out.println();
            }
        }catch (Exception exp){
            System.out.println(exp.getMessage());
        }

    }
    public Object getCellValue(int rowNum, int colNum){
        Object cellValue = null;
        try{
        DataFormatter formatter = new DataFormatter();
        cellValue = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
    }catch(Exception exp){
            System.out.println(exp.getMessage());
        }
        return cellValue;
    }

//    public static void main(String[] args) {
//        String excelPath = "data/users.xlsx";
//        String sheetName = "credentials";
//        ReadExcel excel = new ReadExcel(excelPath, sheetName);
//        excel.getCellData();
//    }
}
