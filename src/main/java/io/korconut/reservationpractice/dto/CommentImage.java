package io.korconut.reservationpractice.dto;

import java.util.Date;

public class CommentImage extends fileInfo {
	
	private int reservationInfoId;
	private int reservationUserCommentId;
	private int reservationUserCommentImageId;
	
	
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	public int getReservationUserCommentId() {
		return reservationUserCommentId;
	}
	public void setReservationUserCommentId(int reservationUserCommentId) {
		this.reservationUserCommentId = reservationUserCommentId;
	}
	public int getReservationUserCommentImageId() {
		return reservationUserCommentImageId;
	}
	public void setReservationUserCommentImageId(int reservationUserCommentImageId) {
		this.reservationUserCommentImageId = reservationUserCommentImageId;
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
	public String toString() {
		return super.toString() + "CommentImage [reservationInfoId=" + reservationInfoId + ", reservationUserCommentId="
				+ reservationUserCommentId + ", reservationUserCommentImageId=" + reservationUserCommentImageId + "]";
	}

	/**
	 * 음 선 query처리를 해줘야 하는데, 이건 data자체가 그렇게 들어올 경우에 처리하는 방법, 만일 query문 자체에서 json으로 들어오게 된다면 이렇게 쓸수 있다는거겠지. 
	 * 아니면 jstl에서?
	 * @param contentType
	 * @param createDate
	 * @param deleteFlag
	 * @param fileId
	 * @param fileName
	 * @param reservationUserCommentImageId
	 * @param modifyDate
	 * @param reservationInfoId
	 * @param reservationUserCommentId
	 * @param saveFileName
	 
	@JsonCreator
	public CommentImage( @JsonProperty("contentType") String contentType, @JsonProperty("createDate") Date createDate,
			@JsonProperty("deleteFlag") boolean deleteFlag, @JsonProperty("fileId") int fileId,
			@JsonProperty("fileName")String fileName, @JsonProperty("reservationUserCommentImageId") int reservationUserCommentImageId,
			@JsonProperty("modifyDate") Date modifyDate, @JsonProperty("reservationInfoId") int reservationInfoId,
			@JsonProperty("reservationUserCommentId") int reservationUserCommentId, @JsonProperty("saveFileName") String saveFileName) {
		
		this.contentType = contentType;
		this.createDate = createDate;
		this.deleteFlag = deleteFlag;
		this.fileId = fileId;
		this.fileName = fileName;
		this.reservationUserCommentImageId = reservationUserCommentImageId;
		this.modifyDate = modifyDate;
		this.reservationInfoId = reservationInfoId;
		this.reservationUserCommentId = reservationUserCommentId;
		this.saveFileName = saveFileName;
		
	}
	*/
	

}
