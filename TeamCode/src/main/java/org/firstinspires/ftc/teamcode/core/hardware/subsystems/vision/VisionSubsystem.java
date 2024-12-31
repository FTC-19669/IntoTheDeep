package org.firstinspires.ftc.teamcode.core.hardware.subsystems.vision;

import com.qualcomm.hardware.limelightvision.Limelight3A;

public class VisionSubsystem {
    private Limelight3A limelight;

    public enum VisionState {
        DETECTED,
        DETECTING,
        INACTIVE
    }

    public VisionSubsystem(Limelight3A limelight) {
        this.limelight = limelight;
    }
}
