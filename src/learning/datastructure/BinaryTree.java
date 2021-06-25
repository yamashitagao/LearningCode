package learning.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description 二叉树方法
 * @author:Alexius
 * @date: 2021/6/25 10:21
 */


public class BinaryTree {
    /*
     * 前序遍历二叉树
     *   压栈方式遍历
     * */
    public List<Integer> preorderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null) {
            list.add(root.val);
            //右不空 压栈右
            if (root.right != null) {
                stack.push(root.right);
            }
            //左不空 进左 循环
            if (root.left != null) {
                root = root.left;
                continue;
            }
            //左空右空 栈空 结束
            if (stack.size() == 0) {
                return list;
            }
            //抛栈
            root = stack.pop();

        }
        return list;
    }

    /*
     * 迭代器只要判断左右
     *
     * */
    public List<Integer> preorderTraversalIterable(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return Iterable(list, root);

    }

    public List<Integer> Iterable(List<Integer> list, TreeNode root) {

        if (root == null) return list;

        //先打印当前节点，然后打印左子树，最后再打印右子树
        list.add(root.val);
        Iterable(list,root.left );
        Iterable(list,root.right);
        return list;
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4, t2, null);
        TreeNode t1 = new TreeNode(1, null, t3);
        TreeNode t0 = new TreeNode(0, t1, t4);
        BinaryTree b = new BinaryTree();
        List<Integer> integers = b.preorderTraversalIterable(t0);

    }
}
