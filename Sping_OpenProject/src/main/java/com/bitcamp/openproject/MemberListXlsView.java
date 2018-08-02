package com.bitcamp.openproject;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.bitcamp.model.MemberInfoView;

@SuppressWarnings("deprecation")
public class MemberListXlsView extends AbstractExcelView {
	@Override
	protected void buildExcelDocument(Map<String,Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HSSFSheet sheet = createFirstSheet(workbook);
		createColumnLable(sheet);
		
		List<MemberInfoView> memberList = (List<MemberInfoView>) model.get("memberList");
		
		int rowNum = 1;
		
		for(MemberInfoView member : memberList)
			createPageMemberRow(sheet, member, rowNum++);
	}
	
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "회원 리스트");
		sheet.setColumnWidth(1, 256*20);
		
		return sheet;
	}
	
	private void createColumnLable(HSSFSheet sheet) {
		HSSFRow firstRow = sheet.createRow(0);
		HSSFCell cell = firstRow.createCell(0);
		cell.setCellValue("회원 ID");
		
		cell = firstRow.createCell(1);
		cell.setCellValue("비밀번호");
		
		cell = firstRow.createCell(2);
		cell.setCellValue("이름");
		
		cell = firstRow.createCell(3);
		cell.setCellValue("생년월일");
		
		cell = firstRow.createCell(4);
		cell.setCellValue("성별");
		
		cell = firstRow.createCell(5);
		cell.setCellValue("이메일");
		
		cell = firstRow.createCell(6);
		cell.setCellValue("휴대전화");
		
		cell = firstRow.createCell(7);
		cell.setCellValue("회원 사진");
	}
	
	private void createPageMemberRow(HSSFSheet sheet, MemberInfoView memberInfoView, int rowNum) {
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(memberInfoView.getId());
		
		cell = row.createCell(1);
		cell.setCellValue(memberInfoView.getPassword());
		
		cell = row.createCell(2);
		cell.setCellValue(memberInfoView.getName());
		
		cell = row.createCell(3);
		cell.setCellValue(memberInfoView.getBirthdate());
		
		cell = row.createCell(4);
		cell.setCellValue(memberInfoView.getGender());
		
		cell = row.createCell(5);
		cell.setCellValue(memberInfoView.getEmail());
		
		cell = row.createCell(6);
		cell.setCellValue(memberInfoView.getPhone());
		
		cell = row.createCell(7);
		cell.setCellValue(memberInfoView.getPhotoName());
	}
}