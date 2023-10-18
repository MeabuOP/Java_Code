/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment1;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P0008 {

    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your content:");
        str = sc.nextLine();

        StringTokenizer st = new StringTokenizer(str);
        
        HashMap<String, Integer> wordsHashMap = new HashMap<>();
        countWords(wordsHashMap, st);
        System.out.println(displayHashMap(wordsHashMap));
        

        StringTokenizer st2 = new StringTokenizer(str);
        HashMap<Character, Integer> charactersHashMap = new HashMap<>();
        countCharacters(charactersHashMap, st2);
        System.out.println(displayHashMap(charactersHashMap));
    }

    public static void countWords(HashMap<String, Integer> wordsHashMap, StringTokenizer st) {
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            int count = wordsHashMap.getOrDefault(word, 0);
            wordsHashMap.put(word, count + 1);
        }
    }

    public static void countCharacters(HashMap<Character, Integer> charactersHashMap, StringTokenizer st) {
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            char[] character = word.toCharArray();
            for (char c:character){
                int count = charactersHashMap.getOrDefault(c, 0);
                charactersHashMap.put(c, count + 1);
            }
        }
    }

    public static String displayHashMap(HashMap hashMap) {
        if (hashMap.keySet().isEmpty()) return "{}";
        String answer = "{";
        for (Object str : hashMap.keySet()) {
            answer = answer + str + '=' + hashMap.get(str) + ',';
        }
        answer = answer.substring(0, answer.length()-1);
        answer = answer + '}';
        return answer;
    }
}
