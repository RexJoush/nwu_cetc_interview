package question02;

import java.util.*;

/**
 * @author Rex Joush
 * @time 2022.07.22
 */

public class Solution01 {
    /*
        拓扑排序，广度优先搜索
            参考课程表 1 的拓扑排序，记录过程即可
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 记录入度
        int[] in = new int[numCourses];

        // 记录当前节点指向的相关节点
        Map<Integer, List<Integer>> map = new HashMap<>();

        // 统计入度即相关节点
        for (int[] prerequisite : prerequisites) {
            in[prerequisite[0]]++;
            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
        }
        // 记录学习课程的过程
        Queue<Integer> queue = new LinkedList<>();
        // 将入度为 0 的课程加入队列
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        // 结果数组
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 取出一门课，表示学习了
            Integer poll = queue.poll();
            // 加入结果即可
            result.add(poll);
            // 获取指向的课程的即可
            List<Integer> list = map.get(poll);
            if (list == null) {
                continue;
            }
            // 将这些节点的入度-1，如果入度为 0，那就加入待学习集合
            for (Integer integer : list) {
                in[integer]--;
                if (in[integer] == 0) {
                    queue.add(integer);
                }
            }
        }
        // 不满足返回空数组
        if (result.size() < numCourses) {
            return new int[]{};
        }
        // 满足返回结果
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}