package com.sxmd.util;

/**
 * Description:  经纬度工具类
 *
 * @author cy
 * @date 2020年05月08日 10:53
 * Version 1.0
 */
public class LngLatUtil {

    private static double PI = Math.PI;
    private static double EARTH_RADIUS = 6378137;
    private static double RAD = Math.PI / 180.0;

    /**
     * Description:
     *
     * @param lng: 经度
     * @param lat: 纬度
     * @param raidus:  半径(米)
     * @return double[]
     * @author cy
     * @date  2020/5/8 10:57
     */
    public static double[] GetAround(double lng,double lat, int raidus)
    {
        Double latitude = lat;
        Double longitude = lng;
        Double degree = (24901 * 1609) / 360.0;
        double raidusMile = raidus;

        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidusMile;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;

        Double mpdLng = degree * Math.cos(latitude * (PI / 180));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidusMile;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;
        return new double[] { minLng, minLat, maxLng, maxLat};
    }

    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
     * @param lng1
     * @param lat1
     * @param lng2
     * @param lat2
     * @return
     */
    public static double getDistance(double lng1, double lat1, double lng2, double lat2)
    {
        double radLat1 = lat1*RAD;
        double radLat2 = lat2*RAD;
        double a = radLat1 - radLat2;
        double b = (lng1 - lng2)*RAD;
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000D;
        return s;
    }

    public static void main(String[] args){
        Double lat1 = 34.264648;
        Double lon1 = 108.952736;
        int radius = 1000;
        double[] doubles = GetAround(lat1, lon1, radius);
        double dis = getDistance(108.952736,34.264648,116.407288,39.904549);
    }

}
