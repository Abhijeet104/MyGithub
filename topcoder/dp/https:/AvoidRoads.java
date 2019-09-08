/** https://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709
*/


public class Main {
    static int m=0;
    static int n=0;
    public static void main(String[] args) {
        int width = 95;
        int height = 16;
        String[] bad = {};
        
        System.out.println(getMaxPaths(width,height,bad));  
        
    }
    public static long getMaxPaths(int width,int height,String[] bad){
        Set<String> set = new HashSet<>();
        for(int i=0;i<bad.length;i++){
            set.add(bad[i]);
        }
        m = width+1;
        n=height+1;
        int[][] roads = new int[m][n];
        Map<String,Long> map = new HashMap<>();

        return traverse(roads,set,map,0,0);
    }

    public static long traverse(int[][] a, Set<String> set, Map<String,Long> map,int i, int j){
        if(i>=n || j >= m)
            return 0;
        if(i==n-1 && j==m-1)
            return 1;
        if(map.containsKey(i+"-"+j))
            return map.get(i+"-"+j);
        
        long top = 0;
        long right = 0;
        if(!set.contains(i+" "+j+" "+i+" "+(j+1)) && !set.contains(i+" "+(j+1)+" "+i+" "+j) )
            top =  traverse(a,set,map,i,j+1) ;
        // else
        //     System.out.println(i+"-"+j+" ----i-j+1----------");
        if(!set.contains(i+" "+j+" "+(i+1)+" "+j) && !set.contains((i+1)+" "+j+" " +i+" "+j))
            right = traverse(a,set,map,i+1,j);
        // else
        //     System.out.println(i+"-"+j+" ----i+1-J---------");

        map.put(i+"-"+j,(top+right));
       // System.out.println(i+"-"+j+" "+(top+right));
        return (top + right);

    }
 
}
