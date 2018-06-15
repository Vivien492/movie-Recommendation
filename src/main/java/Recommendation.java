import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

        return  result;

    }


    public  double[][] hitRate(double[][] weights ,double[][] data){
        int userNumber =(int ) (data.length * 0.9);
        int itemNumber = data[0].length;

        double[][] sortedIndex = new double[userNumber][itemNumber];

        List<Double> line = new ArrayList<Double>();
//        double[] line = new double[userNumber*itemNumber];
        for(int i=0; i<userNumber; i++){
            for(int j=0; j<itemNumber; j++){
                line.add(data[i][j]);
            }
            Collections.sort(line,Collections.<Double>reverseOrder());
            for (int k=0; k<itemNumber; k++){
                sortedIndex[i][k] = line.get(k);
            }
            line.clear();
        }

        double[][] hitrate = new double[userNumber][];
        for(int k=1; k<userNumber; k++){}

    }
}
