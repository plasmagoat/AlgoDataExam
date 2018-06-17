package sortsearch;

import java.io.*;
import java.util.Scanner;

public class CaesarStatistics
{
    // instance variables
    private char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    private int[] frequency = new int[alphabet.length + 1];
    private char[] chars;
    private char[] encryptedchars;
    private char[] decryptedchars;
    private int ealphindex, talphindex;
    private int first, second,third;
    private int firstalphindex, secondalphindex, thirdalphindex;
    private char firstchar, secondchar, thirdchar;
    private int key;
    private String filename;
    private String cryptname;

    // constructor
    public CaesarStatistics()
    {
        System.out.println("Used alphabet :");
        showChararray(alphabet);
        for(int i = 0; i < alphabet.length; i++)
        {
            if(alphabet[i] == 'e') ealphindex = i;
            if(alphabet[i] == 't') talphindex = i;
        }
        System.out.println("Index of 'e' = " + ealphindex + "; index of 't' = " + talphindex);
        System.out.println();

        filename = "Example1.txt";
        //filename = "Example2.txt";
        //filename = "Example3.txt";

        System.out.println("Text read from file (not encrypted):");
        chars  = readTextfile(filename);
        showChararray(chars);
        System.out.println();
        System.out.println("Number of chars in text : " + chars.length);
        System.out.println();

        key = 3;
        encryptedchars = caesarEncrypt(chars, key);
        System.out.println("Caesar encrypted text with key = " + key);
        showChararray(encryptedchars);
        System.out.println();
        cryptname = "Crypt1.txt";
        //cryptname = "Crypt2.txt";
        //cryptname = "Crypt3.txt";
        writeTextfile(encryptedchars, cryptname);
        System.out.println();

        chars = readTextfile(cryptname);
        statistics(encryptedchars);
        strategy();
    }

    // Encrypt
    public char[] caesarEncrypt(char[] input, int key)
    {
        char[] output = new char[input.length];
        int index;
        for(int i = 0; i < input.length; i++)
        {
            index = -1;
            for(int j = 0; j < alphabet.length; j++)
            {
                if(Character.toLowerCase(input[i]) == alphabet[j]) index = j;
            }
            if(index == -1)
            {
                output[i] = input[i];
            }
            else
            {
                output[i] = alphabet[(index + key) % alphabet.length];
            }
        }
        return output;
    }

    // Decrypt
    public char[] caesarDecrypt(char[] input, int key)
    {
        char[] output = new char[input.length];
        int index;
        for(int i = 0; i < input.length; i++)
        {
            index = -1;
            for(int j = 0; j < alphabet.length; j++)
            {
                if(Character.toLowerCase(input[i]) == alphabet[j]) index = j;
            }
            if(index == -1)
            {
                output[i] = input[i];
            }
            else
            {
                output[i] = alphabet[(alphabet.length + index - key) % alphabet.length];
            }
        }
        return output;
    }

    // Statistics
    public void statistics(char[] input)
    {
        boolean found;
        int number;

        for(int i = 0; i < frequency.length; i++)
        {
            frequency[i] = 0;
        }
        for(int i = 0; i < input.length; i++)
        {
            found = false;
            for(int j = 0; j < alphabet.length; j++)
            {
                if(input[i] == alphabet[j])
                {
                    frequency[j] += 1;
                    found = true;
                }
            }
            if(!found) frequency[alphabet.length] +=1;
        }

        System.out.println("Statistics on occurrence of letters");
        for(int i = 0; i < alphabet.length; i++)
        {
            System.out.print(alphabet[i] + "   ");
        }
        System.out.println("other");
        for(int i = 0; i < frequency.length - 1; i++)
        {
            number = frequency[i];
            System.out.print(number + ((number < 100) ? " " : "") + ((number < 10) ? " " : "")+ " ");
        }
        System.out.println(frequency[alphabet.length]);
        System.out.println();
        mostFrequent(frequency);
    }

    // Three most frequent
    public void mostFrequent(int[] frequency)
    {
        first = 0;
        second = 0;
        third = 0;
        firstchar = alphabet[0];
        secondchar = alphabet[0];
        thirdchar = alphabet[0];
        firstalphindex = 0;
        secondalphindex = 0;
        thirdalphindex = 0;

        for(int i = 0; i < alphabet.length; i++)
        {
            if(frequency[i] > first)
            {
                third = second;
                thirdchar = secondchar;
                thirdalphindex = secondalphindex;
                second = first;
                secondchar = firstchar;
                secondalphindex = firstalphindex;
                first = frequency[i];
                firstchar = alphabet[i];
                firstalphindex = i;
            }
            else
            if(frequency[i] > second)
            {
                third = second;
                thirdchar = secondchar;
                thirdalphindex = secondalphindex;
                second = frequency[i];
                secondchar = alphabet[i];
                secondalphindex = i;
            }
            else
            if(frequency[i] > third)
            {
                third = frequency[i];
                thirdchar = alphabet[i];
                thirdalphindex = i;
            }
        }
        System.out.println("Most frequent character        = " + firstchar + "; index in alphabet = " + firstalphindex + ((firstalphindex < 10) ? "  " : " ") + ", number in text = "  + first);
        System.out.println("Second most frequent character = " + secondchar + "; index in alphabet = " + secondalphindex + ((secondalphindex < 10) ? "  " : " ") +", number in text = "  + second);
        System.out.println("Third most frequent character  = " + thirdchar + "; index in alphabet = " + thirdalphindex + ((thirdalphindex < 10) ? "  " : " ") +", number in text = "  + third);
        System.out.println();
    }

    // Strategy
    public void strategy()
    {
        key = (alphabet.length + firstalphindex - ealphindex) % alphabet.length;
        System.out.println("First attempt : Most common = 'e' => key = " + key);
        decryptedchars = caesarDecrypt(chars, key);
        System.out.println("Caesar decrypted text with key = " + key);
        showChararray(decryptedchars);
        System.out.println();

        key = (alphabet.length + secondalphindex - ealphindex) % alphabet.length;
        System.out.println("Secondt attempt : Second most common = 'e' => key = " + key);
        decryptedchars = caesarDecrypt(chars, key);
        System.out.println("Caesar decrypted text with key = " + key);
        showChararray(decryptedchars);
        System.out.println();

        key = (alphabet.length + thirdalphindex - ealphindex) % alphabet.length;
        System.out.println("Third attempt : Third most common = 'e' => key = " + key);
        decryptedchars = caesarDecrypt(chars, key);
        System.out.println("Caesar decrypted text with key = " + key);
        showChararray(decryptedchars);
        System.out.println();

        key = (alphabet.length + firstalphindex - talphindex) % alphabet.length;
        System.out.println("Fourth attempt : Most common = 't' => key = " + key);
        decryptedchars = caesarDecrypt(chars, key);
        System.out.println("Caesar decrypted text with key = " + key);
        showChararray(decryptedchars);
        System.out.println();
    }

    // Read textfile
    public char[] readTextfile(String filename)
    {
        char[] mychararray = {};
        try
        {
            File myfile = new File(filename);
            Scanner scanner = new Scanner(myfile);
            String mytext = scanner.nextLine();
            while (scanner.hasNextLine())
            {
                mytext = mytext + "\n";
                mytext = mytext + scanner.nextLine();
            }
            mychararray = mytext.toCharArray();
        }
        catch(Exception e)
        {
            System.out.println("File " + filename + " not found");
        }
        return mychararray;
    }

    // Write textfile
    public void writeTextfile(char[] input, String filename)
    {
        String output = new String(input);
        try
        {
            PrintWriter writer = new PrintWriter(filename);
            writer.println(output);
            writer.close();
            System.out.println("File " + filename + " written");
        }
        catch(Exception e)
        {
            System.out.println("File " + filename + " not written");
        }
    }

    // Show chararray
    public void showChararray(char[] chars)
    {
        String result = "";
        for(int i = 0; i < chars.length; i++)
        {
            result += chars[i];
        }
        System.out.println(result);
    }

    // main
    public static void main(String[] args)
    {
        new CaesarStatistics();
    }
}

