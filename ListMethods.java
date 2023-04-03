import java.util.*;

public class ListMethods
{
    public static void main(String[] args){
       ArrayList<Integer> l = makeList(3457);
       ArrayList<Integer> x = reverseList(l);
       System.out.println(l); 
       System.out.println(x); 
    }
    
    
    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        if (n <= 0)  // The smallest list we can make
        {
            return tempList;
        }
        else        // All other size lists are created here
        {
            tempList = makeList(n-1); 
        }
        tempList.add(n);
        return tempList;
    }

    public static ArrayList<Integer> reverseList(ArrayList<Integer> rl){
        ArrayList<Integer> cAL = deepClone(rl);
        if(cAL.size() == 0){
            return cAL;
        }
        else{
            int first = cAL.get(0); 
            cAL.remove(0);
            cAL = reverseList(cAL); 
            cAL.add(first);
            return cAL; 
        }
    }

    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (Integer i : tList)
        {
            list.add(new Integer(i));
        }
        return list;
    }
}