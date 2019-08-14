package com.cwnu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rey on 2019-08-14.
 */
public class PageAlgorithm {

    public static final int PAGE_SIZE = 20;

    public static void main(String[] args) {
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
}
