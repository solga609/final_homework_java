// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 import java.lang.System.Logger;
 import java.util.*;
 


public class final_lesson1 {

    public class LaptopModels {
        private int price;
        private int ram;
        private int hardDrive;
        private int screenDiagonal;
    
        private static TreeSet<LaptopModels> modelsSet=new TreeSet<>(new Comparator<LaptopModels>(){
        
        @Override public int compare(LaptopModels o1,LaptopModels o2){return(o1.ram-o2.ram)-(o1.price-o2.price)-(o1.hardDrive-o2.hardDrive)-(o1.screenDiagonal-o2.screenDiagonal);}});
    
        private LaptopModels(int price, int ram, int hardDrive, int screenDiagonal) {
            this.price = price;
            this.ram = ram;
            this.hardDrive = hardDrive;
            this.screenDiagonal = screenDiagonal;
        }
    
        public LaptopModels() {
        }
    
        public void addLaptop(int price, int ram, int hardDrive, int diagonalScreen) {
            LaptopModels newModel = new LaptopModels(price, ram, hardDrive, diagonalScreen);
            modelsSet.add(newModel);
        }
    
        @Override
        public String toString() {
            return "\nPrice=" + price +
                    ", Ram=" + ram +
                    ", HardDrive=" + hardDrive +
                    ", ScreenDiagonal=" + screenDiagonal;
        }
    
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            LaptopModels that = (LaptopModels) o;
            return price == that.price &&
                    ram == that.ram &&
                    hardDrive == that.hardDrive &&
                    screenDiagonal == that.screenDiagonal;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(price, ram, hardDrive, screenDiagonal);
        }
    
        public String searchModels() {
            System.out.println("The minimal characteristics are:");
            HashMap<Integer, Integer> minMod = getSpecifications();
            System.out.println("The maximal characteristics are:");
            HashMap<Integer, Integer> maxMod = getSpecifications();
    
            List<LaptopModels> resultList = new ArrayList<>();
            for (var model : modelsSet) {
                if ((model.price >= minMod.get(1) && model.price <= maxMod.get(1)) &&
                        (model.ram >= minMod.get(2) && model.ram <= maxMod.get(2)) &&
                        (model.hardDrive >= minMod.get(3) && model.hardDrive <= maxMod.get(3)) &&
                        (model.screenDiagonal >= minMod.get(4) && model.screenDiagonal <= maxMod.get(4))) {
                    resultList.add(model);
                }
            }
            if (resultList.size() > 0)
                return resultList.toString();
            else
                return "Nothing was found on your request.";
        }
    
        /**
         * @return
         */
        private static HashMap<Integer, Integer> getSpecifications() {
            HashMap<Integer, Integer> resultMap = new HashMap<>();
            Scanner scanner = new Scanner(System.in);
            int i = 1;
            System.out.println("Price ($): ");
            resultMap.put(i++, scanner.nextInt());
            System.out.println("RAM (GB): ");
            resultMap.put(i++, scanner.nextInt());
            System.out.println("Hard-Driver (GB): ");
            resultMap.put(i++, scanner.nextInt());
            System.out.println("Diagonal (Inch): ");
            resultMap.put(i, scanner.nextInt());
            return resultMap;
        }
    
    }

    

public class main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Object get;
        final Logger logger = Logger.getAnonymousLogger();
        LaptopModels modelsLine = new LaptopModels();
        modelsLine.addLaptop(600, 4, 256, 12);
        modelsLine.addLaptop(500, 4, 400, 13);
        modelsLine.addLaptop(1600, 32, 500, 15);
        modelsLine.addLaptop(1300, 8, 256, 14);
        modelsLine.addLaptop(1300, 16, 500, 16);
        modelsLine.addLaptop(1000, 8, 256, 12);
        modelsLine.addLaptop(1200, 16, 400, 12);
        modelsLine.addLaptop(1450, 16, 500, 14);
        modelsLine.addLaptop(1100, 8, 256, 15);
        logger.info(modelsLine.searchModels());
    }
}

}
    

