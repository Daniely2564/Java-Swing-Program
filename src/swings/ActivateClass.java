package swings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;

public class ActivateClass {
	
	private String name;
	private String phoneNo;
	private String actCode;
	private int days;
	private int plan;
	private String simNo;
	private String desc;
	private String note;
	
	


	public ActivateClass(String name, String phoneNo, String actCode, int days, int plan, String simNo, String desc,
			String note) throws Exception{
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.actCode = actCode;
		this.days = days;
		this.plan = plan;
		this.simNo = simNo;
		this.desc = desc;
		this.note = note;
		this.add();
	}

	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
	}

	public void add() throws FileNotFoundException, IOException {
		File file = new File("ExcelData");
		if(!file.isDirectory()){
			file.mkdir();
		}
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("ExcelData/excel.xls"),true);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int index = 0;
		// this finds the very first row where I can insert numbers
		while(true){
			try{
				sheet.getRow(index).getCell(0);
			}catch(NullPointerException e){
				break;
			}
			index++;
		}
		//this finds the very last number so that I can add new Customer to the next Row
		int order = (int)sheet.getRow(index-1).getCell(0).getNumericCellValue()+1;
		//Input data
		{
		HSSFRow row = sheet.createRow(index);
		row.createCell(0).setCellValue(order);
		DataFormat format = workbook.createDataFormat();
		CellStyle dateStyle = workbook.createCellStyle();
		dateStyle.setDataFormat(format.getFormat("mm/dd"));
		row.createCell(1).setCellStyle(dateStyle);
		row.getCell(1).setCellValue(new Date());
		CellStyle dollar = workbook.createCellStyle();
		row.createCell(2).setCellValue(name);
		row.createCell(3).setCellValue(phoneNo);
		row.createCell(4).setCellValue(desc);
		row.createCell(5).setCellValue(simNo);
		row.createCell(6).setCellValue(actCode);
		row.createCell(7).setCellValue(days);
		row.createCell(8).setCellValue("$"+plan);
		row.createCell(9).setCellStyle(dateStyle);
		row.getCell(9).setCellValue(new Date());
		row.createCell(10).setCellStyle(dateStyle);
		Date newDate = addDays(new Date(),days-1);
		row.getCell(10).setCellValue(newDate);
		row.createCell(11).setCellValue(note);
		
		sheet.autoSizeColumn(1); 
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		sheet.autoSizeColumn(6);
		sheet.autoSizeColumn(7);
		}
		
		workbook.write(new FileOutputStream("ExcelData/excel.xls"));
		workbook.close();
		
	}
}
