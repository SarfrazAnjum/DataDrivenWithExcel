import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadData {
  public Object[][] getData(String excelPath, String sheetName){
      ReadExcel excel = new ReadExcel(excelPath, sheetName);
      int rows = excel.getRowCount();
      int cols = excel.getColCount();
      Object[][] data = new Object[rows-1][cols];
      for (int i = 1; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
              Object testData = excel.getCellValue(i,j);
              data[i-1][j] = testData;

          }

      }
      return data;
  }

  @DataProvider(name="testData")
    public Object[][] getTestData(){
      String excelPath = "data/usersOne.xlsx";
      String sheetName = "Sheet1";

      return getData(excelPath, sheetName);
  }

  @Test(dataProvider = "testData")
  public void loginTest(Object a, Object b){
      System.out.println( a +" | "+b);

  }
}
