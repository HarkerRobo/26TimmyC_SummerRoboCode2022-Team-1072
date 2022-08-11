package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.WristRollers;

public class WristRollersManual extends CommandBase {
    public WristRollersManual() {
        addRequirements(WristRollers.getInstance());
    }

    public void execute() {
        double output = OI.getInstance().getDriver().getLeftTrigger();

        if(Math.abs(output) < 0.5) {
            output = -0.3;
        } else if (Intake.getInstance().isIntaking()) {
            output = 0.3;
        } else {
            output = 0;
        }

        WristRollers.getInstance().setOutput(output);
    }

    public void end(boolean interrupted) {
        WristRollers.getInstance().setOutput(0);
    }
}
