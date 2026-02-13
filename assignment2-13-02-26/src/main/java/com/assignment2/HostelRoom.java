package com.assignment2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HostelRoom {
	@Id
	private int roomId;
	private int roomNo;
	private String blockName;
	private int floorNumber;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	@Override
	public String toString() {
		return "HostelRoom [roomId=" + roomId + ", roomNo=" + roomNo + ", blockName=" + blockName + ", floorNumber="
				+ floorNumber + "]";
	}
	

}
