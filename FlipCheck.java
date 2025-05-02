package orhello;

public class FlipCheck {
	//flipstoneの宣言
	private Flipstone flip;
	//ひっくり返されたかのフラグを宣言
	private boolean isflipped = false;
	
	//デフォルトコンストラクタ
	public FlipCheck(Flipstone flip) {
		this.flip = flip;
	}
	
	//全方向でひっくり返ったのか確認
	public void flipchk() {
		this.isflipped = flip.getFlipcount() > 0;
	}
	
	public boolean getIsFlipped() {
		return this.isflipped;
	}
	
}
