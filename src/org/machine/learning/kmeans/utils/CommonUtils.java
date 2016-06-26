package org.machine.learning.kmeans.utils;

import java.io.IOException;
import java.util.List;

import org.core.utils.files.FileWriteUtils;
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
public class CommonUtils {

    public static double getPointsDistance(Point2D point1, Point2D point2) {
        int differX = point1.getX() - point2.getX();
        int differY = point1.getY() - point2.getY();
        return Math.sqrt(differX * differX + differY * differY);
    }
    
    public static double getPointsDistanceSquare(Point2D point1, Point2D point2) {
        int differX = point1.getX() - point2.getX();
        int differY = point1.getY() - point2.getY();
        return differX * differX + differY * differY;
    }
    
    public static void showCentroidClusters(List<Centroid> centroids) {
        for (Centroid centroid : centroids) {
            System.out.println(centroid);
            System.out.println("\t" + centroid.getCluster() + "\n");
        }
    }
    
    public static void writeCentroids(List<Centroid> centroids, String savePath) {
        try {
            for (int index = 0; index < centroids.size(); index++) {
                FileWriteUtils.appendFile(savePath + "centroid_" + index, centroids.get(index).toStringFormat());
                
                StringBuffer buffer = new StringBuffer();
                List<Point2D> point2ds = centroids.get(index).getCluster();
                for (Point2D point2d : point2ds) {
                    buffer.append(point2d.toStringFormat() + "\n");
                }
                FileWriteUtils.appendFile(savePath + "points_" + index, buffer.toString());
            }
        } catch (IOException e) {
        }
    }
}
