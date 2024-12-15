package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Sample extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Declare our motors
        // Make sure your ID's match your configuration
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
        DcMotor extendoRight = hardwareMap.get(DcMotorEx.class, "extendoRight");
        // no extendoLeft motor in this example
        DcMotor slideMotor = hardwareMap.get(DcMotorEx.class, "slideMotor");

        // Reverse the right side motors. This may be wrong for your setup.
        // If your robot moves backwards when commanded to go forwards,
        // reverse the left side instead.
        // See the note about this earlier on this page.
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        if (isStopRequested()) return;

        slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        extendoRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x * 0.8;
            boolean extendoUp = gamepad1.dpad_right;
            boolean extendoDown = gamepad1.dpad_left;
            boolean slideUp = gamepad1.dpad_up;
            boolean slideDown = gamepad1.dpad_down;

            double motorPower = 0.5;
            // Reset encoder and set up RUN_TO_POSITION mode
            slideMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
            extendoRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
            slideMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
            extendoRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
            slideMotor.setPower(motorPower);
            extendoRight.setPower(motorPower);
            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            if (extendoUp && extendoRight.getCurrentPosition() < 600) {
                extendoRight.setPower(motorPower);
            } else if (extendoDown && extendoRight.getCurrentPosition() > 0) {
                extendoRight.setPower(-motorPower);
            } else {
                extendoRight.setPower(0);
            }

            if (slideUp && slideMotor.getCurrentPosition() < 600) {
                slideMotor.setPower(motorPower);
            } else if (slideDown && slideMotor.getCurrentPosition() > 0) {
                slideMotor.setPower(-motorPower);
            } else {
                slideMotor.setPower(0);
            }


            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);

            frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }
}
