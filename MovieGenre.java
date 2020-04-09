import java.io.*;
import java.io.FileReader;
import java.util.*;


public class Genre {
    public static void main(String[]args)throws IOException{
        File file= new File("movies.csv");
        BufferedReader reader= new BufferedReader(new FileReader(file));
        HashMap<String,Integer> mapYears= new HashMap<>();	//this counts the movie that were released during different years.
        HashMap<String,Integer> map = new HashMap<>();		//this counts how many movies in different genres.
        HashMap<Integer,Integer> howMany = new HashMap<>(); //this counts how many movies came out.
        reader.readLine();
        String[]array;
        String line= reader.readLine();
        while(line !=null){
            array=line.split(",");
            line=reader.readLine();
            
            try{
                int comma = line.lastIndexOf(',');
                String sub = line.substring(0,comma);
                int open = sub.lastIndexOf('(')+1;
                int close = sub.lastIndexOf(')');
                int year = Integer.parseInt(sub.substring(open,close));
                if (howMany.containsKey(year)){
                    howMany.put(year,howMany.get(year)+1);
                }
                else{
                    howMany.put(year,1);
                }
                if (howMany.containsKey(year)){
                    howMany.put(year,howMany.get(year)+1);
                }
                else{
                    howMany.put(year,1);
                }
                if (year>=2015){
                    String[] genres = array[array.length-1].split("\\|");
                    for (String genre:genres){
                        if (mapYears.containsKey(genre)){
                            mapYears.put(genre,mapYears.get(genre)+1);
                        }
                        else{
                            mapYears.put(genre,1);
                        }
                    }

                }
            }

            catch (Exception e){  }

            String[] genres = array[array.length-1].split("\\|");
            for (String genre:genres){
                if (map.containsKey(genre)){
                    map.put(genre,map.get(genre)+1);
                }
                else{
                    map.put(genre,1);
                }
            }
        }
        ArrayList<Map.Entry<String, Integer>> sorted = new ArrayList<>();
        ArrayList<Map.Entry<String,Integer>> sortedYears = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            sorted.add(entry);
        }
        for (Map.Entry<String, Integer> entry : mapYears.entrySet()){
            sortedYears.add(entry);
        }
        sorted.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        sortedYears.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Movie in different genres: ");
        for (Map.Entry<String, Integer> entry : sortedYears) {
            System.out.println(entry.getValue() + " instances of " + entry.getKey());
        }
        
        ArrayList<Map.Entry<Integer, Integer>> sortedd = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : howMany.entrySet()){
            sortedd.add(entry);
        }
        sortedd.sort((a, b) -> a.getKey().compareTo(b.getKey()));
        
        System.out.println("");
        System.out.println("Movies released per year: ");
        for (Map.Entry<Integer, Integer> entry : sortedd) {
            System.out.println(entry.getValue() + " movies in year " + entry.getKey());
        }
    }
}
