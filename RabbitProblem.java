public class RabbitProblem {

    public static int rabbits(int month) {

        if (month == 1 || month == 2)
            return 1;

        return rabbits(month - 1) + rabbits(month - 2);
    }

    public static void main(String[] args) {

        int months = 10;

        System.out.println("Rabbit pairs after " + months + " months: " + rabbits(months));
    }
}