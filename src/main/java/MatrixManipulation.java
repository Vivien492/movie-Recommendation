import java.io.BufferedReader;
import java.io.FileReader;

public class MatrixManipulation {

    public static void main(String[] args) {
        MatrixManipulation matrixManipulation = new MatrixManipulation();
//        matrixManipulation.readFile("D:\\else\\sy\\ml-latest-small\\tags.csv");

//        int[][] a={{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println("a:");
//        for(int i=0; i<a.length; i++){
//            for (int j=0; j<a.length; j++){
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
//        int[][] b = matrixManipulation.transpose(a);
//        System.out.println("b:");
//        for(int i=0; i<a.length; i++){
//            for (int j=0; j<a.length; j++){
//                System.out.print(b[i][j]+" ");
//            }
//            System.out.println();
//        }



    }

    public String[] readFile(String filename) {
        String[] result = new String[0];
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //csv file is devided by ","
                result = line.split(",");
                String last = result[1];
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    // 求向量内积
    public double innerProduct (double[] a,double[] b){
        double result = 0;
        for (int i=0; i<a.length; i++){
            result += a[i]*b[i];
        }
        return result;
    }


    public double[][] transpose(double[][] a){
        double [][] trans = new double[a[0].length][a[0].length];
        for(int i=0; i<a.length; i++){
            for (int j=0; j<a.length; j++){
                trans[i][j] = a[j][i];
            }
        }
        return  trans;
    }


    //求向量中元素的和
    public double sum (double[] a){
        double result = 0;
        for (int i=0; i<a.length; i++){
            result += a[i];
        }
        return result;
    }




}
