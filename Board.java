package orhello;

public class Board {
	
	//8×8のボードを多次元配列で作成
	private String[][] Board = new String[8][8];
	
	//デフォルトコンストラクタで新規盤面を作成
	public Board() {
		MakeNewBoard();
	}
	
	//ボードの初期設定
	public void MakeNewBoard() {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				this.Board[x][y] = "-";
			}
		}
		
		//初期配置を反映
		this.Board[3][4] = "○";
		this.Board[4][3] = "○";
		this.Board[3][3] = "●";
		this.Board[4][4] = "●";
	}
	
	//ボードの出力
	public void output() {
		System.out.println("Y↓| 0 1 2 3 4 5 6 7 ←X");
		for(int x = 0; x < 8; x++) {
			System.out.print(x + " |");
			for(int y = 0; y < 8; y++) {
					System.out.print(" " + this.Board[x][y]);
			}
			System.out.print(" |");
			System.out.println();
		}
	}
	
	
	public void setStone(int x,int y,String player) {
		this.Board[x][y] = player;
	}
	
	public String getStone(int x,int y) {
		return this.Board[x][y];
	}
}
