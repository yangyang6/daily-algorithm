package com.cwnu.face;

/**
 * 输入 aabccccaaa
 * 输出 a2bc4a
 * compressString1()  最笨的方法去实现
 * 还有就是考虑字符 是有对应的ASCII码的
 */
public class CompressStr {
    public static void main(String[] args) {
        String str = "aabccccaaa";
//        System.out.println(compressString2(str));

        long start = System.nanoTime();
        System.out.println(compressString2(str));
        long end = System.nanoTime();
        System.out.println("waste time:" + (end - start));
//
//        char[] chars = {'a', '2', 'b', 'c', '4'};
//        System.out.println(String.valueOf(chars));
    }

    /**
     * 这种方式就是所说的空间复杂度为O(1)
     * @param str
     * @return
     */
    public static String compress(String str) {
        char[] chars = str.toCharArray();
        char temp = chars[0];
        int index = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != temp) {
                chars[index++] = temp;
                temp = chars[i];
                if (count > 1) {
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[index++] = c;
                    }
                }
                count = 1;
                continue;
            }
            count++;
        }
        chars[index++] = chars[chars.length - 1];
        if (count > 1) {
            for (char c : Integer.toString(count).toCharArray()) {
                chars[index++] = c;
            }
        }
        return String.valueOf(chars).substring(0,index);
    }


    public static String compressString2(String s) {
        char[] chars = s.toCharArray();
        char temp = chars[0];
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != temp) {
                result.append(temp);
                temp = chars[i];
                if (count > 1) {
                    result.append(count);
                }
                count = 1;
                continue;
            }
            count++;
        }
        result.append(chars[chars.length - 1]);
        if (count > 1) {
            result.append(count);
        }
        return result.toString();
    }


    public static String compressString1(String s) {
        //首先记录下当前字符串的长度
        if (s.length() < 2) return s;
        //存储数字
        int sum = 1;
        //将字符串转为数组
        char c[] = s.toCharArray();
        //因为不能直接在字符串上进行修改，所以我们用StringBuilder，并直接将第一个字符添加进去，因为它至少拥有一个字符
        StringBuilder sb = new StringBuilder().append(c[0]);
        //遍历，判断当前字符是不是和上一个字符相同
        for (int i = 1; i < s.length(); i++) {
            if (c[i] == c[i - 1])
                sum++;
            else {
                if (sum > 1) {
                    sb.append(sum);
                }
                sb.append(c[i]);
                sum = 1;
            }
        }
        //最后循环结束的时候最后一个字符的数字没有进行录入
        if (sum > 1) {
            sb.append(sum);
        }
        return sb.toString();
    }
}
