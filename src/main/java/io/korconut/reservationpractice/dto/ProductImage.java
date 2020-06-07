package io.korconut.reservationpractice.dto;

import java.util.Date;

public class ProductImage extends fileInfo {
	private int productId;
    private int productImageId;
    private ImageType type;
    
    enum ImageType {
    	ma, th, et 
    }
    
    
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductImageId() {
		return productImageId;
	}
	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}
	public ImageType getType() {
		return type;
	}
	public void setType(ImageType type) {
		this.type = type;
	}
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return super.getContentType();
	}
	@Override
	public void setContentType(String contentType) {
		// TODO Auto-generated method stub
		super.setContentType(contentType);
	}
	@Override
	public Date getCreateDate() {
		// TODO Auto-generated method stub
		return super.getCreateDate();
	}
	@Override
	public void setCreateDate(Date createDate) {
		// TODO Auto-generated method stub
		super.setCreateDate(createDate);
	}
	@Override
	public boolean isDeleteFlag() {
		// TODO Auto-generated method stub
		return super.isDeleteFlag();
	}
	@Override
	public void setDeleteFlag(boolean deleteFlag) {
		// TODO Auto-generated method stub
		super.setDeleteFlag(deleteFlag);
	}
	@Override
	public int getFileId() {
		// TODO Auto-generated method stub
		return super.getFileId();
	}
	@Override
	public void setFileId(int fileId) {
		// TODO Auto-generated method stub
		super.setFileId(fileId);
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return super.getFileName();
	}
	@Override
	public void setFileName(String fileName) {
		// TODO Auto-generated method stub
		super.setFileName(fileName);
	}
	@Override
	public Date getModifyDate() {
		// TODO Auto-generated method stub
		return super.getModifyDate();
	}
	@Override
	public void setModifyDate(Date modifyDate) {
		// TODO Auto-generated method stub
		super.setModifyDate(modifyDate);
	}
	@Override
	public String getSaveFileName() {
		// TODO Auto-generated method stub
		return super.getSaveFileName();
	}
	@Override
	public void setSaveFileName(String saveFileName) {
		// TODO Auto-generated method stub
		super.setSaveFileName(saveFileName);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public String toString() {
		return super.toString() + "ProductImage [productId=" + productId + ", productImageId=" + productImageId + ", type=" + type + "]";
	}
}
