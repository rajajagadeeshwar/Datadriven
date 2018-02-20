package datadrivenwithexcel;

/**
 * @author jagadeeshwar
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutil {
	XSSFWorkbook wb;
	XSSFSheet sh;
	FileInputStream fis;

	public Excelutil(String path) {
		try {
			File src = new File(path);

			fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public String readingdata(int i, int row, int column) {

		sh = wb.getSheetAt(i);
		String data = sh.getRow(row).getCell(column).getStringCellValue();

		return data;

	}

	public int getrowcount(int sheetindex) {

		int row = wb.getSheetAt(sheetindex).getLastRowNum();

		row = row + 1;
		return row;

	}

}
