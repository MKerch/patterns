package patterns.behavioural.mediatror;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        mediator.add(new ConcreteCollegue(mediator, "one"));
        mediator.add(new ConcreteCollegue(mediator, "two"));
        ConcreteCollegue concreteCollegue = new ConcreteCollegue(mediator, "tree");
        mediator.add(concreteCollegue);
        concreteCollegue.changeStatus();
    }
}

interface Mediator {
    void requestAll(Collegue collegue);
}

class ConcreteMediator implements Mediator {
    List<Collegue> collegues = new ArrayList<>();

    void add(Collegue collegue) {
        collegues.add(collegue);
    }

    @Override
    public void requestAll(Collegue trueCollegue) {
        trueCollegue.setTrue();
        for (Collegue c : collegues) {
            if (c != trueCollegue) {
                c.setFalse();
            }
        }
    }
}

interface Collegue {

    void setTrue();

    void setFalse();

    void changeStatus();
}

class ConcreteCollegue implements Collegue {

    boolean status;
    Mediator mediator;
    String name;

    public ConcreteCollegue(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void setTrue() {
        status = true;
        System.out.println(name + " status is true");
    }

    @Override
    public void setFalse() {
        status = false;
        System.out.println(name + " status is false");

    }

    @Override
    public void changeStatus() {
        mediator.requestAll(this);
    }
}
