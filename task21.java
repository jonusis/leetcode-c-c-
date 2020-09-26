/**
*
*
难度简单633收藏分享切换为英文关注反馈给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

 

说明:
	初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
	你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

自己方法： 把数组nums1 向后移动n个位置 再进行归并排序。
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        for(int i = m + n- 1;i >= n ;i--){
            nums1[i] = nums1[i - n];
        }
        int p1 = n,p2 = 0;
        int index = 0;
        while(p1 < m + n && p2 < n){
            if(nums1[p1] >= nums2[p2]){
                nums1[index] = nums2[p2];
                index++;
                p2++;
            }else{
                nums1[index] = nums1[p1];
                index++;
                p1++;
            }
        }
        if(p1 == m + n){
            while(p2 < n){
                nums1[index] = nums2[p2];
                index++;
                p2++;
            }
        }else{
            while(p1 < m){
                nums1[index] = nums1[p1];
                index++;
                p1++;
            }
        }
    }
}