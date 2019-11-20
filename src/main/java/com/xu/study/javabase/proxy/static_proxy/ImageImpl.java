package com.xu.study.javabase.proxy.static_proxy;

/**
 * @Description
 * @Author xgx
 * @Date 2019/9/16 16:23
 */
public class ImageImpl implements Image {
    private String imagePath;

    public ImageImpl(String imagePath) {
        this.imagePath = imagePath;
        loadFromDisk(imagePath);
    }
    @Override
    public void display() {
        System.out.println("展示图片.....");
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}
