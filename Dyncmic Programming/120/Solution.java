import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int column = triangle.get(row-1).size();
        int[][] dpArray = new int[row][column];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(i > 0 && j > 0){
                    if(j == triangle.get(i).size() - 1)
                        dpArray[i][j] = dpArray[i - 1][j - 1];
                    else
                        dpArray[i][j] = Math.min(dpArray[i - 1][j], dpArray[i - 1][j - 1]);
                }else if(i > 0){
                    dpArray[i][j] = dpArray[i - 1][j];
                }else if(j > 0){
                    dpArray[i][j] = dpArray[i][j - 1];
                }
                // this is why should not init dpArray[0][0]
                dpArray[i][j] += triangle.get(i).get(j);
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                System.out.print(dpArray[i][j]);
            }
            System.out.println("======");
        }
        Arrays.sort(dpArray[row - 1]);
        return dpArray[row - 1][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        int[] a = {2};
        int[] b = {3, 4};
        int[] c = {6, 5, 7};
        int[] d = {4, 1, 8, 3};
        triangle.add(Arrays.stream(a).boxed().collect(Collectors.toList()));
        triangle.add(Arrays.stream(b).boxed().collect(Collectors.toList()));
        triangle.add(Arrays.stream(c).boxed().collect(Collectors.toList()));
        triangle.add(Arrays.stream(d).boxed().collect(Collectors.toList()));
        int res = solution.minimumTotal(triangle);
        System.out.println(res);
    }
}