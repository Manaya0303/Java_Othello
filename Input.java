package orhello;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	//標準入力を宣言
	Scanner sc = new Scanner(System.in);
	//playerの宣言
	private Player player;
	//skipchkの宣言
	private SkipCheck skipchk;
	//連続スキップを追跡
	private boolean lastWasSkip = false;
	//受け取った座標を格納するための変数を宣言
	private int x = 0;
	private int y = 0;
	
	//デフォルトコンストラクタ
	public Input(Board board, Player player) {
		this.player = player;
		this.skipchk = new SkipCheck(board,player);
	}
	
	
	//石をひっくり返すメソッド
	public void putStone(Board board) {
		
		//スキップフラグを受け取ってスキップされるべきかを判定
		if(skipchk.getIsSkip() == true) {
			System.out.println(getColor() + "のターンはスキップされます");
			player.chgTurn();										//ターンチェンジ処理
			this.lastWasSkip = true;								//前回スキップされたかのフラグをtrueに
			return;													//returnでメソッド全体を抜ける
		}else {
			this.lastWasSkip = false;								//前回スキップフラグをfalseに
		}
		
		//プレイヤーの色をわかりやすくするために変数を用意
		String color = getColor();
		System.out.println(color + "のターンです");
		
		//whileで入力受付
		while(true) {
			
			//例外が発生したらcatch部分に移動
			try {
				System.out.println("Y?(0-7)");
				y = sc.nextInt();
				System.out.println("X?(0-7)");
				x = sc.nextInt();
				
				//範囲外が入力された場合の処理
				if(x < 0|| x > 7|| y < 0|| y > 7) {
					System.out.println("有効な数値を入力してください");
					continue;										//continueで戻る
				}
				
				break;												//whileの終了
				
			} catch(InputMismatchException e) {						//数値ではないものが入力された場合の処理
				System.out.println("エラー：数値を入力してください");
				sc.nextLine();
			}
		}
		
	}
	
	//色を格納する処理
	public String getColor() {
		return player.getPlayer().equals("○") ? "白": "黒";			//equalsで合っていた場合白を格納。違う場合黒を格納
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean getLastWasSkip() {
		return this.lastWasSkip;
	}
	
	public void setLastWasSkip(boolean wasSkip) {
		this.lastWasSkip = wasSkip;
	}
}
