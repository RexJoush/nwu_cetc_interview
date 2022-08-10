
import java.util.*;

/**
 * @author Rex Joush
 * @time 2022.08.10
 */
public class Question1 {
    /*
        未转换完成，暂不知通过多少
     */
    public static void main(String[] args) {
        edge = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        color = sc.nextLine().toCharArray();
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            listA.add(b);
            listB.add(a);
            edge.put(a, listA);
            edge.put(b, listB);
        }
        if (color[1] == 'R') {
            dfs(1, -1, 1, 0);
        } else {
            dfs(1, -1, 0, 1);
        }
        System.out.println(res);
    }

    public static Map<Integer, List<Integer>> edge;
    public static char[] color;
    public static int res = 0;

    public static void dfs(int root, int father, int red, int blue) {
        res += Math.abs(red - blue);
        for (int i = 0; i < edge.get(root).size(); ++i) {
            int son = edge.get(root).get(i);
            if (son == father) {
                continue;
            }
            if (color[son - 1] == 'R') {
                dfs(son, root, red + 1, blue);
            } else {
                dfs(son, root, red, blue + 1);
            }
        }
    }
}
