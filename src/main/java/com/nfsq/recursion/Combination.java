package com.nfsq.recursion;

/**
 * 　　③、组合：选择一支队伍
 * 　　在数学中，组合是对事物的一种选择，而不考虑他们的顺序。
 * <p>
 * 　　比如有5个登山队员，名称为 A,B,C,D和E。想要从这五个队员中选择三个队员去登峰，这时候如何列出所有的队员组合。（不考虑顺序）
 * <p>
 * 　　还是以递归的思想来解决：首先这五个人的组合选择三个人分成两个部分，第一部分包含A队员，第二部分不包含A队员。假设把从 5 个人中选出 3 个人的组合简写为（5,3），规定 n 是这群人的大小，并且 k 是组队的大小。那么根据法则可以有：
 * <p>
 * 　　(n,k) = (n-1,k-1) + (n-1,k)
 * <p>
 * 　　对于从 5 个人中选择 3 个人，有：
 * <p>
 * 　　(5,3) = (4,2)+(4,3)
 * <p>
 * 　　(4,2)表示已经有A队员了，然后从剩下的4个队员中选择2个队员，(4,3)表示从5个人中剔除A队员，从剩下的4个队员中选择3个队员，这两种情况相加就是从5个队员中选择3个队员。
 * <p>
 * 　　现在已经把一个大问题转换为两个小问题了。从4个人的人群中做两次选择（一次选择2个，一次选择3个），而不是从5个人的人群中选择3个。
 * <p>
 * 　　从4个人的人群中选择2个人，又可以表示为：(4,2) = (3,1) + (3,2)，以此类推，很容易想到递归的思想。
 */
public class Combination {
    /**
     *  组中所有可供选择的人员
     */
    private char[] persons;
    /**
     * 组中所有可供选择的人员
     */
    private boolean[] selects;


    private Combination(char[] persons) {
        this.persons = persons;
        selects = new boolean[persons.length];
    }

    public void showTeams(int teamNumber) {
        combination(teamNumber, 0);
    }

    public void combination(int teamNumber, int index) {
        if (teamNumber == 0) {
            for (int i = 0; i < selects.length; i++) {
                if (selects[i] == true) {
                    System.out.println(persons[i]);
                }
            }
            System.out.println();
            return;
        }

        if (index >= persons.length) {
            return;
        }
        selects[index] = true;
        combination(teamNumber - 1, index + 1);
        selects[index] = false;
        combination(teamNumber, index + 1);
    }

    public static void main(String[] args) {
        char[] persons = {'A', 'B', 'C', 'D', 'E'};
        Combination cb = new Combination(persons);
        cb.showTeams(3);
    }
}
