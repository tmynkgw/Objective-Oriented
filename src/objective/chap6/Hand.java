package objective.chap6;

import java.util.ArrayList;

/**
 *
 * @author Tomoya
 */
public class Hand {

    /* 手札にあるカード保持するリスト */
    private ArrayList hand_ = new ArrayList();

    public void addCard(Card card) {
        // カードをリストの最後に追加する
        hand_.add(card);
    }

    /**
     * カードを引く
     *
     * @return
     */
    public Card pickCard() {
        Card pickedCard = (Card) hand_.remove(0);
        return pickedCard;
    }

    /**
     * シャッフルする
     */
    public void shuffle() {
        // 手札の枚数を取得
        int number = hand_.size();
        // カードを抜き出す位置
        int pos;

        // カードをランダムに抜き取って最後に加える動作を繰り返す
        for (int count = 0; count < number * 2; count++) {
            // ランダムな位置からカードを1枚抜き取る
            pos = (int) (Math.random() * number);
            Card pickedCard = (Card) hand_.remove(pos);

            // 抜き取ったカードを最後に加える
            hand_.add(pickedCard);
        }
    }

    /**
     * 手札の枚数を取得する
     *
     * @return
     */
    public int getNumberOfCards() {
        return hand_.size();
    }

    /**
     * 同じ数のカードを探す
     *
     * @return
     */
    public Card[] findSameNumberCard() {
        int numberOfCards = hand_.size();
        Card[] sameCards = null;

        // 手札にカードが1枚もない場合は何もしない
        if (numberOfCards > 0) {
            // 最後に追加されたカードを取得する
            int lastIndex = numberOfCards - 1;
            Card lastAddedCard = (Card) hand_.get(lastIndex);

            // 最後に追加されたカードの数字を取得する
            int lastAddedCardNum = lastAddedCard.getNUmber();

            for (int index = 0; index < lastIndex; index++) {
                Card card = (Card) hand_.get(index);
                if (card.getNUmber() == lastAddedCardNum) {
                    // 最後に見つかったカードと同じカードが見つかった場合
                    // 見つかった組み合わせをsameCardsに格納しループを抜ける
                    sameCards = new Card[2];
                    sameCards[0] = (Card) hand_.remove(lastIndex);
                    sameCards[1] = (Card) hand_.remove(index);
                    break;
                }
            }
        }
        return sameCards;
    }

    /**
     * 手札にあるカードを文字列で出力する
     * @return 
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int size = hand_.size();
        if (size > 0) {
            for (int index = 0; index < size; index++) {
                Card card = (Card) hand_.get(index);
                sb.append(card);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
