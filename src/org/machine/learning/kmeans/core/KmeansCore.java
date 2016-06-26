package org.machine.learning.kmeans.core;

import java.util.List;

import org.machine.learning.kmeans.model.Centroid;
import org.machine.learning.kmeans.model.Point2D;
import org.machine.learning.kmeans.utils.CommonUtils;

/**
 * <p>
 * K-means 算法的核心类
 * </p>
 * Create Date: 2016年6月24日
 * Last Modify: 2016年6月24日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.0.1
 */
public class KmeansCore {

    /**
     * 定位每个坐标的质心
     * 
     * @param point2ds
     *      原坐标点数据集
     * @param centroids
     *      质心集合
     * @param threshold
     *      阈值：用于终止算法
     */
    public void positionCentroidCluster(List<Point2D> point2ds, List<Centroid> centroids, int threshold) {
        positionCentroidCluster(point2ds, centroids, 0, threshold, 0);
    }
    
    // TODO -------------------------------------------- private separated line ----------------------------------------------
    
    /**
     * 定位每个坐标的质心
     * 
     * @param point2ds
     * @param centroids
     * @param lastDistanceSum
     * @param threshold
     */
    private void positionCentroidCluster(List<Point2D> point2ds, List<Centroid> centroids, double lastDistanceSum, int threshold, int times) {
        for (Point2D point2d : point2ds) {
            Centroid minDistanceCentroid = getMinDistanceCentroid(point2d, centroids);
            minDistanceCentroid.addPoint2D(point2d);
        }
        
        moveAllCentroidsToClusterCenter(centroids);
        double distanceSum = getPointDistanceSquareSum(centroids);
        double assess = Math.abs(distanceSum - lastDistanceSum);
        if (assess > threshold) {
            clearAllCentroidClusters(centroids);
            positionCentroidCluster(point2ds, centroids, distanceSum, threshold, times + 1);
        }
    }
    
    /**
     * 获取到坐标点最近的质心点
     * 
     * @param point2d
     * @param centroids
     * @return
     */
    private Centroid getMinDistanceCentroid(Point2D point2d, List<Centroid> centroids) {
        Centroid minCentroid = null;
        double minDistance = Double.MAX_VALUE;
        for (Centroid centroid : centroids) {
            double distance = CommonUtils.getPointsDistance(point2d, centroid);
            if (minDistance > distance) {
                minDistance = distance;
                minCentroid = centroid;
            }
        }
        return minCentroid;
    }
    
    /**
     * 将质心移动到簇的中心位置
     * 
     * @param centroids
     * @return
     */
    private void moveAllCentroidsToClusterCenter(List<Centroid> centroids) {
        for (Centroid centroid : centroids) {
            moveCentroidToClusterCenter(centroid);
        }
    }
    
    /**
     * 清空所有质心的簇，以便重新添加
     * 
     * @param centroids
     */
    private void clearAllCentroidClusters(List<Centroid> centroids) {
        for (Centroid centroid : centroids) {
            centroid.clearCluster();
        }
    }
    
    /**
     * 将质心移动到簇的中心位置
     * 
     * @param centroid
     */
    private void moveCentroidToClusterCenter(Centroid centroid) {
        List<Point2D> point2dCluster = centroid.getCluster();
        int coordinateXSum = 0;
        int coordinateYSum = 0;
        for (Point2D point2d : point2dCluster) {
            coordinateXSum += point2d.getX();
            coordinateYSum += point2d.getY();
        }
        
        centroid.setX(coordinateXSum / point2dCluster.size());
        centroid.setY(coordinateYSum / point2dCluster.size());
    }
    
    /**
     * 计算所有质心与相应簇中的距离平方和
     * 
     * @param centroids
     * @return
     */
    private double getPointDistanceSquareSum(List<Centroid> centroids) {
        double assess = 0.0;
        for (Centroid centroid : centroids) {
            List<Point2D> subCluster = centroid.getCluster();
            for (Point2D centroidMember : subCluster) {
                assess += CommonUtils.getPointsDistanceSquare(centroidMember, centroid);
            }
        }
        
        return assess;
    }
}
