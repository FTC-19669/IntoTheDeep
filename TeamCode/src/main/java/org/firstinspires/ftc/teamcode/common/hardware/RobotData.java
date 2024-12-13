package org.firstinspires.ftc.teamcode.common.hardware;

public class RobotData {
    public long loopTime = System.currentTimeMillis();

    public boolean scoring = false;
    public boolean sampleLoaded = false;
    public boolean specimenLoaded = false;
    public boolean intakingSample = false;
    public boolean intakingSpecimen = false;

    public void startScoring() {
        scoring = true;
        intakingSample = false;
    }

    public void stopScoring() {
        scoring = false;
        intakingSample = false;
    }

    public void startIntaking() {
        scoring = false;
        intakingSample = true;
    }

    public void stopIntaking() {
        scoring = false;
        intakingSample = false;
    }

    public void setSampleLoaded() {
        sampleLoaded = true;
    }

    public void setSampleUnloaded() {
        sampleLoaded = false;
    }

    public void setSpecimenLoaded() {
        specimenLoaded = true;
    }

    public void setSpecimenUnloaded() {
        specimenLoaded = false;
    }
}
