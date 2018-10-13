package org.java.bin.exam.头条;



/**
 * Created by wangbin on 2017/8/22.
 */
import java.util.*;
public class 最大点 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            Point point = new Point(x, y);
            points[i] = point;
        }

        if (!isSorted(points)) {
            quickSort(points);
        }

        int maxY = Integer.MIN_VALUE;
        List<Point> maxPoints = new ArrayList<>(500000);
        for (int i = n - 1; i >= 0; i--) {
            Point point = points[i];
            if (point.y > maxY) {
                maxPoints.add(point);
                maxY = point.y;
            }
        }
        for (int i = maxPoints.size() - 1; i >= 0; i--) {
            Point point = null;
            if (i >= 0) {
                point = maxPoints.get(i);
            }
            System.out.println(point.x + " " + point.y);
        }
    }

    public static boolean isSorted(Point[] points) {
        if (points == null || points.length == 0) {
            return false;
        }
        int length = points.length;

        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            Point point = points[i];
            if (point.x <= pre) {
                return false;
            }
            pre = point.x;
        }
        return true;
    }

    public static void quickSort(Point[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(Point[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            qSort(arr, low, pivot - 1);
            qSort(arr, pivot + 1, high);
        }
    }

    private static int partition(Point[] arr, int low, int high) {
        Point pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high].compareTo(pivot) > 0) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low].compareTo(pivot) < 0) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = pivot;
        return low;
    }
}

class Point implements Comparable{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Point){
            return this.x - ((Point) o).x;
        }
        return 0;
    }
}
