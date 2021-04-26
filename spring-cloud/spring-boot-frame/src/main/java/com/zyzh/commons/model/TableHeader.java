package com.zyzh.commons.model;

public class TableHeader {
	
	private String name;
	
	private int beginRow;
	private int endRow;
	private int beginCol;
	private int endCol;
	
	public TableHeader(String name, int beginRow, int endRow, int beginCol, int endCol){
		this.name = name;
		this.beginRow = beginRow;
		this.endRow = endRow;
		this.beginCol = beginCol;
		this.endCol = endCol;
	}
	
	public int getBeginRow() {
		return beginRow;
	}
	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getBeginCol() {
		return beginCol;
	}
	public void setBeginCol(int beginCol) {
		this.beginCol = beginCol;
	}
	public int getEndCol() {
		return endCol;
	}
	public void setEndCol(int endCol) {
		this.endCol = endCol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
