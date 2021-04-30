import java.util.ArrayList;

class Room {

    static String[] directions = {"[n]orth","[e]ast","[s]outh","[w]est"};

    String name;
    String description;
    Room[] doors = new Room[4];
    Item[] items;
    Monster[] monsters;
    boolean locked = false;

    Room(String name, String description){
        this.name = name;
        this.description = description;

    }

    public void setDoors(Room north, Room east, Room south, Room west){
        this.doors[0] = north;
        this.doors[1] = east;
        this.doors[2] = south;
        this.doors[3] = west;
    }

    void setMonsters(Monster[] monsters){
        this.monsters = new Monster[monsters.length];
        for ( int i =0; i<monsters.length; i++ ){
            this.monsters[i] = monsters[i];
        }
    }


    void setItems(Item[] items){
        this.items = new Item[items.length];
        for ( int i = 0; i<items.length; i++ ){
            this.items[i] = items[i];
        }
        
    }

    void unlock(){
        this.locked = false;
    }

    void describe(){
        System.out.print("You are in ");
        System.out.println(this.description);

        // monsters in the room        
        if(this.monsters.length > 0){
            if(this.monsters.length == 1){
                System.out.println("\nIn the room there is one monster: \n");
            }else{
                System.out.print("In the room there are ");
                System.out.println(this.monsters.length + " monsters \n");
            }
        }
        
        if(this.monsters.length > 0){
            for (int i = 0; i<this.monsters.length; i++){
                System.out.println(monsters[i].describe());
            }
            System.out.println();

        }

        this.getExits();

    } //end of describe method


    // exits
    void getExits(){
        System.out.print("\nThere are exit doors to the ");
        for (int i=0; i<4; i++){
            if (this.doors[i] != null){
                System.out.print(directions[i] + " ");
            }
        }
        System.out.println("\n");
    }

    void getItems(){
        System.out.println("\nIn the room, there is:\n");
        for (int i = 0; i < this.items.length; i++){
            System.out.print("("+ (i+1) + ") " );
            this.items[i].about();
            System.out.println();
        }
    }




        


    
    
}