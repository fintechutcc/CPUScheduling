package th.ac.utcc.computer.cpuscheduling;

import th.ac.utcc.computer.cpuscheduling.algorithm.SchedulingAlgorithm;

/**
 *
 * @author  Suparerk Manitpornsut
 * @since   April 06, 2020
 * @version 1.0.0
 */
public abstract class CPUScheduler implements SchedulerInterface {
    protected SchedulingAlgorithm scheduler;
    protected CPUProcess [] processes;
    protected boolean isWaitingTimeReady;
    protected boolean isTurnAroundTimeReady;
    protected double avgWaitingTime;
    protected double avgTurnAroundTime;
    
    public CPUScheduler(SchedulingAlgorithm scheduler) {
        this.scheduler = scheduler;
        this.processes = this.scheduler.schedule();
        this.isWaitingTimeReady = false;
        this.isTurnAroundTimeReady = false;
        this.avgWaitingTime = 0.0;
        this.avgTurnAroundTime = 0.0;
    }

    // Getters
    public CPUProcess[] getProcesses() {
        return processes;
    }

    public double getAvgWaitingTime() {
        return avgWaitingTime;
    }

    public double getAvgTurnAroundTime() {
        return avgTurnAroundTime;
    }
    
    // Setters
    public void setScheduler(SchedulingAlgorithm scheduler) {
        this.scheduler = scheduler;
        this.scheduler.schedule();
        this.isTurnAroundTimeReady = false;
        this.isWaitingTimeReady = false;
        this.avgTurnAroundTime = 0.0;
        this.avgWaitingTime = 0.0;
    }
}
