package swings;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TableData extends AbstractTableModel{
	private List<Person> list;
	String[] items = {"Order","Date","Name","Phone Number","Activation", " Sim #","Code" ,"Days","Plan","Start Date","End Date","Note"};
	
	public TableData() throws Exception{
		ExcelList el = new ExcelList();
		list = el.getList();
	}
	
	@Override
	public String getColumnName(int cell) {
		// TODO Auto-generated method stub
		return items[cell];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}
	
	
	
	@Override
	public Object getValueAt(int row, int cell) {
		Person p = list.get(row);
		switch(cell){
		case 0:
			return p.getOrder();
		case 1:
			return p.getDate();
		case 2:
			return p.getName();
		case 3:
			return p.getPhoneNo();
		case 4:
			return p.getActCode();
		case 5:
			return p.getSimNo();
		case 6:
			return p.getCode();
		case 7:
			return p.getDays();
		case 8:
			return p.getPlan();
		case 9:
			return p.getStartDate();
		case 10:
			return p.getEndDate();
		case 11:
			return p.getNote();
		}
		return null;
	}
	
	public void refresh(){
		super.fireTableDataChanged();
	}
	
}

class ExcelList{
	private List<Person> list;
	private HSSFWorkbook wb;
	public ExcelList() throws Exception{
		wb = new HSSFWorkbook(new FileInputStream(".\\ExcelData\\excel.xls"));
		HSSFSheet sheet = wb.getSheetAt(0);
		list = new ArrayList<>();
		int maxRow = 2;
		try{
			while(true){
				sheet.getRow(maxRow).getCell(0);
				maxRow++;
			}
		}catch(Exception e){
		
		}finally{
			for(int i = 2; i<maxRow;i++){
				Person person;
				PersonBuilder pb = new PersonBuilder(new Person());
				person = pb.order((int)sheet.getRow(i).getCell(0).getNumericCellValue())
				  .date(sheet.getRow(i).getCell(1).toString())
				  .name(sheet.getRow(i).getCell(2).toString())
				  .phoneNo(sheet.getRow(i).getCell(3).toString())
				  .actCode(sheet.getRow(i).getCell(4).toString())
				  .simNo(sheet.getRow(i).getCell(5).toString())
				  .code(sheet.getRow(i).getCell(6).toString())
				  .days((int)sheet.getRow(i).getCell(7).getNumericCellValue())
				  .plan(sheet.getRow(i).getCell(8).toString())
				  .startDate(sheet.getRow(i).getCell(9).toString())
				  .endDate(sheet.getRow(i).getCell(10).toString())
				  .note(sheet.getRow(i).getCell(11).toString())
				  .person();
				list.add(person);
				  
			}
		}
	}
	
	public List<Person> getList(){
		return list;
	}
}



class Person{
	private int Order;
	private String date;
	private String name;
	private String phoneNo;
	private String actCode;
	private String simNo;
	private String code;
	private int days;
	private String plan;
	private String startDate;
	private String endDate;
	private String note;
	public int getOrder() {
		return Order;
	}
	public void setOrder(int order) {
		Order = order;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getActCode() {
		return actCode;
	}
	public void setActCode(String actCode) {
		this.actCode = actCode;
	}
	public String getSimNo() {
		return simNo;
	}
	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}

class PersonBuilder{
	private Person person;
	public PersonBuilder(Person person){
		this.person = person;
	}
	
	public PersonBuilder phoneNo(String phoneNo){
		this.person.setPhoneNo("("+phoneNo.substring(0,3)+")-"+phoneNo.substring(3,6)+"-"+phoneNo.substring(6));
		return this;
	}
	
	public PersonBuilder order(int order){ 
		this.person.setOrder(order);
		return this; 
	}
	
	public PersonBuilder date(String date){
		this.person.setDate(date);
		return this;
	}
	
	public PersonBuilder name(String name){
		this.person.setName(name);
		return this;
	}
	
	public PersonBuilder actCode(String actCode){
		this.person.setActCode(actCode);
		return this;
	}
	
	public PersonBuilder simNo(String simNo){
		this.person.setSimNo(simNo);
		return this;
	}
	
	public PersonBuilder code(String code){
		this.person.setCode(code);
		return this;
	}
	
	public PersonBuilder days(int days){
		this.person.setDays(days);
		return this;
	}
	
	public PersonBuilder startDate(String startDate){
		this.person.setStartDate(startDate);
		return this;
	}
	
	public PersonBuilder endDate(String endDate){
		this.person.setEndDate(endDate);
		return this;
	}
	
	public PersonBuilder note(String note){
		this.person.setNote(note);
		return this;
	}
	
	public PersonBuilder plan(String plan){
		this.person.setPlan(plan);
		return this;
	}
	
	public Person person(){
		return this.person;
	}
}