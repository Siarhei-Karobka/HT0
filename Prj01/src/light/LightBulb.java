package light;

/**
 * @author OK
 * @since 22.10.2018
 */
public class LightBulb {
    private int illuminance;

    public LightBulb(int illuminance) {
        if (illuminance <0){
            throw new IllegalArgumentException("bulb Illuminance can't be less than 0");
        } else {
            this.illuminance = illuminance;
        }
    }

    public int getIlluminance() {
        return illuminance;
    }

    @Override
    public String toString() {
        return "lightBulb: " + illuminance;
    }
}
