// 1.辅助栈
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode tmp = head;
        while(tmp!=null){
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for(int i =0;i<size;i++)print[i]=stack.pop();
        return print;
    }
}
