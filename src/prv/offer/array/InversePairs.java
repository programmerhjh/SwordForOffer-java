package prv.offer.array;

/**
 * 数组中的逆序对
 * 归并排序判断数组中的逆序对
 * @author HJH
 *
 * @date 2019年3月11日
 */
public class InversePairs {
	public int inversePairs(int [] array) {
        if (array.length == 0) {
			return 0;
		}
		return mergeSort(0, array.length-1, array)%1000000007;
    }
    public int mergeSort(int l, int r, int[] arr){
        if(l >= r){
            return 0;
        }
		int m = l + ((r - l) >> 1);
		return mergeSort(l, m, arr)%1000000007 + mergeSort(m+1, r, arr)%1000000007 + merge(l, r, m, arr);
	}

	public int merge(int l, int r, int m, int[] arr){
		int p1 = l, p2 = m + 1, k = 0, count = 0;
		int temp[] = new int[r-l+1];
		while(p1 <= m && p2 <= r){
			if (arr[p1] <= arr[p2]) {
				temp[k++] = arr[p1++];
			} else {
				count += m - p1 + 1;  // 下标补齐
				if(count >= 1000000007)
                    count %= 1000000007;
                temp[k++] = arr[p2++];
			}
		}
		while(p1 <= m){
			temp[k++] = arr[p1++];
		}
		while(p2 <= r){
			temp[k++] = arr[p2++];
		}
		for (k=0;k<temp.length;k++) {
			arr[l+k] = temp[k];
		}
		return count;
	}
}
