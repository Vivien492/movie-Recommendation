import java.util.*;

public class Recommendation {


    private  MatrixManipulation matrixManipulation = new MatrixManipulation();

    public static void main(String[] args) {

        double[][] a={{209,23,45,67,23,7867,234,767,34,765,34,413,324,87645,123154,46}};
                Recommendation r = new Recommendation();
                r.order(a,5,"D:\\workspace\\movieRecommendation\\lala.txt");

        for(int i=0; i<a.length; i++){
            for (int j=0; j<a.length; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }



    }


    //train matrix, m*n, m->user, n->movie
    public double[][] recomend(int[][] train){
        int row = train.length;
        int col = train[0].length;

        double[][] weights = new double[col][col];
        int[][] subtrain = new int[row][col];
        for(int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                subtrain[i][j] = train[i][j];
            }
        }

        int[][] trasTrain = matrixManipulation.transpose(subtrain);
        int [] row_sum=get_sum(trasTrain);
        int [] col_sum=get_sum(subtrain);
        System.out.println("total:"+col);
        for (int i=0; i<col; i++){

            System.out.println(i+":"+i*1.0/col+"%");
            for (int j=0; j<col; j++){
                //产品的度
                double degree = row_sum[j];
                double sum = 0;
                for(int l=0; l<row; l++){
                    sum += trasTrain[i][l]*trasTrain[j][l] / (col_sum[l]+0.0000001 );
                }
                if(degree !=0){
                    weights[i][j] = sum / degree;
                }
            }
        }

        double[][] result = new double[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(0 == subtrain[i][j]){
                    result[i][j] =  matrixManipulation.innerProduct( weights[j] ,subtrain[i] );
                }
            }
        }

        return  result;



    }



    public int[]  get_sum(int martix[][]){
        int [] result=new int[martix.length];
        for(int i=0;i<martix.length;i++){

            for(int j=0;j<martix[0].length;j++){
                result[i]=j==0?0:result[i];
                result[i]+=martix[i][j];
            }
        }
        return result;

    }


    public  void order(double[][] data,int top,String path){
        int[][] max = new int[data.length][top];
        for(int i=0; i< max.length; i++){
            for(int j=0; j<max[0].length; j++ ){
                max[i][j] = -1;
            }

        }
        int lineMax = -1;

        PriorityQueue<ForSort> sorts = new PriorityQueue<ForSort>(top,new Comparator<ForSort>() {
            //reverse
            public int compare(ForSort o1, ForSort o2) {
                return (int)(o2.weight *1000 - o1.weight * 1000);
            }
        });
        for(int i=0; i<data.length; i++){
            for(int j =0; j<data[0].length; j++){
                //将所有元素加入到PriorityQueue中
                sorts.add(new ForSort(data[i][j],j));
//                if(sorts.size() < top){
//                    sorts.add(new ForSort(data[i][j],j));
//                    System.out.println("add:"+sorts.peek().weight+"~:"+sorts.peek().index);
//
//                }else if(sorts.peek().weight < data[i][j]) {
//                    sorts.poll();
//                    sorts.add(new ForSort(data[i][j],j));
//                    System.out.println("more than top"+sorts.peek().weight+"~:"+sorts.peek().index);
//
//                }
            }

            for(int m=0; m<top; m++){
                //拿出前top个最大的值的下标，存入max
                max[i][m] = sorts.peek().index;
                sorts.poll();
            }
            sorts.clear();
//                        System.out.println("==========");
        }
        matrixManipulation.writeFile(max,path);
    }



    public  double[][] hitRate(double[][] weights ,double[][] data){
        int userNumber =(int ) (data.length * 0.9);
        int itemNumber = data[0].length;

        double[][] sortedIndex = new double[userNumber][itemNumber];

        List<Double> line = new ArrayList<Double>();
//        double[] line = new double[userNumber*itemNumber];
        for(int i=0; i<userNumber; i++){
            for(int j=0; j<itemNumber; j++){
                line.add(weights[i][j]);
            }
            Collections.sort(line,Collections.<Double>reverseOrder());
            for (int k=0; k<itemNumber; k++){
                sortedIndex[i][k] = line.get(k);
            }
            line.clear();
        }

        double[][] hitrate = new double[userNumber][2];
        for(int k=1; k<userNumber; k++){
            double counter = 0;
            hitrate[k][0] = k;
            for(int i=0; i<userNumber; i++){
                for (int j=0; j<k; j++){
                    int itemIndex = (int)sortedIndex[i][j];
                    if(data[i][itemIndex] == 0){
                        counter++;
                    }
                }
                hitrate[k][1] = counter/userNumber;
            }
        }

        return  hitrate;

    }
}
