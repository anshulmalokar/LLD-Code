abstract class IPerson {
    int id;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    float rating;

    public void setId(int id) {
        this.id = id;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }
}
