
import java.util.*;

/**
 * @author Rex Joush
 * @time 2022.08.10
 */
public class Question2 {

    /*
        未考虑传递的情况，过了 10%
     */
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Map<String, Set<String>> map = new HashMap<>();
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                String[] strings = sc.nextLine().split(" ");
                if ("1".equals(strings[0])) {
                    // 遇到 1 就将当前的人和持有的股票存储，name -> [股票列表]
                    String[] stores = sc.nextLine().split(" ");
                    Set<String> set = new HashSet<>(Arrays.asList(stores));
                    map.put(strings[1], set);
                } else {
                    // 根据 map 查询
                    System.out.println(getResult(map, strings[1]));
                }
            }
    }

    private static String getResult(Map<String, Set<String>> map, String name) {
        // 不存在
        if (!map.containsKey(name)) {
            return "error";
        }
        // 当前用户持有的股票列表
        Set<String> strings = map.get(name);
        // 将要持有的列表
        Set<String> containsAll = new HashSet<>();

        // 遍历当前用户持有的股票
        for (String string : strings) {
            // 只要某个用户持有的股票与当前用户有交叉，就将该用户的所有股票加入集合
            for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                if (entry.getValue().contains(string)){
                    containsAll.addAll(entry.getValue());
                }
            }
        }
        return String.valueOf(containsAll.size() - strings.size());
    }

}
