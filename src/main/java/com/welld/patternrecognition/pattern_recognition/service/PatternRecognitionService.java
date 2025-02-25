package com.welld.patternrecognition.pattern_recognition.service;

import com.welld.patternrecognition.pattern_recognition.model.Line;
import com.welld.patternrecognition.pattern_recognition.model.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PatternRecognitionService {
    //plane contains points
    private final Set<Point> plane = new HashSet<>();

    public void addPoint(int x, int y) {
        plane.add(new Point(x, y));
    }

    public List<Point> getALlPoints() {
        return new ArrayList<>(plane);
    }

    public List<Line> getLines(int n) {
        List<Line> lines = new ArrayList<>();
        List<Point> pointList = new ArrayList<>(plane);

        Set<Set<Point>> uniqueLines = new HashSet<> ();

        for(int i=0; i<plane.size(); i++){
            for(int j=i+1; j<plane.size(); j++){
                Set<Point> linePoints = new HashSet<>();
                Point iPoint = pointList.get(i);
                Point jPoint = pointList.get(j);

                linePoints.add(iPoint);
                linePoints.add(jPoint);

                for(int k = 0; k<pointList.size(); k++) {
                    Point kPoint = pointList.get(k);
                    if( (k != i && k != j) && isCollinear(iPoint, jPoint, kPoint) ){
                        linePoints.add(kPoint);
                    }
                }

                if(linePoints.size() >= n && uniqueLines.add(linePoints)) {
                    lines.add(new Line(new ArrayList<>(linePoints)));
                }
            }

        }
        return lines;
    }

    public List<Line> findLines(List<Point> points) {
        List<Line> toReturn = new ArrayList<>();
        List<Line> lines = getLines(points.size());
        for(Line line : lines) {
            if(new HashSet<>(line.getPointList()).containsAll(points)) {
                toReturn.add(line);
            }
        }
        return toReturn;
    }


    public void clearPoints(){
        plane.clear();
    }

    private boolean isCollinear(Point p1, Point p2, Point p3) {
        int determinant = p1.getX() * (p2.getY() - p3.getY()) +
                p2.getX() * (p3.getY() - p1.getY()) +
                p3.getX() * (p1.getY() - p2.getY());
        return determinant == 0;
    }
}
