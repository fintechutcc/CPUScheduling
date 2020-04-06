package th.ac.utcc.computer.cpuscheduling;

import th.ac.utcc.computer.cpuscheduling.algorithm.SchedulingAlgorithm;

/**
 *
 * @author  Suparerk Manitpornsut
 * @since   April 06, 2020
 * @version 1.0.0
 */
public class NonPreemptiveCPUScheduler extends CPUScheduler {
    
    public NonPreemptiveCPUScheduler(SchedulingAlgorithm scheduler) {
        super(scheduler);
        this.scheduler = scheduler;
        this.processes = this.scheduler.schedule();
        this.isWaitingTimeReady = false;
        this.isTurnAroundTimeReady = false;
        this.avgWaitingTime = 0.0;
        this.avgTurnAroundTime = 0.0;
    }
    
    @Override
    public void calculateAverageTime() {
        if(processes.length > 0) {
            if (!this.isWaitingTimeReady) {
                this.calculateWaitingTime();
            }

            if (!this.isTurnAroundTimeReady) {
                this.calculateTurnAroundTime();
            }

            double waitingTimeTotal = 0, turnAroundTimeTotal = 0;
            for (CPUProcess process : processes) {
                waitingTimeTotal = waitingTimeTotal + process.getWaitingTime();
                turnAroundTimeTotal = turnAroundTimeTotal + process.getTurnAroundTime();
            }

            this.avgWaitingTime = waitingTimeTotal / processes.length;
            this.avgTurnAroundTime = turnAroundTimeTotal / processes.length; 
        }
    }
    
    @Override
    public void calculateWaitingTime() {
        // Waiting Time for first process = 0.0
        processes[0].setWaitingTime(0.0); 
  
        // Calculating Waiting Time  
        for (int i = 1; i < processes.length; i++) { 
            processes[i].setWaitingTime(processes[i-1].getBurstTime() + processes[i-1].getWaitingTime());
        } 
        
        this.isWaitingTimeReady = true;
    }
    
    @Override
    public void calculateTurnAroundTime() {
        if(!this.isWaitingTimeReady) {
            this.calculateWaitingTime();
        }
        
        for (CPUProcess process : processes) {
            process.setTurnAroundTime(process.getBurstTime() + process.getWaitingTime());
        }
        
        this.isTurnAroundTimeReady = true;
    }
}
