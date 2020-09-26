package com.spring.schedule;


public class Master {


    String[] files;
    int nMap;
    int nReduce;
    TaskState[] mapTaskStatus;
    TaskState[] reduceTaskStatus;
    TaskInfo taskInfo;
    boolean finished;


    public Master(String[] files, int nReduce) {
        this.files = files;
        this.nMap = files.length;
        this.nReduce = nReduce;

        mapTaskStatus = new TaskState[nMap];
        initStatus(mapTaskStatus);

        reduceTaskStatus = new TaskState[nReduce];
        initStatus(reduceTaskStatus);

    }

    private void initStatus(TaskState[] states) {
        for (int i = 0; i < states.length; i++) {
            states[i] = TaskState.notYetStart;
        }
    }

    public boolean done() {

        if (finished) {
            return true;
        }
        return false;
    }


    enum TaskState {
        notYetStart,
        doing,
        done;
    }


}
