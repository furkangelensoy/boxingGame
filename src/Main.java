public class Main {
    public static void main(String[] args) {

        Fighter f1 = new Fighter("Tyson",10,120,100,40);
        Fighter f2 = new Fighter("Joshua",20,60,85,50);

        Match match = new Match(f1,f2,85,100);
        match.run();
    }
}