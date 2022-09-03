package com.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * O(n) - RunTime Complexity
 * Runtime - 403 ms
 * Memory - 125.2 MB
 */
public class _295_FindMedianFromDataStream_02 {

    static class MedianFinder {

        List<Integer> list;

        public MedianFinder() {
            list = new ArrayList<>(50001);
        }

        private int findPosByBinarySearch(int num){
            int start, mid, end;
            start = 0;
            end = list.size() - 1;
            while( start <= end ){
                mid = (start + end)/2;
                if( num == list.get(mid) )
                    return mid;
                else if( num < list.get(mid) ){
                    if( mid == 0 )
                        return 0;
                    if( num <= list.get(mid - 1) ){
                        end = mid - 1;
                        continue;
                    }
                    return mid;
                }
                else{
                    if( mid == list.size() - 1 )
                        return -1;
                    if( list.get(mid+1) <= num){
                        start = mid + 1;
                        continue;
                    }
                    return mid + 1;
                }
            }
            return -1;
        }

        public void addNum(int num) {
            int post = findPosByBinarySearch(num);
            if( post == -1 )
                list.add(num);
            else
                list.add(post, num);
        }

        public double findMedian() {
            System.out.println(list);
            if( list.size() % 2 == 0 ){
                // even size
                double res = list.get( (list.size()/2) - 1 );
                return (res + list.get( list.size()/2 ) )  / 2;
            }
            return list.get( list.size()/2 );
        }
    }

    public static void main(String[] args) {
        _295_FindMedianFromDataStream_01.MedianFinder mf = new _295_FindMedianFromDataStream_01.MedianFinder();
        mf.addNum(6);
        mf.addNum(10);
        mf.addNum(2);
        //mf.findMedian();
        mf.addNum(6);
        // mf.findMedian();
        mf.addNum(5);
        //mf.findMedian();
        mf.addNum(0);
        mf.findMedian();
        mf.addNum(6);
        mf.findMedian();

        mf.addNum(3);
        //mf.findMedian();

        mf.addNum(1);

        //mf.findMedian();

    }
}
