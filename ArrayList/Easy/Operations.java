package ArrayList.Easy;

import java.util.ArrayList;
public class Operations {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

    //1. add() operation : == > O(1)
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println(list);

    // 2.get() operation :== > O(1)
        int element = list.get(2);
        System.out.println("Get Element at index 2 :"+element);

    //3.remove() operation :== > O(n)
        list.remove(2);
        System.out.println("Index 2 Element Remove then list :"+list);
    
    // 4.set() operation :== > O(1)
    //  set(index,value)
        list.set(3,60);
        System.out.println("Index 3 value set then list :"+list);

    //5.contains() operation :==> O(n)
    //  conation(value) := > exist - > true , not exist -> false
       System.out.println("Exists :"+list.contains(10));
        System.out.println("Not exists :"+list.contains(70));


        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(40);
        list2.add(50);
        System.out.println(list2);
        int e = list2.get(1);
        System.out.println("get element of index 1 :"+e);

        list2.add(1,90); // add(index,value) -> O(n)
        System.out.println(list2);

        int changeE = list2.get(1);
        System.out.println("get element of index 1 :"+changeE);

        //size method
        System.out.println("Size of list2 is :"+list2.size());
       
        // print all elements of list2
        for(int i=0;i<list2.size();i++){
            System.out.print(list2.get(i)+" ");
        }
        System.out.println();
    }
}
