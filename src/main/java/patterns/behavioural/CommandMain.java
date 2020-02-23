package patterns.behavioural;

import java.util.ArrayList;
import java.util.List;

public class CommandMain {

    public static void main(String[] args) {
        Resiver resiver = new Resiver();
        resiver.addComands(new MauseClick());
        resiver.addComands(new MausePress());
        resiver.runCommands();
    }
}

interface Command{
    void execute();
}

class MausePress implements Command{

    @Override
    public void execute() {
        System.out.println("Click mouse pressend");
    }
}

class MauseClick implements Command{

    @Override
    public void execute() {
        System.out.println("Click mouse");
    }
}
class Resiver {
    List<Command> commandList = new ArrayList<>();
    void addComands(Command command){
        commandList.add(command);
    }

    void runCommands(){
        for(Command c: commandList){
            c.execute();
        }
    }
}
