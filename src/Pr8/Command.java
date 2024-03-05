package Pr8;

interface Command {
    void execute();
}
class Order {
    public void create() {
        System.out.println("Order is created");
    }
    public void updateStatus(String status) {
        System.out.println("Status of the order is updated: " + status);
    }
}
class CreateOrderCommand implements Command {
    private Order order;

    public CreateOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.create();
    }
}

class UpdateStatus implements Command {
    private Order order;
    private String status;

    public UpdateStatus(Order order, String status) {
        this.order = order;
        this.status = status;
    }

    @Override
    public void execute() {
        order.updateStatus(status);
    }
}

class Test2 {
    public static void main(String[] args) {
        Order order = new Order();
        Command create = new CreateOrderCommand(order);
        Command update = new UpdateStatus(order, "Shipping");
        create.execute();
        update.execute();
        update = new UpdateStatus(order, "delivered");
        update.execute();
    }
}