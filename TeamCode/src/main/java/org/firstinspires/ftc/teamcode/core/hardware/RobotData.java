package org.firstinspires.ftc.teamcode.core.hardware;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;

import org.firstinspires.ftc.teamcode.core.hardware.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.PTOSubsystem;

public class RobotData {
    public long loopTime = System.currentTimeMillis();

    public Pose currentPose;

    public boolean scoringSample = false;
    public boolean scoringSpecimen = false;

    public boolean sampleLoaded = false;
    public boolean specimenLoaded = false;

    public boolean intakingSample = false;
    public boolean intakingSpecimen = false;

    public boolean isHanging = false;

    // TODO: Add hardware data as variable and to write() method
    public IntakeSubsystem.IntakeState intakeState = IntakeSubsystem.IntakeState.STOP;
    public double intakeYawServoPosition;
    public double intakePitchServoPosition;
    public double intakeArmServoPosition;
    public int extensionPosition = 0;

    public double outtakeClawServoPosition;
    public double outtakeYawServoPosition;
    public double outtakePitchServoPosition;
    public double outtakeArmServoPosition;
    public int outtakeMotorOnePosition = 0;
    public int outtakeMotorTwoPosition = 0;

    public PTOSubsystem.PTOState ptoState = PTOSubsystem.PTOState.DISENGAGED;
    public double leftPTOPosition;
    public double rightPTOPosition;

    public void write(Telemetry telemetry) {
        telemetry.addData("Loop Time:", System.currentTimeMillis() - loopTime);
        loopTime = System.currentTimeMillis();

        telemetry.addLine();

        telemetry.addData("Pose:", currentPose);
        telemetry.addData("Busy:", Robot.getInstance().isBusy());

        telemetry.addLine();

        telemetry.addData("Scoring Sample", scoringSample);
        telemetry.addData("Scoring Specimen", scoringSpecimen);
        telemetry.addData("Sample Loaded", sampleLoaded);
        telemetry.addData("Specimen Loaded", specimenLoaded);
        telemetry.addData("Intaking Sample", intakingSample);
        telemetry.addData("Intaking Specimen", intakingSpecimen);

        telemetry.addLine();

        telemetry.addData("Intake State", intakeState);
        telemetry.addData("Intake Yaw Servo Position", intakeYawServoPosition);
        telemetry.addData("Intake Pitch Servo Position", intakePitchServoPosition);
        telemetry.addData("Intake Arm Servo Position", intakeArmServoPosition);
        telemetry.addData("Intake Extension Position", extensionPosition);

        telemetry.addLine();

        telemetry.addData("Outtake Claw Servo Position", outtakeClawServoPosition);
        telemetry.addData("Outtake Yaw Servo Position", outtakeYawServoPosition);
        telemetry.addData("Outtake Pitch Servo Position", outtakePitchServoPosition);
        telemetry.addData("Outtake Arm Servo Position", outtakeArmServoPosition);
        telemetry.addData("Outtake Motor One Position", outtakeMotorOnePosition);
        telemetry.addData("Outtake Motor Two Position", outtakeMotorTwoPosition);

        telemetry.addLine();

        telemetry.addData("PTO State", ptoState);
        telemetry.addData("Left PTO Position", leftPTOPosition);
        telemetry.addData("Right PTO Position", rightPTOPosition);
        telemetry.addData("Hanging", isHanging);

        telemetry.update();
    }


    public void startScoringSample() {
        scoringSample = true;
        intakingSample = false;
    }

    public void stopScoringSample() {
        scoringSample = false;
        intakingSample = false;
    }

    public void startIntakingSample() {
        scoringSample = false;
        intakingSample = true;
    }

    public void stopIntakingSample() {
        scoringSample = false;
        intakingSample = false;
    }

    public void setSampleLoaded() {
        sampleLoaded = true;
    }

    public void setSampleUnloaded() {
        sampleLoaded = false;
    }

    public void startScoringSpecimen() {
        scoringSpecimen = true;
        intakingSpecimen = false;
    }

    public void stopScoringSpecimen() {
        scoringSpecimen = false;
        intakingSpecimen = false;
    }

    public void startIntakingSpecimen() {
        scoringSpecimen = false;
        intakingSpecimen = true;
    }

    public void stopIntakingSpecimen() {
        scoringSpecimen = false;
        intakingSpecimen = false;
    }

    public void setSpecimenLoaded() {
        specimenLoaded = true;
    }

    public void setSpecimenUnloaded() {
        specimenLoaded = false;
    }

    public void setHanging() {
        isHanging = !isHanging;
    }
}
