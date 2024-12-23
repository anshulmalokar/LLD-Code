public class Rider {
    private int id;
    private String name;
    private float rating;

    public Rider(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public float getRating(){
        return this.rating;
    }

}
