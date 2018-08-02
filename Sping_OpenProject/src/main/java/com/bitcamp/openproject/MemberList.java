package com.bitcamp.openproject;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bitcamp.model.MemberInfoView;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="members")
public class MemberList {
	
	@XmlElement(name="member")
	private List<MemberInfoView> memberList;
	
	public MemberList() { }

	public MemberList(List<MemberInfoView> memberList) {
		super();
		this.memberList = memberList;
	}

	public List<MemberInfoView> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberInfoView> memberList) {
		this.memberList = memberList;
	}
}