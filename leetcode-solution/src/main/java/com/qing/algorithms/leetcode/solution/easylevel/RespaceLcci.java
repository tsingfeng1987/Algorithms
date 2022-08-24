package com.qing.algorithms.leetcode.solution.easylevel;

//哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’
//t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一
//本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
//
//
// 注意：本题相对原题稍作改动，只需返回未识别的字符数
//
//
//
// 示例：
//
// 输入：
//dictionary = ["looked","just","like","her","brother"]
//sentence = "jesslookedjustliketimherbrother"
//输出： 7
//解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
//
//
// 提示：
//
//
// 0 <= len(sentence) <= 1000
// dictionary中总字符数不超过 150000。
// 你可以认为dictionary和sentence中只包含小写字母。
//
// Related Topics 记忆化 字符串
// 👍 104 👎 0


import java.util.*;

/**
 * @author Guoqingfeng
 * @date 2020/7/9
 */
//leetcode submit region begin(Prohibit modification and deletion)
class RespaceLcci {
    public int respace(String[] dictionary, String sentence) {
        Map<Character, Set<String>> dictMap = new HashMap<>();

        for (String dict : dictionary) {
            char c = dict.charAt(0);
            Set<String> dictSet = dictMap.computeIfAbsent(c, key -> new HashSet<>());
            dictSet.add(dict);
        }

        int unused = sentence.length();
        int end = unused - 1;
        int start = end;

        for (int i = end; i >= 0; i--) {
            char key = sentence.charAt(i);
            if (!dictMap.containsKey(key)) {
                start--;
                continue;
            }

            Set<String> dictSet = dictMap.get(key);


            for (int j = end; j > start; j--) {
                if (dictSet.contains(sentence.substring(start, j + 1))) {
                    end = j;
                    break;
                }
            }
            unused -= end + 1 - start;
            end = start - 1;
            start = end;

        }
        return unused;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

