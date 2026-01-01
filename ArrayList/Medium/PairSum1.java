package ArrayList.Medium;
import java.util.ArrayList;
public class PairSum1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=6;i++){
            list.add(i); // 1 2 3 4 5 6
        }
        int target = 5;

        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j) == target){
                    System.out.println(list.get(i)+"+"+list.get(j)+" = "+(list.get(i)+list.get(j)));
                }
            }
        }
    }
}
