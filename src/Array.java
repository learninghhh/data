public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    //无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    //获取数组中的元素个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //返回的数组是否为空
    public boolean isEmpity(){
        return size == 0;
    }

    //向所有元素后添加一个新元素
    public void addLast(E e){
        add(size , e);
    }

    //在第index个位置插入一个新元素e
    public void add(int index,E e){

        if(size == data.length)
            resize(2*data.length);

        if(index < 0 || index > size)
            throw new IllegalArgumentException("AddLast Failed");

        for(int i = size - 1 ; i >= index ; i --)
            data[i + 1] = data[i];

        data[index] = e;
        size ++;
    }

    //获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("AddLast Failed");
        return data[index];
    }

    //修改index索引位置的元素
    public void set(int index , E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("AddLast Failed");
        data[index] = e;
    }

    //查找数组中是否有e元素
    public boolean contains(E e){
        for(int i = 0 ; i < size ; i ++){
            if (data[i] == e)
                return true;
        }
        return false;
    }

    //查找数组中e元素的索引，如果不存在返回-1
    public int find(E e){
        for(int i = 0 ; i < size ; i ++){
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //删除数组中元素，返回删除的元素
    public E remove(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("AddLast Failed");

        E ret = data[index];
        for(int i = index + 1 ; i < size ; i ++)
            data[i - 1] = data[i];
        size --;
        if (size == data.length - 1)
            resize(data.length - 1);
        return ret;
    }

    //删除数组中元素，不返回
    public void remove1(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("AddLast Failed");

        E ret = data[index];
        for(int i = index + 1 ; i < size ; i ++)
            data[i - 1] = data[i];
        size --;
        if (size == data.length - 1)
            resize(data.length - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n" , size , data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if (i != size - 1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0 ; i < size ; i ++)
            newData[i] = data[i];
        data = newData;

    }
}

