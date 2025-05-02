package orhello;

public class SkipCheck {
	//boardの宣言
	private Board board;
	//flip判定クラスの宣言
	private Canflip chk;
	//スキップフラグの宣言
	private boolean isSkip;
	
	//デフォルトコンストラクタでそれぞれの変数に設定
	public SkipCheck(Board board, Player player) {
		this.board = board;
		this.chk = new Canflip(board,player);
		this.isSkip = false;
	}
	
	public void Chk() {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				if(board.getStone(x, y).equals("-")) {			//ボードから受け取った場所に何も置かれていなければ処理に進む
					
					//各判定メソッドを呼び出し
					chk.canflipdown(x, y);
					chk.canflipleft(x, y);
					chk.canflipleftdown(x, y);
					chk.canflipleftup(x, y);
					chk.canflipright(x, y);
					chk.canfliprightdown(x, y);
					chk.canfliprightup(x, y);
					chk.canflipup(x, y);
				}
			}
		}
		this.isSkip = chk.getCanflipcount() == 0;				//getterでカウントがゼロだった場合にスキップフラグをtrueに
		chk.setCanflipcount(0);									//カウントをリセット
	}
	
	public boolean getIsSkip() {
		return isSkip;
	}
	
	public void reset() {
		this.isSkip = false;
	}

}
