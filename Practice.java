public class Practice {
    int i = 5;

    public void newM() {
        int i = 6;
    }

    public static void main(String[] args) {
        // Create an instance of Practice class
        Practice practice = new Practice();

        // Call the newM method
        practice.newM();

        // Access the instance variable i
        System.out.println(practice.i);
    }
}
