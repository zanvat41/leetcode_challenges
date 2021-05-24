class naiveSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] a = new int[n];
        merge(nums1, nums2, nums1.length, nums2.length, a);
        double m=0;
        if(n%2==1)
        {
            //System.out.println(123);
            m=a[(n+1)/2-1];
        }
        else
        {
            //System.out.println(a[n/2]);
            m=(double)(a[n/2-1]+a[n/2]);
            m = m / 2;
        }
        return m;
    }

    public static void merge(int[] arr1, int[] arr2, int n1,
                             int n2, int[] arr3)
    {
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i<n1 && j <n2)
        {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        // Store remaining elements of first array
        while (i < n1)
            arr3[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < n2)
            arr3[k++] = arr2[j++];
    }
}
