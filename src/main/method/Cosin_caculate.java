package main.method;

        import main.opreate.Words_divider;
        import org.ujmp.core.Matrix;


        import java.io.IOException;
        import java.util.HashMap;
        import java.util.List;

public class Cosin_caculate {

    private Words_divider hanlpUtil=new Words_divider();

    public double calculation(String original,String copy) throws IOException {
        List<String> phrase = hanlpUtil.getPhrase(original, copy);
        //获取语句分词词频
        HashMap<String,Integer> originalWords = hanlpUtil.division(original);
        HashMap<String,Integer> copyWords = hanlpUtil.division(copy);
        int line= phrase.size();
        //创建向量矩阵
        Matrix originalMatrix=Matrix.Factory.zeros(1,line);
        Matrix copyMatrix=Matrix.Factory.zeros(1,line);
        Matrix squareOriginalMatrix=Matrix.Factory.zeros(1,line);
        Matrix squareCopyMatrix=Matrix.Factory.zeros(1,line);
        int i=0;
        //对向量进行赋值
        for (String s : phrase) {
            if(originalWords.containsKey(s)){
                int value=originalWords.get(s);
                originalMatrix.setAsInt(value,0,i);
                squareOriginalMatrix.setAsInt(value*value,0,i);
            }
            if(copyWords.containsKey(s)){
                int value=copyWords.get(s);
                copyMatrix.setAsInt(value,0,i);
                squareCopyMatrix.setAsInt(value*value,0,i);
            }
            i++;
        }
        //向量相乘
        int vectorProduct=originalMatrix.mtimes(copyMatrix.transpose()).getAsInt(0,0);
        double sum1=squareOriginalMatrix.getValueSum();
        double sum2=squareCopyMatrix.getValueSum();
        return vectorProduct/(Math.sqrt(sum1)*Math.sqrt(sum2));
    }



}
