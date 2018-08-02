package com.bitcamp.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.dao.MemberDaoInterface;
import com.bitcamp.dao.MyBatisMemberDao;
import com.bitcamp.model.MemberInfo;


public class RegisterService {
/*	@Autowired
	JdbcTemplateMemberDao memberDao;*/
	
	@Autowired
	MyBatisMemberDao memberDao;
	
/*	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDaoInterface memberDao;*/

	//@Transactional //이 안에서 실행되는 트랜잭션처리가 서버에 적용되지 않도록
	public int register(MemberInfo memberInfo, HttpServletRequest request) throws Exception {
		//memberDao = template.getMapper(MemberDaoInterface.class);
		//int result = 0;
		//Connection conn = null;
		
		//저장용 파일 이름, 물리적 저장, DB 저장용
		String imgName = "";
		
		/* 물리적 저장 */
		
		//1. 저장 경로 설정
		String uploadUri = "/uploadFile/memberPhoto";
		
		//2. 시스템의 물리적인 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);
		System.out.println(dir);
		
		//사용자의 업로드 파일 물리적으로 저장
		if(!memberInfo.getPhoto().isEmpty()) {
			//imgName = System.currentTimeMillis() + memberInfo.getPhoto().getOriginalFilename();
			imgName = memberInfo.getId() + "_" + memberInfo.getPhoto().getOriginalFilename();
		
			//저장
			memberInfo.getPhoto().transferTo(new File(dir, imgName));
			
			//DB에 저장할 파일 이름을 set
			memberInfo.setPhotoName(imgName);
		}

/*		System.out.println("입력 전 value : " + memberInfo.getmIdx());
		result = memberDao.insert(memberInfo);
		System.out.println("입력 후 value : " + memberInfo.getmIdx());
		return result;*/
		return memberDao.insert(memberInfo);
	}
}