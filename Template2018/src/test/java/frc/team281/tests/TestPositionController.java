package frc.team281.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.team281.robot.subsystems.PositionController;

public class TestPositionController {

	@Test
	public void testCreatingPositionController() {
		
		int DESIRED_POSITION = 2000;
		double P = 0.2;
		double I = 0.3;
		double D = 0.4;
		double F = 0.5;
		int PID_SLOT = 0;
		int PROFILE_SLOT = 0;
		int SPEED = 6000;
		int ACCEL = 15000;
		//have to mock this-- creating one needs native libraries we dont have loaded.
		TalonSRX talon = Mockito.mock(TalonSRX.class);
		
		PositionController pc = new PositionController.Builder(talon) 
				.withDefaultOutputLevels()
				.withGains(F, P, I, D)
				.withMotionProfile(ACCEL, SPEED)
				.build();
		
		pc.setDesiredPosition(DESIRED_POSITION);
		pc.zeroSensorPosition();
		pc.setPositionTolerance(10);
		assertEquals(DESIRED_POSITION,pc.getDesiredPosition());
		assertEquals(false,pc.hasReachedTarget());
		
		Mockito.verify(talon).config_kD(0, D, PositionController.TIMEOUT_MS);
		Mockito.verify(talon).config_kI(0, I, PositionController.TIMEOUT_MS);
		Mockito.verify(talon).config_kP(0, P, PositionController.TIMEOUT_MS);
		Mockito.verify(talon).config_kF(0, F, PositionController.TIMEOUT_MS);
		Mockito.verify(talon).configMotionCruiseVelocity(SPEED, PositionController.TIMEOUT_MS);
		Mockito.verify(talon).configMotionAcceleration(ACCEL, PositionController.TIMEOUT_MS);
		Mockito.verify(talon).selectProfileSlot(PROFILE_SLOT, PID_SLOT);
	}
}