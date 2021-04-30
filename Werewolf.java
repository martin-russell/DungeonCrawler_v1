class Werewolf extends Monster {

    Werewolf(String name, String description){
        this.name = name;
        this.description = description;
        this.dicePool = 6;

    }


    @Override
    void attack(){
        System.out.println(this.name + " lunges at you with his claws...");


    }

    @Override
    void defend(){

    }

    @Override
    void die(){
        
    }

}