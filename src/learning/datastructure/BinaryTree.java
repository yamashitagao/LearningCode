package learning.datastructure;

import java.util.*;

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
     * 中序遍历
     *
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;

            }

        }
        return list;

    }

    /*
     * 后序遍历
     * 根先压栈
     * 再从右开始循环压栈
     * 细节 压栈先左后右
     *
     * */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        Collections.reverse(res);
        return res;


    }

    /*
     * 前序遍历
     * 迭代器只要判断左右
     *
     * */
    public List<Integer> preorderTraversalIterable(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return preIterable(list, root);

    }

    /*
     * 中序遍历
     * 迭代器只要判断左右
     *
     * */
    public List<Integer> inorderTraversalIterable(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return inorderIterable(list, root);

    }

    /*
     * 后续遍历
     * 迭代器只要判断左右
     *
     * */
    public List<Integer> postorderTraversalIterable(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return postorderIterable(list, root);

    }

    /*
     * 前序迭代
     * */
    private List<Integer> preIterable(List<Integer> list, TreeNode root) {

        if (root == null) return list;

        //先打印当前节点，然后打印左子树，最后再打印右子树
        list.add(root.val);
        preIterable(list, root.left);
        preIterable(list, root.right);
        return list;
    }

    //中序迭代
    private List<Integer> inorderIterable(List<Integer> list, TreeNode root) {

        if (root == null) return list;
        inorderIterable(list, root.left);
        list.add(root.val);
        inorderIterable(list, root.right);
        return list;
    }

    //后续迭代
    private List<Integer> postorderIterable(List<Integer> list, TreeNode root) {

        if (root == null) return list;
        postorderIterable(list, root.left);
        postorderIterable(list, root.right);
        list.add(root.val);
        return list;
    }

    /*
     * 二叉树的层序遍历
     * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        //边界条件判断
        if (root == null)
            return new ArrayList<>();
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        //根节点入队
        queue.add(root);
        //如果队列不为空就继续循环
        while (!queue.isEmpty()) {
            //BFS打印，levelNum表示的是每层的结点数
            int levelNum = queue.size();
            //subList存储的是每层的结点值
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                //出队
                TreeNode node = queue.poll();
                subList.add(node.val);
                //左右子节点如果不为空就加入到队列中
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //把每层的结点值存储在res中，
            res.add(subList);
        }
        return res;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);

    }
    /*
    * 结构是否对称
    * */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null){
            return true;
        }
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()){
            TreeNode l =q.poll();
            TreeNode r =q.poll();
            if (l == null && r == null){
                continue;
            }
            //异或运算
            if (l == null ^ r == null){
                return false;
            }
            if (l.val != r.val){
                return false;
            }
            //这里要记住入队的顺序，他会每两个两个的出队。
            //左子节点的左子节点和右子节点的右子节点同时
            //入队，因为他俩会同时比较。
            //左子节点的右子节点和右子节点的左子节点同时入队，
            //因为他俩会同时比较
            q.add(l.left);
            q.add(r.right);
            q.add(l.right);
            q.add(r.left);
        }
        return true;
    }
    /*
    *
    * 迭代判断对称
    * */
    public boolean isSymmetricIterable(TreeNode root) {
        if (root == null)
            return true;
        //从两个子节点开始判断
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        //如果左右子节点都为空，说明当前节点是叶子节点，返回true
        if (left == null && right == null)
            return true;
        //如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相同，直接返回false
        if (left == null || right == null || left.val != right.val)
            return false;
        //然后左子节点的左子节点和右子节点的右子节点比较，左子节点的右子节点和右子节点的左子节点比较
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4, t2, null);
        TreeNode t1 = new TreeNode(1, null, t3);
        TreeNode t0 = new TreeNode(0, t1, t4);
        BinaryTree b = new BinaryTree();
        List<List<Integer>> integers = b.levelOrder(t0);

    }
}
