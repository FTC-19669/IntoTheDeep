package org.firstinspires.ftc.teamcode.core.util;

import com.acmerobotics.dashboard.config.Config;
import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;

@Config
public class Constants {
    /* --------------------------------------NAMES----------------------------------------------- */

    public static final String leftFrontMotorName = "frontLeftMotor";
    public static final String leftRearMotorName = "backLeftMotor";
    public static final String rightFrontMotorName = "frontRightMotor";
    public static final String rightRearMotorName = "backRightMotor";
    public static final String extendoMotorName = "extendo";
    public static final String outtakeMotorOneName = "outtakeOne";
    public static final String outtakeMotorTwoName = "outtakeTwo";

    public static final String leftPtoName = "leftpto";
    public static final String rightPtoName = "rightpto";
    public static final String intakeName = "intake";
    public static final String lowYawServoName = "lowyaw";
    public static final String lowPivotServoName = "lowpivot";
    public static final String lowerArmServoName = "lowarm";
    public static final String clawServoName = "claw";
    public static final String highYawServoName = "highyaw";
    public static final String highPivotServoName = "highpivot";
    public static final String highArmServoName = "higharm";

    /* ---------------------------------TELEOP CONSTANTS----------------------------------------- */

    /* ---------------------------------AUTO CONSTANTS------------------------------------------- */

    public static final Pose sampleStartPose = new Pose(6.563, 113.8, 0);
    public static final Pose specimenStartPose = new Pose(6.375, 65.625, 180);

    public static final Pose bucketScorePose = new Pose(13.313, 129, 315);
    public static final Pose specimenScorePose = new Pose(0, 0, 0);

    public static final Pose sampleParkPose = new Pose(0, 0, 0);
    public static final Pose specimenParkPose = new Pose(0, 0, 0);

    /* ---------------------------------SERVO CONSTANTS------------------------------------------ */

    // Left PTO
    public static final double leftPTODownPosition = 0.3;
    public static final double leftPTOUpPosition = 0.6;

    // Right PTO
    public static final double rightPTODownPosition = 0.5;
    public static final double rightPTOUpPosition = 0.25;

    /* TODO: RENAME ALL OF THIS */
    // Rotate
    public static final double rotateStraightPosition = 0.53;
    public static final double rotateExchangePosition = 0.53;
    public static final double rotateReadyPosition = 0.53;
    public static final double rotateDropPosition = 0.50;

    // Wrist
    public static final double wristPickPosition = 0.489;
    public static final double wristExchangePosition = 0.189;
    public static final double wristReadyPosition = 0.189;
    public static final double wristExchangePreparePosition = 0.159;

    // Arm
    public static final double armPickPosition = 0.42;
    public static final double armExchangePosition = 0.649;
    public static final double armReadyPosition = 0.649;
    public static final double armExchangePreparePosition = 0.669;

    // Claw
    public static final double clawExchangePosition = 0.37;
    public static final double clawReadyPosition = 0.52;
    public static final double clawClosePosition = 0.63;
    public static final double clawDropPosition = 0.37;
    public static final double clawBeforeClosePosition = 0.61;
    public static final double clawOpenPosition = 0.37;

    // High Rotate
    public static final double highRotateExchangePosition = 0.337;
    public static final double highRotateReadyPosition = 0.337;
    public static final double highRotateDropPosition = 0.618;
    public static final double highRotateGetClipPosition = 0.618;
    public static final double highRotateHangClipPosition = 0.618;

    // High Wrist
    public static final double highWristExchangePosition = 0.688;
    public static final double highWristReadyPosition = 0.688;
    public static final double highWristPullSamplePosition = 0.560;
    public static final double highWristDropPosition = 0.04;
    public static final double highWristThrowPosition = 0.25;
    public static final double highWristGetClipPosition = 0.26;
    public static final double highWristHangClipPosition = 0.257;
    public static final double highWristHangClipDragPosition = 0.357;

    // High Arm
    public static final double highArmExchangePosition = 0.91;
    public static final double highArmReadyPosition = 0.91;
    public static final double highArmPullSamplePosition = 0.22;
    public static final double highArmDropPosition = 0.97;
    public static final double highArmGetClipPosition = 0.83;
    public static final double highArmHangClipPosition = 1.00;

    /* ---------------------------------MOTOR CONSTANTS------------------------------------------ */

    // Horizontal Extendo
    public static final double extendoMaxPosition = 590;

    // Vertical Extendo
    public static final double outtakeMaxPosition = 1025;
    public static final double hangSpecimenPosition = 400;

    /* ---------------------------------VISION CONSTANTS----------------------------------------- */

    /* ---------------------------------OTHER CONSTANTS------------------------------------------- */

    public static class Globals {
        public static boolean isAuto = true;

        public enum AllianceColor {
            RED,
            BLUE,
        }
        public static AllianceColor allianceColor = AllianceColor.RED;
    }
}