package org.machine.learning.kmeans.utils;

import java.util.ArrayList;
import java.util.List;

import org.core.utils.nums.RandomUtils;
import org.machine.learning.kmeans.model.Centroid;
import org.machine.learning.kmeans.model.Point2D;

/**
 * <p></p>
 * Create Date: 2016年6月24日
 * Last Modify: 2016年6月24日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.0.1
 */
public class KmeansUtils {

    /**
     * 随机生成测试数据集
     * 
     * @param maxAxisX
     * @param maxAxisY
     * @param size
     * @return
     */
    public static List<Point2D> randomPoint2DSet(int maxAxisX, int maxAxisY, int size) {
        List<Point2D> resultSet = new ArrayList<>();
        List<Integer> axisXList = new RandomUtils().randomList(maxAxisX, size);
        List<Integer> axisYList = new RandomUtils().randomList(maxAxisY, size);
        
        for (int index = 0; index < size; index++) {
            resultSet.add(new Point2D(axisXList.get(index), axisYList.get(index)));
        }
        
        return resultSet;
    }
    
    /**
     * 从原始点集合中随机挑选出 k 个作为质心
     * 
     * @param point2ds
     * @param k
     * @return
     */
    public static List<Centroid> randomSelectCentroidSet(List<Point2D> point2ds, int k) {
        List<Integer> randomIndexs = new RandomUtils().randomSet(point2ds.size() - 1, k);
        List<Centroid> centroids = new ArrayList<>();
        for (int index : randomIndexs) {
            Point2D tmpPoint2d = point2ds.get(index);
            centroids.add(new Centroid(tmpPoint2d.getX(), tmpPoint2d.getY()));
        }
        
        return centroids;
    }
}
