package objective.chap6;

/**
 *
 * @author Tomoya
 */
public class Player {

    /* 進行役 */
    private Master master_;
    /* テーブル */
    private Table table_;
    /* 自分の手札 */
    private Hand myHand_ = new Hand();
    /* 名前 */
    private String name_;

    /**
     * コンストラクタ
     *
     * @param master_
     * @param table_
     * @param name_
     */
    public Player(String name_, Master master_, Table table_) {
        this.name_ = name_;
        this.master_ = master_;
        this.table_ = table_;
    }

    public void play(Player nextPlayer) {
        // 次のプレイヤーに手札を出してもらう
        Hand nextHand = nextPlayer.showHand();
        // 相手の手札からカードを1枚引く
        Card pickedCard = nextHand.pickCard();
        // 引いた結果を表示
        System.out.println(this + ":" + nextPlayer + "さんから" + pickedCard + "を引きました");
        // 引いたカードを自分の手札に加え、同じ数のカードがあったらすてる
        dealCard(pickedCard);
        //手札が0になったかどうか調べる
        if (myHand_.getNumberOfCards() == 0) {
            master_.declareWin(this);
        } else {
            // 現在の手札を表示する
            System.out.println(this + ":残りの手札は" + myHand_ + "です");
        }
    }

    public Hand showHand() {
        // この時点で手札が1枚の場合、上りとなるの宣言する
        if (myHand_.getNumberOfCards() == 1) {
            master_.declareWin(this);
        }
        // 見せる前にシャッフルする
        myHand_.shuffle();

        return myHand_;
    }

    public void receiveCard(Card card) {
        dealCard(card);
    }

    private void dealCard(Card card) {
        // カードを自分の手札に加える
        myHand_.addCard(card);

        // 加えたカードと同じカードを探す
        Card[] sameCards = myHand_.findSameNumberCard();

        // 同じカードの組み合わせが存在した場合
        if (sameCards != null) {
            // テーブルへカードを捨てる
            System.out.print(this + ":");
            table_.disposeCard(sameCards);
        }
    }

    public String toString() {
        return name_;
    }
}
