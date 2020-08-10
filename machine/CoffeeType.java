package machine;

public enum CoffeeType {
        espresso(250, 0,16,4),
        latte(350, 75, 20, 7),
        cappuccino(200, 100, 12, 6);
        int water, milk,beans,money;
        CoffeeType(int water, int milk,int beans, int money){
            this.water=water;
            this.milk=milk;
            this.beans=beans;
            this.money=money;
        }

        public int getWater() {
            return water;
        }

        public int getMilk() {
            return milk;
        }

        public int getBeans() {
            return beans;
        }

        public int getMoney() {
            return money;
        }
    }


