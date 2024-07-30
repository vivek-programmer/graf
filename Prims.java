
import java.util.PriorityQueue;

public class Prims {
    static class Edge implements Comparable<Edge> {
        int des ;
        int wt;
        public Edge (int d,int w){
            this.des=d;
            this.wt=w;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt-e2.wt;
        }
    }
    public static int connnectcitise (int citise[][]){
      PriorityQueue<Edge>q=new PriorityQueue<>();
      boolean visi[]=new boolean[citise.length];
      q.add(new Edge(0, 0));
          int c=0;
      while (!q.isEmpty()){
        Edge curr=q.remove();
            if(!visi[curr.des]){
                visi[curr.des]=true;
                c+=curr.wt;
                for(int i=0;i<citise[curr.des].length;i++){
                   if(citise[curr.des][i]!=0){
                    q.add(new Edge (i,citise[curr.des][i]));
                   }
                }
            }
      }   // SIMILAR TO PRIMS ALGOTHRIUMS USED IN FINDING MINIMUMS SPANNING TREES MST
      return c;
    }
    
    public static void main(String[] args) {
        int citise [][]={{0,1,2,3,4},
                          {1,0,5,0,7},
                          {2,5,0,6,0},
                          {3,0,6,0,0},
                          {4,7,0,0,0}                        
                        };
         System.out.println(connnectcitise(citise));               
    }
}
