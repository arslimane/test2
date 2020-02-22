package com.example.recycle;

public class word {
    String mtitle;
    String mcategory;
    String mtext;
    int im;

    public word (String title,String category,String text ,int image ) {
        this.mtitle= title;
         this.mcategory=category;
         this.mtext=text;
         this.im=image;

    }
    public String getMtitle(){return mtitle;}
    public int getIm(){return im;}
    public void setIm(int image){im=image;}
    public String getMcategory(){return mcategory;}
    public String getMtext(){return mtext;}
    public void setMtitle(String title){mtitle=title;}
    public void setMtext(String text){mtext=text;}
    public void setMcategory(String category){mcategory=category;}

}
