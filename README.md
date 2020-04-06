# CPU Scheduling
ตัวอย่างอย่างง่ายสำหรับ CPU Scheduling โครงสร้างของแพ็กเกจที่สำคัญมีดังนี้

## th.ac.utcc.computer.cpuscheduling
คลาสที่สำคัญได้แก่ NonPreemptiveCPUScheduler ที่ได้สร้างเป็นต้นแบบอย่างง่ายสำหรับ Non-Preemptive Scheduler สามารถคำนวณ Waiting Time, Turn Around time และ Average Time ได้

## th.ac.utcc.computer.cpuscheduling.algorithm
คลาสที่สำคัญได้แก่ 
- SchedulingAlgorithm ที่เป็น abstract class หากต้องการสร้างอัลกอริทึมเพิ่มเติม ควรเป็นคลาสลูกของคลาสนี้
- FCFSAlgorithm เป็นตัวอย่างของ First Come First Serve ที่จัดลำดับของโพรเซสให้ CPU จาก Arrival Time

## th.ac.utcc.computer.cpuscheduling.example
มีตัวอย่างของ FCFSScheduler เอาไว้ให้ หากมีการสร้างอัลกอริทึมอื่น สามารถดัดแปลงตัวอย่างนี้เพื่อใช้ทดสอบอัลกอริทึมใหม่ได้
