public class DoRecomendation {
    public static void main(String[] args) {
        MatrixManipulation matrixManipulation = new MatrixManipulation();
        double[][] a = matrixManipulation.readFile("D:\\else\\sy\\ml-latest-small\\ratings.csv");

//        System.out.println(a[0][30]);
//        System.out.println(a[0][1028]);

//        System.out.println(a[0][0]);
        for(int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }


    }
}
