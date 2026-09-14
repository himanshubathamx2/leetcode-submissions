class DisjointSetBySize {
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    DisjointSetBySize(int nodes){
        for(int i=0;i<nodes;i++){
            size.add(1);
            parent.add(i);
        }
    }


    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSetBySize ds = new DisjointSetBySize(n);
        int extraEdges = 0;
        for(int[] edge : connections){
            int ult_u = ds.findUPar(edge[0]);
            int ult_v = ds.findUPar(edge[1]);
            if(ult_u == ult_v){
                extraEdges++;
                continue;
            }
            ds.unionBySize(edge[0], edge[1]);
        }

        int nCnt = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            int ult_parent = ds.findUPar(i);
            set.add(ult_parent);
        }

        nCnt = set.size();

        return extraEdges >= nCnt-1 ? nCnt - 1 : -1;  
    }
}