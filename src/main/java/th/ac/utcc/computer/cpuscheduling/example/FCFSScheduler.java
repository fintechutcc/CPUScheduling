package th.ac.utcc.computer.cpuscheduling.example;

import th.ac.utcc.computer.cpuscheduling.CPUProcess;
import th.ac.utcc.computer.cpuscheduling.NonPreemptiveCPUScheduler;
import th.ac.utcc.computer.cpuscheduling.algorithm.FCFSAlgorithm;
import th.ac.utcc.computer.cpuscheduling.algorithm.SchedulingAlgorithm;

/**
 *
 * @author  Suparerk Manitpornsut
 * @since   April 06, 2020
 * @version 1.0.0
 */
public class FCFSScheduler {
    public static void main(String [] args) {
        // Create 3 processes
        // Process 0 : {ID : "A", Arrival Time 1, BurstTime : 10 }
        // Process 1 : {ID : "B", Arrival Time 3, BurstTime : 8  }
        // Process 2 : {ID : "C", Arrival Time 2, BurstTime : 5  }
        // Process 3 : {ID : "D", Arrival Time 0, BurstTime : 7  }
        CPUProcess [] processes = new CPUProcess[4];
        processes[0] = new CPUProcess("A", 1, 10);
        processes[1] = new CPUProcess("B", 3, 8);
        processes[2] = new CPUProcess("C", 2, 5);
        processes[3] = new CPUProcess("D", 0, 7);
        
       
        // Create algorithm object as the FCFSAlgorithm
        SchedulingAlgorithm algorithm = new FCFSAlgorithm(processes);
        
        // Assign the algorithm object to the scheduler 
        NonPreemptiveCPUScheduler scheduler = new NonPreemptiveCPUScheduler(algorithm);
        
        // Calculate Waiting Time, Turn Around Time, and Average Time
        scheduler.calculateWaitingTime();
        scheduler.calculateTurnAroundTime();
        scheduler.calculateAverageTime();
        
        // Display outputs
        System.out.printf("%5s %10s %18s %18s %18s\n", "No.", "ProcessID", "Burst Time", "Waiting Time", "Turn Around Time");
        processes = scheduler.getProcesses();
        int order = 1;
        for(CPUProcess process : processes) {
            System.out.printf("%5d %10s %18.2f %18.2f %18.2f\n", 
                    order++,
                    process.getProcessID(), 
                    process.getBurstTime(),
                    process.getWaitingTime(),
                    process.getTurnAroundTime());
        }
        
        System.out.printf("%-30s %9.4f\n", "Average Waiting Time:", scheduler.getAvgWaitingTime());
        System.out.printf("%-30s %9.4f\n", "Average Turn Around Time:", scheduler.getAvgTurnAroundTime());
    }
}
