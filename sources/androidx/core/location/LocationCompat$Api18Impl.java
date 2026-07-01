package androidx.core.location;

import android.location.Location;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(18)
public class LocationCompat$Api18Impl {
    private LocationCompat$Api18Impl() {
    }

    @DoNotInline
    public static boolean isMock(Location location) {
        return location.isFromMockProvider();
    }
}
