package org.firstinspires.ftc.teamcode.core.hardware.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.util.Constants;
import org.firstinspires.ftc.teamcode.core.util.wrappers.WSubsystemBase;

public class PTOSubsystem extends WSubsystemBase {
    private final Servo leftPTO;
    private final Servo rightPTO;

    public enum PTOState {
        ENGAGED,
        DISENGAGED
    }
    public PTOState ptoState;

    public PTOSubsystem(HardwareMap hardwareMap) {
        leftPTO = hardwareMap.get(Servo.class, Constants.leftPtoName);
        rightPTO = hardwareMap.get(Servo.class, Constants.rightPtoName);

        ptoState = PTOState.DISENGAGED;

        Robot.getInstance().subsystems.add(this);
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

    @Override
    public void periodic() {
        setPTOPosition(ptoState);
    }
}