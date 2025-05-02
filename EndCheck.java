package orhello;

public class EndCheck {

	//終了フラグの宣言
	private boolean isEnd;
	//Boardの宣言
	private Board board;
	//Inputの宣言
	private Input input;
	//SkipCheckの宣言
	private SkipCheck skipchk;
	
	//デフォルトコンストラクタ
	public EndCheck(Board board,Input input,SkipCheck skipchk) {
		this.board = board;
		this.isEnd = false;
		this.input = input;
		this.skipchk = skipchk;
	}
	
	//終了チェック処理
	public void chk() {
		//すべての盤面の内容をfor文で取り出し
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				if(board.getStone(x, y).equals("-")) {				//盤面が何も置いていないものがあった場合
					checkBothSkip();								//両スキップではないかを判定するメソッドを呼び出し
					return;											//checkBothSkipに判定を投げてfalseのままメソッドを抜ける
				}
			}
		}
		this.isEnd = true;											//すべて埋まっていた場合終了フラグをtrueに
	}
	
	
	//両Skip判定メソッド
	public void checkBothSkip() {
		if(input.getLastWasSkip() && skipchk.getIsSkip()) {			//前回スキップされていてかつSkipCheckがtrueを返した場合、
			this.isEnd = true;										//終了フラグをtrueに
		}
	}
	
	public boolean getisEnd() {
		return this.isEnd;
	}
}
