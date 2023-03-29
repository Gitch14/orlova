package org.example.cipher;

public class DoubleSquareCipher {

    private final char[][] square1;
    private final char[][] square2;

    public DoubleSquareCipher() {
        square1 = new char[][] {
                {'а','б','в','г','д','е','є','ж','з','и'},
                {'й','к','л','м','н','о','п','р','с','т'},
                {'у','ф','х','ц','ч','ш','щ','ь','ю','я'}
        };
        square2 = new char[][] {
                {'я','ю','ь','щ','ш','ч','ц','х','ф','у'},
                {'т','с','р','п','о','н','м','л','к','й'},
                {'и','з','ж','є','е','д','г','в','б','а'}
        };
    }

    private int[] findPosition(char c, char[][] square) {
        int[] pos = new int[2];
        for(int i = 0; i < square.length; i++) {
            for(int j = 0; j < square[i].length; j++) {
                if(square[i][j] == c) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return null;
    }

    public void encrypt(String text) {
        System.out.println("Твій текст = " + text);
        text = text.toLowerCase();
        StringBuilder ciphertext = new StringBuilder();
        for(int i = 0; i < text.length(); i += 2) {
            char c1 = text.charAt(i);
            char c2 = (i + 1 < text.length()) ? text.charAt(i + 1) : 'а';
            if(Character.isLetter(c1) && Character.isLetter(c2)) {
                int[] pos1 = findPosition(c1, square1);
                int[] pos2 = findPosition(c2, square2);
                if (pos1 != null && pos2 != null) {
                    int row = pos1[0];
                    int col = pos2[1];
                    ciphertext.append(square1[row][col]);
                    col = pos1[1];
                    row = pos2[0];
                    ciphertext.append(square2[row][col]);
                }
            }
            else {
                ciphertext.append(c1).append(c2);
            }
        }
        System.out.println(ciphertext.toString());
    }

}
