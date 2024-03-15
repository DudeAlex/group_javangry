package ai;

public class Fibonachi {

    public static long fibonachi (int n){
        if (n==1) return 1;
        long previous=0;
        long next = 1;
        long sum=0;

        for (int i=1; i<n; i++){

            sum = previous+next;
            previous = next;
            next = sum;

        }
        return sum;
    }

    public static void main(String[] args) {


        System.out.println(fibonachi(2));
    }
}

