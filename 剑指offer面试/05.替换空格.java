请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

// 1.算法流程：
// 初始化一个 list (Python) / StringBuilder (Java) ，记为 res ；
// 遍历列表 s 中的每个字符 c ：
// 当 c 为空格时：向 res 后添加字符串 "%20" ；
// 当 c 不为空格时：向 res 后添加字符 c ；
// 将列表 res 转化为字符串并返回。

// 作者：jyd
// 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/mian-shi-ti-05-ti-huan-kong-ge-ji-jian-qing-xi-tu-/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray()){
            if(c==' '){
                res.append("%20");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}


