package org.firstinspires.ftc.teamcode.common.vision;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.*;
import org.opencv.imgproc.*;

public class SampleAlignment implements VisionProcessor {

    private static final Scalar LOWER_YELLOW = new Scalar(20, 100, 100);
    private static final Scalar UPPER_YELLOW = new Scalar(30, 255, 255);
    private static final double CAMERA_FOV_HORIZONTAL = 60.0;

    private Rect largestRect = null; // Store the largest rectangle for use in onDrawFrame
    private double angleToRotate = 0.0; // Store the calculated angle for external access

    @Override
    public Object processFrame(Mat input, long captureTimeNanos) {
        Mat hsvMat = new Mat();
        Mat mask = new Mat();
        Mat hierarchy = new Mat();

        // Convert to HSV color space
        Imgproc.cvtColor(input, hsvMat, Imgproc.COLOR_RGB2HSV);

        // Create a mask for yellow objects
        Core.inRange(hsvMat, LOWER_YELLOW, UPPER_YELLOW, mask);

        // Find contours
        java.util.List<MatOfPoint> contours = new java.util.ArrayList<>();
        Imgproc.findContours(mask, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        double maxArea = 0;
        largestRect = null;

        for (MatOfPoint contour : contours) {
            Rect rect = Imgproc.boundingRect(contour);
            double area = Imgproc.contourArea(contour);

            if (area > maxArea) {
                maxArea = area;
                largestRect = rect;
            }
        }

        if (largestRect != null) {
            // Draw a rectangle around the largest yellow object
            Imgproc.rectangle(input, largestRect, new Scalar(0, 255, 0), 2);

            // Calculate angle offset
            double sampleCenterX = largestRect.x + (largestRect.width / 2.0);
            double frameCenterX = input.cols() / 2.0;
            double pixelOffset = sampleCenterX - frameCenterX;
            double anglePerPixel = CAMERA_FOV_HORIZONTAL / input.cols();
            angleToRotate = pixelOffset * anglePerPixel;
        } else {
            angleToRotate = 0.0;
        }

        // Release memory
        hsvMat.release();
        mask.release();
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
            paint.setColor(android.graphics.Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5.0f * scaleCanvasDensity);

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
}
