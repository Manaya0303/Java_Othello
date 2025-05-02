package orhello;

public class Main {

	public static void main(String args[]) {
		
		//Boardの宣言
		Board board = new Board();
		board.MakeNewBoard();
		//Playerの宣言
		Player player = new Player();
		//Inputの宣言
		Input input = new Input(board, player);
		//Skipchkの宣言
		SkipCheck skipchk = new SkipCheck(board, player);
		//Endchkの宣言
		EndCheck endchk = new EndCheck(board,input,skipchk);
		//Flipstoneの宣言	
		Flipstone flip = new Flipstone(board,player);
		//Resultの宣言
		Result result = new Result();
		//FlipCheckの宣言
		FlipCheck flipchk = new FlipCheck(flip);
		
		
		System.out.println("ゲームスタート！");
		System.out.println();
		
		
		//EndCheckで終了フラグが立つまで繰り返し
		while(!endchk.getisEnd()) {
			board.output();				//ボードの出力
			skipchk.Chk();				//スキップされるべきか判定
			input.putStone(board);		//入力受付
			
			//スキップされた場合に分岐
			if(skipchk.getIsSkip()) {
				endchk.chk();
				continue;				//スキップされていた場合whileを最初から
			}
			
			//各判定メソッドを呼び出し
			flip.flipdown(input.getY(), input.getX());
			flip.flipleft(input.getY(), input.getX());
			flip.flipleftdown(input.getY(), input.getX());
			flip.flipleftup(input.getY(), input.getX());
			flip.flipright(input.getY(), input.getX());
			flip.fliprightdown(input.getY(), input.getX());
			flip.fliprightup(input.getY(), input.getX());
			flip.flipup(input.getY(), input.getX());
			flipchk.flipchk();			//ひっくり返されているのか判定するメソッドを呼び出し
			flip.reset();				//カウントをリセット
				
			
			//ひっくり返されたわけでもなく、スキップされたわけでもない場合(置けない場合)の処理
			if(!flipchk.getIsFlipped() && !skipchk.getIsSkip()) {
				System.out.println("置けません");
				input.setLastWasSkip(false);		//前回skipされたかのフラグをリセット
				continue;
				}
			
			//ひっくり返せた場合の処理
			if(flipchk.getIsFlipped()) {
				board.setStone(input.getY(), input.getX(), player.getPlayer());
				input.setLastWasSkip(false);		//置けているのでスキップフラグをリセット
				player.chgTurn();					//ターンチェンジメソッドを呼び出し
				endchk.chk();						//終了判定
			}
		}
		
		//終了処理
		board.output();
		System.out.println("ゲーム終了！");
		result.count(board);
	}
}
