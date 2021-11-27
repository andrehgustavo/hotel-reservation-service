package br.com.projects.hotelreservationservice.entity;

/**
 * Enumerates customer kind.
 * @author André
 */
public enum LoyaltyProgram {
    /** Regular Customer */
    REGULAR("Regular"),
    /** Reward Customer */ 
    REWARD("Reward");

    private String loyatyProgram;

    private LoyaltyProgram(String type){
        this.loyatyProgram = type;
    }

    @Override
    public String toString(){
        return loyatyProgram;
    }

    public boolean isRegular(){
        return this == REGULAR;
    }
    public boolean isReward(){
        return this == REWARD;
    }
}
