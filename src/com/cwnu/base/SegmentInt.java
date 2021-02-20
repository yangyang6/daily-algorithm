package com.cwnu.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SegmentInt implements Serializable {

    private Integer a;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "SegmentInt{" +
                "a=" + a +
                '}';
    }

    public static void main(String[] args) {
        List<SegmentInt> resulta = new ArrayList<>();
        List<SegmentInt> resultb = new ArrayList<>();
        SegmentInt segmentInt1 = new SegmentInt();
        segmentInt1.setA(1);
        resulta.add(segmentInt1);
        segmentInt1.setA(2);
        resultb.add(segmentInt1);
        System.out.println(resulta);
        System.out.println(resultb);
    }
}
