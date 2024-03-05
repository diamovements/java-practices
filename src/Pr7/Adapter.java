package Pr7;

interface OldRemote {
    void turnOn();
    void turnOff();
}
class NewTV {
    void powerOn() {
        System.out.println("TV is turned on");
    }
    void powerOff() {
        System.out.println("TV is turned off");
    }
}

class OldRemoteAdapter implements OldRemote {
    private NewTV newTV;

    public OldRemoteAdapter(NewTV newTV) {
        this.newTV = newTV;
    }

    @Override
    public void turnOn() {
        newTV.powerOn();
    }

    @Override
    public void turnOff() {
        newTV.powerOff();
    }
}

class Test2 {
    public static void main(String[] args) {
        NewTV newTV = new NewTV();
        OldRemote adapter = new OldRemoteAdapter(newTV);
        adapter.turnOn();
        adapter.turnOff();
    }
}