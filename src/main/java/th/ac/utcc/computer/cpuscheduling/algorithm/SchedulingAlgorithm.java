package th.ac.utcc.computer.cpuscheduling.algorithm;

import th.ac.utcc.computer.cpuscheduling.CPUProcess;

/**
 *
 * @author  Suparerk Manitpornsut
 * @since   April 06, 2020
 * @version 1.0.0
 */
public abstract class SchedulingAlgorithm implements SchedulingAlgorithmInterface {
    protected CPUProcess [] processes;
    
    public SchedulingAlgorithm(CPUProcess [] processes) {
        this.processes = processes;
    }
}
