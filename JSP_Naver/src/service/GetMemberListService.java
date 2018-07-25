package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Jdbc.JdbcUtil;
import connection.ConnectionProvider;
import dao.MemberDao;
import model.MemberInfo;

public class GetMemberListService {
	private GetMemberListService() { }
	
	private static GetMemberListService getMemberListService = new GetMemberListService();
	
	public static GetMemberListService getInsatnce() {
		return getMemberListService;
	}
	
	//xml test
	public List<MemberInfo> getList() throws ServiceException, MemberInfoNotFoundException, InvalidLoginException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			MemberDao dao = MemberDao.getInstance();
			
			List<MemberInfo> memberList = dao.selectAll(conn);
			
			return memberList;
		} catch(SQLException e) {
			throw new ServiceException("회원 정보 가져오기 실패: " +e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public MemberInfo getList(String id, String password) throws ServiceException, MemberInfoNotFoundException, InvalidLoginException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			MemberDao dao = MemberDao.getInstance();
			
			MemberInfo member = dao.select(conn, id, password);
			
			if(member == null) 
				throw new MemberInfoNotFoundException();
			
			if(!member.matchPassword(password)) 
				throw new InvalidLoginException();
			
			else
				return member;
		} catch(SQLException e) {
			throw new ServiceException("회원 정보 가져오기 실패: " +e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public int getList(String id) throws ServiceException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			MemberDao dao = MemberDao.getInstance();
			
			return dao.selectCount(conn, id);
		} catch(SQLException e) {
			throw new ServiceException("회원 정보 가져오기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}