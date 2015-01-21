package com.AFK.travel56.dao;

public class ArticlePagingVO {

	private boolean PrevPage;
	private boolean NextPage;
	private int nowPage;
	private int rowTotal;
	private int blockList;
	private int blockSize;
	private int blockPage;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;

	public ArticlePagingVO(int nowPage, int rowTotal, int blockList,
			int blockPage, int blockSize) {
		super();

		// 각종 플래그를 초기화
		PrevPage = false;
		NextPage = false;

		// 입력된 전체 열의 수를 통해 전체 페이지 수를 계산한다
		this.totalPage = (int) Math
				.ceil((double) rowTotal / (double) blockList);

		// 현재 페이지가 전체 페이지수보다 클경우 전체 페이지수로 강제로 조정한다
		if (nowPage > this.totalPage) {
			nowPage = this.totalPage;
		}

		// DB입력을 위한 시작과 종료값을 구한다
		this.startRow = (int) (nowPage - 1) * blockList;
		this.endRow = (int) this.startRow + blockList - 1;

		// 시작페이지와 종료페이지의 값을 구한다
		this.startPage = (int) ((nowPage - 1) / blockPage) * blockPage + 1;
		this.endPage = (int) this.startPage + blockPage - 1;

		// 마지막 페이지값이 전체 페이지값보다 클 경우 강제 조정
		if (this.endPage > this.totalPage) {
			this.endPage = totalPage;
		}

		// 시작 페이지가 1보다 클 경우 이전 페이징이 가능한것으로 간주한다
		if (this.startPage > 1) {
			this.PrevPage = true;
		}

		// 종료페이지가 전체페이지보다 작을경우 다음 페이징이 가능한것으로 간주한다
		if (this.endPage < this.totalPage) {
			this.NextPage = true;
		}

		// 기타 값을 저장한다
		this.nowPage = nowPage;
		this.rowTotal = rowTotal;
		this.blockList = blockList;
		this.blockPage = blockPage;
		this.blockSize = blockSize;
	}

	public void Debug() {
		System.out.println("Total Page : " + this.totalPage
				+ " / Start Page : " + this.startPage + " / End Page : "
				+ this.endPage);
		System.out.println("Total Row : " + this.rowTotal + " / Start Row : "
				+ this.startRow + " / End Row : " + this.endRow);
	}

	public boolean isPrevPage() {
		return PrevPage;
	}

	public void setPrevPage(boolean prevPage) {
		PrevPage = prevPage;
	}

	public boolean isNextPage() {
		return NextPage;
	}

	public void setNextPage(boolean nextPage) {
		NextPage = nextPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getRowTotal() {
		return rowTotal;
	}

	public void setRowTotal(int rowTotal) {
		this.rowTotal = rowTotal;
	}

	public int getBlockList() {
		return blockList;
	}

	public void setBlockList(int blockList) {
		this.blockList = blockList;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
}
