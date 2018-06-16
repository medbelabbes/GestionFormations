package entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class Localisation implements Serializable {


    @NotNull
    @Size(max = 25)
    private double altitude;

    @NotNull
    @Size(max = 25)
    private double longitude;

    public Localisation() {
    }

    public Localisation(@NotNull @Size(max = 25) double altitude, @NotNull @Size(max = 25) double longitude) {
        this.altitude = altitude;
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
