package frc.team281.robot.subsystems;

/**
 * Moves four motors ahead, just enough to test that the encoders work.
 * 
 * @author dcowden
 *
 */
public class MotorEncoderTester {

	public static final double TEST_SPEED = 0.2;
	public static final long TEST_TIME_MS = 200;

	protected TalonSpeedController leftFrontMotor;
	protected TalonSpeedController leftRearMotor;
	protected TalonSpeedController rightFrontMotor;
	protected TalonSpeedController rightRearMotor;

	public MotorEncoderTester(TalonSpeedController leftFrontMotor, TalonSpeedController leftRearMotor,
			TalonSpeedController rightFrontMotor, TalonSpeedController rightRearMotor) {

		this.leftFrontMotor = leftFrontMotor;
		this.leftRearMotor = leftRearMotor;
		this.rightFrontMotor = rightFrontMotor;
		this.rightRearMotor = rightRearMotor;
	}

	public EncoderCheck testMotors() {

		leftFrontMotor.resetPosition();
		leftRearMotor.resetPosition();
		rightFrontMotor.resetPosition();
		rightRearMotor.resetPosition();

		leftFrontMotor.setDesiredSpeed(TEST_SPEED);
		leftRearMotor.setDesiredSpeed(TEST_SPEED);
		rightFrontMotor.setDesiredSpeed(TEST_SPEED);
		rightRearMotor.setDesiredSpeed(TEST_SPEED);

		sleep(TEST_TIME_MS);

		leftFrontMotor.setDesiredSpeed(0);
		leftRearMotor.setDesiredSpeed(0);
		rightFrontMotor.setDesiredSpeed(0);
		rightRearMotor.setDesiredSpeed(0);

		return new EncoderCheck(leftRearMotor.getActualPosition(), leftFrontMotor.getActualPosition(),
				rightFrontMotor.getActualPosition(), rightRearMotor.getActualPosition());

	}

	public void sleep(long millisToSleep) {
		try {
			Thread.sleep(millisToSleep);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
