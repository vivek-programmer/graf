public class DisJoint {
    static int =7;
    static int par[]=new int[n];
    static int rank[]=new int[n];
    public static void init( ){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    public static int  find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]= find(par[x]);
    }
    public static void union (int a,int b){
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB]){
            par[parA]=parB;
            rank[parB]++;
        }else if(rank[parB]>rank[parA]){
            par[parA]=parB;
        }else {
            par[parB]=parA;  // SEE THE CODE ONE MORE TIME FOR BETTER CLARITY
        }
    }
    public static void main(String[] args) {
        
    }
}
