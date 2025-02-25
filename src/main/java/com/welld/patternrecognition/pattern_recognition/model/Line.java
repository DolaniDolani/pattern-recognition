package com.welld.patternrecognition.pattern_recognition.model;


import java.util.List;

public class Line {
    private final List<Point> pointList;

    public List<Point> getPointList() {
        return pointList;
    }

    public Line(List<Point> pointList) {
        this.pointList = pointList;
    }
}
