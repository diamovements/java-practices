package Pr7;

interface Remote {
    void turnOn();
    void turnOff();
}

interface Device {
    void enable();
    void disable();
}

class TV implements Device {

    @Override
    public void enable() {
        System.out.println("TV is on");
    }

    @Override
    public void disable() {
        System.out.println("TV is off");
    }
}

class RemoteTV implements Remote {
    private Device dev;

    public RemoteTV(Device dev) {
        this.dev = dev;
    }

    @Override
    public void turnOn() {
        dev.enable();
    }

    @Override
    public void turnOff() {
        dev.disable();
    }
}

class Test1 {
    public static void main(String[] args) {
        Device dev = new TV();
        Remote rem = new RemoteTV(dev);
        rem.turnOn();
        rem.turnOff();
    }
}
