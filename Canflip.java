package orhello;

public class Canflip{
	
	//終了フラグの宣言
	private boolean isFinish = false;
	//移動回数をカウントする変数の宣言
	private int movecount;
	//ひっくり返すことが可能な場所をカウントする変数の宣言
	private int canflipcount;
	//Boardの宣言
	private Board board;
	//playerの宣言
	private Player player;
	
	//デフォルトコンストラクタ
	public Canflip(Board board, Player player) {
		this.board = board;
		this.player = player;
	}
	
	//下方向にひっくり返せるか確認するメソッド。基本的にはflipstoneと変わらず
	public void canflipdown(int y,int x) {
		this.isFinish = false;							//終了フラグのセット
		this.movecount = 0;								//移動回数のセット
		int currentY = y + 1;							//見たい場所を格納する変数の宣言
		
		//whileで終了フラグが立つまで繰り返し
		while(!this.isFinish && currentY < 8) {
			//見たい座標の内容を取り出し
			String stone = board.getStone(currentY, x);
			
			//現在のプレイヤーと同じ石だった場合の処理
			if(stone.equals(player.getPlayer())) {
				for(int i = 0; i < this.movecount; i++) {
					this.canflipcount++;
				}
				this.isFinish = true;
				this.movecount = 0;
				
			//相手プレイヤーの石だった場合の処理
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentY++;
			
			//それ以外（何も置いていない）場合の処理
			}else if(stone.equals("-")) {
				this.isFinish = true;
				this.movecount = 0;
			}
		}
	}
	
	//左
	public void canflipleft(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentX = x - 1;
		while(!this.isFinish && currentX >= 0) {
			String stone = board.getStone(y, currentX);
			
			if(stone.equals(player.getPlayer())) {
				for(int i = 0; i < this.movecount; i++) {
					this.canflipcount++;
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentX--;
				
			}else if(stone.equals("-")) {
				this.isFinish = true;
			}
		}
	}
	
	//左下
	public void canflipleftdown(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentY = y + 1;
		int currentX = x - 1;
		while(!this.isFinish && currentY < 8 && currentX >= 0) {
			String stone = board.getStone(currentY, currentX);
			
			if(stone.equals(player.getPlayer())) {
				for(int i = 0; i < this.movecount; i++) {
					this.canflipcount++;
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentY++;
				currentX--;
				
			}else if(stone.equals("-")) {
				this.isFinish = true;
			}
		}
	}
	
	//左上
	public void canflipleftup(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentY = y - 1;
		int currentX = x - 1;
		
		while(!this.isFinish && currentY >= 0 && currentX >= 0) {
			String stone = board.getStone(currentY, currentX);

			if(stone.equals(player.getPlayer())) {
				for(int i = 0; i < this.movecount; i++) {
					this.canflipcount++;
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentY--;
				currentX--;
				
			}else if(stone.equals("-")) {
				this.isFinish = true;
			}
		}
	}
	
	//右
	public void canflipright(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentX = x + 1;
		
		while(!this.isFinish && currentX < 8) {
			
			String stone = board.getStone(y, currentX);
	
			if(stone.equals(player.getPlayer())) {
				for(int i = 0; i < this.movecount; i++) {
					this.canflipcount++;
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentX++;
				
			}else if(stone.equals("-")) {
				this.isFinish = true;
			}
		}
	}
	
	//右下
	public void canfliprightdown(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentY = y + 1;
		int currentX = x + 1;
		
		while(!this.isFinish && currentY < 8 && currentX < 8) {
			String stone = board.getStone(currentY, currentX);

			if(stone.equals(player.getPlayer())) {
				for(int i = 0; i < this.movecount; i++) {
					this.canflipcount++;
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentY++;
				currentX++;
				
			}else if(stone.equals("-")) {
				this.isFinish = true;
			}
		}
	}
	
	//右上
	public void canfliprightup(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentY = y - 1;
		int currentX = x + 1;
		
		while(!this.isFinish && currentY >= 0 && currentX < 8) {
			String stone = board.getStone(currentY, currentX);

			if(stone.equals(player.getPlayer())) {
				for(int i = 0; i < this.movecount; i++) {
					this.canflipcount++;
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentY--;
				currentX++;
				
			}else if(stone.equals("-")) {
				this.isFinish = true;
			}
		}
	}
	
	//上
	public void canflipup(int y,int x) {
		this.isFinish = false;
		this.movecount = 0;
		int currentY = y - 1;
		
		while(!this.isFinish && currentY >= 0) {
			String stone = board.getStone(currentY, x);
	
			if(stone.equals(player.getPlayer())) {
				for(int i = 0; i < this.movecount; i++) {
					this.canflipcount++;
				}
				this.isFinish = true;
				this.movecount = 0;
				
			}else if(stone.equals(player.getNextPlayer())) {
				this.movecount++;
				currentY--;
				
			}else if(stone.equals("-")) {
				this.isFinish = true;
			}
		}
	}
	
	public void setCanflipcount(int i) {
		this.canflipcount = i;
	}
	
	public int getCanflipcount() {
		return this.canflipcount;
	}
	
	
	
}
