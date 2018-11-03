package com.lhengi.project2;

public class Data {
    int postion; //useless... ignore
    String name;// car name
    int imgResource;// high res img resource
    int lowImg; // low res img resource
    String officialSite;
    String[] dealers;

    public Data(int postion, String name, int lowImg, int imgResource,String officialSite, String[] dealers)
    {
        this.postion = postion;
        this.name = name;
        this.imgResource = imgResource;
        this.officialSite = officialSite;
        this.dealers = dealers;
        this.lowImg = lowImg;
    }
}
