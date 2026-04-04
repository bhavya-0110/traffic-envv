package traffic;

public class TrafficEnv {

	    int laneA;
	    int laneB;

	 
	    void reset() {
	        laneA = 20;
	        laneB = 15;
	    }

	 
	    void state() {
	        System.out.println("Lane A: " + laneA);
	        System.out.println("Lane B: " + laneB);
	    }

	    
	    void step(String action) {
	        if(action.equals("A")) {
	            laneA = laneA - 10;
	        } else {
	            laneB = laneB - 8;
	        }
	    }

	  
	    int reward() {
	        return (laneA + laneB);
	    }

	  
	    String agent() {
	        if(laneA > laneB) {
	            return "A";
	        } else {
	            return "B";
	        }
	    }

	   
	    double grader() {
	        int total = laneA + laneB;

	        double score;
	        String level;

	        if (total == 0) {
	            score = 1.0;
	            level = "easy";
	        } else if (total <= 5) {
	            score = 0.7;
	            level = "Medium";
	        } else {
	            score = 0.3;
	            level = "hard";
	        }

	        System.out.println("Total work: " + total);
	        System.out.println("Performance score: " + score);
	        System.out.println("Task level: " + level);

	        return score;
	    }
    public static void main(String[] args) {

        TrafficEnv t = new TrafficEnv();

        t.reset();

        for(int i = 0; i < 5; i++) {

            t.state();

            String action = t.agent();  

            System.out.println("Action: " + action);

            t.step(action);

            System.out.println("Reward: " + t.reward());
            


        }

        System.out.println("Final Score: " + t.grader());
    }
}
