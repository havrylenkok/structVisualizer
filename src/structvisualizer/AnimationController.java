package structvisualizer;

/*
 * AnimationController   3/13/16, 20:48
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Kyrylo Havrylenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * <what class do>
 *
 * @see
 *
 * @author Kyrylo Havrylenko
 *
 */
public class AnimationController {
    //        final DoubleProperty x = new SimpleDoubleProperty();
//        final DoubleProperty y = new SimpleDoubleProperty();
//
//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.seconds(0),
//                        new KeyValue(x, 0),
//                        new KeyValue(y, 0)
//                        ),
//                new KeyFrame(Duration.seconds(3),
//                        new KeyValue(x, W - D),
//                        new KeyValue(y, H - D)
//                )
//        );
//        timeline.setAutoReverse(true);
//        timeline.setCycleCount(Timeline.INDEFINITE);
//
//        final Canvas canvas = new Canvas(W, H);
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                GraphicsContext gc = canvas.getGraphicsContext2D();
//                gc.setFill(Color.CORNSILK);
//                gc.fillRect(0, 0, W, H);
//                gc.setFill(Color.FORESTGREEN);
//                gc.fillOval(
//                        x.doubleValue(),
//                        y.doubleValue(),
//                        D,
//                        D
//                );
//            }
//        };
//
//        primaryStage.setScene(
//                new Scene(
//                        new Group(
//                                canvas
//                        )
//                )
//        );
//        primaryStage.show();
//        timer.start();
//        timeline.play();
}
