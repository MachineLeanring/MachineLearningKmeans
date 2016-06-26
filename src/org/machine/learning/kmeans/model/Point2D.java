package org.machine.learning.kmeans.model;

/**
 * <p>
 * 算法中使用的二维平面中的点对象
 * </p>
 * Create Date: 2016年6月24日
 * Last Modify: 2016年6月24日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.0.1
 */
public class Point2D {

    int x;
    int y;
    boolean isCentroid = false;
    
    public Point2D() {
    }
    
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public boolean isCentroid() {
        return isCentroid;
    }
    
    public String toStringFormat() {
        return x + " " + y;
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
//        return x + " " + y;
    }
}
