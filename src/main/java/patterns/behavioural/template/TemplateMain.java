package patterns.behavioural.template;


public class TemplateMain {
    public static void main(String[] args) {
        Tamplate jub = new Jub();
        jub.run();
    }
}

abstract class Tamplate {
    abstract void stepOne();

    abstract void stepTwo();

    abstract void stepTree();

    void run() {
        stepOne();
        stepTwo();
        stepTree();
    }
}

class Jub extends Tamplate {

    @Override
    void stepOne() {
        System.out.println("first");
    }

    @Override
    void stepTwo() {
        System.out.println("second");
    }

    @Override
    void stepTree() {
        System.out.println("third");
    }
}