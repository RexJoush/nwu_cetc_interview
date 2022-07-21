package question01;

import java.util.*;

/**
 * @author Rex Joush
 * @time 2022.07.22
 */
public class Solution02 {

    /*
        将所有入度为 0 的节点加入 queue，同时，将此 queue 的节点进行顺序取出，将与之相关的入度均减1
        使用 list 存储与之相关的节点即可
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (prerequisites.length < 2) {
            return true;
        }
        // 邻接表,记录了所有的入度节点
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 定义学习的顺序队列
        Queue<Integer> queue = new LinkedList<>();
        // 记录所有节点的入度
        int[] in = new int[numCourses];

        // [2,3] 则，3 的入度为 0,且 3 的邻接表保存了 3->2
        for (int[] prerequisite : prerequisites) {
            in[prerequisite[0]]++;
            List<Integer> table = map.getOrDefault(prerequisite[1], new ArrayList<>());
            table.add(prerequisite[0]);
            map.put(prerequisite[1], table);
        }
        // 将入度为 0 的节点加入队列
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0; // 已经学习的课程数量
        while (!queue.isEmpty()) {
            int top = queue.poll();
            count++;
            // 获取当前节点的指向节点列表
            List<Integer> list = map.get(top);
            if (list == null) {
                continue;
            }
            // 遍历指向的节点列表
            for (Integer integer : list) {
                in[integer]--; // 出度 -1
                // 如果出度为 0 了，就加入 queue 待判断
                if (in[integer] == 0) {
                    queue.add(integer);
                }
            }
        }
        // 所学的课程和要求的是否一样
        return count == numCourses;
    }
}
