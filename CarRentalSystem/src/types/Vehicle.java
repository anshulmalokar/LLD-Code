package types;

public class Vehicle {
    private double id;
    private String name;
    private boolean status;
    private String kms;

    public Vehicle(String name, boolean status, String kms) {
        this.id = Math.random();
        this.name = name;
        this.status = status;
        this.kms = kms;
    }

    public double getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getKms() {
        return kms;
    }

    public void setKms(String kms) {
        this.kms = kms;
    }
}
