package service;

import java.util.List;

import model.BoardInfo;

public class BoardListView {
	private int boardTotalCount;
	private int currentPageNumber;
	private List<BoardInfo> boardList;
	private int pageTotalCount;
	private int boardCountPerPage;
	private int firstRow;
	private int endRow;
	
	public BoardListView(int boardTotalCount, int currentPageNumber, List<BoardInfo> boardList, int boardCountPerPage, int firstRow, int endRow) {
		super();
		this.boardTotalCount = boardTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.boardList = boardList;
		this.boardCountPerPage = boardCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calculatePageTotalCount();
	}

	private void calculatePageTotalCount() {
		if(boardTotalCount == 0)
			pageTotalCount = 0;
		
		else {
			pageTotalCount = boardTotalCount / boardCountPerPage;
			
			if(boardTotalCount % boardCountPerPage > 0)
				pageTotalCount++;
		}
	}

	public int getBoardTotalCount() {
		return boardTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<BoardInfo> getBoardList() {
		return boardList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getBoardCountPerPage() {
		return boardCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}
	
	public boolean isEmpty() {
		return boardTotalCount == 0;
	}
}