package Pr6;

interface Button {
    void render();
}
interface Checkbox {
    void render();
}

class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("Windows button created");
    }
}

class MacOSButton implements Button {

    @Override
    public void render() {
        System.out.println("MacOS button created");
    }
}

class WindowsCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Windows checkbox created");
    }
}

class MacOSCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("MacOS checkbox created");
    }
}

interface Draw {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements Draw {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSFactory implements Draw {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

class Test2 {
    public static void main(String[] args) {
        MacOSFactory mac = new MacOSFactory();
        Button bm = mac.createButton();
        Checkbox cm = mac.createCheckbox();
        bm.render();
        cm.render();
        WindowsFactory win = new WindowsFactory();
        Button bw = win.createButton();
        Checkbox cw = win.createCheckbox();
        bw.render();
        cw.render();
    }
}
