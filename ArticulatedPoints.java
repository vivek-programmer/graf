public class ArticulatedPoints {
    static class Edge {
        int src;
        int des;
        public Edge(int s,int d){
            this.src=s;
            this.des=d;
        }
    }
    public static void getap(ArrayList<Edge>graph[],int V){
        int dt[]=new int [V];
        int low[]=new int [V];
        int time=0;
        boolean visi[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visi[i]){
                dfs(graph,i,-1,dt,low,visi,time);
            }
        }
    }
    public static void dfs(ArrayList<Edge>graph[],int curr,int par,int dt[],int low[],boolean visi[],int time){
        visi[curr]=true;
        dt[curr]=low[curr]=++time;
        int c=0
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            int neigh=e.des;
            if(par==e.des){
                continue;
            } else if(visi[e.des]) {
                low[curr]=Math.min(low[curr],dt[neigh]);
            }else {
                dfs(graph,neigh,curr,dt,low,visi,time);
                low[curr]=Math.min(low[curr], low[neigh]);
                if(par!=-1&&dt[curr]<=low[neigh]){                // BEAWARE OF GEETING SAME AP PRINTED MULTIPLE TIME SO MAKE A BOOLENA TYPE ARRAY AP THEN GET THE ELEMEMT INTO IT THEN PRINT IT IN LAST
                    System.out.println("Ap is"+curr);
                }
                c++;
            }
        }
        if(par==-1&&c>1){
            System.out.println("Ap is"+curr);
        }
    }
    public static void main(String[] args) {
        
    }
}
