class Item {
    
    String name;
    String description;
    boolean isWeapon;

    public Item (String name, String description){
        this.name = name;
        this.description = description;
        this.isWeapon = false;
    }

    void about(){
        System.out.println(this.name + " : " + this.description);
    }


    
    
}