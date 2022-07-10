import java.util.*;

class Program {
	public static List<Integer> spiralTraverse(int[][] array) {
		// Write your code here.
		List<Integer> res = new ArrayList<Integer>();
		int endrow = array.length - 1;
		int endcolumn = array[0].length - 1;
		int startrow = 0, startcolumn = 0;
		while(startrow <= endrow && startcolumn <= endcolumn){
			for(int column = startcolumn; column <= endcolumn; column++){
				res.add(array[startrow][column]);
			}
			for(int row = startrow+1; row <= endrow; row++){
				res.add(array[row][endcolumn]);
			}
			for(int column = endcolumn - 1; column >= startcolumn; column--){
				if(startrow == endrow)
					break;
				res.add(array[endrow][column]);
			}
			for(int row = endrow - 1; row > startrow; row--){
				if(startcolumn == endcolumn)
					break;
				res.add(array[row][startcolumn]);
			}
			startcolumn++;
			endcolumn--;
			startrow++;
			endrow--;
		}
		return res;
	}
}
