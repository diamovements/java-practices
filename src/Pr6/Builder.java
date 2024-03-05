package Pr6;

class Order {
    private String burger;
    private String cola;
    private String fries;

    public void setBurger(String burger) {
        this.burger = burger;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }

    public void setFries(String fries) {
        this.fries = fries;
    }
    public void show() {
        System.out.println("Burger: " + burger);
        System.out.println("Fries: " + fries);
        System.out.println("Cola: " + cola);
    }
}

class BuildOrder {
    private Order order = new Order();
    public void addBurger(String b) {
        order.setBurger(b);
    }
    public void addCola(String c) {
        order.setCola(c);
    }
    public void addFries(String f) {
        order.setFries(f);
    }
    public Order build() {
        return order;
    }
}

class Test3 {
    public static void main(String[] args) {
        BuildOrder order = new BuildOrder();
        order.addBurger("Cheeseburger");
        order.addCola("Cola zero");
        order.addFries("French fries with cheesy sauce");
        Order or = order.build();
        or.show();
    }
}
