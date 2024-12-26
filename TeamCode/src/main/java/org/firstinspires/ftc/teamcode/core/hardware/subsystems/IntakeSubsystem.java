package org.firstinspires.ftc.teamcode.core.hardware.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.util.Constants;
import org.firstinspires.ftc.teamcode.core.util.wrappers.WSubsystemBase;

public class IntakeSubsystem extends WSubsystemBase {

    private final DcMotorEx extensionMotor;
    private final CRServoImplEx intakeServo;
    private final Servo rollerServo;
    private final Servo pivotServo;
    private final Servo wristServo;

    public IntakeState intakeState;
    public ArmState armState;
    public PivotState pivotState;
    public WristState wristState;

    public enum IntakeState {
        INTAKE,
        TRANSFER,
        STOP
    }

    public enum PivotState {
        PICK,
        EXCHANGE,
        READY,
        EXCHANGE_PREPARE
    }

    public enum WristState {
        PICK,
        EXCHANGE,
        READY,
        EXCHANGE_PREPARE
    }

    public enum ArmState {
        PICK,
        EXCHANGE,
        READY,
        EXCHANGE_PREPARE
    }

    public IntakeSubsystem(HardwareMap hardwareMap, String extMotor, String intake, String roller,
                           String pivot, String wrist) {
        this.extensionMotor = hardwareMap.get(DcMotorEx.class, extMotor);
        this.extensionMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        this.extensionMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        this.intakeServo = hardwareMap.get(CRServoImplEx.class, intake);
        this.rollerServo = hardwareMap.get(Servo.class, roller);
        this.pivotServo = hardwareMap.get(Servo.class, pivot);
        this.wristServo = hardwareMap.get(Servo.class, wrist);

        intakeState = IntakeState.STOP;
        armState = ArmState.READY;
        pivotState = PivotState.READY;
        wristState = WristState.READY;

        Robot.getInstance().subsystems.add(this);
    }

    public void setExtensionPosition(int targetPosition, double power) {
        extensionMotor.setTargetPosition(targetPosition);
        extensionMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        extensionMotor.setPower(power);
    }

    public void setExtensionPower(double power) {
        extensionMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        extensionMotor.setPower(power);
    }

    public int getExtensionPosition() {
        return extensionMotor.getCurrentPosition();
    }

    public void stopExtension() {
        extensionMotor.setPower(0);
    }

    public void setIntakeState(IntakeState state) {
        this.intakeState = state;
    }

    public void setIntakePower(double power) {
        intakeServo.setPower(power);
    }

    public void stopIntake() {
        intakeServo.setPower(0);
    }

    public void setRollerPosition(double position) {
        rollerServo.setPosition(position);
    }

    public void setPivotState(PivotState state) {
        this.pivotState = state;
    }

    public void setPivotPosition(PivotState state) {
        switch (state) {
            case PICK:
                pivotServo.setPosition(Constants.rotateStraightPosition);
                break;
            case EXCHANGE:
                pivotServo.setPosition(Constants.rotateExchangePosition);
                break;
            case READY:
                pivotServo.setPosition(Constants.rotateReadyPosition);
                break;
            case EXCHANGE_PREPARE:
                pivotServo.setPosition(Constants.rotateDropPosition);
                break;
        }
    }

    public void setWristState(WristState state) {
        this.wristState = state;
    }

    public void setWristPosition(WristState state) {
        switch (state) {
            case PICK:
                wristServo.setPosition(Constants.wristPickPosition);
                break;
            case EXCHANGE:
                wristServo.setPosition(Constants.wristExchangePosition);
                break;
            case READY:
                wristServo.setPosition(Constants.wristReadyPosition);
                break;
            case EXCHANGE_PREPARE:
                wristServo.setPosition(Constants.wristExchangePreparePosition);
                break;
        }
    }

    public void setArmState(ArmState state) {
        this.armState = state;
    }

    public void setArmPosition(ArmState state) {
        switch (state) {
            case PICK:
                rollerServo.setPosition(Constants.armPickPosition);
                break;
            case EXCHANGE:
                rollerServo.setPosition(Constants.armExchangePosition);
                break;
            case READY:
                rollerServo.setPosition(Constants.armReadyPosition);
                break;
            case EXCHANGE_PREPARE:
                rollerServo.setPosition(Constants.armExchangePreparePosition);
                break;
        }
    }

    @Override
    public void periodic() {
        // Intake State
        switch (intakeState) {
            case INTAKE:
                intakeServo.setPower(1.0);
                break;
            case TRANSFER:
                intakeServo.setPower(-1.0);
                break;
            case STOP:
                intakeServo.setPower(0.0);
                break;
        }

        // Pivot State
        setPivotPosition(pivotState);

        // Wrist State
        setWristPosition(wristState);

        // Arm State
        setArmPosition(armState);
    }
}