//Pervin Yaren Ünsal 02190201016

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = 0;

        System.out.println("Kodlanacak metni yaziniz (tum ascii karekterler uygundur): ");
        String metin = scanner.nextLine();
        int [] tekrarSayisi = new int[255];
        int [] harfinTekrarSayisi = new int[255];
        char [] harfSiralama = new char[255];
        String [] huffman = new String[255];

        for(i = 0; i<metin.length(); i++)
            tekrarSayisi[metin.charAt(i)]++;


        i = 0;

        while(maxIndexBul(tekrarSayisi) != 0){
            int temp = maxIndexBul(tekrarSayisi);
            harfSiralama[i] = (char) temp;
            harfinTekrarSayisi[i] = tekrarSayisi[temp];
            tekrarSayisi[temp] = 0;
            i++;
        }

        i = 0;

        while (harfSiralama[i] != 0) {
            System.out.print(harfSiralama[i] + ": " + harfinTekrarSayisi[i] + ", ");
            i++;
        }
        System.out.print("\b\b.");

        int j = 0;

        for(j = 0; j < i; j++){
            huffman[j] = "";
            for(int k = 0; k<j; k++)
                huffman[j] = huffman[j] + '1';
            huffman[j] = huffman[j] + "0";
        }
        huffman[j-1] = huffman[j-1].substring(0,huffman[j-1].length()-1);

        System.out.println("\n");

        j = 0;

        for(String a:huffman)
            if(a!=null) {
                System.out.println(harfSiralama[j] + "= " + a);
                j++;
            }

        System.out.print("\nSonuc:\n");

        for(j = 0; j < metin.length(); j++){
            int temp = charIndexBul(harfSiralama, metin.charAt(j));
            System.out.print(huffman[temp]);
        }
        
        
    }

    public static int maxIndexBul(int [] array){
        int sonuc = 0, indexBulundu = 0;

        for(int i = 0; i < array.length; i++)
            if(array[i] > sonuc) {
                sonuc = array[i];
                indexBulundu = i;
            }

        return indexBulundu;
    }

    public static int charIndexBul(char [] arr, char arama){
        int i = 0;

        for(i = 0; i < arr.length; i++){
            if(arr[i] == arama){
                break;
            }
        }

        return i;
    }
}