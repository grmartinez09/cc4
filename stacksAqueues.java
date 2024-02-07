 //Stacks and Queues

    import java.util.*;
    
    public class stacksAqueues {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the Stack and Queue Program!");
            System.out.println("What would you like to do?");

            System.out.print("1. Stack\n2. Queue\nEnter your choice: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("What is the upper bound: ");
                int upperBound_S = scanner.nextInt();
                stack_prog(upperBound_S, scanner);
            } else if (choice == 2) {
                System.out.print("What is the upper bound: ");
                int upperBound_Q = scanner.nextInt();
                queue_prog(upperBound_Q, scanner);
            } else {
                System.out.println("Invalid choice. Please choose either '1' or '2'.");
            }
        }

        public static void stack_prog(int upperBound_S, Scanner scanner) {
            Stack<String> stack = new Stack<>();
            int actionChoice_S = 0;
            while (actionChoice_S != 3) {
                System.out.println("1. Push\n2. Pop\n3. Quit");
                System.out.print("Enter your choice: ");
                actionChoice_S = scanner.nextInt();
                if (actionChoice_S == 1) {
                    if (stack.size() < upperBound_S) {
                        System.out.println("Enter the value to push into the stack: ");
                        String item = scanner.nextLine();
                        stack.push(item);
                        System.out.println(stack);
                    } else {
                        System.out.println("Stack is full");
                    }
                }    else if (actionChoice_S == 2) {
                    if (!stack.isEmpty()) {
                        System.out.println("Popped " + stack.pop() + " from the stack");
                        System.out.println(stack);
                    } else {
                        System.out.println("Stack is empty");
                    }
                }
            }
        }

        public static void queue_prog(int upperBound_Q, Scanner scanner) {
            Queue<String> queue = new LinkedList<>();
            int actionChoice_Q = 0;
            while (actionChoice_Q != 3) {
                System.out.println("1. Enqueue\n2. Dequeue\n3. Quit");
                System.out.println("Enter your choice: ");
                actionChoice_Q = scanner.nextInt();
                if (actionChoice_Q == 1) {
                    if (queue.size() < upperBound_Q) {
                        System.out.println("Enter the value to enqueue in the queue: ");
                        String item = scanner.nextLine();
                        queue.add(item);
                        System.out.println(queue);
                    } else {
                        System.out.println("Queue is full");
                    }
                    } else if (actionChoice_Q == 2){
                        if (!queue.isEmpty()) {
                            System.out.println("Dequeued " + queue.remove() + " from the queue");
                            System.out.println(queue);
                        } else {
                            System.out.println("Queue is empty");
                        }
                        }
                    }
                }
            }