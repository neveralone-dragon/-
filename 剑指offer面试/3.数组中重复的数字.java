// 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

// 1.排序解法
import java.util.Arrays;
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || length<=0){
            return false;
        }
        // 先对数组排序:O(nlgn)
        Arrays.sort(numbers);
        boolean flag = false;
        for(int i=0;i<length-1;i++){
            // 相邻比较
            if(numbers[i] == numbers[i+1]){
                duplication[0] = numbers[i];
                flag = true;
            }
        }
        return flag;
    }
}

// 哈希表 时间复杂度：O(n),空间复杂度:O(n)
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<length;i++){
            if(set.contains(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }else{
                set.add(numbers[i]);
            }
        }
        return false;
    }
}

//3. 
import java.util.Arrays;
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || length<=0)return false;
        
        //判断数据合法性
        for(int i=0;i<length;i++){
            if(numbers[i]<0||numbers[i]>length-1){
                return false;
            }
        }
        
        // 下标与数值比较
        for (int i=0;i<length;i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }
                // 否则交换
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }
}
