package com.yxkj.yqcp.bean;

import java.util.List;

public class AwardBean {
	private String code;
	public List<AwardCls> data;
	private String msg;
	private String stamp;
	private String success;
	
	public class AwardCls{
		private String issueId;
		private String winNumber;
		private String orderNumber;
		private String issue;
		private String endTime;
		private String lotteryName;
		private String lotteryId;
		private String getIssueId() {
			return issueId;
		}
		public void setIssueId(String issueId) {
			this.issueId = issueId;
		}
		public String getWinNumber() {
			return winNumber;
		}
		public void setWinNumber(String winNumber) {
			this.winNumber = winNumber;
		}
		public String getOrderNumber() {
			return orderNumber;
		}
		public void setOrderNumber(String orderNumber) {
			this.orderNumber = orderNumber;
		}
		public String getIssue() {
			return issue;
		}
		public void setIssue(String issue) {
			this.issue = issue;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		public String getLotteryName() {
			System.out.println(lotteryName+"opopopop");
			return lotteryName;
		}
		public void setLotteryName(String lotteryName) {
			this.lotteryName = lotteryName;
		}
		public String getLotteryId() {
			return lotteryId;
		}
		public void setLotteryId(String lotteryId) {
			this.lotteryId = lotteryId;
		}
}
	
	
	
	

}
