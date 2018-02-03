package frc.team281.robot;
import java.lang.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team281.robot.commands.ProngsUp;
import frc.team281.robot.commands.ProngsDown;
import frc.team281.robot.commands.ShooterOutTakeAbove;
import frc.team281.robot.commands.EnableFieldAbsolute;
import frc.team281.robot.commands.DisableFieldAbsolute;
import frc.team281.robot.commands.ShooterInTake;
import frc.team281.robot.commands.ShooterOutTakeBelow;
import frc.team281.robot.commands.CompleteBallShoot;
import frc.team281.robot.commands.DisableHoldYaw;
import frc.team281.robot.commands.SetRandomYawAngle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick _driveJoystick = new Joystick(RobotMap.driveJoystick);
	private static JoystickButton m_prongUpButton = new JoystickButton(_driveJoystick, RobotMap.prongsUpButton);
	private static JoystickButton m_prongDownButton = new JoystickButton(_driveJoystick, RobotMap.prongsDownButton);
	private static JoystickButton m_shootUpButton = new JoystickButton(_driveJoystick, RobotMap.shootUpButton);
	private static JoystickButton m_shootDownButton = new JoystickButton(_driveJoystick, RobotMap.shootDownButton);
	private static JoystickButton m_IntakeButton = new JoystickButton(_driveJoystick, RobotMap.InTakeButton);
	private static JoystickButton m_Effshooter = new JoystickButton(_driveJoystick, RobotMap.Effshooter);
	private static JoystickButton m_setRandomYawButton = new JoystickButton(_driveJoystick, RobotMap.setRandomYawButton);
	private static JoystickButton m_disableHoldYawButton = new JoystickButton(_driveJoystick, RobotMap.disableHoldYawButton);
	private static JoystickButton m_fieldAbsoluteButton = new JoystickButton(_driveJoystick, RobotMap.fieldAbsoluteButton);

    public OI () {
	    m_prongUpButton.whenPressed(new ProngsUp(Robot._prongsSubsystem));
	    m_prongDownButton.whenPressed(new ProngsDown(Robot._prongsSubsystem));

	    m_shootUpButton.whileHeld(new ShooterOutTakeAbove(Robot.m_ShooterOutTakeSubsystem));
	    // m_shootUpButton.whenReleased(new ShooterOutTakeSTOP(Robot.m_ShooterOutTakeSubsystem));

	    m_shootDownButton.whileHeld(new ShooterOutTakeBelow(Robot.m_ShooterOutTakeSubsystem));
	    // m_shootDownButton.whenReleased(new ShooterOutTakeSTOP(Robot.m_ShooterOutTakeSubsystem));

	    m_IntakeButton.whileHeld(new ShooterInTake(Robot.m_ShooterInTakeSubsystem));
	    // m_IntakeButton.whenReleased(new ShooterInTakeSTOP(Robot.m_ShooterInTakeSubsystem));

	    m_Effshooter.whenPressed(new CompleteBallShoot());

	    m_setRandomYawButton.whenPressed(new SetRandomYawAngle(Robot._driveSubsystem));
	    m_disableHoldYawButton.whenPressed(new DisableHoldYaw(Robot._driveSubsystem));
        m_fieldAbsoluteButton.whenPressed(new EnableFieldAbsolute(Robot._driveSubsystem));
        m_fieldAbsoluteButton.whenReleased(new DisableFieldAbsolute(Robot._driveSubsystem));
	}

	public double getDriveJoystickForward() {
		double a= _driveJoystick.getY();
		if(a<0) {
			return -Math.pow(-a,RobotMap.JoystickYSoftness);
		} else {
			return Math.pow(a,RobotMap.JoystickYSoftness);
		}
	}

	// Multiple branch issue was here
	public double getDriveJoystickLateral() {
		double a= _driveJoystick.getX();
		if(a<0) {
			return -Math.pow(-a, RobotMap.JoystickXSoftness);
		} else {
			return Math.pow(a, RobotMap.JoystickXSoftness);
		}
	}

	public double getJoystickDirection() {
		double x= _driveJoystick.getX();
		double y= _driveJoystick.getY();
		if ((Math.abs(x) < 0.01) && (Math.abs(y) < 0.01)) {
			return 360.0;
		}
		return Math.toDegrees(Math.atan2(x,-y));
	}

	public double getJoystickMagnitude() {
		double x= _driveJoystick.getX();
		double y= _driveJoystick.getY();
		return Math.sqrt(x*x+y*y);
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
