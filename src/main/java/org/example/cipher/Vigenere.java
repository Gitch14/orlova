package org.example.cipher;

import java.util.Arrays;

public class VigenereCipher {

    private final char[] alphabet;

    public VigenereCipher() {
        alphabet = new char[] {
                'а','б','в','г','д','е','є','ж','з','и',
                'й','к','л','м','н','о','п','р','с','т',
                'у','ф','х','ц','ч','ш','щ','ь','ю','я'
        };
    }

    private int mod(int a, int b) {
        return (a % b + b) % b;
    }

    private char shiftChar(char c, char keyChar, int direction) {
        int shift = keyChar - 'а';
        if(direction < 0) {
            shift = -shift;
        }
        int index = mod(Arrays.binarySearch(alphabet, c), alphabet.length);
        index = mod(index + shift, alphabet.length);
        return alphabet[index];
    }

    public void encrypt(String text, String key) {
        System.out.println("Твій текст = " + text);
        System.out.println("Твій ключ = " + key);
        text = text.toLowerCase();
        key = key.toLowerCase();
        StringBuilder ciphertext = new StringBuilder();
        int keyIndex = 0;
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(Character.isLetter(c)) {
                char keyChar = key.charAt(keyIndex % key.length());
                ciphertext.append(shiftChar(c, keyChar, 1));
                keyIndex++;
            }
            else {
                ciphertext.append(c);
            }
        }
        System.out.println(ciphertext.toString());

    }


}

