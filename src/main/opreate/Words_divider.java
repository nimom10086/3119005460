package main.opreate;




import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.io.IOException;
import java.util.*;

public class Words_divider {


    //分词
    public HashMap<String, Integer> division(String sentence) throws IOException {
        //调用分词器分词
        List<Term> DivideList = StandardTokenizer.segment(sentence);
        HashMap<String, Integer> word = new HashMap<>();
        for (Term term : DivideList) {
            int times = 0;
            //计算词频
            if (word.containsKey(term.word)) {
                times = word.get(term.word);
                word.put(term.word, times + 1);
            } else {
                word.put(term.word, 1);
            }
        }
        return word;
    }

    //引入句子
    public List<String> getPhrase(String str1, String str2) {
        HashSet<String> phraseSet = new HashSet<>();
        StringBuilder Builder = new StringBuilder();
        Builder.append(str1);
        Builder.append(str2);
        List<String> phrase = null;
        List<Term> termList = SpeedTokenizer.segment(Builder.toString());
        for (Term term : termList) {
            phraseSet.add(term.word);
        }
        //将数组变为list
        phrase = Arrays.asList(phraseSet.toArray(new String[0]));
        return phrase;
    }
}

