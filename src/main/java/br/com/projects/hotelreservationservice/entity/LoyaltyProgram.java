package br.com.projects.hotelreservationservice.entity;

/**
 * Enumerates customer kind.
 * @author André
 */
public enum LoyaltyProgram {
    /** Regular Customer */
    REGULAR,
    /** Reward Customer */ 
    REWARD;

    public String toString(){
        switch (this){
            case REGULAR: return "Cliente comum";
            case REWARD: return "Cliente com cartão fidelidade";
            default:
                return null;
        }
    }

    public boolean isRegular(){
        return this == REGULAR;
    }
    public boolean isReward(){
        return this == REWARD;
    }
}
