package org.machine.learning.kmeans.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 质心
 * </p>
 * Create Date: 2016年6月24日
 * Last Modify: 2016年6月24日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.0.1
 */
public class Centroid extends Point2D {
    
    private List<Point2D> cluster = null;
    
    public Centroid() {
        init();
    }
    
    public Centroid(int x, int y) {
        this.x = x;
        this.y = y;
        init();
    }
    
    private void init() {
        cluster = new ArrayList<>();
        setCentroid();
    }
    
    private void setCentroid() {
        this.isCentroid = true;
    }
    
    public List<Point2D> getCluster() {
        return cluster;
    }
    
    public void addPoint2D(Point2D point) {
        cluster.add(point);
    }
    
    public void clearCluster() {
        cluster.clear();
    }
    
    public String toStringFormat() {
        return x + " " + y;
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
