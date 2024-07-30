import java.util.*;
public class cheapWithinK {
        static class Edge {
            int src ;
            int des;
            int wt;
            public Edge (int s,int d ,int w){
                this.src=s;
                this.des=d;
                this.wt=w;
            }
        }
        public static void CreatGreaph(int fligths[][],ArrayList<Edge>graph[]){
            for(int i=0;i<graph.length;i++){
                graph[i]=new ArrayList<>();
            }
            for(int i=0;i<fligths.length;i++){
                int src=fligths[i][0];
                int des =fligths[i][1];
                int wt=fligths[i][2];
                Edge e =new Edge(src, des, wt);
                graph[src].add(e);
            }
        }
    public static int CheapMain(int flight[][],int src,int des,int k,int n){
        ArrayList<Edge>graph[]=new ArrayList[n];
        CreatGreaph(flight, graph);
        int dis[]=new int[n];
        for(int i=0;i<dis.length;i++){
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Info>q=new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while (!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i=0;i<graph[curr.V].size();i++){
                Edge e= graph[curr.V].get(i);
                int u=e.src;
                int v=e.des;
                int wt=e.wt;
                if(dis[u]!=Integer.MAX_VALUE&&curr.cost+wt<dis[v]&&curr.stops<=k){
                    dis[v]=curr.cost+wt;
                    q.add(new Info(v , dis[v], curr.stops+1));

                }
            }
        }
        if(dis[des]==Integer.MAX_VALUE){
            return -1;
        }else {
           return dis[des];
        }
        
    }
       static class Info{
        int V;
        int cost;
        int stops;
        public Info(int v,int c,int s){
            this.V=v;
            this.cost=c;
            this.stops=s;
        }
       }
    public static void main(String[] args) {
        int n=4;
        int flight[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0;
        int des=3;
        int k=1;
        System.out.println(CheapMain(flight, src, des, k, n));
        
    } 
}
ArrayList<Edge>graph[]=new ArrayList[n];
crate(flights,graph);
int dist[]=new int[n];
for(int i=0;i<dist.length;i++){
    if(i!=src){
        dist[i]=Integer.MAX_VALUE;
    }
}
 Queue<Info>q=new LinkedList<>();
q.add(new Info(src,0,0));
while(!q.isEmpty()){
    Info curr=q.remove();
    if(curr.stops>k){
        break;
    }
    for(int i=0;i<graph[curr.V].size();i++){
        Edge e=graph[curr.V].get(i);
        int u=e.src;
        int v=e.des;
        int wt=e.wt;
        if(dist[u]!=Integer.MAX_VALUE&&curr.cost+wt<dist[v]&&k<=curr.stops){
            dist[v]=curr.cost+wt;
            q.add(new Info(v,dist[v],curr.stops+1));
        }
    }
}
if(dist[des]==Integer.MAX_VALUE){
    return -1;
}else {
    return dist[des];
}