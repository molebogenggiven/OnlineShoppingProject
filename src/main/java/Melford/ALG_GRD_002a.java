package Melford;

public class ALG_GRD_002a {

    public static void main(String[] args) {
      ALG_GRD_002a alg_grd_002a = new ALG_GRD_002a();
      alg_grd_002a.sumOfBatchConstants(101,500,40);
    }

    int sumOfBatchConstants(int a, int b, int q){
        int sum = 0;
        int x=0;
        for(int i = a; i <= b; i++){
            int min = a;
          //  System.out.println(i);
            for(int j = 0; j < 39; j++ ){

                i =i + 1;
            }

            int sumOfBatches=0;
            int cout=0;


            for (x=min; x <= i; x++){
                cout++;
                sumOfBatches +=x;
               // System.out.println(sumOfBatches);

            }
            if (min == 101 && i == 140){
                System.out.println("Sum from "+min+" to "+i+": "+ sumOfBatches);
                System.out.println("Sum from "+min+" to "+i+": "+ sumOfBatches);
                continue;

            }else{
                int secondBatchSum =0;
                int secondMin = i + 1;
                int secondMax = secondMin + 39;
                // System.out.println("Min "+secondMin);
                // System.out.println("Max"+secondMax);
                for(; secondMin <= secondMax; secondMin++ ){

                    secondBatchSum +=secondMin;
                }
                System.out.println("Sum from "+secondMin+" to "+secondMax+": "+ secondBatchSum);

                System.out.println("Sum from "+min+" to "+i+": "+ sumOfBatches);

            }


           // int j;
//            for ( j = 0; j < 40 ; j++) {
//
//                j +=1;
//
//            }
         //   System.out.println(j);
           // System.out.println(i);

//            for(int k =i; k < j; k++ ){
//                secondBatchSum +=k;
//            }
//
           // System.out.println(i);



        }

        return sum;
    }
}
