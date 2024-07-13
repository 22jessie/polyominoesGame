package model;

public class BoardCleanerThread extends Thread implements Constants{
	private Board board;
	private boolean checkRows;
	
	
	public BoardCleanerThread(Board board) {
		this.board=board;
		checkRows=false;
	}
	
	public void run() {
		int i;
		int j;
		
		while(true) {
			if(checkRows) {
				for(i=ROWS-1; i>=0; i--) {
					j=0;
					while(j<COLUMNS && !board.tileIsEmpty(i,j)) {
						j++;
					}
					if(j>=COLUMNS) {
						cleanRow(i);
					}
				}
				checkRows=false;
			}
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void cleanRow(int row) {
		int c;
		
		synchronized(board) {
			if(row==0) {
				for(c=0; c<COLUMNS;c++) {
					board.cleanTile(row, c);
				}
			}else {
				for(int i=row;i>0;i--) {
					for(c=0; c<COLUMNS;c++) {
						board.overwriteTile(i,c,i-1,c);
					}
				}
			}
		}
	}

	public void lookForFullRows() {
		checkRows=true;
	}
	
	

}
