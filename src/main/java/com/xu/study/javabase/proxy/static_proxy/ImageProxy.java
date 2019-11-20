package com.xu.study.javabase.proxy.static_proxy;

/**
 * @Description
 * @Author xgx
 * @Date 2019/9/16 16:23
 */
public class ImageProxy implements Image {
    private ImageImpl realImage;
    private String fileName;
    public ImageProxy(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void display() {
        if(realImage == null){
            realImage = new ImageImpl(fileName);
        }
        realImage.display();
    }
}
