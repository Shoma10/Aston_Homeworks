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
