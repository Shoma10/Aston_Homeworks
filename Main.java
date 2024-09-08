public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Плюха");
        Dog dog2 = new Dog("Шегги");

        Cat cat1 = new Cat("Кеша");
        Cat cat2 = new Cat("Маруся");
        Cat cat3 = new Cat("Барсик");

        dog1.run(500);
        dog1.swim(10);

        cat1.run(200);
        cat1.swim(5);

        Bowl bowl = new Bowl(25);
        Cat[] cats = {cat1, cat2, cat3};

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        System.out.println("Сытость котов:");
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isFed());
        }

        System.out.println("Количество животных: " + Animal.getAnimalCount());
        System.out.println("Количество собак: " + Dog.getDogCount());
        System.out.println("Количество котов: " + Cat.getCatCount());
    }
}

class Animal {
    protected String name;
    protected static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFed = false;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() >= 10) {
            bowl.decreaseFood(10);
            isFed = true;
            System.out.println(name + " поел.");
        } else {
            System.out.println(name + " не может поесть, так как в миске недостаточно еды.");
        }
    }

    public boolean isFed() {
        return isFed;
    }

    public static int getCatCount() {
        return catCount;
    }
}

class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void addFood(int amount) {
        foodAmount += amount;
    }

    public void decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
