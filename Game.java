import java.util.Scanner;

class Game {

    void run(){
        Player player = new Player();
        Scanner sc = new Scanner(System.in);
        String selection;
        boolean victory = false;


        // Create the rooms
        Room entrance = new Room("Entrance Hall","a dark and dusty entrance hall. Behind you there is a locked door, boarded up windows, and a dead plant.");
        Room lounge = new Room("Lounge","a family sitting room, but it has been wrecked. There is a broken table upturned in the center of the room, and a smashed TV, emitting static from the corner.");
        Room kitchen = new Room("Kitchen","a dark and smelly room, with mice running around, heard but unseen. There are dirty dishes in the sink.");
        Room pantry = new Room("Pantry","a dark and cold room, which smells stringly of garlic.");
        Room bedroom = new Room("Bedroom","a bedroom, complete with bed, wardrobes and a chest of drawers. It is strangely clean and tidy. The bed is freshly made.");
        Room toilet = new Room("En-suite","a clean en-suite bathroom. Shower, sink and toilet...");
        Room balcony = new Room("Balcony", "a twee terrace, set for breakfast. There are stairs down to the garden and freedom");
        Room freedom = new Room("Freedom!","you are free!");

        // create the monsters
        Vampire vamp1 = new Vampire("Dave","a tall, thin vampire.");
        Vampire vamp2 = new Vampire("Colin", "an old, grumpy looking vampire, who is struggling to walk.");
        Vampire vamp3 = new Vampire("Anabell","a beautiful, long haired vampire with seductive eyes...");
        Vampire vamp4 = new Vampire("James","an incredibly fat vampire.");
        Werewolf wolf1 = new Werewolf("Simon", "a small child werewolf... a werecub, perhaps?");
        Werewolf wolf2 = new Werewolf("Claire","a large, and lumbering werewolf with huge teeth.");
        Werewolf wolf3 = new Werewolf("Axel","a very angry looking werewolf, with the sharpest, biggest claws you can imagine!");
        Werewolf wolf4 = new Werewolf("Jonathan","a very, very old werewolf, who can hardly lift his head to growl at you.");

        // create the items
        Food chocolate = new Food("chocolate","a bar of dairymilk... a little out of date",2);
        Food bread = new Food("bread", "a loaf of brown, seaded bread",3);
        Weapon knife = new Weapon("knife","a very sharp kitchen knife.");
        Weapon gun = new Weapon("gun","a large caliber revolver");
        Weapon stake = new Weapon("stake","a sharp wooden stake - it looks like it was once a table leg...");
        Item tableleg = new Item("table leg","a broken table leg, about 12 inches long");
        Item bullets = new Item("bullets","some *very* shiny bullets in a gun clip");
        Item key = new Item("key","a small door key");
        Item toiletRoll = new Item("toilet roll","for pooping...");
        Item carKey = new Item("car key","the key to a Nissan car");


        //build the map
        entrance.setDoors(lounge, null, null, null);
        lounge.setDoors(bedroom, kitchen, entrance, null);
        kitchen.setDoors(pantry,null,null,lounge);
        pantry.setDoors(null,null,kitchen,null);
        bedroom.setDoors(null, toilet, lounge, balcony);
        toilet.setDoors(null, null, null, bedroom);
        balcony.setDoors(freedom,bedroom,null,null);
        freedom.setDoors(null,null,balcony,null);
    
        System.out.println();

        //add monsters
        Monster[] m1 = {};
            entrance.setMonsters(m1);
        Monster[] m2 = {vamp1};
            lounge.setMonsters(m2);
        Monster[] m3 = {vamp2,wolf1};
            kitchen.setMonsters(m3);
        Monster[] m4 = {};
            pantry.setMonsters(m4);
        Monster[] m5 = {wolf2,wolf3,wolf4};
            bedroom.setMonsters(m5);
        Monster[] m6 ={vamp3}; 
            toilet.setMonsters(m6);
        Monster[] m7 ={vamp4}; 
            balcony.setMonsters(m7);
        Monster[] m8 = {};
            freedom.setMonsters(m8);


        //add items
        Item[] t1 = {bullets, chocolate, stake};
            entrance.setItems(t1);
        Item[] t2 = {gun, tableleg};
            lounge.setItems(t2);
        Item[] t3 = {knife};
            kitchen.setItems(t3);
        Item[] t4 = {bread, bullets,key};
            pantry.setItems(t4);
        Item[] t5 = {};
            bedroom.setItems(t5);
        Item[] t6 = {toiletRoll};
            toilet.setItems(t6);
        Item[] t7 = {carKey};
            balcony.setItems(t7);


        //lock doors
        balcony.locked = true;


        // start the Game

        player.setCurrentLocation(entrance);

        while(victory != true){
            if(player.moved == true){
                player.currentLocation.describe();
                player.moved = false;
            }
            
            System.out.println(ConsoleColors.CYAN);
            System.out.println("ACTIONS:");
            System.out.println("(i)  Show inventory...");
            System.out.println("(m)  Move...");
            System.out.println("(l)  Look at...");
            System.out.println("(p)  Pick up...");
            System.out.println("(u)  Use...");
            System.out.println("(f)  fight...");

            System.out.print(ConsoleColors.RESET + "\n> ");
            selection = sc.next();
            
            switch (selection){
                case "i" : player.showInventory(); break;
                case "m" : player.move(); break;
                case "l" : player.look(); break;
                case "p" : player.pickUp(); break;
                case "u" : player.use(); break;
                case "f" : player.fight(); break;
                case "n" : player.directMove("n"); break;
                case "e" : player.directMove("e"); break;
                case "s" : player.directMove("s"); break;
                case "w" : player.directMove("w"); break;

                default : System.out.println(selection + " is not a valid choice");
            }

        }// end of victory loop

        sc.close();
    }// end of run method
}// end of class