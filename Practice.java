class Solution{
    public static int binarysearch(int[] l,int target){
        int start = 0 , end = l.length;
        while(start <= end){
            int mid = start + (end - start)/2 ;
            if(l[mid] > target){
                end = mid - 1;
            }
            else if(l[mid] < target){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,89,90,112};
            
        int res = binarysearch(arr, 112);
        System.out.println(res);
    }
}