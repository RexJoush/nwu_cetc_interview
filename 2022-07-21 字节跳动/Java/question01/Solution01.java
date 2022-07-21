package question01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Rex Joush
 * @time 2022.07.22
 */

public class Solution01 {
    /*
        关键路径，定义 map，记录所有节点的入度，找到入度为 0 的点，将此节点指向的所有点的入度减一
        当某节点的入度为 0 时，将此节点从节点 map 中移除，当节点 map 大小为 0 时，说明拓扑排序有效
        否则，当某一刻节点 map 不再减小时，说明拓扑排序无效
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        // 0 和 1 门课一定可以完成
        if (n < 2) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Map<String, Integer[]> dir = new HashMap<>();
        // 记录所有点的入度
        for (int[] prerequisite : prerequisites) {
            int value = map.getOrDefault(prerequisite[1], 0) + 1;
            // 记录所有待判断的边加入 map，"0->1" -> [0,1]
            map.put(prerequisite[1], value);
            dir.put(prerequisite[0] + "->" + prerequisite[1], new Integer[]{prerequisite[0], prerequisite[1]});
        }

        // 记录前一次 map 的大小
        int pre = map.size();
        while (map.size() != 0) {
            // 待删除的边
            List<String> rm = new LinkedList<>();
            // 遍历待判断的边
            for (Map.Entry<String, Integer[]> entry : dir.entrySet()) {
                // 如果不包含此 key，说明此节点的入度为 0，将之指向的点入度减一
                if (!map.containsKey(entry.getValue()[0])) {
                    // 获取指向的节点的 key
                    int key = entry.getValue()[1];
                    if (map.get(key) == null) {
                        continue;
                    }
                    // 获取指向节点的入度
                    int value = map.get(key);
                    // 如果为 1，将此节点移除
                    if (value == 1) {
                        map.remove(key);
                    } else {
                        // 否则将此节点的入度 -1
                        map.put(key, value - 1);
                    }
                    // 将当前使用完毕的边加入待删除的集合
                    rm.add(entry.getKey());
                }
            }
            // 将使用过的边删除
            for (String s : rm) {
                dir.remove(s);
            }
            // 如果节点个数不变，说明存在环，返回 false
            if (map.size() == pre) {
                return false;
            }
            pre = map.size();
        }
        // 所有节点均删除了，返回 true
        return true;
    }
}