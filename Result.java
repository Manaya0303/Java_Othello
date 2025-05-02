package orhello;

public class Result {
	
	//白のカウント用変数
	private int W = 0;
	//黒のカウント用変数
	private int B = 0;
	
	//デフォルトコンストラクタ
	public Result() {
		//初期化のみ
	}
	
	//集計メソッド
	public void count(Board board) {					//全盤面の内容をそれぞれの変数に格納してカウント
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				String stone = board.getStone(x, y);
				if(stone.equals("●")) {
					this.B++;
				}else if(stone.equals("○")) {
					this.W++;
				}
			}
		}
		
		System.out.println("黒：" + this.B);
		System.out.println("白：" + this.W);
		
		if(this.B > this.W) {
			System.out.println("黒の勝利です！");
		}else if(this.B < this.W) {
			System.out.println("白の勝利です！");
		}else if(this.B == this.W) {
			System.out.println("引き分け！");
		}
		
		//リセット
		this.B = 0;
		this.W = 0;
	}
}
