class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            List<Integer> row = getRow(i);
            ans.add(row);
        }
        return ans;
    }

    public List<Integer> getRow(int row){
        int prev = 1;
        List<Integer> rowList = new ArrayList<>();
        rowList.add(1);
        int n = row;
        for(int i=1; i < n; i++){
            row--;
            int res = prev * row;
            res = res / i;
            rowList.add(res);
            prev = res; 
        }
        return rowList;
    }
}