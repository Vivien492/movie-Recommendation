public class Recommendation {

    private  MatrixManipulation matrixManipulation = new MatrixManipulation();

    public static void main(String[] args) {



    }

    //train matrix, m*n, m->user, n->movie
    public double[][] recomend(double[][] train){
        int row = train.length;
        int col = train[0].length;

        double[][] weights = new double[row][col];

        double[][] trasTrain = matrixManipulation.transpose(train);

        for (int i=0; i<col; i++){
            for (int j=0; j<col; j++){
                double degree = matrixManipulation.sum(trasTrain[j]);
                double sum = 0;
                for(int l=0; l<row; l++){
                    sum += trasTrain[i][l]*trasTrain[j][l] / matrixManipulation.sum( train[l] );
                }
                if(degree !=0){
                    weights[i][j] = sum / degree;
                }
            }
        }

        double[][] result = new double[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(0 == train[i][j]){
                    train[i][j] = matrixManipulation.innerProduct( weights[j] ,train[i] );
                }
            }
        }
        return  weights;
    }

    
}
