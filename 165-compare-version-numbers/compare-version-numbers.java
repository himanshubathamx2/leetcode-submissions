class Solution {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int max = Math.max(strs1.length, strs2.length);
        for(int i=0; i<max; i++){
            int v1 = i < strs1.length ? Integer.parseInt(strs1[i]+""): 0;
            System.out.println(v1);
            int v2 = i < strs2.length ? Integer.parseInt(strs2[i]+""): 0;
            if(v1 > v2)
                return 1;
            else if(v1 < v2)
                return -1;        
        }
        return 0;
        
    }
}