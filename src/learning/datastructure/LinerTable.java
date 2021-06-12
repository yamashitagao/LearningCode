package learning.datastructure;


/**
 * @description
 * @author:Alexius
 * @time: 9:49
 * @date: 2021-06-02
 */


public class LinerTable<E> {
    private Object[] obj;
    private int index;

    public LinerTable() {
        this(10);
    }

    public LinerTable(int size) {
        obj = new Object[size];
    }

    /**
     * 先判断是否扩容，再增加元素
     */
    public boolean add(E e) {
        if (index >= obj.length) {
            Object[] bigObj = new Object[obj.length * 2];
            //复制数组        复制的数组  开始位置 复制到的数组 开始位置 复制长度
            //ArrayList的remove()和add(int ?,object ？)都是是根据此方法进行的操作
            System.arraycopy(obj, 0, bigObj, 0, obj.length);
        }
        obj[index++] = e;
        return true;
    }

    /**
     * 先判断下标是否越界，在看是否需要扩容，在进行插入，插入的思想就是把数组当中的某些元素向后移动1
     */
    public void add(int n, E e) {
        if (n > index || n < 0) {
            throw new RuntimeException("插入的位置不对");
        }
        //数组长度已满或者需要扩容
        if (index >= obj.length) {
            Object[] o2 = new Object[obj.length * 2];
            for (int i = 0; i < index; i++) {
                o2[i] = obj[i];
            }
            obj = o2;
        }
        //倒序 后移一个位置
        for (int i = this.index; i > n; i--) {
            obj[i] = obj[i - 1];
        }
        obj[n] = e;
        index ++;
    }
    /**
     * 根据下标获取
     */
    public E get(int n){
        if (n>obj.length-1||n<0){
            throw new RuntimeException("错误下标");
        }
        return (E) obj[n];
    }
    /**
     * 根据元素数值逐一和数组元素中的值进行对比，如果数组当中有此数值，则直接返回，否则返回-1
     */
    public int indexOf(E e){
        for (int i = 0; i < index; i++) {
            if (obj[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinerTable<String> lt =new LinerTable<>();
        lt.add("s");
        System.out.println(lt.index);
    }
}
