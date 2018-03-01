public class Task2 {

    public static void main(String[] args) {

        //Integer[] input = {3, 5, 4};
        //Integer[] input = {6, 16, 7};
        //Integer[] input = {101, 317, 64};
        //Integer[] input = {571, 317, 420};
        //Integer[] input = {1699, 1409, 1334};
	Integer[] input = new Integer[3];
	input[0] = Integer.valueOf(args[0]);
	input[1] = Integer.valueOf(args[1]);
	input[2] = Integer.valueOf(args[2]);

        boolean order = input[0] < input[1];
        String solution = solve(order ? input[0] : input[1], order ? input[1] : input[0], input[2]);
        System.out.println(solution);
    }

    private static String solve(int buckle1, int buckle2, int amount) {
        String solution = "No solution";

        if(amount > buckle2 || gcd(buckle1, buckle2) != 1) {
            return solution;
        }

        if(amount == buckle1) {
            return "[0,0] ["+buckle1+",0]";
        }
        if(amount == buckle2) {
            return "[0,0] [0,"+buckle2+"]";
        }

        StringBuilder builder = fill(buckle1, buckle2, 0, 0, amount);
        return builder.toString();
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    private static StringBuilder fill(int buckle1, int buckle2, int current1, int current2, int amount) {
        StringBuilder builder = new StringBuilder();
        write(builder, current1, current2);

        // fill B
        current2 = buckle2;
        write(builder, current1, current2);
	boolean found = false;

        while(!found) {
            while (current2 > buckle1) {
                // empty into A
                current2 -= buckle1;
                current1 = buckle1;
                write(builder, current1, current2);
                if (amount == current2) {
		    found = true;
                    return builder;
                }
                // empty A
                current1 = 0;
                write(builder, current1, current2);
            } // until B less than A

            // fill A with B content
            current1 = current2;
	    current2 = 0;
            write(builder, current1, current2);
            // fill B
            current2 = buckle2;
            write(builder, current1, current2);

            // fill up A from B
            current2 -= (buckle1 - current1);
            current1 = buckle1;
            write(builder, current1, current2);
            if (amount == current2) {
		found = true;
                return builder;
            }
	    current1 = 0;
	    write(builder, current1, current2);
        } // until B less than A
        return builder;
    }

    private static void write(StringBuilder builder, int current1, int current2) {
        builder.append("[").append(current1).append(",").append(current2).append("] ");
    }
}

