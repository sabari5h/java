import java.util.Random;

class NumOperation implements Runnable {
    private Random random = new Random();
    private SharedData sharedData;

    public NumOperation(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        int number = random.nextInt(100);
        sharedData.setNumber(number);

        System.out.println("Generated number: " + number);

        if (number % 2 == 0) {
            sharedData.setOperation(Operation.SQUARE);
        } else {
            sharedData.setOperation(Operation.CUBE);
        }
    }
}

class OperationExecutor implements Runnable {
    private SharedData sharedData;

    public OperationExecutor(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            int number = sharedData.getNumber();
            Operation operation = sharedData.getOperation();

            if (operation == Operation.SQUARE) {
                int square = number * number;
                System.out.println("Square of " + number + ": " + square);
                break;
            } else if (operation == Operation.CUBE) {
                int cube = number * number * number;
                System.out.println("Cube of " + number + ": " + cube);
                break;
            }
        }
    }
}

enum Operation {
    SQUARE, CUBE
}

class SharedData {
    private int number;
    private Operation operation;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}

public class MultiThread{
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread t1 = new Thread(new NumOperation(sharedData));
        Thread t2 = new Thread(new OperationExecutor(sharedData));

        t1.start();
        t2.start();
    }
}