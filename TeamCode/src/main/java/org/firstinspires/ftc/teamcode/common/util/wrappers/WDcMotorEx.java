package org.firstinspires.ftc.teamcode.common.util.wrappers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.common.util.Constants.*;

public class WDcMotorEx {

    public DcMotorEx motor;
    public WDcMotorExParams params;

    private boolean usePower = true;
    private boolean modeUpdate = false;
    private boolean useEncoder = true;

    private int targetPosition = 0;
    private double targetPower = 0;
    private int currentPosition = 0;
    private double power = 0.0;

    public WDcMotorEx(DcMotorEx motor, WDcMotorExParams params) {
        this.motor = motor;
        this.params = params;
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public int getPosition() {
        return this.currentPosition;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void setTargetPosition(int target, double power) {
        this.targetPosition = Range.clip(target, this.params.minPosition, this.params.maxPosition);

        this.targetPower = power;
        usePower = false;
        useEncoder = true;
    }

    public void setPosition(double power, int target) {
        motor.setPower(power);
        motor.setTargetPosition(target);
        motor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }

    public void setMode(DcMotor.RunMode mode) {
        this.motor.setMode(mode);
    }

    public void periodic() {
        currentPosition = motor.getCurrentPosition();

        if (usePower && power == 0) {
            usePower = false;
            targetPosition = currentPosition;
            useEncoder = true;
        }

        if (power > 0.05) {
            useEncoder = true;
            // user trying to lift up
            if (currentPosition < this.params.maxPosition || !Globals.LIMITS) {
                usePower = true;
                power *= this.params.upRatio;
            } else {
                power = 0;
            }
        } else if (power < -0.05) {
            useEncoder = true;
            // user trying to lift down
            if (currentPosition > this.params.minPosition || !Globals.LIMITS) {
                usePower = true;
                power *= this.params.downRatio;
                if (currentPosition > this.params.slow) {
                    currentPosition *= this.params.slowRatio;
                }
            } else {
                power = 0;
            }
        } else if (usePower) {
            power = 0;
        }

        if (modeUpdate && useEncoder) {
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            modeUpdate = false;
        }

        if (usePower) {
            motor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
            motor.setPower(this.power);
        } else {
            setPosition(this.targetPower, this.targetPosition);
            useEncoder = false;
            modeUpdate = true;
        }

    }

}