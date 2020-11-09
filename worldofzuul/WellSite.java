package worldofzuul;

enum Lining {wood, stone, concrete, brick, noLining}
enum Pump {mechanicPump, handPump, noPump}
enum Engine {electrical, diesel, noEngine}

class WinCondition {
    boolean isThereAHole;
    Lining ligningType;
    boolean isThereABucket;
    Pump pumpType;
    Engine engineType;

    //lining Type
    float noLiningValue = 0.2f;
    float woodLiningValue = 1f;
    float stoneLiningValue = 1.5f;
    float brickLiningValue = 1.7f;

    float handPumpValue = 1f;
    float bucketValue = 0.2f;
    float electricalValue = 2.5f;
    float dieselValue = 2f;

    float uponWellValue = 0.1f;

    public float scoreMultiplier = 1f;


    WinCondition(){
        this.ligningType = Lining.noLining;
        this.pumpType = Pump.noPump;
        this.engineType = Engine.noEngine;
    }
}

public class WellSite extends Room {
    WinCondition winCondition = new WinCondition();
    public WellSite(String description){
        super(description);
    }

    //byte: 0 if you want to update the hole. 1 if you want to update the bucket
    public void updateWell(boolean condition, byte updateType){
        if (updateType == (byte)0){
            winCondition.isThereAHole = condition;
        }
        else if (updateType == (byte)1){
            winCondition.isThereABucket = condition;
        }
    }

    public void updateWell(Engine engine){
        winCondition.engineType = engine;
    }

    public void updateWell(Lining lining){
        winCondition.ligningType = lining;
    }

    public void updateWell(Pump pump){
        winCondition.pumpType = pump;
    }

    //run through the win conditions and return the total value of the score
    public float finishGame(){

        //check all of the liningstypes
        if (winCondition.ligningType == Lining.noLining){
            winCondition.scoreMultiplier *= winCondition.noLiningValue;
        }
        else if (winCondition.ligningType == Lining.wood){
            winCondition.scoreMultiplier *= winCondition.woodLiningValue;
        }
        else if (winCondition.ligningType == Lining.stone){
            winCondition.scoreMultiplier *= winCondition.stoneLiningValue;
        }
        else if (winCondition.ligningType == Lining.brick){
            winCondition.scoreMultiplier *= winCondition.brickLiningValue;
        }
        else {
            System.out.println("Unable to come decide liningType in WellSite.java");
        }

        //check how the player take the water up from the well
        if (winCondition.pumpType != Pump.noPump){
            if (winCondition.pumpType == Pump.handPump){
                winCondition.scoreMultiplier *= winCondition.handPumpValue;
            }
            else if (winCondition.pumpType == Pump.mechanicPump && winCondition.engineType != Engine.noEngine){
                if (winCondition.engineType == Engine.electrical){
                    winCondition.scoreMultiplier *= winCondition.electricalValue;
                }
                else if (winCondition.engineType == Engine.diesel){
                    winCondition.scoreMultiplier *= winCondition.dieselValue;
                }
                else {
                    System.out.println("Unable to decide on the Enginetype in WellSite.java");
                }
            }
            else {
                System.out.println("Du har brug for en motor til at kunne kører en mekanisk pumpe");
            }
        }
        else if (winCondition.isThereABucket && winCondition.isThereAHole){
            winCondition.scoreMultiplier *= winCondition.bucketValue;
        }

        if (winCondition.isThereAHole){
            winCondition.scoreMultiplier *= winCondition.uponWellValue;
        }

        return 100.0f * winCondition.scoreMultiplier;
    }
}
