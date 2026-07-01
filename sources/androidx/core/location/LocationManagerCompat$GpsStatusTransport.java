package androidx.core.location;

import android.location.GpsStatus;
import android.location.GpsStatus$Listener;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class LocationManagerCompat$GpsStatusTransport implements GpsStatus$Listener {
    public final GnssStatusCompat$Callback mCallback;

    @Nullable
    public volatile Executor mExecutor;
    private final LocationManager mLocationManager;

    public LocationManagerCompat$GpsStatusTransport(LocationManager locationManager, GnssStatusCompat$Callback gnssStatusCompat$Callback) {
        Preconditions.checkArgument(gnssStatusCompat$Callback != null, "invalid null callback");
        this.mLocationManager = locationManager;
        this.mCallback = gnssStatusCompat$Callback;
    }

    @Override // android.location.GpsStatus$Listener
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public void onGpsStatusChanged(int i) {
        GpsStatus gpsStatus;
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        if (i == 1) {
            executor.execute(new LocationManagerCompat$GpsStatusTransport$1(this, executor));
            return;
        }
        if (i == 2) {
            executor.execute(new LocationManagerCompat$GpsStatusTransport$2(this, executor));
            return;
        }
        if (i != 3) {
            if (i == 4 && (gpsStatus = this.mLocationManager.getGpsStatus(null)) != null) {
                executor.execute(new LocationManagerCompat$GpsStatusTransport$4(this, executor, GnssStatusCompat.wrap(gpsStatus)));
                return;
            }
            return;
        }
        GpsStatus gpsStatus2 = this.mLocationManager.getGpsStatus(null);
        if (gpsStatus2 != null) {
            executor.execute(new LocationManagerCompat$GpsStatusTransport$3(this, executor, gpsStatus2.getTimeToFirstFix()));
        }
    }

    public void register(Executor executor) {
        Preconditions.checkState(this.mExecutor == null);
        this.mExecutor = executor;
    }

    public void unregister() {
        this.mExecutor = null;
    }
}
