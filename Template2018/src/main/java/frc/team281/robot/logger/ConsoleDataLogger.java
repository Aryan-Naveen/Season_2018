package frc.team281.robot.logger;

import frc.team281.robot.subsystems.BaseSubsystem;

/**
 * logs data to the console ( system.out ) . Useful for unit testing.
 * 
 * @author dcowden
 *
 */
public class ConsoleDataLogger extends DataLogger {

    private TimeSource timer;

    public ConsoleDataLogger(String name, TimeSource systemTimer) {
        super(name);
        this.timer = systemTimer;
    }

    private void printMessage(String format, String key, Object value) {
        System.out.printf("[ %.3f ] - %s::" + format + "\n", timer.getElapsedSeconds(), computePath(key), value);
    }

    @Override
    public void log(String key, String value) {
        printMessage("%s", key, value);
    }

    @Override
    public void log(String key, Object value) {
        printMessage("%s", key, value.toString());
    }

    @Override
    public void log(String key, double value) {
        printMessage("%.3f", key, value);
    }

    @Override
    public void log(String key, int value) {
        printMessage("%d", key, value);
    }

    @Override
    public void log(String key, long value) {
        printMessage("%d", key, value);
    }

    @Override
    public void log(String key, boolean value) {
        printMessage("%s", key, Boolean.toString(value));
    }

    // Prints time, name and value for the Subsystem log
    @Override
    public void log(BaseSubsystem subsystem) {
        printMessage("%s", subsystem.getName(), subsystem);

    }
}
