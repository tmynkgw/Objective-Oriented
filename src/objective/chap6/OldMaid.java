package objective.chap6;

/**
 *
 * @author Tomoya
 */
public class OldMaid {

    public static void main(String[] args) {
        // 進行役の生成
        Master master = new Master();
        // テーブルの生成
        Table table = new Table();
        // プレイヤーの生成
        Player murata = new Player("村田", master, table);
        Player yamada = new Player("山田", master, table);
        Player saitou = new Player("斉藤", master, table);
        
        // 進行役へプレイヤーを登録
        master.registerPlayer(murata);
        master.registerPlayer(yamada);
        master.registerPlayer(saitou);
        
        // トランプを生成する
        Hand trump = createTrump();
        // ゲームの準備をする
        master.prepareGame(trump);
        // ゲームを開始する
        master.startGame();
    }

    private static Hand createTrump() {
        Hand trump = new Hand();
        for (int number = 1; number <= 13; number++) {
            trump.addCard(new Card(Card.SUIT_CLUB, number));
            trump.addCard(new Card(Card.SUIT_DIAMOND, number));
            trump.addCard(new Card(Card.SUIT_HEART, number));
            trump.addCard(new Card(Card.SUIT_SPADE, number));
        }
        // ジョーカー作成
        trump.addCard(new Card(0, Card.JOKER));
        return trump;
    }
    
}
