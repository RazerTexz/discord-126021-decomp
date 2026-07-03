package androidx.core.location;

import android.location.Location;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Location.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LocationKt {
    public static final double component1(Location location) {
        C12238m.checkNotNullParameter(location, "<this>");
        return location.getLatitude();
    }

    public static final double component2(Location location) {
        C12238m.checkNotNullParameter(location, "<this>");
        return location.getLongitude();
    }
}
