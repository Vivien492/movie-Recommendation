public class DoRecomendation {
    public static void main(String[] args) {
        MatrixManipulation matrixManipulation = new MatrixManipulation();
        int[][] a = matrixManipulation.readFile("D:\\else\\sy\\ml-latest-small\\ratings.csv");

        matrixManipulation.writeFile(a,"D:\\workspace\\movieRecommendation\\test.txt");


    }
}
