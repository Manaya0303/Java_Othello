package orhello;

public class Player {
	//現在のプレイヤー
	private String player;
	//次のプレイヤー
	private String nextPlayer;
	
	//デフォルトコンストラクタで初期設定を行う
	public Player() {
		prepare();
	}
	
	//先攻後攻を格納
	public void prepare() {
		this.player = "●";
		this.nextPlayer = "○";
	}
	
	//ターンチェンジの処理
	public void chgTurn() {
		
		//現在のプレイヤーを格納するスタックを用意してそれぞれ入れ替え
		String temp = this.player;
		this.player = this.nextPlayer;
		this.nextPlayer = temp;
	}
	
	public String getPlayer() {
		return this.player;
	}
	
	public String getNextPlayer() {
		return this.nextPlayer;
	}
	
}
