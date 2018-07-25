package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Jdbc.JdbcUtil;
import model.BoardInfo;
import model.MemberInfo;

public class MemberDao {
	private MemberDao() { }
	
	private static MemberDao memberDao = new MemberDao();
	
	public static MemberDao getInstance() {
		return memberDao;
	}
	
	public int insert(Connection conn, MemberInfo memberInfo) throws SQLException {
		PreparedStatement pstmt = null;
		
		String sql = "insert into member (id, password, name, birthdate, gender, email, phone, photo) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPassword());
			pstmt.setString(3, memberInfo.getName());
			pstmt.setString(4, memberInfo.getYear() + "-" + memberInfo.getMonth() + "-" + memberInfo.getDay());
			pstmt.setString(5, memberInfo.getGender());
			pstmt.setString(6, memberInfo.getEmail());
			pstmt.setString(7, memberInfo.getPhone());
			pstmt.setString(8, memberInfo.getPhoto());
			
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public MemberInfo select(Connection conn, String id, String password) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select id, password, name, to_char(birthdate, 'YYYY-MM-DD') birthdate, gender, email, substr(phone, 1,3) || '-'  || substr(phone, 4,4) || '-'  || substr(phone, 8,4) phone, photo from member where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
				return memberInfoResultSet(rs);
			else 
				return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	//xml test
	public List<MemberInfo> selectAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberInfo> memberList = new ArrayList<MemberInfo>();
		
		String sql = "select id, password, name, to_char(birthdate, 'YYYY-MM-DD') birthdate, gender, email, substr(phone, 1,3) || '-'  || substr(phone, 4,4) || '-'  || substr(phone, 8,4) phone, photo from member";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					memberList.add(memberInfoResultSet(rs));
				} while(rs.next());
				
				return memberList;
			}
			else 
				return Collections.emptyList();
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public int selectCount(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from member where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private MemberInfo memberInfoResultSet(ResultSet rs) throws SQLException {
		MemberInfo memberInfo = new MemberInfo();
		
		memberInfo.setId(rs.getString(1));
		memberInfo.setPassword(rs.getString(2));
		memberInfo.setName(rs.getString(3));
		memberInfo.setGender(rs.getString(5));
		memberInfo.setEmail(rs.getString(6));
		memberInfo.setPhone(rs.getString(7));
		memberInfo.setPhoto(rs.getString(8));
		
		String birthdate = rs.getString(4);
		
		String split[] = birthdate.split("-");
		
		memberInfo.setYear(split[0]);
		memberInfo.setMonth(split[1]);
		memberInfo.setDay(split[2]);
		
		return memberInfo;
	}
}