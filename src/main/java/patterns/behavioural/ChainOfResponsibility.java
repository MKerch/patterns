package patterns.behavioural;

public class ChainOfResponsibility {

    public static void main(String[] args) {
        MessagePrinter messagePrinter = new ConsoleMessagePrinter();
        MessagePrinter fileMessagePrinter = new FileMessagePrinter();
        messagePrinter.setMessagePrinter(fileMessagePrinter);
        MessagePrinter printer = new DBMessagePrinter();
        fileMessagePrinter.setMessagePrinter(printer);
        messagePrinter.print("Max");
    }
}

abstract class MessagePrinter {

    MessagePrinter messagePrinter;

    public void setMessagePrinter(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    void print(String massage) {
        printMessage(massage);
        if (messagePrinter != null) {
            messagePrinter.print(massage);
        }
    }

    abstract void printMessage(String mess);
}

class ConsoleMessagePrinter extends MessagePrinter {

    @Override
    void printMessage(String mess) {
        System.out.println("Print to console");
    }
}

class FileMessagePrinter extends MessagePrinter {

    @Override
    void printMessage(String mess) {
        System.out.println("Print to file");
    }
}

class DBMessagePrinter extends MessagePrinter {

    @Override
    void printMessage(String mess) {
        System.out.println("Print to db");
    }
}