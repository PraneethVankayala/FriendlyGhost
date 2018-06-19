package com.example.user.friendlyghost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class SimpleDictionary {

    private ArrayList<String> words;
    private Random random;
     public SimpleDictionary(InputStream inputStream)throws IOException{
         words=new ArrayList<>();
         BufferedReader bf=new BufferedReader(new InputStreamReader(inputStream));
         String line="";
         while((line=bf.readLine())!=null){
             String word=line.trim();
             if (word.length() >= 4) {

                 words.add(word);
             }

         }
    }
  public   boolean isGoodWord(String word){
         return words.contains(word);
    }

    public String getGoodWord(String prefix){
         random=new Random();
         if(prefix==null||prefix.equals("")) {
             return words.get(random.nextInt(words.size()));
         }
         else{

           int low=0;
           int mid;
           int high=words.size();
           while(low<high){
               mid=(low+high)/2;
               if(words.get(mid).startsWith(prefix)){
                   return words.get(mid);
               }else if(prefix.compareTo(words.get(mid))>0){
                   low=mid+1;
               }else{
                   high=mid-1;
               }
           }
        return null;
         }

    }
}
