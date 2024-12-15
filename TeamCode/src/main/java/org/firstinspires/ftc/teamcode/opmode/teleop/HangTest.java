package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.common.util.Constants;


@TeleOp
public class HangTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
        Servo leftPTO = hardwareMap.servo.get("leftPTO");
        Servo rightPTO = hardwareMap.servo.get("rightPTO");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        if (isStopRequested()) return;
        boolean pressed = false;
        while (opModeIsActive()) {
//            // Test PTO
//            boolean a = gamepad1.a;
//            boolean y = gamepad1.y;
//            boolean dpad_up = gamepad1.dpad_up;
//            boolean dpad_down = gamepad1.dpad_down;
//            double leftPTOPosition = leftPTO.getPosition();
//            double rightPTOPosition = rightPTO.getPosition();
//            if (a || y || dpad_up || dpad_down) {
//                if (!pressed) {
//                    if (y) {
//                        leftPTO.setPosition(leftPTOPosition + 0.05);
//                    } else if (a) {
//                        leftPTO.setPosition(leftPTOPosition - 0.05);
//                    }
//
//                    if (dpad_up) {
//                        rightPTO.setPosition(rightPTOPosition + 0.05);
//                    } else if (dpad_down) {
//                        rightPTO.setPosition(rightPTOPosition - 0.05);
//                    }
//                }
//                pressed = true;
//            }
//            else {
//                pressed = false;
//            }
//            telemetry.addData("Left PTO Position", leftPTO.getPosition());
//            telemetry.addData("Right PTO Position", rightPTO.getPosition());
//            telemetry.update();

            // Engage PTO
            if (gamepad1.a) {
                leftPTO.setPosition(Constants.leftPTOUp);
                rightPTO.setPosition(Constants.rightPTOUp);
            } else if (gamepad1.b) {
                leftPTO.setPosition(Constants.leftPTODown);
                rightPTO.setPosition(Constants.rightPTODown);
            }

        }
    }
}
