/*
 Runtime - Time Limit Exceeded
 72 / 82 testcases passed
*/
class Solution {

    static class Pair implements Comparator<Pair>{
        int time;
        int room;
        int task;

        Pair(){}

        Pair(int t,int r, int _tsk){
            time = t;
            room = r;
            task = _tsk;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.time - o2.time;
        }
    }

    static class mat implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0]-o2[0];
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        // sort meetings according to start time
        Arrays.sort(meetings, new mat());


        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        PriorityQueue<Pair> occupiedRooms = new PriorityQueue<>(1, new Pair());
        Set<Integer> tsks = new HashSet<>();
        int time = -1;
        int meetingCountInRooms[] = new int[n];
        
        // init meetingCountInRooms
        for(int i=0 ; i<n; i++){
            meetingCountInRooms[i] = 0;
        }
        int resultIndex = 0;
        int resultValue = 0;

        // put all rooms in availableRooms
        for(int i=0 ; i<n ; i++){
            availableRooms.add(i);
        }
        // put all tasks in tsks
        for(int i=0 ; i<meetings.length ; i++){
            tsks.add(i);
        }
        // process
        int currentMeeting = 0;
        int currentMeetingStartTime, currentMeetingEndTime;
        while( true ){
            time++;
            
            // if all tasks are processed, break
            if( tsks.isEmpty() ){
                break;
            }
            
            // free rooms from occupiedRooms
            while( !occupiedRooms.isEmpty() && occupiedRooms.peek().time == time ){
                Pair p = occupiedRooms.poll();
                // tsks is processed, so remove from tsks Set
                tsks.remove( p.task );
                // put room back in availableRooms
                availableRooms.add(p.room);
            }

            // check if any task availabe for processing and room can be assigned or not
            while( currentMeeting < meetings.length && time >= meetings[currentMeeting][0] && !availableRooms.isEmpty() ){
                currentMeetingStartTime = meetings[currentMeeting][0];
                currentMeetingEndTime = meetings[currentMeeting][1];
                Pair p = new Pair();
                p.time = time + currentMeetingEndTime - currentMeetingStartTime;
                p.room = availableRooms.peek();
                p.task = currentMeeting;

                availableRooms.poll();
                occupiedRooms.add(p);

                tsks.remove( p.task );
                currentMeeting++;

                meetingCountInRooms[p.room]++;
                if( resultValue < meetingCountInRooms[p.room] ){
                    resultValue = meetingCountInRooms[p.room];
                    resultIndex = p.room;
                }
                else if(resultValue == meetingCountInRooms[p.room] && resultIndex > p.room){
                    resultIndex = p.room;
                }
            }
        }
        return resultIndex;
    }
}
