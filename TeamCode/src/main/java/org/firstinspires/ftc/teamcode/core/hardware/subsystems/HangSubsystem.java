package org.firstinspires.ftc.teamcode.core.hardware.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.util.Constants;
import org.firstinspires.ftc.teamcode.core.util.wrappers.WSubsystemBase;

public class HangSubsystem extends WSubsystemBase {
    private final DcMotorEx motorOne;
    private final DcMotorEx motorTwo;
    private final DcMotorEx motorThree;
    private final DcMotorEx motorFour;

    private final Servo leftPTO;
    private final Servo rightPTO;

    // State Enums
    public enum HangState {
        RAISE,
        LOWER,
        STOP
    }

    public enum PTOState {
        ENGAGED,
        DISENGAGED
    }

    // Current States
    public HangState hangState;
    public PTOState ptoState;

    public HangSubsystem(HardwareMap hardwareMap, String motorOneName, String motorTwoName,
                         String motorThreeName, String motorFourName,
                         String leftPTOName, String rightPTOName) {

        motorOne = hardwareMap.get(DcMotorEx.class, motorOneName);
        motorTwo = hardwareMap.get(DcMotorEx.class, motorTwoName);
        motorThree = hardwareMap.get(DcMotorEx.class, motorThreeName);
        motorFour = hardwareMap.get(DcMotorEx.class, motorFourName);

        leftPTO = hardwareMap.get(Servo.class, leftPTOName);
        rightPTO = hardwareMap.get(Servo.class, rightPTOName);

        // Initialize motor behavior
        motorOne.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorTwo.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorThree.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorFour.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        hangState = HangState.STOP;
        ptoState = PTOState.DISENGAGED;

        Robot.getInstance().subsystems.add(this);
    }

    // State Setters
    public void setHangState(HangState state) {
        this.hangState = state;
    }

    public void setPTOState(PTOState state) {
        this.ptoState = state;
    }

    // Set PTO Servo Positions
    public void setPTOPosition(PTOState state) {
        switch (state) {
            case ENGAGED:
                leftPTO.setPosition(Constants.leftPTODownPosition);
                rightPTO.setPosition(Constants.rightPTODownPosition);
                break;
            case DISENGAGED:
                leftPTO.setPosition(Constants.leftPTOUpPosition);
                rightPTO.setPosition(Constants.rightPTOUpPosition);
                break;
        }
    }

    // Periodic Updates
    @Override
    public void periodic() {
        // Handle PTO State
        setPTOPosition(ptoState);

        // Handle Hang State
        switch (hangState) {
            case RAISE:
                setAllMotorsPower(1.0);
                break;
            case LOWER:
                setAllMotorsPower(-1.0);
                break;
            case STOP:
                setAllMotorsPower(0.0);
                break;
        }
    }

    private void setAllMotorsPower(double power) {
        motorOne.setPower(power);
        motorTwo.setPower(power);
        motorThree.setPower(power);
        motorFour.setPower(power);
    }

    public void stopAllMotors() {
        setAllMotorsPower(0.0);
    }
}