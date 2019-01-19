import java.util.HashMap;
import java.util.Scanner;

/**
 * ある文字列が全て固有であるか否かを判定するプログラム。
 * 文字列は標準入力から受け取る。
 * 入力できる文字列は1つ。
 */

class UniqueCharJudgement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        try {
            //入力した文字列内に重複した文字があるか否かで分岐。
            if (judgeDuplicateCharExistance(str)) {
                //重複した文字がある場合。
                System.out.println("重複した文字が存在します。");
            } else {
                System.out.println("全て固有の文字です。");
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            } 
        }
        
    }

    /**
     * 文字列に重複した文字が存在するか否かを判定。
     * @param str 判定対象の文字列。
     * @return 重複した文字が存在する->true。
     *         重複した文字が存在しない->false。
     */
    private static boolean judgeDuplicateCharExistance(String str) {

        //HashMapを使うことで計算量を削減する。
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();

        //一文字ずつ重複した文字がないか順番に調べる。
        for (int i = 0; i < str.length(); i++) {
            //重複があるか調べる文字。
            String targetChar = String.valueOf(str.charAt(i));

            if (map.get(targetChar) != null) {
                //同じ文字が既にmapに入っている場合。
                return true;
            } else {
                map.put(targetChar, true);
            }

        }
        //最後まで重複する文字が無かったらfalseを返す。
        return false;

    }

}