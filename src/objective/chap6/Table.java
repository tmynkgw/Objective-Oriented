package objective.chap6;

import java.util.ArrayList;

/**
 *
 * @author Tomoya
 */
public class Table {
    
    // 捨てられたカードを保持しておくためのリスト
    private ArrayList diposeCards_ = new ArrayList();
    
    public void disposeCard(Card[] card) {
        for (int index = 0; index < card.length; index++) {
            // 捨てられたカードを表示する
            System.out.print(card[index] + " ");
            
        }
        System.out.println("を捨てました");
        
        // 捨てられたカードを保存
        diposeCards_.add(card);
    }
}
