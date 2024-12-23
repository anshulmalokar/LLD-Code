public class Driver {
    private int id;
    private String name;
    private boolean available;
    private float rating;

    public Driver(String name){
        this.name = name;
        this.available = true;
    }

    public String getName(){
        return this.name;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public float getRating(){
        return this.rating;
    }
}
