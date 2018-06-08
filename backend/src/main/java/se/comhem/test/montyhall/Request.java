package se.comhem.test.montyhall;

public class Request {
    private int simNum;
    private Boolean changeDoor;

    public Request(){}

    public Request(int simNum, Boolean changeDoor) {
        this.simNum = simNum;
        this.changeDoor = changeDoor;
    }

    public int getSimNum() {
        return simNum;
    }

    public void setSimNum(int simNum) {
        this.simNum = simNum;
    }

    public Boolean getChangeDoor() {
        return changeDoor;
    }

    public void setChangeDoor(Boolean changeDoor) {
        this.changeDoor = changeDoor;
    }
}
