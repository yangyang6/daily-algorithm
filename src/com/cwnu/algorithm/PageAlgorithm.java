package com.cwnu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rey on 2019-08-14.
 */
public class PageAlgorithm {

    public static final int PAGE_SIZE = 10;

    public static void paging1() {
        //模拟数据
        List<String> ums = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ums.add(i + "");
        }

        //算法开始
        boolean pageEnd = false;
        int page = 0;
        while (!pageEnd) {
            int beginIndex = page * PAGE_SIZE;
            int endIndex = PAGE_SIZE;
            int diffValue = ums.size() - beginIndex;
            if (diffValue < 0) {
                endIndex = ums.size();
            } else if (diffValue > 0) {
                if (diffValue < PAGE_SIZE) {
                    endIndex = ums.size();
                } else {
                    endIndex = beginIndex + PAGE_SIZE;
                }
            }

            //每次分页获取的数据集
            List<String> subList = ums.subList(page * PAGE_SIZE, endIndex);
            System.out.println("page:" + page);
            if ((endIndex - beginIndex) < PAGE_SIZE || diffValue == PAGE_SIZE) {
                pageEnd = true;
                continue;
            }
            page++;
        }
    }

    /**
     * 第二种分页还是很清晰
     */
    public static void paging2() {
        //模拟数据
        List<String> ums = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ums.add(i + "");
        }

        for (int i = 0; i < ums.size(); i = i + PAGE_SIZE) {
            int toIndex = i + PAGE_SIZE;
            toIndex = toIndex > ums.size() ? ums.size() : toIndex;
            List<String> subList = ums.subList(i, toIndex);
            System.out.println("subList:" + subList);
        }
    }

    public static void main(String[] args) {
        paging2();
    }
}
