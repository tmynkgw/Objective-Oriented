package objective.chap6;

import java.util.ArrayList;

/**
 *
 * @author Tomoya
 */
public class Master {

    /* プレイヤーのリスト */
    private ArrayList players_ = new ArrayList();

    public void prepareGame(Hand cards) {
        System.out.println("【カードを配ります】");
        // トランプをシャッフルする
        cards.shuffle();

        // トランプの枚数を取得する
        int numberOfCards = cards.getNumberOfCards();
        // プレイヤーの人数を取得する
        int numberOfPlayers = players_.size();
        for (int index = 0; index < players_.size(); index++) {
            // カードから1枚引く
            Card card = cards.pickCard();
            // 各プレイヤーに順番にカードを配る
            Player player = (Player) players_.get(index % numberOfCards);
            player.receiveCard(card);
            System.out.println(player.toString() + "：");
        }
    }

    public void startGame() {
        System.out.println("【ババ抜きを開始します】");
        // プレイヤーの任数を取得する
        for (int count = 0; players_.size() > 1; count++) {
            int playerIndex = count % players_.size();
            int nextPlayerIndex = (count + 1) % players_.size();

            // 指名するプレイヤーの取得
            Player player = (Player) players_.get(playerIndex);
            // 次のプレイヤーの取得
            Player nextPlayer = (Player) players_.get(nextPlayerIndex);
            // プレイヤーを指名する
            System.out.println("\n" + player + "さんの番です");
            player.play(nextPlayer);
        }
        System.out.println("【ババ抜きが終了しました】");
    }

    public void declareWin(Player winner) {
        System.out.println(winner + "さんが上がりました");
        // 上がったプレイヤーをリストから外す
        players_.remove(players_.indexOf(winner));
        
        if (players_.size() == 1) {
            Player loser = (Player) players_.get(0);
            System.out.println(loser + "さんの負けです");
        }
    }
    
    public void registerPlayer(Player player) {
        players_.add(player);
    }

}
