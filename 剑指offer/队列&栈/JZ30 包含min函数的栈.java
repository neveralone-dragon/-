// 首先需要一个正常栈normal,用于栈的正常操作，然后需要一个辅助栈minval，专门用于获取最小值，具体操作如下。
import java.util.Stack;

public class Solution {
    Stack<Integer> normol = new Stack<>();
    Stack<Integer> minval = new Stack<>();
    
    public void push(int node) {
        normol.push(node);
        if(minval.isEmpty()){
            minval.push(node);
        }else{
            if(node < minval.peek()){
                minval.push(node);
            }else{
                minval.push(minval.peek());
            }
        }
    }
    
    public void pop() {
        normol.pop();
        minval.pop();
    }
    
    public int top() {
        return normol.peek();
    }
    
    public int min() {
        return minval.peek();
    }
}
