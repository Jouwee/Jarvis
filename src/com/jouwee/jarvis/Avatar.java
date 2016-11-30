package com.jouwee.jarvis;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Jarvis avatar
 *
 * @author Jouwee
 */
public class Avatar extends Pane {

    public Avatar() {
        super();
//        GraphicsContext gc = getGraphicsContext2D();
//        drawShapes(gc);
        
        Rectangle baseRect = new Rectangle(110, 60, 100, 100);
        baseRect.setArcWidth(50);
        baseRect.setArcHeight(50);
        baseRect.setFill(Color.BLACK);
        Rectangle leftEyeRect = new Rectangle(130, 80, 25, 35);
        leftEyeRect.setArcWidth(10);
        leftEyeRect.setArcHeight(10);
        leftEyeRect.setFill(new Color(78f/255f, 197f/255f, 201f/255f, 1.0));
        Rectangle rightEyeRect = new Rectangle(168, 80, 25, 35);
        rightEyeRect.setArcWidth(10);
        rightEyeRect.setArcHeight(10);
        rightEyeRect.setFill(new Color(78f/255f, 197f/255f, 201f/255f, 1.0));

        getChildren().addAll(baseRect, leftEyeRect, rightEyeRect);

        final Timeline blinkTimeline = new Timeline();
        blinkTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(0),
            new KeyValue(leftEyeRect.heightProperty(), 35),
            new KeyValue(leftEyeRect.yProperty(), 80),
            new KeyValue(leftEyeRect.widthProperty(), 25),
            new KeyValue(leftEyeRect.xProperty(), 130),
            //
            new KeyValue(rightEyeRect.heightProperty(), 35),
            new KeyValue(rightEyeRect.yProperty(), 80),
            new KeyValue(rightEyeRect.widthProperty(), 25),
            new KeyValue(rightEyeRect.xProperty(), 168)
        ));
        blinkTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(50), 
            new KeyValue(leftEyeRect.heightProperty(), 5),
            new KeyValue(leftEyeRect.yProperty(), 100),
            new KeyValue(leftEyeRect.widthProperty(), 33),
            new KeyValue(leftEyeRect.xProperty(), 126),
            //
            new KeyValue(rightEyeRect.heightProperty(), 5),
            new KeyValue(rightEyeRect.yProperty(), 100),
            new KeyValue(rightEyeRect.widthProperty(), 33),
            new KeyValue(rightEyeRect.xProperty(), 164)
        ));

        blinkTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(100),
            new KeyValue(leftEyeRect.heightProperty(), 35),
            new KeyValue(leftEyeRect.yProperty(), 80),
            new KeyValue(leftEyeRect.widthProperty(), 25),
            new KeyValue(leftEyeRect.xProperty(), 130),
            //
            new KeyValue(rightEyeRect.heightProperty(), 35),
            new KeyValue(rightEyeRect.yProperty(), 80),
            new KeyValue(rightEyeRect.widthProperty(), 25),
            new KeyValue(rightEyeRect.xProperty(), 168)
        ));
        
        Timeline[] idleAnimations = new Timeline[] {blinkTimeline};
        

        new Thread(() -> {
            while (true) {
                idleAnimations[(int)(Math.random() * idleAnimations.length)].play();
                try {
                    Thread.sleep((long) (Math.random() * 3000 + 300));
                } catch(Exception e) {}
            }
        }).start();
             
    }

}
