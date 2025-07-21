import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> inputInfo = new ArrayList<>(); // 解析后的输入将会存进该容器中, 类似于c语言的二维数组
        ArrayList<Adventurer> adventurers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim()); // 读取行数
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine(); // 读取本行指令
            String[] strings = nextLine.trim().split(" +"); // 按空格对行进行分割
            inputInfo.add(new ArrayList<>(Arrays.asList(strings))); // 将指令分割后的各个部分存进容器中
        }
        Mysterious mysterious = new Mysterious();
        MainClass.solve(inputInfo, adventurers,mysterious);
    }

    public static Adventurer findAdventurer(ArrayList<Adventurer> adventurers, int id) {
        for (Adventurer adventurer : adventurers) {
            if (adventurer.getId() == id) {
                return adventurer;
            }
        }
        return null;
    }

    public static void solve(
            ArrayList<ArrayList<String>> inputInfo,ArrayList<Adventurer> adventurers,Mysterious m
    ) {
        for (ArrayList<String> info : inputInfo) {
            int adventurerId = Integer.parseInt(info.get(1));
            Adventurer adventurer = findAdventurer(adventurers, adventurerId);
            switch (Integer.parseInt(info.get(0))) {
                case 1:
                    adventurers.add(new Adventurer(Integer.parseInt(info.get(1)), info.get(2)));
                    break;
                case 2:
                    int boId = Integer.parseInt(info.get(2));
                    int bce = Integer.parseInt(info.get(6));
                    adventurer.addBottle(
                            boId, info.get(3),Integer.parseInt(info.get(4)),info.get(5),bce
                    );
                    break;
                case 3:
                    int eqId = Integer.parseInt(info.get(2));
                    int eqCE = Integer.parseInt(info.get(6));
                    adventurer.addEquipment(
                            eqId,info.get(3),Integer.parseInt(info.get(4)),info.get(5),eqCE
                    );
                    break;
                case 4:
                    adventurer.fix(Integer.parseInt(info.get(2)));
                    break;
                case 5:
                    adventurer.removeBottle(Integer.parseInt(info.get(2)));
                    adventurer.removeEquipment(Integer.parseInt(info.get(2)));
                    break;
                case 6:
                    adventurer.join(Integer.parseInt(info.get(2)));
                    break;
                case 7:
                    adventurer.drink(Integer.parseInt(info.get(2)));
                    break;
                case 8:
                    adventurer.addFramgment(Integer.parseInt(info.get(2)),info.get(3));
                    break;
                case 9:
                    adventurer.redeem(info.get(2),Integer.parseInt(info.get(3)));
                    break;
                case 10:
                    int k = Integer.parseInt(info.get(4));
                    ArrayList<Adventurer> tempA = new ArrayList<>();
                    for (int i = 0;i < k;i++) {
                        tempA.add(findAdventurer(adventurers,Integer.parseInt(info.get(i + 5))));
                    }
                    adventurer.attack(info.get(2),tempA,info.get(3));
                    break;
                case 11:
                    Adventurer employee = findAdventurer(adventurers,Integer.parseInt(info.get(2)));
                    adventurer.employ(employee);
                    break;
                case 12:
                    m.game(adventurer);
                    break;
                default:
            }
        }
    }
}