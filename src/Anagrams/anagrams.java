package Anagrams;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Scanner;
        import java.util.Arrays;
        import java.io.File;
        import java.util.Iterator;

class anagram {

// Documentación sobre manejo de ArrayLists
// http://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html

    static ArrayList<String> dictionaryList = new ArrayList<>();

// Documentacion sobre lectura del fichero
// http://chuwiki.chuidiang.org/index.php?title=Lectura_de_teclado_en_java#Ejemplo_de_lectura_de_un_fichero_con_Scanner


    public static ArrayList<String> setDictionary() throws IOException
    {
        System.out.println("Cargando diccionario. Un momento, por favor...");
        File dictionary = new File ("./wordlist.txt");
        Scanner filescan = new Scanner(dictionary);
        while (filescan.hasNextLine()){
            anagram.dictionaryList.add(filescan.nextLine());
        }
        filescan.close();
        return dictionaryList;
    }

    public static void checkWord (ArrayList<String> anagramList, String searchWord) {
        if (anagramList.contains(searchWord))
            anagram.checkDictionary(anagramList,searchWord);
        else
            System.out.println("La palabra no figura en el diccionario\n");
    }

// Documentación sobre proceso de búsqueda de anagramas
// https://es.stackoverflow.com/questions/41519/identificar-una-anagrama

    public static void checkDictionary(ArrayList<String> anagramList, String searchWord) {
        Iterator<String> iter = anagramList.iterator();
        System.out.println("\nAnagramas encontrados en el diccionario: ");
        while (iter.hasNext()) {
            String word = iter.next();
            char[] array1 = searchWord.toCharArray();
            char[] array2 = word.toCharArray();
            Arrays.sort(array1);
            Arrays.sort(array2);
            if (new String(array1).equals(new String(array2))) {
                System.out.println(word);
            }
        }
    }
}

public class anagrams {
    public static void main(String[] args) {
        try{
            ArrayList<String> anagramList = anagram.setDictionary();
            Scanner wordscan = new Scanner (System.in);
            System.out.println("Introduzca la palabra de la que quiera encontrar anagramas: ");
            String searchWord = wordscan.nextLine();
            wordscan.close();
            anagram.checkWord(anagramList, searchWord);
        }

// Documentación sobre manejo de mensaje de error de lectura si no encuentra el fichero
// https://users.dcc.uchile.cl/~lmateu/Java/Transparencias/.arch/all.htm

        catch ( IOException e ) {
            System.err.println("Diccionario no encontrado. Compruebe que wordlist.txt se encuentra en la carpeta raíz del proyecto");
        }
    }
}