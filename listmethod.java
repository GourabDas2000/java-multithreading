
public class listmethod {
    public void conqure(int arr[] , int start , int mid , int end){
        int[] n1 = new int[mid - start+1];
        int[] n2 = new int[end-mid];
        int i = 0,j=0, k = start;
        for (i = 0 ; i<n1.length ; i++){
            n1[i] = arr[k];
            k++;
        }
        k = mid+1;
        for (j = 0 ; j<n2.length ; j++){
            n2[j] = arr[k];
            k++;
        }
        i=0; 
        j = 0; 
        k = start;
        while ( i < n1.length && j < n2.length) {
            if(n1[i]<n2[j]){
                arr[k] = n1[i];
                i++;
            }
            else{
                arr[k] = n2[j];
                j++;
            }
            k++;
        }
        while (i<n1.length) {
            arr[k] = n1[i];
            k++;
            i++;
        }
        while (j<n2.length) {
            arr[k] = n2[j];
            k++;
            j++;
        }

    }

    public void divide(int arr[] , int start , int end){
        if(start < end){
            int mid = start + (end -start) / 2 ;
            divide(arr, start, mid);
            divide(arr, mid+1 , end);
            conqure(arr,start,mid , end);
        }
    }
    
     public static void main(String args[]){
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        listmethod l = new listmethod();
        l.divide(arr, 0, arr.length-1 );
        for(int i = 0 ; i<arr.length ; i++ ){
            System.out.println(arr[i]);
        }

        // ArrayList<Integer> l = new ArrayList<Integer>();
        // l.add(2);
        // for(int i = 0 ;i<10 ; i++){
        //     l.add(i+1);
        // }
        // Iterator<Integer> iterator = l.iterator();
        // iterator.remove();
        // System.err.println(l);
        
        
        //Hashmap in java
        // HashMap<String,String> hashMap = new HashMap<String,String>();
        // for(int i = 0; i<10;i++){
        //    hashMap.put(Integer.toString(i),String.valueOf(i));
        // }
        
        // System.out.println(hashMap.computeIfAbsent("11", (key) -> key));
        // hashMap.forEach((item,i) -> System.out.println(item));
        
        // Queue<Integer> queue = new ArrayDeque <>();
        // queue.size();
        // Deque <String> d = new ArrayDeque<>();
        // d.getClass();
        // System.err.println(5/2);
        
    }
}
