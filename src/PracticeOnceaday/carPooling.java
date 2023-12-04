package PracticeOnceaday;

/**
 * @author cbz
 * @version 1.0
 */
public class carPooling {

    public static void main(String[] args) {
        int[][] trips = {{3,2,7},{3,7,9},{8,3,9}};
        int capacity = 11;
        System.out.println(new carPooling().carPooling(trips,capacity));
    }

    /**
     * 1.人数不能超过空位数
     * @param trips
     * @param capacity
     * @return
     */

    public boolean carPooling(int[][] trips, int capacity) {
        int m = trips.length; //旅行次数
        int n = trips[0].length; //列数应该等于3 第一列是人数，二列开始位置，三列结束位置
        for (int i = 0; i < m; i++) {
                int people = trips[i][0]; //人数
                int start = trips[i][1]; //起始位置
                int end = trips[i][2]; //结束位置
//                System.out.println("people = " + people + "start = " + start + "end = " + end);
                if(i>0){
                    for (int j = 0; j <= i; j++) {
//                        if(start >= trips[j][2]){
//                            capacity += trips[j][0];
//                        }
//                        capacity = start >= trips[j][2] ? capacity += trips[j][0] : capacity;
//                        capacity =start >= trips[j][1] ? capacity : 0;
//                        if (start!=end) {
                            start = Math.max(trips[j][1], start);
                            end = Math.min(trips[j][2], end);
//                        }
                    }
                }
                if (people <= capacity) {
                    capacity -= people;
                }else {
                    return false;
                }
            System.out.println(start + " " + end + " " + capacity);
        }

        return true;
    }
}
