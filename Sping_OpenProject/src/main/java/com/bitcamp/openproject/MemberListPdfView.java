package com.bitcamp.openproject;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.bitcamp.model.MemberInfoView;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

@SuppressWarnings("deprecation")
public class MemberListPdfView extends AbstractPdfView {
	@Override
	protected void buildPdfDocument(Map<String,Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MemberInfoView> memberList = (List<MemberInfoView>) model.get("memberList");
		
		Table table = new Table(8, memberList.size() + 1);
		table.setPadding(5);
		
		BaseFont bf = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bf);
		
		Cell cell = new Cell(new Paragraph("회원 ID", font));
		cell.setHeader(true);
		
		table.addCell(cell);
		cell = new Cell(new Paragraph("비밀번호", font));
		
		table.addCell(cell);
		cell = new Cell(new Paragraph("이름", font));
		
		table.addCell(cell);
		cell = new Cell(new Paragraph("생년월일", font));
		
		table.addCell(cell);
		cell = new Cell(new Paragraph("성별", font));
		
		table.addCell(cell);
		cell = new Cell(new Paragraph("이메일", font));
		
		table.addCell(cell);
		cell = new Cell(new Paragraph("휴대전화", font));
		
		table.addCell(cell);
		cell = new Cell(new Paragraph("회원 사진", font));
		
		table.addCell(cell);
		table.endHeaders();
		
		for(MemberInfoView member : memberList) {
			table.addCell(new Cell(member.getId()));
			table.addCell(new Cell(member.getPassword()));
			table.addCell(new Cell(member.getName()));
			table.addCell(new Cell(member.getBirthdate()));
			table.addCell(new Cell(member.getGender()));
			table.addCell(new Cell(member.getEmail()));
			table.addCell(new Cell(member.getPhone()));
			table.addCell(new Cell(member.getPhotoName()));
		}
		document.add(table);
	}
}