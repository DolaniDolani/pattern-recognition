package com.welld.patternrecognition.pattern_recognition.controller;

import com.welld.patternrecognition.pattern_recognition.model.Line;
import com.welld.patternrecognition.pattern_recognition.model.Point;
import com.welld.patternrecognition.pattern_recognition.service.PatternRecognitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PatternRecognitionController {

    private final PatternRecognitionService patternRecognitionService;

    public PatternRecognitionController(PatternRecognitionService patternRecognitionService){
        this.patternRecognitionService = patternRecognitionService;
    }

    @PostMapping("/point")
    public ResponseEntity<Void> addPoint(@RequestBody Point point) {
        patternRecognitionService.addPoint(point.getX(), point.getY());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/space")
    public ResponseEntity<List<Point>> getAllPoints() {
        return ResponseEntity.ok(patternRecognitionService.getALlPoints());
    }

    @GetMapping("/lines/{n}")
    public ResponseEntity<List<Line>> getLines(@PathVariable int n) {
        return ResponseEntity.ok(patternRecognitionService.getLines(n));
    }

    @DeleteMapping("/space")
    public ResponseEntity<Void> clearPoints() {
        patternRecognitionService.clearPoints();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/find-lines")
    public ResponseEntity<List<Line>> findLines (@RequestBody List<Point> points) {
        return ResponseEntity.ok(patternRecognitionService.findLines(points));
    }
}
