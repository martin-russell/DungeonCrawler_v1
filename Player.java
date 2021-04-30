import java.util.Scanner;

class Player {

    Scanner sc = new Scanner(System.in);

    String name;
    int strength = 0;
    int intelligence = 0;
    int reflexes = 0;
    int injury = 0;
    Item[] inventory = new Item[10];
    int inventoryCount = 0;
    Item[] weapons = new Weapon[4];
    int weaponCount = 0;
    int ammo = 0;
    boolean beingAttacked = false;
    Room currentLocation;
    boolean moved = true;
    String direction;

    Player(){

        // build a character with user input
        System.out.print("Welcome Adventurer... what is your name? ");
        this.name = sc.next();
        System.out.println();
        System.out.println(this.name + "? Well, that doesn't sound much like an Adventurer's name!\nRegardless, let's get you started. ");

        // // Method for creating a character sheet. Currently unused
        // System.out.println("\nYou have 2 skill points to spend, where would you like to put them?\n");

        // int points_used = 0;
        // while (points_used != 2){
        //     System.out.println("(1) Strength:     " + strength);
        //     System.out.println("(2) Intelligence: " + intelligence);
        //     System.out.println("(3) Reflexes:     " + reflexes);
        //     int choice = sc.nextInt();
        //     if (choice == 1){
        //         this.strength++;
        //         points_used ++;
        //     } else if (choice == 2){
        //         this.intelligence++;
        //         points_used ++;
        //     } else if (choice == 3){
        //         this.reflexes++;
        //         points_used ++;
        //     } else {
        //         System.out.println("That is not a valid selection.");
        //     }
        // }

        // System.out.println("(1) Strength:     "+strength);
        // System.out.println("(2) Intelligence: "+intelligence);
        // System.out.println("(3) Reflexes:     "+reflexes);

    }// end of constructor


    // getters and setters
    void setCurrentLocation(Room x){
        this.currentLocation = x;
    }


    // player methods
    public void showInventory(){
        System.out.println("\nINVENTORY:");
        for (int i = 0; i<this.inventory.length;i++){
            if(this.inventory[i] == null){
                System.out.println((i+1) + ": ....................");
            } else {
                System.out.print((i+1) + ": ");
                this.inventory[i].about();
            }
        }
        System.out.println("\nWEAPONS:");
        for (int i = 0; i < this.weapons.length; i++){
            if(this.inventory[i] == null){
                System.out.println((i+1) + ": ....................");
            } else {
                System.out.print((i+1) + ": ");
                this.weapons[i].about();
            }
        }
    }


    public void move(){
        // move player between rooms
        System.out.println("Which direction would you like to go?");
        this.currentLocation.getExits();
        
        direction = sc.next();

        if (direction.equals("n") && this.currentLocation.doors[0] != null){
            //TODO - implement door locking system
            System.out.print("\nYou go north - ");
            this.setCurrentLocation(this.currentLocation.doors[0]);
            this.moved = true;
        } else if (direction.equals("e") && this.currentLocation.doors[1] != null){
            System.out.print("\nYou go east - ");
            this.setCurrentLocation(this.currentLocation.doors[1]);
            this.moved = true;
        } else if (direction.equals("s") && this.currentLocation.doors[2] != null){
            System.out.print("\nYou go south - ");
            this.setCurrentLocation(this.currentLocation.doors[2]);
            this.moved = true;
        } else if (direction.equals("w") && this.currentLocation.doors[3] != null){
            System.out.print("\nYou go west - ");
            this.setCurrentLocation(this.currentLocation.doors[3]);
            this.moved = true;
        } else {
            System.out.println("\nThere is no exit in that direction");
        }
        

    }

    public void look(){
        // describe an object, or list the uncollected items in the current room
        this.currentLocation.describe();
        this.currentLocation.getItems();

    }

    void pickUp(){
        // collect an uncollected item from the current room, after having looked at it
        if(this.currentLocation.items.length == 0){
            System.out.println("There is nothing to pick up...");
        } else {
            System.out.println("What would you like to pick up?");
            this.currentLocation.getItems();

            if (sc.hasNextInt() == true){
                int selection = sc.nextInt();
                    selection = selection -1;
                    if (selection < this.currentLocation.items.length){
                        System.out.println("You pick up the " + this.currentLocation.items[selection].name);
                        // add the item to the inventory or weapons
                        System.out.println(this.currentLocation.items[selection].getClass());
                        if (this.currentLocation.items[selection].getClass() == Weapon.class) {
                            //System.out.println("Its a weapon");
                            this.weapons[weaponCount] = this.currentLocation.items[selection];
                        } else {
                            //System.out.println("It's not a weapon");
                            this.inventory[inventoryCount] = this.currentLocation.items[selection];
                            inventoryCount ++;
                        }

                        //remove the item from the room

                        Item[] temp = new Item[this.currentLocation.items.length-1];
                        for (int i=0, k=0; i<this.currentLocation.items.length; i++) {
                            if (i == selection){
                                continue;
                            }
                            //else copy the items into the new array
                            temp[k++] = this.currentLocation.items[i];
                        }
                        // resets the item array of the room to the new array
                        this.currentLocation.setItems(temp);

                    } else {
                        System.out.println("That is not a valid selection");
                    }

            } else { 
                System.out.println("That is not a valid selction");
            }
        }
    }

    void use(){
        // use an item from inventory as appropriate
        System.out.println("What would you like to use?");
        this.showInventory();
    }

    void fight(){
        // select a monster to fight against, and a weapon to fight with
        // can only select a monster to fight, if not being attacked. Otherwise, must defend
        System.out.println("Temp = you fight");
    }





}