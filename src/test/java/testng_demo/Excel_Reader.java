package testng_demo;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Arrays;

public class Excel_Reader {


    public static Object[][] getdata(String filePath, String sheetname) throws IOException {

        ;

        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetname);

        int rowCount = sheet.getPhysicalNumberOfRows() - 1;       // data rows = last index
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1);  // skip header
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);

                // Safer for different cell types
                data[i][j] = cell.toString();
            }
        }
        workbook.close();
        fis.close();
        return data;
    }

    @DataProvider(name = "exceldata")
    public Object[][] excelDataprovider() throws IOException {


        String filePath = "C:\\Users\\Administrator\\IdeaProjects\\Weekendmaven1230\\src\\test\\resources\\data.xlsx";
        String sheetName = "Sheet1";

        Object[][] data = getdata(filePath, sheetName);
        System.out.println(Arrays.deepToString(data));

        String username = data[0][0].toString();
        String password = data[0][1].toString();

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        return getdata(filePath, sheetName);


    }

}