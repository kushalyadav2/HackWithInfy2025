/*
1353. Maximum Number of Events That Can Be Attended

You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

Return the maximum number of events you can attend.

 

Example 1:


Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
Example 2:

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
 

Constraints:

1 <= events.length <= 105
events[i].length == 2
1 <= startDayi <= endDayi <= 105
*/

class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b) -> a[0]-b[0]);

        int startDay = events[0][0];
        int Day = 0, i=0;
        int cnt = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(!pq.isEmpty() || i<n){
            while(i<n && events[i][0] == Day){
                pq.add(events[i][1]);
                i++;
            }

            if(!pq.isEmpty()){
                pq.remove();
                cnt++;
            }

            Day++;

            while(!pq.isEmpty() && pq.peek() < Day){
                pq.remove();
            }

        }

        return cnt;
        
    }

    public int solve(int idx, int start, int end, int[][] events){
        if(idx == events.length) return 0;

        int take = 0;
        if(end <= events[idx][0])
        take = 1+solve(idx+1, events[idx][0], events[idx][1], events);
        int nontake = solve(idx+1, events[idx][0], events[idx][1], events);

        return Math.max(take, nontake);
    }
}