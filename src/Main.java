public class Main {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<>(20);
        double m = arr.getCapacity();
        for(int i = 0 ; i < 7 ; i ++)
            arr.addLast(i);
        for(int i = 7 ; i < 20 ; i++)
            arr.addLast(5);
        System.out.println(arr);
        for (int i = 0 ; i < arr.getCapacity() ; i ++){
            int a = arr.get(i);
            double count = 1 ;
            for (int j = i + 1 ; j < arr.getCapacity() ; j ++){
                if (a == arr.get(j)){
                    arr.remove1(j);
                    count ++;
                    j --;
                }
            }
            if (count > m / 2){
                System.out.println(a);
                System.out.println(count);
            }
        }
    }
}
