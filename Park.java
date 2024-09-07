public class Park {
    public static class Attraction {
        private String name;
        private String workingHours;
        private int price;

        public Attraction(String name, String workingHours, int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Attraction attraction1 = new Attraction("Карусель", "10:00 - 20:00", 150);
        Attraction attraction2 = new Attraction("Американские горки", "11:00 - 20:00", 200);
        Attraction attraction3 = new Attraction("Колесо обозрения", "10:00 - 22:00", 300);

        attraction1.printInfo();
        attraction2.printInfo();
        attraction3.printInfo();
    }
}

