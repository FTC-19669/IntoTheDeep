package org.firstinspires.ftc.teamcode.core.vision;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.*;
import org.opencv.imgproc.*;

public class SampleAlignmentProcessor implements VisionProcessor {

    // Color thresholds for yellow
    private static final Scalar LOWER_YELLOW = new Scalar(20, 100, 100);
    private static final Scalar UPPER_YELLOW = new Scalar(30, 255, 255);

    // Color thresholds for red
    private static final Scalar LOWER_RED1 = new Scalar(0, 100, 100);
    private static final Scalar UPPER_RED1 = new Scalar(10, 255, 255);
    private static final Scalar LOWER_RED2 = new Scalar(170, 100, 100);
    private static final Scalar UPPER_RED2 = new Scalar(180, 255, 255);

    // Color thresholds for blue
    private static final Scalar LOWER_BLUE = new Scalar(100, 150, 50);
    private static final Scalar UPPER_BLUE = new Scalar(130, 255, 255);

    // Camera field of view and pixel constants
    private static final double CAMERA_FOV_HORIZONTAL = 60.0;
    private static final int CAMERA_INTAKE_START = 100;
    private static final int CAMERA_PIXEL_PER_INCH = 70;

    // Variables to store the largest detected rectangle and calculated values
    private Rect largestRect = null;
    private double angleToRotate = 0.0;
    private double distanceToMove = 0.0;
    private SampleColor detectedColor = SampleColor.UNKNOWN;

    // Enum to represent detected sample colors
    public enum SampleColor {
        RED,
        YELLOW,
        BLUE,
        UNKNOWN
    }

    @Override
    public Object processFrame(Mat input, long captureTimeNanos) {
        Mat hsvMat = new Mat();
        Mat maskYellow = new Mat();
        Mat maskRed = new Mat();
        Mat maskRed1 = new Mat();
        Mat maskRed2 = new Mat();
        Mat maskBlue = new Mat();
        Mat maskCombined = new Mat();
        Mat hierarchy = new Mat();

        // Convert the input frame to HSV color space
        Imgproc.cvtColor(input, hsvMat, Imgproc.COLOR_RGB2HSV);

        // Create masks for yellow, red, and blue objects
        Core.inRange(hsvMat, LOWER_YELLOW, UPPER_YELLOW, maskYellow);
        Core.inRange(hsvMat, LOWER_RED1, UPPER_RED1, maskRed1);
        Core.inRange(hsvMat, LOWER_RED2, UPPER_RED2, maskRed2);
        Core.addWeighted(maskRed1, 1.0, maskRed2, 1.0, 0.0, maskRed);
        Core.inRange(hsvMat, LOWER_BLUE, UPPER_BLUE, maskBlue);

        // Combine all masks into one
        Core.bitwise_or(maskYellow, maskRed, maskCombined);
        Core.bitwise_or(maskCombined, maskBlue, maskCombined);

        // Find contours in the combined mask
        java.util.List<MatOfPoint> contours = new java.util.ArrayList<>();
        Imgproc.findContours(maskCombined, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        double maxArea = 0;
        largestRect = null;
        detectedColor = SampleColor.UNKNOWN;

        // Iterate through contours to find the largest one and determine its color
        for (MatOfPoint contour : contours) {
            Rect rect = Imgproc.boundingRect(contour);
            double area = Imgproc.contourArea(contour);

            if (area > maxArea) {
                Mat subMat = hsvMat.submat(rect);

                // Create masks for the submat
                Mat subMaskYellow = new Mat();
                Mat subMaskRed = new Mat();
                Mat subMaskRed1 = new Mat();
                Mat subMaskRed2 = new Mat();
                Mat subMaskBlue = new Mat();

                Core.inRange(subMat, LOWER_YELLOW, UPPER_YELLOW, subMaskYellow);
                Core.inRange(subMat, LOWER_RED1, UPPER_RED1, subMaskRed1);
                Core.inRange(subMat, LOWER_RED2, UPPER_RED2, subMaskRed2);
                Core.addWeighted(subMaskRed1, 1.0, subMaskRed2, 1.0, 0.0, subMaskRed);
                Core.inRange(subMat, LOWER_BLUE, UPPER_BLUE, subMaskBlue);

                // Count non-zero pixels in each mask to determine the predominant color
                int yellowCount = Core.countNonZero(subMaskYellow);
                int redCount = Core.countNonZero(subMaskRed);
                int blueCount = Core.countNonZero(subMaskBlue);

                if (yellowCount > redCount && yellowCount > blueCount) {
                    detectedColor = SampleColor.YELLOW;
                } else if (redCount > yellowCount && redCount > blueCount) {
                    detectedColor = SampleColor.RED;
                } else if (blueCount > yellowCount && blueCount > redCount) {
                    detectedColor = SampleColor.BLUE;
                } else {
                    detectedColor = SampleColor.UNKNOWN;
                }

                // Release sub masks
                subMaskYellow.release();
                subMaskRed1.release();
                subMaskRed2.release();
                subMaskRed.release();
                subMaskBlue.release();
                subMat.release();

                maxArea = area;
                largestRect = rect;
            }
        }

        if (largestRect != null) {
            // Draw a rectangle around the largest detected object
            Imgproc.rectangle(input, largestRect, new Scalar(0, 255, 0), 2);

            // Calculate angle offset
            double sampleCenterX = largestRect.x + (largestRect.width / 2.0);
            double frameCenterX = input.cols() / 2.0;
            double pixelOffset = sampleCenterX - frameCenterX;
            double anglePerPixel = CAMERA_FOV_HORIZONTAL / input.cols();
            angleToRotate = pixelOffset * anglePerPixel;

            // Calculate distance to move
            double sampleCenterY = largestRect.y + (largestRect.height / 2.0);
            double frameBottom = input.rows();
            double pixelDistance = frameBottom - sampleCenterY - CAMERA_INTAKE_START;
            distanceToMove = pixelDistance / CAMERA_PIXEL_PER_INCH;
        } else {
            angleToRotate = 0.0;
            distanceToMove = 0.0;
            detectedColor = SampleColor.UNKNOWN;
        }

        // Release memory
        hsvMat.release();
        maskYellow.release();
        maskRed.release();
        maskRed1.release();
        maskRed2.release();
        maskBlue.release();
        maskCombined.release();
        hierarchy.release();

        return angleToRotate;
    }

    @Override
    public void init(int width, int height, CameraCalibration calibration) {
        // Initialization logic if needed
    }

    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {
        if (largestRect != null) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5.0f * scaleCanvasDensity);

            // Set paint color based on detected sample color
            switch (detectedColor) {
                case YELLOW:
                    paint.setColor(android.graphics.Color.YELLOW);
                    break;
                case RED:
                    paint.setColor(android.graphics.Color.RED);
                    break;
                case BLUE:
                    paint.setColor(android.graphics.Color.BLUE);
                    break;
                default:
                    paint.setColor(android.graphics.Color.WHITE);
                    break;
            }

            // Scale OpenCV rectangle to canvas coordinates
            RectF scaledRect = new RectF(
                    largestRect.x * scaleBmpPxToCanvasPx,
                    largestRect.y * scaleBmpPxToCanvasPx,
                    (largestRect.x + largestRect.width) * scaleBmpPxToCanvasPx,
                    (largestRect.y + largestRect.height) * scaleBmpPxToCanvasPx
            );

            // Draw the rectangle
            canvas.drawRect(scaledRect, paint);
        }
    }

    // Getter for the calculated angle
    public double getAngleToRotate() {
        return angleToRotate;
    }

    // Getter for the calculated distance
    public double getDistanceToMove() {
        return distanceToMove;
    }

    // Getter for the detected color
    public SampleColor getDetectedColor() {
        return detectedColor;
    }
}