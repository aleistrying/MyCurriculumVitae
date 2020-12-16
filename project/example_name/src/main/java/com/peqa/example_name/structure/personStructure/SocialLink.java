package com.peqa.example_name.structure.personStructure;

public class SocialLink {
    private String text;
    private String detail;
    private String pathToImage;

    public SocialLink() {
        //
    }

    public SocialLink(String _text, String _detail, String _pathToImage) {
        text = _text;
        detail = _detail;
        pathToImage = _pathToImage;
    }

    public String getText() {
        return text;
    }

    public void setText(String _text) {
        text = _text;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String _detail) {
        detail = _detail;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String _pathToImage) {
        pathToImage = _pathToImage;
    }

}
