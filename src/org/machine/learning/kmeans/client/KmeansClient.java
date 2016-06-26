package org.machine.learning.kmeans.client;

import java.util.List;

import org.machine.learning.kmeans.core.KmeansCore;
import org.machine.learning.kmeans.model.Centroid;
import org.machine.learning.kmeans.model.Point2D;
import org.machine.learning.kmeans.utils.CommonUtils;
import org.machine.learning.kmeans.utils.KmeansUtils;

/**
 * <p></p>
 * Create Date: 2016年6月24日
 * Last Modify: 2016年6月24日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.0.1
 */
public class KmeansClient {
    
    public static void main(String[] args) {
        new KmeansClient().execute(10, 100);
    }
    
    private void execute(int k, int threshold) {
        KmeansCore core = new KmeansCore();
        List<Point2D> point2ds = KmeansUtils.randomPoint2DSet(1000, 1000, 10000);
        List<Centroid> centroids = KmeansUtils.randomSelectCentroidSet(point2ds, k);
        
        core.positionCentroidCluster(point2ds, centroids, threshold);
        CommonUtils.showCentroidClusters(centroids);
        
        // 这里把结果输出到文件中，这样就可以使用可视化工具验证了
        // 我目前使用的是 Gnuplot, 很好用。
        CommonUtils.writeCentroids(centroids, "F:/Temp/kmeans/");
    }
}
