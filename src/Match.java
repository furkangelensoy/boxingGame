public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    void run() {
        boolean f1Starts = true;
        if (whoStarts()) {
            f1Starts = true;
            System.out.println("İlk vuruşu " + this.f1.name + " yapıyor.");
            System.out.println("-------------");
        } else {
            f1Starts = false;
            System.out.println("İlk vuruşu " + this.f2.name + " yapıyor.");
            System.out.println("-------------");
        }
        if (isWeightAvailable()) {
            int i = 0;
            while (this.f1.health > 0 && this.f2.health > 0) {
                i++;
                System.out.println("==== " + "Round: " + i + " ===");
                if (f1Starts) {
                    this.f2.health = this.f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    this.f1.health = this.f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                } else {
                    this.f1.health = this.f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    this.f2.health = this.f1.hit(f2);
                    if (isWin()) {
                        break;
                    }

                }
                System.out.println("----------------------");
                System.out.println(this.f1.name + " Sağlık: " + this.f1.health);
                System.out.println(this.f2.name + " Sağlık: " + this.f2.health);
            }


        } else {
            System.out.println("Sporcuların sikletleri uygun değil.");
        }

    }

    boolean isWeightAvailable() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) &&
                (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " kazandı.");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " kazandı.");
            return true;
        }
        return false;
    }

    boolean whoStarts() {
        double randomNumber = Math.random() * 100;
        if (randomNumber <= 50) {
            System.out.println(randomNumber);
            return true;
        } else {
            System.out.println(randomNumber);
            return false;
        }
    }

}
