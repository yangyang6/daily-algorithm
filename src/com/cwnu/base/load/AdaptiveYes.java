package com.cwnu.base.load;

import java.net.URL;

public class AdaptiveYes {
    public String sayHi(URL url){
//        NoClassDefFoundError
        return "";
    }
}


class YesA implements Yes{
    @Override
    public String sayHi(URL url) {
        return "hi yes A";
    }
}

class YesB implements Yes{
    @Override
    public String sayHi(URL url) {
        return "hi yes B";
    }
}