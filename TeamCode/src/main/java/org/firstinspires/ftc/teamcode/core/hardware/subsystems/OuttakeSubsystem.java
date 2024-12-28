package org.firstinspires.ftc.teamcode.core.hardware.subsystems;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.util.Constants;
import org.firstinspires.ftc.teamcode.core.util.wrappers.WSubsystemBase;

public class OuttakeSubsystem extends WSubsystemBase {
    private final DcMotorEx motorOne;
    private final DcMotorEx motorTwo;
    private final Servo clawServo;
    private final Servo highRotateServo;
    private final Servo highWristServo;
    private final Servo highArmServo;

    private final PIDFController pidfController;

    // State Enums
    public enum SlideState {
        EXTEND,
        RETRACT,
        STOP
    }

    public enum ClawState {
        EXCHANGE,
        READY,
        CLOSE,
        DROP,
        BEFORE_CLOSE,
        OPEN
    }

    public enum RotateState {
        EXCHANGE,
        READY,
        DROP,
        GET_CLIP,
        HANG_CLIP
    }

    public enum WristState {
        EXCHANGE,
        READY,
        PULL_SAMPLE,
        DROP,
        THROW,
        GET_CLIP,
        HANG_CLIP,
        HANG_CLIP_DRAG
    }

    public enum ArmState {
        EXCHANGE,
        READY,
        PULL_SAMPLE,
        DROP,
        GET_CLIP,
        HANG_CLIP
    }

    // Current States
    public SlideState slideState;
    public ClawState clawState;
    public RotateState rotateState;
    public WristState wristState;
    public ArmState armState;

    // TODO: Tune the PIDF values
    private static final double kP = 1.0;
    private static final double kI = 0.0;
    private static final double kD = 0.0;
    private static final double kF = 0.0;

    public OuttakeSubsystem(HardwareMap hardwareMap, String motorOneName, String motorTwoName,
                            String clawServoName, String highRotateServoName,
                            String highWristServoName, String highArmServoName) {

        motorOne = hardwareMap.get(DcMotorEx.class, motorOneName);
        motorTwo = hardwareMap.get(DcMotorEx.class, motorTwoName);

        clawServo = hardwareMap.get(Servo.class, clawServoName);
        highRotateServo = hardwareMap.get(Servo.class, highRotateServoName);
        highWristServo = hardwareMap.get(Servo.class, highWristServoName);
        highArmServo = hardwareMap.get(Servo.class, highArmServoName);

        // Initialize motor behavior
        motorOne.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorTwo.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        // Initialize PIDF Controllers
        pidfController = new PIDFController(kP, kI, kD, kF);

        slideState = SlideState.STOP;
        clawState = ClawState.OPEN;
        rotateState = RotateState.EXCHANGE;
        wristState = WristState.EXCHANGE;
        armState = ArmState.EXCHANGE;

        Robot.getInstance().subsystems.add(this);
    }

    // State Setters
    public void setSlideState(SlideState state) {
        this.slideState = state;
    }

    public void setClawState(ClawState state) {
        this.clawState = state;
    }

    public void setRotateState(RotateState state) {
        this.rotateState = state;
    }

    public void setWristState(WristState state) {
        this.wristState = state;
    }

    public void setArmState(ArmState state) {
        this.armState = state;
    }

    // Set Servo Positions
    public void setClawPosition(ClawState state) {
        switch (state) {
            case EXCHANGE:
                clawServo.setPosition(Constants.clawExchangePosition);
                break;
            case READY:
                clawServo.setPosition(Constants.clawReadyPosition);
                break;
            case CLOSE:
                clawServo.setPosition(Constants.clawClosePosition);
                break;
            case DROP:
                clawServo.setPosition(Constants.clawDropPosition);
                break;
            case BEFORE_CLOSE:
                clawServo.setPosition(Constants.clawBeforeClosePosition);
                break;
            case OPEN:
                clawServo.setPosition(Constants.clawOpenPosition);
                break;
        }
    }

    public void setRotatePosition(RotateState state) {
        switch (state) {
            case EXCHANGE:
                highRotateServo.setPosition(Constants.highRotateExchangePosition);
                break;
            case READY:
                highRotateServo.setPosition(Constants.highRotateReadyPosition);
                break;
            case DROP:
                highRotateServo.setPosition(Constants.highRotateDropPosition);
                break;
            case GET_CLIP:
                highRotateServo.setPosition(Constants.highRotateGetClipPosition);
                break;
            case HANG_CLIP:
                highRotateServo.setPosition(Constants.highRotateHangClipPosition);
                break;
        }
    }

    public void setWristPosition(WristState state) {
        switch (state) {
            case EXCHANGE:
                highWristServo.setPosition(Constants.highWristExchangePosition);
                break;
            case READY:
                highWristServo.setPosition(Constants.highWristReadyPosition);
                break;
            case PULL_SAMPLE:
                highWristServo.setPosition(Constants.highWristPullSamplePosition);
                break;
            case DROP:
                highWristServo.setPosition(Constants.highWristDropPosition);
                break;
            case THROW:
                highWristServo.setPosition(Constants.highWristThrowPosition);
                break;
            case GET_CLIP:
                highWristServo.setPosition(Constants.highWristGetClipPosition);
                break;
            case HANG_CLIP:
                highWristServo.setPosition(Constants.highWristHangClipPosition);
                break;
            case HANG_CLIP_DRAG:
                highWristServo.setPosition(Constants.highWristHangClipDragPosition);
                break;
        }
    }

    public void setArmPosition(ArmState state) {
        switch (state) {
            case EXCHANGE:
                highArmServo.setPosition(Constants.highArmExchangePosition);
                break;
            case READY:
                highArmServo.setPosition(Constants.highArmReadyPosition);
                break;
            case PULL_SAMPLE:
                highArmServo.setPosition(Constants.highArmPullSamplePosition);
                break;
            case DROP:
                highArmServo.setPosition(Constants.highArmDropPosition);
                break;
            case GET_CLIP:
                highArmServo.setPosition(Constants.highArmGetClipPosition);
                break;
            case HANG_CLIP:
                highArmServo.setPosition(Constants.highArmHangClipPosition);
                break;
        }
    }

    // PIDF Motor Control
    private void setMotorTargetPosition(DcMotorEx motor, PIDFController controller, int targetPosition) {
        double currentPosition = motor.getCurrentPosition();
        double power = controller.calculate(currentPosition, targetPosition);
        motor.setPower(power);
    }

    public void setTargetPosition(int targetPosition) {
        setMotorTargetPosition(motorOne, pidfController, targetPosition);
        setMotorTargetPosition(motorTwo, pidfController, targetPosition);
    }

    // Periodic Updates
    @Override
    public void periodic() {
        // Handle Slide State
        switch (slideState) {
            case EXTEND:
                setTargetPosition(1000); // Example position
                break;
            case RETRACT:
                setTargetPosition(-1000); // Example position
                break;
            case STOP:
                stopAllMotors();
                break;
        }

        // Handle Claw State
        setClawPosition(clawState);

        // Handle Rotate State
        setRotatePosition(rotateState);

        // Handle Wrist State
        setWristPosition(wristState);

        // Handle Arm State
        setArmPosition(armState);
    }

    private void stopAllMotors() {
        motorOne.setPower(0.0);
        motorTwo.setPower(0.0);
    }
}