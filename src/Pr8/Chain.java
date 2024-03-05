package Pr8;

interface ReturnHandler {
    void handleReturn(ReturnRequest request);
}

class ReturnRequest {
    private boolean isAuthorized;

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }
}

class AuthorizedReturnHandler implements ReturnHandler {
    private ReturnHandler nextHandler;

    public void setNextHandler(ReturnHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleReturn(ReturnRequest request) {
        if (request.isAuthorized()) {
            System.out.println("Return has been successfully authorized");
        }
        else if (nextHandler != null) {
            nextHandler.handleReturn(request);
        }
        else {
            System.out.println("Return has not been authorized");
        }
    }
}


class Test1 {
    public static void main(String[] args) {
        ReturnHandler first = new AuthorizedReturnHandler();
        ReturnHandler second = new AuthorizedReturnHandler();
        ReturnHandler third = new AuthorizedReturnHandler();

        ((AuthorizedReturnHandler) first).setNextHandler(second);
        ((AuthorizedReturnHandler) second).setNextHandler(third);

        ReturnRequest request = new ReturnRequest();
        request.setAuthorized(true);
        first.handleReturn(request);
    }
}