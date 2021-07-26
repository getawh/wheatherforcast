package wheatherForcast;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class wheatherForcast {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/wheatherForcast/read.txt");
        Scanner input = new Scanner(file);
        ArrayList <String> city = new ArrayList<>();
        ArrayList <ArrayList> all = new ArrayList<>();
        while(input.hasNextLine()){
            String text = input.nextLine();
            System.out.println(text);
            String newList[] = text.split(" ");
            ArrayList<String> news = new ArrayList<String>();
            for(int i = 0;i<newList.length;i++) {
                news.add(newList[i]);

            }
            all.add(news);

        }
        System.out.println();
        //===================================================================//
        System.out.println("\tDAILY REPORT");
        for (int i = 7; i<all.get(0).size();i+=7){
            int min = 10000;
            int max = 0;

            for(int k = 0;k<all.size();k++){
                if (Integer.parseInt((String)all.get(k).get(i-3))<min){
                    min = Integer.parseInt((String)all.get(k).get(i-3));
                }
            }
            for (int k = 0;k<all.size();k++){

                if (Integer.parseInt((String)all.get(k).get(i))>max){
                    max = Integer.parseInt((String)all.get(k).get(i));
                }

            }
            System.out.println(all.get(0).get(i-6) + "   MIN = "+ min + "     MAX = "+max );
        }
        System.out.println();

        //======================================================//

        System.out.println("\t WEEKLY HOTTEST CITY! ");
        int hot = 0;
        int index = 0;

        for(int i = 0; i<all.size();i++){
            int temp = 0;
            for (int k = 7; k<all.get(0).size();k+=7){
                temp+=Integer.parseInt((String) all.get(i).get(k));
            }
            if(temp>hot){
                hot = temp;
                index = i;
            }

        }
        System.out.println(all.get(index).get(0));
        System.out.println();

        //=========================================================================//

        System.out.println("\t WEEKLY COLDEST CITY! ");
        int cold = 1000;
        index = 0;
        for(int i = 0; i<all.size();i++){
            int temp = 0;
            for (int k = 4; k<all.get(i).size();k+=7){
                temp+=Integer.parseInt((String) all.get(i).get(k));
            }
            if(temp<cold){
                index = i;
                cold = temp;
            }
        }
        System.out.println(all.get(index).get(0));
    }
}




