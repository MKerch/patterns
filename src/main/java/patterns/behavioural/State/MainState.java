package patterns.behavioural.State;

public class MainState {
    public static void main(String[] args) {
        Context context = new Context(new LoverCaseState(), "Max");
        context.doAction();
    }
}

interface State {
    void doAction(Context context);
}

class LoverCaseState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toLowerCase());
    }
}

class UpperCaseState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toUpperCase());
    }
}

class Context {
    State state;
    String name;

    public Context(State state, String name) {
        this.state = state;
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doAction() {
        state.doAction(this);
    }
}
