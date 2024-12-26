package org.firstinspires.ftc.teamcode.core.util;

import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.BezierCurve;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.BezierLine;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Path;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Point;
import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;

public class AutonomousHelpers {

    public enum HeadingInterpolation {
        LINEAR,
        CONSTANT,
        TANGENT
    }

    public static Path buildLine(Pose startPose, Pose endPose, HeadingInterpolation interpolation) {
        Point startPoint = new Point(startPose.getX(), startPose.getY());
        Point endPoint = new Point(endPose.getX(), endPose.getY());

        Path path = new Path(new BezierLine(startPoint, endPoint));
        setHeadingInterpolation(path, startPose.getHeading(), endPose.getHeading(), interpolation);

        return path;
    }

    public static Path buildCurve(Pose startPose, Point controlPoint, Pose endPose,
                                  HeadingInterpolation interpolation) {
        Point startPoint = new Point(startPose.getX(), startPose.getY());
        Point endPoint = new Point(endPose.getX(), endPose.getY());

        Path path = new Path(new BezierCurve(startPoint, controlPoint, endPoint));
        setHeadingInterpolation(path, startPose.getHeading(), endPose.getHeading(), interpolation);

        return path;
    }

    public static Path buildCurve(Pose startPose, Point firstControlPoint, Point secondControlPoint,
                                  Pose endPose, HeadingInterpolation interpolation) {
        Point startPoint = new Point(startPose.getX(), startPose.getY());
        Point endPoint = new Point(endPose.getX(), endPose.getY());

        Path path = new Path(new BezierCurve(startPoint, firstControlPoint, secondControlPoint, endPoint));
        setHeadingInterpolation(path, startPose.getHeading(), endPose.getHeading(), interpolation);

        return path;
    }

    private static void setHeadingInterpolation(Path path, double startHeading, double endHeading,
                                                HeadingInterpolation interpolation) {
        switch (interpolation) {
            case LINEAR:
                path.setLinearHeadingInterpolation(startHeading, endHeading);
                break;
            case CONSTANT:
                path.setConstantHeadingInterpolation(startHeading);
                break;
            case TANGENT:
                path.setTangentHeadingInterpolation();
                break;
        }
    }
}