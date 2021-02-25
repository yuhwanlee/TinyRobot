package org.exponential.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.exponential.superclasses.Mechanism;

public class Arm implements Mechanism {
    LinearOpMode opMode;

    Servo clampServo;
    DcMotorEx raiseMotor;
    @Override
    public void initialize(LinearOpMode opMode) {
        this.opMode = opMode;

        clampServo = opMode.hardwareMap.servo.get("clampServo");
        raiseMotor = opMode.hardwareMap.get(DcMotorEx.class, "raiseMotor");
    }

    public void lower() {

    }

    public void raise() {

    }

    public void release() {

    }

    public void clamp() {

    }
}
