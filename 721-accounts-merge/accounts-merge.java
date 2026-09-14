class Solution {
    public List<List<String>> accountsMerge(List<List<String>> details) {
        int n = details.size();
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);
        for(int i=0; i<n; i++){
            for(int j=1; j<details.get(i).size(); j++){
                String name = details.get(i).get(j);
                if(!map.containsKey(name))
                    map.put(name, i);
                else{
                    ds.unionBySize(i, map.get(name));
                }    
            }
        }

        ArrayList<String>[] arr = new ArrayList[n];
        for(int i=0; i<n; i++) 
            arr[i] = new ArrayList<>();
        for(Map.Entry<String, Integer> mapping : map.entrySet()){
            String mail = mapping.getKey();
            int node = ds.findUPar(mapping.getValue());
            arr[node].add(mail);
        }   

        for(int i=0; i<arr.length; i++){
            List<String> mails = arr[i];
            if(mails.isEmpty()) continue;
            String name = details.get(i).get(0);
            List<String> tmp = new ArrayList<>();
            tmp.add(name);
            Collections.sort(mails);
            for(String mail : mails){
                tmp.add(mail);
            }
            ans.add(tmp);
        } 
        return ans;
    }
}


class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}   