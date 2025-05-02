package orhello;

public class Flipstone extends Flip{
	//Field判定変数
	private boolean isFinish = false;
	//石をひっくり返した回数をカウント
	private int flipcount;
	//移動回数をカウント
	private int movecount;
	//boardの宣言
	private Board board;
	//playerの宣言
	private Player player;
	
	//デフォルトコンストラクタ
	public Flipstone(Board board,Player player) {
		this.board = board;
		this.player = player;
	}
	
	//下方向の石をひっくり返すメソッド
	public void flipdown(int y,int x) {
		//終了フラグの初期化
		this.isFinish = false;
		//移動した回数をカウントする変数を初期化
		this.movecount = 0;
		//現在見たい位置の座標を格納する変数の宣言
		int currentY = y + 1;
		
		//終了フラグが立つまで繰り返し
		while(!this.isFinish && currentY < 8) {
			//見たい盤面の内容を取り出し
			String stone = board.getStone(currentY, x);
			
			//取り出した内容物で分岐
			//移動回数が一回以上かつ同じ色の場合の処理
			if(stone.equals(player.getPlayer()) && this.movecount > 0) {
				for(int i = 1; i <= this.movecount; i++) {
					this.flipcount++;									//ひっくり返した回数を追加
					board.setStone(y + i, x, player.getPlayer());		//石をひっくり返す(セット)
				}
				this.isFinish = true;									//終了フラグを立てる
				this.movecount = 0;										//移動回数をリセット
				
			
			//内容物が相手プレイヤーの駒だった場合の処理
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;										//移動回数を追加
				currentY++;												//ここの隣を見るためにcurrentYを＋1
					
			//それ以外（何も置かれていなかった場合)の処理
			}else {
				this.isFinish = true;									//終了フラグを立てる
				this.movecount = 0;										//移動回数をリセット
			}
		}
	}
	
	//左上方向の処理。内容はほぼ同上のため割愛
	public void flipleft(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentX = x - 1;
		while(!this.isFinish && currentX >= 0) {
			String stone = board.getStone(y, currentX);
			
			if(stone.equals(player.getPlayer()) && this.movecount > 0) {
				for(int i = 1; i <= this.movecount; i++) {
					this.flipcount++;
					board.setStone(y, x - i, player.getPlayer());
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentX--;
				
			}else {
				this.isFinish = true;
				this.movecount = 0;
			}
		}
	}
	
	//左下
	public void flipleftdown(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentY = y + 1;
		int currentX = x - 1;
		while(!this.isFinish && currentY < 8 && currentX >= 0) {
			String stone = board.getStone(currentY, currentX);
			
			if(stone.equals(player.getPlayer()) && this.movecount > 0) {
				for(int i = 1; i <= this.movecount; i++) {
					this.flipcount++;
					board.setStone(y + i, x - i, player.getPlayer());
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentY++;
				currentX--;
				
			}else {
				this.isFinish = true;
				this.movecount = 0;
			}
		}
	}
	
	//上
	public void flipleftup(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentY = y - 1;
		int currentX = x - 1;
		
		while(!this.isFinish && currentY >= 0 && currentX >= 0) {
			String stone = board.getStone(currentY, currentX);

			if(stone.equals(player.getPlayer()) && this.movecount > 0) {
				for(int i = 1; i <= this.movecount; i++) {
					this.flipcount++;
					board.setStone(y - i, x - i, player.getPlayer());
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentY--;
				currentX--;
				
			}else {
				this.isFinish = true;
				this.movecount = 0;
			}
		}
	}
	
	//右
	public void flipright(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentX = x + 1;
		
		while(!this.isFinish && currentX < 8) {
			
			String stone = board.getStone(y, currentX);
	
			if(stone.equals(player.getPlayer()) && this.movecount > 0) {
				for(int i = 1; i <= this.movecount; i++) {
					this.flipcount++;
					board.setStone(y, x + i, player.getPlayer());
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentX++;
				
			}else {
				this.isFinish = true;
				this.movecount = 0;
			}
		}
	}
	
	//右下
	public void fliprightdown(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentY = y + 1;
		int currentX = x + 1;
		
		while(!this.isFinish && currentY < 8 && currentX < 8) {
			String stone = board.getStone(currentY, currentX);

			if(stone.equals(player.getPlayer()) && this.movecount > 0) {
				for(int i = 1; i <= this.movecount; i++) {
					this.flipcount++;
					board.setStone(y + i, x + i, player.getPlayer());
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentY++;
				currentX++;
				
			}else {
				this.isFinish = true;
				this.movecount = 0;
			}
		}
	}
	
	//右上
	public void fliprightup(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentY = y - 1;
		int currentX = x + 1;
		
		while(!this.isFinish && currentY >= 0 && currentX < 8) {
			String stone = board.getStone(currentY, currentX);

			if(stone.equals(player.getPlayer()) && this.movecount > 0) {
				for(int i = 1; i <= this.movecount; i++) {
					this.flipcount++;
					board.setStone(y - i, x + i, player.getPlayer());
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentY--;
				currentX++;
				
			}else {
				this.isFinish = true;
				this.movecount = 0;
			}
		}
	}
	
	//上
	public void flipup(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentY = y - 1;
		
		while(!this.isFinish && currentY >= 0) {
			String stone = board.getStone(currentY, x);
	
			if(stone.equals(player.getPlayer()) && this.movecount > 0) {
				for(int i = 1; i <= this.movecount; i++) {
					this.flipcount++;
					board.setStone(y - i, x, player.getPlayer());
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentY--;
				
			}else {
				this.isFinish = true;
				this.movecount = 0;
			}
		}
	}
	
	public int getFlipcount() {
		return this.flipcount;
	}
	
	//リセット処理。カウンタ系を全部リセット
	public void reset() {
		this.flipcount = 0;
		this.movecount = 0;
	}
}
