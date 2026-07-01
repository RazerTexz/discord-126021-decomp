package androidx.core.location;

import android.location.LocationManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public class LocationManagerCompat$Api28Impl {
    private LocationManagerCompat$Api28Impl() {
    }

    @DoNotInline
    public static String getGnssHardwareModelName(LocationManager locationManager) {
        return locationManager.getGnssHardwareModelName();
    }

    @DoNotInline
    public static int getGnssYearOfHardware(LocationManager locationManager) {
        return locationManager.getGnssYearOfHardware();
    }

    @DoNotInline
    public static boolean isLocationEnabled(LocationManager locationManager) {
        return locationManager.isLocationEnabled();
    }
}
