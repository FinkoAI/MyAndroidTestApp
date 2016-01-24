package ru.sibhtc.passwordtranslater;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Антон on 23.01.2016.
 **/
public final class TextEncodingHelper {

    private static Map<Character, Character> _characterDictionary;

    public static  Map<Character, Character> getCharacterDictionary(){

        if (_characterDictionary == null){
            initCharacterDictionary();
        }

        return _characterDictionary;
    }

    private static void initCharacterDictionary(){
        _characterDictionary = new HashMap<>();

        // region Dictionary insertion
        _characterDictionary.put('й', 'q');
        _characterDictionary.put('ц', 'w');
        _characterDictionary.put('у', 'e');
        _characterDictionary.put('к', 'r');
        _characterDictionary.put('е', 't');
        _characterDictionary.put('н', 'y');
        _characterDictionary.put('г', 'u');
        _characterDictionary.put('ш', 'i');
        _characterDictionary.put('щ', 'o');
        _characterDictionary.put('з', 'p');
        _characterDictionary.put('х', '[');
        _characterDictionary.put('ъ', ']');
        _characterDictionary.put('ф', 'a');
        _characterDictionary.put('ы', 's');
        _characterDictionary.put('в', 'd');
        _characterDictionary.put('а', 'f');
        _characterDictionary.put('п', 'g');
        _characterDictionary.put('р', 'h');
        _characterDictionary.put('о', 'j');
        _characterDictionary.put('л', 'k');
        _characterDictionary.put('д', 'l');
        _characterDictionary.put('ж', ';');
        _characterDictionary.put('э', '\'');
        _characterDictionary.put('\\', '\\');
        _characterDictionary.put('я', 'z');
        _characterDictionary.put('ч', 'x');
        _characterDictionary.put('с', 'c');
        _characterDictionary.put('м', 'v');
        _characterDictionary.put('и', 'b');
        _characterDictionary.put('т', 'n');
        _characterDictionary.put('ь', 'm');
        _characterDictionary.put('б', ',');
        _characterDictionary.put('ю', '.');
        _characterDictionary.put('.', '/');
        _characterDictionary.put('Й', 'Q');
        _characterDictionary.put('Ц', 'W');
        _characterDictionary.put('У', 'E');
        _characterDictionary.put('К', 'R');
        _characterDictionary.put('Е', 'T');
        _characterDictionary.put('Н', 'Y');
        _characterDictionary.put('Г', 'U');
        _characterDictionary.put('Ш', 'I');
        _characterDictionary.put('Щ', 'O');
        _characterDictionary.put('З', 'P');
        _characterDictionary.put('Х', '{');
        _characterDictionary.put('Ъ', '}');
        _characterDictionary.put('Ф', 'A');
        _characterDictionary.put('Ы', 'S');
        _characterDictionary.put('В', 'D');
        _characterDictionary.put('А', 'F');
        _characterDictionary.put('П', 'G');
        _characterDictionary.put('Р', 'H');
        _characterDictionary.put('О', 'J');
        _characterDictionary.put('Л', 'K');
        _characterDictionary.put('Д', 'L');
        _characterDictionary.put('Ж', ':');
        _characterDictionary.put('Э', '"');
        _characterDictionary.put('/', '|');
        _characterDictionary.put('Я', 'Z');
        _characterDictionary.put('Ч', 'X');
        _characterDictionary.put('С', 'C');
        _characterDictionary.put('М', 'V');
        _characterDictionary.put('И', 'B');
        _characterDictionary.put('Т', 'N');
        _characterDictionary.put('Ь', 'M');
        _characterDictionary.put('Б', '<');
        _characterDictionary.put('Ю', '>');
        _characterDictionary.put(',', '?');
        _characterDictionary.put('1', '1');
        _characterDictionary.put('2', '2');
        _characterDictionary.put('3', '3');
        _characterDictionary.put('4', '4');
        _characterDictionary.put('5', '5');
        _characterDictionary.put('6', '6');
        _characterDictionary.put('7', '7');
        _characterDictionary.put('8', '8');
        _characterDictionary.put('9', '9');
        _characterDictionary.put('0', '0');
        _characterDictionary.put('-', '-');
        _characterDictionary.put('=', '=');
        _characterDictionary.put('!', '!');
        _characterDictionary.put('"', '@');
        _characterDictionary.put('№', '#');
        _characterDictionary.put(';', '$');
        _characterDictionary.put('%', '%');
        _characterDictionary.put(':', '^');
        _characterDictionary.put('?', '&');
        _characterDictionary.put('*', '*');
        _characterDictionary.put('(', '(');
        _characterDictionary.put(')', ')');
        _characterDictionary.put('_', '_');
        _characterDictionary.put('+', '+');
        // endregion
    }

    public TextEncodingHelper(){
    }

    public static String getEngWordByRus(Character rusWord){
        if (getCharacterDictionary().containsKey(rusWord)) {
            return getCharacterDictionary().get(rusWord).toString();
        }
        else
            return "";
    }

    public static String getEngPasswordTranscription(String rusTranscription){
        String engTranscription = "";

        for(char c: rusTranscription.toCharArray()) {
            engTranscription = engTranscription + getEngWordByRus(c);
        }

        return engTranscription;

    }
}
