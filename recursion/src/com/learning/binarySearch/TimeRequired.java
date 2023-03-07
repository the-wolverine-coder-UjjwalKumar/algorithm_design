package com.learning.binarySearch;

public class TimeRequired {

    public static void main(String[] args) {
        int[] time = {1,2,3};
        int totalTrips = 5;
        long ans = minimumTime(time, totalTrips);
        System.out.println(ans);
    }

    public static long minimumTime(int[] time, int totalTrips) {

        long low = 0;
        long high = time.length;
        long ans = 0;
        while(low<=high){
            long mid = (low+(high-low)/2);
            if(solve(mid,time,totalTrips)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static boolean solve(long mid, int[] time , long totalTrips){
        long count = 0;
        for(int i =0 ; i< time.length ; i++){
            long t = time[i];
            count+= mid/t;
            if(count>=totalTrips) return true;
        }
        return false;
    }
}

