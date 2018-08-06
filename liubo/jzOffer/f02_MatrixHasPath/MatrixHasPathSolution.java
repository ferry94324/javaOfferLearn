package liubo.jzOffer.f02_MatrixHasPath;

import org.junit.Test;

public class MatrixHasPathSolution {
    @Test
    public void test() {
        String strs = "ABCESFCSADEE";
        char[] matrix = strs.toCharArray();
        int rows = 3;
        int cols = 4;
        String str = "ADEF";
        boolean flag = hasPath(matrix, rows, cols, str.toCharArray());
        System.out.println(flag);
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 异常输入
        if (matrix == null || rows <= 0 || cols <= 0 || str == null || str.length == 0)
            return false;
        //visited记录矩阵对应元素是否已经被访问
        boolean[] visited = new boolean[rows * cols];
        //pathLength记录当前判断的元素下标
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCode(matrix, rows, cols, row, col, str, pathLength, visited))
                    return true;
            }
        }
        return false;
    }

    /*
     * 判断指定row,col是否为str[pathLength]，如果是，循环判断下一个元素
     * 否则返回false
     */
    private boolean hasPathCode(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
                                boolean[] visited) {
        if (pathLength == str.length)
            return true;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength]
                && visited[row * cols + col] == false) {
            visited[row * cols + col] = true;
            pathLength++;
            if (hasPathCode(matrix, rows, cols, row + 1, col, str, pathLength, visited)
                    || hasPathCode(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCode(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCode(matrix, rows, cols, row, col - 1, str, pathLength, visited))
                return true;
            // 把不在该路径上的，且设为true的字符重新设为false
            visited[row * cols + col] = false;
        }
        return false;
    }
}