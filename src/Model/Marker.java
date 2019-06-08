package Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Marker {
    MOUSE, BEAR, FIRE;
    /**
     * Makes a list of the values of Marker
     */
    private static final List<Marker> values = Collections.unmodifiableList(Arrays.asList(values()));

    /**
     * Gives a random marker
     *
     * @return Marker
     */
    public static Marker randomMarker() {
        return values.get(new Random().nextInt(values.size()));
    }
}
