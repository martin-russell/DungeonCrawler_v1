class Item {
    
    String name;
    String description;

    public Item (String name, String description){
        this.name = name;
        this.description = description;
    }

    void about(){
        System.out.println(this.name + " : " + this.description);
    }


    
    
}