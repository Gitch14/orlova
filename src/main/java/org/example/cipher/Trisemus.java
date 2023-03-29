package org.example.cipher;

public class TrisemusCipher {

    private final char[][] table;

    public TrisemusCipher() {
        table = new char[][]{
                {'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з'},
                {'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п'},
                {'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я'}
        };

    }

    private int[] findPosition(char c) {
        int[] pos = new int[2];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == c) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return null;
    }

    public void encrypt(String text, String key) {
        System.out.println("Твій текст = " + text);
        System.out.println("Твій ключ = " + key);
        text = text.toLowerCase();
        key = key.toLowerCase();
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                int[] pos = findPosition(c);
                int row = pos[0];
                int col = pos[1];
                char keyChar = key.charAt(i % key.length());
                int shift = keyChar - 'а';
                col = (col + shift) % table[row].length;
                ciphertext.append(table[row][col]);
            } else {
                ciphertext.append(c);
            }
        }
        System.out.println(ciphertext.toString());
    }


}
