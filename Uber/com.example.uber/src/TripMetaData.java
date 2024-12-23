public class TripMetaData {
    private Location src;
    private Location dest;
    private float riderRating;

    public TripMetaData(Location src, Location dest, float riderRating){
        this.dest = dest;
        this.src = src;
        this.riderRating = riderRating;
    }
}
