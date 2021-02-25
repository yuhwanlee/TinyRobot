package org.exponential.robots;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.exponential.mechanisms.Arm;
import org.exponential.mechanisms.Drivetrain;
import org.exponential.superclasses.Robot;

public class TinyRobot implements Robot {
    LinearOpMode opMode;
    public Drivetrain drivetrain;
    public Arm arm;
    @Override
    public void initialize(LinearOpMode opMode) {
        this.opMode = opMode;
        drivetrain = new Drivetrain();
        drivetrain.initialize(opMode);

        arm = new Arm();
        arm.initialize(opMode);
    }
}
