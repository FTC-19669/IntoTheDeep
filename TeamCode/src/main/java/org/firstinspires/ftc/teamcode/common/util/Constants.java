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

    public static String leftPTO = "leftpto";
    public static String rightPTO = "rightpto";

    public static String lowRotate = "lowrotate";
    public static String lowWrist = "lowwrist";
    public static String lowArm = "lowarm";

    public static String claw = "claw";
    public static String highRotate = "highrotate";
    public static String highWrist = "highwrist";
    public static String highArm = "higharm";

    public static String extendo = "extendo";
    public static String outtake = "outtake";

    /* ---------------------------------TELEOP CONSTANTS----------------------------------------- */

    /* ---------------------------------AUTO CONSTANTS------------------------------------------- */

    public static Pose sampleStartPose = new Pose(6.563, 113.8, 0);
    public static Pose specimenStartPose = new Pose(6.375, 65.625, 180);

    public static Pose bucketScorePose = new Pose(13.313, 129, 315);
    public static Pose specimenScorePose = new Pose(0, 0, 0);

    public static Pose sampleParkPose = new Pose(0, 0, 0);
    public static Pose specimenParkPose = new Pose(0, 0, 0);

    /* ---------------------------------SERVO CONSTANTS------------------------------------------ */

    // Left PTO
    public static double leftPTOUp = 0.659;
    public static double leftPTODown = 0.349;

    public static double leftPTODownNew = 0.3;
    public static double leftPTOUpNew = 0.6;

    // Right PTO
    public static double rightPTOUp = 0.209;
    public static double rightPTODown = 0.449;

    public static double rightPTODownNew = 0.5;
    public static double rightPTOUpNew = 0.25;

    // Low Rotate
    public static double lowRotateStraight = 0.53;
    public static double lowRotateExchange = 0.53;
    public static double lowRotateReady = 0.53;
    public static double lowRotateDrop = 0.50;
    public static double lowRotateGetBrick3 = 0.71;
    public static double lowRotateBackPick = 0.0;

    // Low Wrist
    public static double lowWristPick = 0.42;
    public static double lowWristExchange = 0.649;
    public static double lowWristReady = 0.649;
    public static double lowWristExchangePrepare = 0.669;
    public static double lowWristPickNear = 0.41;

    // Low Arm
    public static double lowArmPick = 0.489;
    public static double lowArmExchange = 0.189;
    public static double lowArmReady = 0.189;
    public static double lowArmExchangePrepare = 0.159;
    public static double lowArmGetBrick3 = 0.71;
    public static double lowArmBackPick = 0.0;

    // Grip
    public static double clawExchange = 0.37;
    public static double clawReady = 0.52;
    public static double clawClose = 0.63;
    public static double clawDrop = 0.37;
    public static double clawBeforeClose = 0.61;
    public static double clawOpen = 0.37;

    // High Rotate
    public static double highRotateExchange = 0.337;
    public static double highRotateReady = 0.337;
    public static double highRotateDrop = 0.618;
    public static double highRotateGetClip = 0.618;
    public static double highRotateHangClip = 0.618;

    // High Wrist
    public static double highWristExchange = 0.688;
    public static double highWristReady = 0.688;
    public static double highWristPullSample = 0.560;
    public static double highWristDrop = 0.04;
    public static double highWristThrow = 0.25;
    public static double highWristGetClip = 0.26;
    public static double highWristHangClip = 0.257;
    public static double highWristHangClipDrag = 0.357;

    // High Arm
    public static double highArmExchange = 0.91;
    public static double highArmReady = 0.91;
    public static double highArmPullSample = 0.22;
    public static double highArmDrop = 0.97;
    public static double highArmGetClip = 0.83;
    public static double highArmHangClip = 1.00;

    /* ---------------------------------MOTOR CONSTANTS------------------------------------------ */

    // Extendo
    public static double extendoMax = 2700;

    // Outtake
    public static double outtakeMax =  2700;
    public static double hangSpecimen = 400;

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