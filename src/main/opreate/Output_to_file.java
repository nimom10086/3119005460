package main.opreate;

        import java.io.BufferedWriter;
        import java.io.File;
        import java.io.FileWriter;
        import java.io.IOException;

public class Output_to_file {

    public static void main(String[] args) throws IOException {

    }

    public static boolean writeIntoFile(String answer,String Name) {
        //写入答案文件
        File file=new File(Name);
        if(Name.indexOf(".txt")!=-1){
            String[] split = Name.split("/");
            Name=Name.replace("/"+split[split.length-1],"");
        }
        File answerDirectory=new File(Name);
        if(!answerDirectory.exists()){
            answerDirectory.mkdirs();
        }
        try {
            //文件若不存在则创建
            file.createNewFile();
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(answer);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}