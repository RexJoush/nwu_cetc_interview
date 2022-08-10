## 题目：股票推荐

## 题目描述
```text
请你完成设计一个股票推荐系统，该系统会自动根据注册用户的关注情况进行推荐。
例如，对于一个同时关注了 Zoom 和 Warmart 的人而言，推荐算法会根据它的信息认为，
关注了 Zoom 的人，可能对 Warmart 也感兴趣，反之亦然，关注了 Warmart 的人，可能对 Zoom 也感兴趣
因此，对于另一个关注了 Warmart、没关注 Zoom 的人来说，该系统就会推荐他关注 Zoom
请注意，该系统会计算连锁信息，例如假设在刚刚的前提（同时存在关注 Warmart 和 Zoom）下，存在一个
同时关注 Zoom 和 Apple 的人，那么斗鱼另一个只关注了 Warmart 的人，该系统会同时推荐他 Zoom 和 Apple。
现在给出一些人的注册信息和一些询问，你需要回答每次询问时，推荐系统会推荐给那个人多少只他还没关注的股票
```

#### 输入描述
```text
第一行输入一个正整数 q，代表操作次数
接下来输入一次操作。
共有两种操作：
1. 注册。格式为：
第一行输入 1 name n，代表有一个名字为 name 的人注册了该系统，他关注了 n 只股票。
第二行输入 n 个仅包含英文字母的字符串 str，代表这个人关注股票的名字
保证不会重复注册，这 n 个字符串互不相同
2. 查询。格式为：
仅有一行，输入 2 name，代表询问该推荐系统会给这个人推荐多少只股票。
1 <= q <= 10000
1 <= n <= 5
所有字符串均只包含英文字母，且长度不超过 10.
保证至少有 1 次询问
```

#### 输出描述
```text
对于每次询问：
若查询的人不存在，则输出"error"
否则输出一个整数，代表该系统查询推荐的数量。
```

#### 示例 1
* 输入
```text
5
1 Alice 2
Zoom Apple
2 Bob
2 Alice
1 Bob 2
Apple Microsoft
2 Bob
```
* 输出
```text
error
0
1
```
* 说明
```text
第一次询问时，系统内还没有名字为 Bob 的用户，输出 error
第二次询问时，系统不会给 Alice 推荐任何股票，输出 0
第三次询问时，由于 Alice 和 Bob 都关注了 Apple，所以系统会给 Bob 推荐他还没关注的 Zoom
```