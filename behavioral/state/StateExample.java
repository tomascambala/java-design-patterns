package behavioral.state;

interface State {
    void doSomeAction(Context context);
}

class StartState implements State {
    public void doSomeAction(Context context) {
        System.out.println("State's started...");
        context.setState(this);
    }
}

class StopState implements State {
    public void doSomeAction(Context context) {
        System.out.println("State's stopped...");
        context.setState(this);
    }
}

class Context {
    private State state;

    public Context() {
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}

public class StateExample {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doSomeAction(context);

        StopState stopState = new StopState();
        stopState.doSomeAction(context);
    }
}
