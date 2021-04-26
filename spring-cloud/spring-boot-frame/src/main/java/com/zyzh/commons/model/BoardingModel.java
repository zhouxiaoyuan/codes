package com.zyzh.commons.model;


public class BoardingModel {

	private String boarding;
	private String name;
	private String flightNo;
	private String boardingDate;
	private String seatNo;
	private String departure;
	private String checkinNumber;
	private boolean boardingPass;
	private String message;
	
	public String getBoarding() {
		return boarding;
	}
	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getBoardingDate() {
		return boardingDate;
	}
	public void setBoardingDate(String boardingDate) {
		this.boardingDate = boardingDate;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getCheckinNumber() {
		return checkinNumber;
	}
	public void setCheckinNumber(String checkinNumber) {
		this.checkinNumber = checkinNumber;
	}
	public boolean isBoardingPass() {
		return boardingPass;
	}
	public void setBoardingPass(boolean boardingPass) {
		this.boardingPass = boardingPass;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "BoardingModel [boarding=" + boarding + ", name=" + name
				+ ", flightNo=" + flightNo + ", boardingDate=" + boardingDate
				+ ", seatNo=" + seatNo + ", departure=" + departure
				+ ", checkinNumber=" + checkinNumber + ", boardingPass="
				+ boardingPass + ", message=" + message + "]";
	}
}
