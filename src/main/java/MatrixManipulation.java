import java.io.BufferedReader;
import java.io.FileReader;

public class MatrixManipulation {

    public static void main(String[] args) {
        MatrixManipulation matrixManipulation = new MatrixManipulation();
//        String[][] s = matrixManipulation.readFile("D:\\else\\sy\\ml-latest-small\\tags.csv");
//        for(int i=0; i<10; i++){
//            System.out.println(s[1]);
//        }

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

    //return a double matrix, with the rating score.
    public double[][] readFile(String filename) {
        String[] re = new String[0];
        double  [][] result  = new double[671][164979];
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                //csv file is devided by ","
                re = line.split(",");
                int i = Integer.parseInt(re[0])-1;
                int j = Integer.parseInt(re[1])-1;
                double k = Double.parseDouble(re[2]);

                result[i][j] = k;
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
