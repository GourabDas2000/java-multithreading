package IPA;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IPA_RANDOM{
    public ArrayList<Integer> countVowelOrConsonet(String sentence){
        int vowels = 0 , consonent = 0;
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = 0 ; i <sentence.length(); i++){
            char ch = sentence.charAt(i);
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' &&  ch <= 'z')){
                if(sentence.charAt(i) == 'A' || sentence.charAt(i) == 'a' ||sentence.charAt(i) == 'E' ||sentence.charAt(i) == 'e' ||sentence.charAt(i) == 'I' ||
                sentence.charAt(i) == 'i' ||sentence.charAt(i) == 'O' ||sentence.charAt(i) == 'o' || sentence.charAt(i) == 'U' ||sentence.charAt(i) == 'u' ){
                    vowels++;
                }
                else{
                    consonent++;
                }
            }
        }
        l.add(vowels);
        l.add(consonent);
        return l;
    }
    public static String uniqueOuccurence(String[] s){
        List<String> l = new ArrayList<>();
        for(int i = 0 ; i < s.length ; i++){
            if(s[i] != " " && !l.contains(s[i])){
                l.add(s[i]);

            }
        }

        String a = String.join("",l);
        System.out.println(a.toCharArray());
        return a;
    }
    public static String reversestring(String s){
        char[] ch  = s.toCharArray();
        for(int i = 0 ; i<ch.length ; i++){
            if(Character.isDigit(ch[i])){
                System.out.println(ch[i]);
            }
        }

        List<String> l = new ArrayList<>(List.of(s.split("")));
        // l.addAll(List.of(s.split("")));
        // int a = Integer.parseInt(l.get(0));
        Collections.reverse(l);
        return String.join("", l);
    }
    public static void main(String[] args) {
        IPA_RANDOM ipa = new IPA_RANDOM();
        Scanner sc = new Scanner(System.in);
        String sentence = "Gourab0Das";
        String[] s = sentence.split("");
        sc.close();
        // String r1 = uniqueOuccurence(s);
        String r2 = reversestring(sentence);
        System.out.println(r2);
        // ArrayList<Integer> l = ipa.c)ountVowelOrConsonet(sentence);
        // System.out.println("vowels count" + l.get(0) + "Consonent count" + l.get(1));
    }
}