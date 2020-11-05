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

    float noLiningValue = 0.2f;
    float woodLiningValue = 1f;
    float stoneLiningValue = 1.5f;
    float brickLiningValue =


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

    public void checkIfDone(){
        if (winCondition.isThereABucket && winCondition.isThereAHole){
            //win
        }
        else if (winCondition.pumpType != Pump.noPump){
            //win
        }
        /*
        if (winCondition.ligningType == Lining.wood){
            if (winCondition.isThereAHole && winCondition.isThereABucket){
                //win
            }
            else if (!winCondition.isThereAHole && winCondition.pumpType == Pump.handPump){
                //win
            }
            else if (!winCondition.isThereAHole && winCondition.pumpType == Pump.mechanicPump && winCondition.engineType == Engine.diesel){
                //win
            }
            else if (!winCondition.isThereAHole && winCondition.pumpType == Pump.mechanicPump && winCondition.engineType == Engine.electrical){
                //win
            }
        }

        else if (winCondition.ligningType == Lining.stone || winCondition.ligningType == Lining.brick){
            if (winCondition.isThereAHole && winCondition.isThereABucket){
                //win
            }
            else if (!winCondition.isThereAHole && winCondition.pumpType == Pump.handPump){
                //win
            }
            else if (!winCondition.isThereAHole && winCondition.pumpType == Pump.mechanicPump && winCondition.engineType == Engine.diesel){
                //win
            }
            else if (!winCondition.isThereAHole && winCondition.pumpType == Pump.mechanicPump && winCondition.engineType == Engine.electrical){
                //win
            }
        }

        else if (winCondition.ligningType == Lining.concrete){
            if (winCondition.isThereAHole && winCondition.isThereABucket){
                //win
            }
            else if (!winCondition.isThereAHole && winCondition.pumpType == Pump.handPump){
                //win
            }
            else if (!winCondition.isThereAHole && winCondition.pumpType == Pump.mechanicPump && winCondition.engineType == Engine.diesel){
                //win
            }
            else if (!winCondition.isThereAHole && winCondition.pumpType == Pump.mechanicPump && winCondition.engineType == Engine.electrical){
                //win
            }
        }

        else if (winCondition.ligningType == Lining.noLining){
            if (winCondition.isThereAHole && winCondition.isThereABucket){
                //win
            }
            else if (!winCondition.isThereAHole && winCondition.pumpType == Pump.handPump){
                //win
            }
            else if (!winCondition.isThereAHole && winCondition.pumpType == Pump.mechanicPump && winCondition.engineType == Engine.diesel){
                //win
            }
            else if (!winCondition.isThereAHole && winCondition.pumpType == Pump.mechanicPump && winCondition.engineType == Engine.electrical){
                //win
            }
        }
        */
    }

}
