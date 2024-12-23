package org.firstinspires.ftc.teamcode.common.hardware.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import com.arcrobotics.ftclib.command.SubsystemBase;

public class SampleSubsystem extends SubsystemBase {

    private final DcMotorEx extendo;
    private final Servo arm, rotate, wrist;

    public IntakeState intakeState;
    public ArmState armState;

    public enum IntakeState {
        IN,
        STOP,
        OUT
    }

    public enum ArmState {
        TRANSFER,
        INTAKE,
        UP,
        NONE
    }

    public enum DetectedColor {
        BLUE,
        RED,
        YELLOW,
        NONE
    }

    public SampleSubsystem(HardwareMap hardwareMap) {
    }

    public void updateData() {
    }

    public void setArmPosition(double pos) {
    }

    public void updateArmState(ArmState state) {
        this.armState = state;
    }

    private double getArmStatePosition(ArmState state) {
    }

    public void setExtensionPower(double power) {
    }

    public void setTargetExtensionPosition(int target) {
    }

    public void setExtensionPosition(double power, int target) {
    }

    public void periodic() {
    }

    public void updateIntakeState(IntakeState state) {
        this.intakeState = state;
    }
}