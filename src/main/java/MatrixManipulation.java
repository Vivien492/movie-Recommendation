import java.io.*;
import java.util.List;

public class MatrixManipulation {

//    int  [][] result  = new int[671][164979];


    public static void main(String[] args) {
        MatrixManipulation matrixManipulation = new MatrixManipulation();
        int[] s = matrixManipulation.read("D:\\else\\sy\\ml-latest-small\\movies.csv");



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

    public int[] read(String filePath){
        int[] result = new int[9125];
        String[] re;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = bufferedReader.readLine();
            int i=0;
            while( (line = bufferedReader.readLine()) != null ) {

                re = line.split(",");
//                System.out.println(re[i]);

                result[i++] = Integer.parseInt(re[0]);
//                System.out.println(result[i-1]);
            }

        }catch (Exception e){}

        return  result;
    }

    //return a double matrix, with the rating score.
    public int[][] readFile(String filename,int[] movie) {
        String[] re = new String[0];
        int  [][] result  = new int[671][9125];
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                //csv file is devided by ","
                re = line.split(",");
                int i = Integer.parseInt(re[0])-1;
                int movieId = Integer.parseInt(re[1]);

//                System.out.println(i);


                double rating = Double.parseDouble(re[2]);
                int k=0;
                    for(int j=0; j<movie.length; j++){
                        if( (movieId == movie[j]) ){
                            result [i][j] = rating>=3? 1 : 0;
                        }
                    }


//                result[i][j]= (k>=3)?1:0;

//                if( k>=3 ){
//                    result[i][j] = 1;
//                }
            }

//            for(int i=0; i<10; i++){
//            for (int j=0; j<10; j++){
//                System.out.print(result[i][j]+" ");
//            }
//            System.out.println();
//        }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    // 求向量内积
    public double innerProduct (double[] a,int[] b){
        double result = 0;
        for (int i=0; i<a.length; i++){
            result += a[i]*b[i];
        }
        return result;
    }


    public int[][] transpose(int[][] a){
        //转置后的行和列的长度交换
        int [][] trans = new int[a[0].length][a.length];
        for(int i=0; i<a[0].length; i++){
            for (int j=0; j<a.length; j++){
                trans[i][j] = a[j][i];
            }
        }
        return  trans;
    }


    //求向量中元素的和
    public int sum (double[] a){
        int result = 0;
        for (int i=0; i<a.length; i++){
            result += a[i];
        }
        return result;
    }

    public void writeFile(double[][] matrix, String filePath){
        try{
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length; j++){
                    bufferedWriter.write(String.format( "%.3f",matrix[i][j])+" ");
//                    System.out.print(matrix[i][j]+" ");
                }
                bufferedWriter.write("\r\n");
//                System.out.println();
//                System.out.println(i+":"+i*1.0/164979+"%");
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeFile(int[][] matrix, String filePath){
        try{
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length; j++){
                    bufferedWriter.write(matrix[i][j]+" ");
//                    System.out.print(matrix[i][j]+" ");
                }
                bufferedWriter.write("\r\n");
//                System.out.println();
//                System.out.println(i+":"+i*1.0/164979+"%");
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
