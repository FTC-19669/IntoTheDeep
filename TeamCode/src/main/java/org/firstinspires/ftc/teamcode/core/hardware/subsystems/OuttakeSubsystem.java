package org.firstinspires.ftc.teamcode.core.hardware.subsystems;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.util.Constants;
import org.firstinspires.ftc.teamcode.core.util.wrappers.WSubsystemBase;

public class OuttakeSubsystem extends WSubsystemBase {
    private final DcMotorEx motorOne;
    private final DcMotorEx motorTwo;
    private final Servo clawServo;
    private final Servo yawServo;
    private final Servo pitchServo;
    private final Servo armServo;

    private final PIDFController pidfController;

    // TODO: Tune PIDF values
    private static final double kP = 1.0;
    private static final double kI = 0.0;
    private static final double kD = 0.0;
    private static final double kF = 0.0;

    public OuttakeSubsystem(HardwareMap hardwareMap) {
        motorOne = hardwareMap.get(DcMotorEx.class, Constants.outtakeMotorOneName);
        motorTwo = hardwareMap.get(DcMotorEx.class, Constants.outtakeMotorTwoName);

        clawServo = hardwareMap.get(Servo.class, Constants.clawServoName);
        yawServo = hardwareMap.get(Servo.class, Constants.highYawServoName);
        pitchServo = hardwareMap.get(Servo.class, Constants.highPivotServoName);
        armServo = hardwareMap.get(Servo.class, Constants.highArmServoName);

        motorOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorTwo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorTwo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // TODO: Set the intial positions of the servos

        pidfController = new PIDFController(kP, kI, kD, kF);

        Robot.getInstance().subsystems.add(this);
    }

    public void moveSlidesToPosition(int targetPosition) {
        motorOne.setTargetPosition(targetPosition);
        motorTwo.setTargetPosition(targetPosition);

        motorOne.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorTwo.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        setSlidePowerUsingPIDF(targetPosition);
    }

    public void setSlidePower(double power) {
        motorOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorOne.setPower(power);
        motorTwo.setPower(power);
    }

    public void setSlidePowerUsingPIDF(int targetPosition) {
        double currentPositionOne = motorOne.getCurrentPosition();
        double currentPositionTwo = motorTwo.getCurrentPosition();

        double powerOne = pidfController.calculate(currentPositionOne, targetPosition);
        double powerTwo = pidfController.calculate(currentPositionTwo, targetPosition);

        motorOne.setPower(powerOne);
        motorTwo.setPower(powerTwo);
    }

    public void resetSlides() {
        motorOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorTwo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void stopSlides() {
        motorOne.setPower(0.0);
        motorTwo.setPower(0.0);
    }

    public void setClawPosition(double position) {
        clawServo.setPosition(position);
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

    public double getClawPosition() {
        return clawServo.getPosition();
    }

    public double getYawPosition() {
        return yawServo.getPosition();
    }

    public double getPitchPosition() {
        return pitchServo.getPosition();
    }

    public double getArmPosition() {
        return armServo.getPosition();
    }

}