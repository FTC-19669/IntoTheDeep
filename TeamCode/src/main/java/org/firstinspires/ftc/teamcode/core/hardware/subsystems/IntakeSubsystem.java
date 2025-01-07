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
    private final Servo yawServo;
    private final Servo pitchServo;
    private final Servo armServo;

    public enum IntakeState {
        INTAKE,
        TRANSFER,
        STOP
    }
    public IntakeState intakeState;

    public IntakeSubsystem(HardwareMap hardwareMap) {
        extensionMotor = hardwareMap.get(DcMotorEx.class, Constants.extendoMotorName);
        extensionMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        extensionMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        extensionMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intakeServo = hardwareMap.get(CRServoImplEx.class, Constants.intakeName);
        yawServo = hardwareMap.get(Servo.class, Constants.lowYawServoName);
        pitchServo = hardwareMap.get(Servo.class, Constants.lowPivotServoName);
        armServo = hardwareMap.get(Servo.class, Constants.lowerArmServoName);

        intakeState = IntakeState.STOP;
        // TODO: Set the initial position of the servos

        Robot.getInstance().subsystems.add(this);
    }

    @Override
    public void updateData() {
        Robot.getInstance().data.extensionPosition = extensionMotor.getCurrentPosition();
        Robot.getInstance().data.intakeState = intakeState;
        Robot.getInstance().data.intakeYawServoPosition = yawServo.getPosition();
        Robot.getInstance().data.intakePitchServoPosition = pitchServo.getPosition();
        Robot.getInstance().data.intakeArmServoPosition = armServo.getPosition();
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

    public double getYawPosition() {
        return yawServo.getPosition();
    }

    public void resetExtensionEncoder() {
        extensionMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
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

    public void setYawPosition(double position) {
        yawServo.setPosition(position);
    }

    public void setPitchPosition(double position) {
        pitchServo.setPosition(position);
    }

    public void setArmPosition(double position) {
        armServo.setPosition(position);
    }

    @Override
    public void periodic() {
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
    }
}