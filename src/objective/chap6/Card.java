package objective.chap6;

/**
 *
 * @author Tomoya
 */
public class Card {

    /* ジョーカー */
    public static final int JOKER = 0;
    /* スペード */
    public static final int SUIT_SPADE = 1;
    /* ダイヤ */
    public static final int SUIT_DIAMOND = 2;
    /* クラブ */
    public static final int SUIT_CLUB = 3;
    /* ハート */
    public static final int SUIT_HEART = 4;
    /* カードの示すスート */
    private int suit_;
    /* カードの示す数 */
    private int number_;

    /**
     * コンストラクタ
     *
     * @param suit
     * @param number
     */
    public Card(int suit, int number) {
        this.suit_ = suit;
        this.number_ = number;
    }

    /**
     * 数字取得
     * 
     * @return 
     */
    public int getNUmber() {
        return number_;
    }

    /**
     * カードの文字列で表現する
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (number_ > 0) {
            // スートの表示
            switch (suit_) {
                case SUIT_SPADE:
                    sb.append("S");
                    break;
                case SUIT_DIAMOND:
                    sb.append("D");
                    break;
                case SUIT_CLUB:
                    sb.append("C");
                    break;
                case SUIT_HEART:
                    sb.append("H");
                    break;
                default:
                    break;
            }
            // 数の表示
            switch (number_) {
                case 1:
                    sb.append("A");
                    break;
                case 10:
                    sb.append("T");
                    break;
                case 11:
                    sb.append("J");
                    break;
                case 12:
                    sb.append("Q");
                    break;
                case 13:
                    sb.append("K");
                    break;
                default:
                    sb.append(number_);
                    break;
            }
        } else {
            // ジョーカーを表す
            sb.append("JK");
        }
        return sb.toString();
    }
}
