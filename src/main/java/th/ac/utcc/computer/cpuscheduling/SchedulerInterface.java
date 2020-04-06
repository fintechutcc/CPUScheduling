package th.ac.utcc.computer.cpuscheduling;

/**
 *
 * @author  Suparerk Manitpornsut
 * @since   April 06, 2020
 * @version 1.0.0
 */
public interface SchedulerInterface {
    public void calculateAverageTime();
    public void calculateWaitingTime();
    public void calculateTurnAroundTime();
}
