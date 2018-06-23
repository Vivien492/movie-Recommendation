public class DoRecomendation {
    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
        MatrixManipulation matrixManipulation = new MatrixManipulation();
        int[] movie = matrixManipulation.read("D:\\else\\sy\\ml-latest-small\\movies.csv");
        int[][] movieData = matrixManipulation.readFile("D:\\else\\sy\\ml-latest-small\\ratings.csv",movie);
        matrixManipulation.writeFile(movieData,"D:\\workspace\\movieRecommendation\\movieData.txt");





//        long end = System.currentTimeMillis();
//        System.out.println(end-start+"ms");

        Recommendation recommendation = new Recommendation();
        double[][] result = recommendation.recomend(movieData);
        matrixManipulation.writeFile(result,"D:\\workspace\\movieRecommendation\\RecomendationWeight.txt");

        recommendation.order(result,20,"D:\\workspace\\movieRecommendation\\RecomendationOrder.txt");





    }
}
