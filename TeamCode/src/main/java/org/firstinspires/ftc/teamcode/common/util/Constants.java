package org.firstinspires.ftc.teamcode.common.util;

import com.acmerobotics.dashboard.config.Config;
import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;

@Config
public class Constants {
    /* --------------------------------------NAMES----------------------------------------------- */

    public static String leftFrontMotorName = "frontLeftMotor";
    public static String leftRearMotorName = "backLeftMotor";
    public static String rightFrontMotorName = "frontRightMotor";
    public static String rightRearMotorName = "backRightMotor";

    public static String pinpointName = "pinpoint";
    public static String forwardEncoderName = "leftRear";
    public static String strafeEncoderName = "strafeEncoder";

    public static String leftPtoName = "leftpto";
    public static String rightPtoName = "rightpto";

    public static String lowRotateName = "lowrotate";
    public static String lowWristName = "lowwrist";
    public static String lowArmName = "lowarm";

    public static String clawName = "claw";
    public static String highRotateName = "highrotate";
    public static String highWristName = "highwrist";
    public static String highArmName = "higharm";

    public static String extendoName = "extendo";
    public static String outtakeName = "outtake";

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
    public static double leftPTODownPosition = 0.3;
    public static double leftPTOUpPosition = 0.6;

    // Right PTO
    public static double rightPTODownPosition = 0.5;
    public static double rightPTOUpPosition = 0.25;

    // Low Rotate
    public static double lowRotateStraightPosition = 0.53;
    public static double lowRotateExchangePosition = 0.53;
    public static double lowRotateReadyPosition = 0.53;
    public static double lowRotateDropPosition = 0.50;
    public static double lowRotateGetBrick3Position = 0.71;
    public static double lowRotateBackPickPosition = 0.0;

    // Low Wrist
    public static double lowWristPickPosition = 0.42;
    public static double lowWristExchangePosition = 0.649;
    public static double lowWristReadyPosition = 0.649;
    public static double lowWristExchangePreparePosition = 0.669;
    public static double lowWristPickNearPosition = 0.41;

    // Low Arm
    public static double lowArmPickPosition = 0.489;
    public static double lowArmExchangePosition = 0.189;
    public static double lowArmReadyPosition = 0.189;
    public static double lowArmExchangePreparePosition = 0.159;
    public static double lowArmGetBrick3Position = 0.71;
    public static double lowArmBackPickPosition = 0.0;

    // Claw
    public static double clawExchangePosition = 0.37;
    public static double clawReadyPosition = 0.52;
    public static double clawClosePosition = 0.63;
    public static double clawDropPosition = 0.37;
    public static double clawBeforeClosePosition = 0.61;
    public static double clawOpenPosition = 0.37;

    // High Rotate
    public static double highRotateExchangePosition = 0.337;
    public static double highRotateReadyPosition = 0.337;
    public static double highRotateDropPosition = 0.618;
    public static double highRotateGetClipPosition = 0.618;
    public static double highRotateHangClipPosition = 0.618;

    // High Wrist
    public static double highWristExchangePosition = 0.688;
    public static double highWristReadyPosition = 0.688;
    public static double highWristPullSamplePosition = 0.560;
    public static double highWristDropPosition = 0.04;
    public static double highWristThrowPosition = 0.25;
    public static double highWristGetClipPosition = 0.26;
    public static double highWristHangClipPosition = 0.257;
    public static double highWristHangClipDragPosition = 0.357;

    // High Arm
    public static double highArmExchangePosition = 0.91;
    public static double highArmReadyPosition = 0.91;
    public static double highArmPullSamplePosition = 0.22;
    public static double highArmDropPosition = 0.97;
    public static double highArmGetClipPosition = 0.83;
    public static double highArmHangClipPosition = 1.00;

    /* ---------------------------------MOTOR CONSTANTS------------------------------------------ */

    // Extendo
    public static double extendoMaxPosition = 580;

    // Outtake
    public static double outtakeMaxPosition = 1010;
    public static double hangSpecimenPosition = 400;

    /* ---------------------------------VISION CONSTANTS----------------------------------------- */

    /* --------------------------------------OTHER----------------------------------------------- */

    public static class Globals {
        public static boolean limitsEnabled = true;
        public static boolean isAutonomous = false;
        public static Alliance alliance;

        public enum Alliance {
            RED,
            BLUE
        }
    }
}