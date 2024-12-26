package org.firstinspires.ftc.teamcode.core.hardware.subsystems;

import com.arcrobotics.ftclib.controller.PIDFController;
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

    private final PIDFController pidfController;

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

    // TODO: Tune the values
    private static final double kP = 1.0;
    private static final double kI = 0.0;
    private static final double kD = 0.0;
    private static final double kF = 0.0;

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

        // Initialize PIDF Controllers
        pidfController = new PIDFController(kP, kI, kD, kF);

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

    // PIDF Motor Control
    private void setMotorTargetPosition(DcMotorEx motor, PIDFController controller, int targetPosition) {
        double currentPosition = motor.getCurrentPosition();
        double power = controller.calculate(currentPosition, targetPosition);
        motor.setPower(power);
    }

    public void setTargetPosition(int targetPosition) {
        setMotorTargetPosition(motorOne, pidfController, targetPosition);
        setMotorTargetPosition(motorTwo, pidfController, targetPosition);
        setMotorTargetPosition(motorThree, pidfController, targetPosition);
        setMotorTargetPosition(motorFour, pidfController, targetPosition);
    }

    // Periodic Updates
    @Override
    public void periodic() {
        // Handle PTO State
        setPTOPosition(ptoState);

        // Handle Hang State
        switch (hangState) {
            case RAISE:
                setTargetPosition(1000); // Example position
                break;
            case LOWER:
                setTargetPosition(-1000); // Example position
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