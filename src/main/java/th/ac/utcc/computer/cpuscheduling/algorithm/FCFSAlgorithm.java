package th.ac.utcc.computer.cpuscheduling.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import th.ac.utcc.computer.cpuscheduling.CPUProcess;

/**
 *
 * @author  Suparerk Manitpornsut
 * @since   April 06, 2020
 * @version 1.0.0
 */
public class FCFSAlgorithm extends SchedulingAlgorithm {

    public FCFSAlgorithm(CPUProcess [] processes) {
        super(processes);
    }

    @Override
    public CPUProcess [] schedule() {
        // Order the process by Arrival Time
        Arrays.sort(processes, new Comparator<CPUProcess>() {
            @Override
            public int compare(CPUProcess p1, CPUProcess p2) {
                return p1.getArrivalTime() - (p2.getArrivalTime());
            }
        });
        return processes;
    }
}
