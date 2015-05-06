package com.gimbal.android.sample;

public class Score {
	
	private static Score instance;
	private  String name ;
	private  int score = 0;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	public static final Score getInstance() {
        if (instance == null) {
            instance = new Score();
        }
        return instance;
    }

 

    public int update() {
        return score = score + 1;
        
		
    }

}
