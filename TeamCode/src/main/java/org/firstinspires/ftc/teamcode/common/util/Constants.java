package org.firstinspires.ftc.teamcode.common.util;

import com.acmerobotics.dashboard.config.Config;
import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;

@Config
public class Constants {
    /* --------------------------------------NAMES----------------------------------------------- */

    public static String leftFrontMotor = "frontLeftMotor";
    public static String leftRearMotor = "backLeftMotor";
    public static String rightFrontMotor = "frontRightMotor";
    public static String rightRearMotor = "backRightMotor";

    public static String pinpoint = "pinpoint";
    public static String forwardEncoder = "leftRear";
    public static String strafeEncoder = "strafeEncoder";

    /* ---------------------------------TELEOP CONSTANTS----------------------------------------- */

    /* ---------------------------------AUTO CONSTANTS------------------------------------------- */

    public static Pose sampleStartPose = new Pose(6.563, 113.8, 0);
    public static Pose specimenStartPose = new Pose(6.375, 65.625, 180);

    public static Pose bucketScorePose = new Pose(13.313, 129, 315);
    public static Pose specimenScorePose = new Pose(0, 0, 0);

    public static Pose sampleParkPose = new Pose(0, 0, 0);
    public static Pose specimenParkPose = new Pose(0, 0, 0);

    /* ---------------------------------SERVO CONSTANTS------------------------------------------ */

    /* ---------------------------------MOTOR CONSTANTS------------------------------------------ */

    /* ---------------------------------VISION CONSTANTS----------------------------------------- */

    /* --------------------------------------OTHER----------------------------------------------- */

    public static class Globals {
        public static boolean LIMITS = true;
        public static boolean IS_AUTO = false;
        public static Alliance ALLIANCE;

        public enum Alliance {
            RED,
            BLUE
        }
    }

}