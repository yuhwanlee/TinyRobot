package org.exponential.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.exponential.superclasses.Mechanism;

public class Arm implements Mechanism {
    LinearOpMode opMode;

    Servo clampServo;
    DcMotorEx raiseMotor;

    public static final int LOWER_POSITION = 77;
    public static final int RAISE_POSITION = 0;
    public static final double RELEASE_POSITION = 0;
    public static final double CLAMP_POSITION = 1;

    @Override
    public void initialize(LinearOpMode opMode) {
        this.opMode = opMode;

        clampServo = opMode.hardwareMap.servo.get("clampServo");
        raiseMotor = opMode.hardwareMap.get(DcMotorEx.class, "raiseMotor");
        raiseMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        raiseMotor.setTargetPosition(0);
        raiseMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        raiseMotor.setPower(1);
    }

    public void lower() {
        raiseMotor.setTargetPosition(LOWER_POSITION);
        raiseMotor.setPower(1);
    }

    public void raise() {
        raiseMotor.setTargetPosition(RAISE_POSITION);
        raiseMotor.setPower(1);
    }

    public void release() {
        clampServo.setPosition(CLAMP_POSITION);
    }

    public void clamp() {
        clampServo.setPosition(RELEASE_POSITION);
    }
}
