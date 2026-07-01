package androidx.core.location;

import android.location.GnssStatus;
import android.location.GnssStatus$Callback;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class LocationManagerCompat$GnssStatusTransport extends GnssStatus$Callback {
    public final GnssStatusCompat$Callback mCallback;

    public LocationManagerCompat$GnssStatusTransport(GnssStatusCompat$Callback gnssStatusCompat$Callback) {
        Preconditions.checkArgument(gnssStatusCompat$Callback != null, "invalid null callback");
        this.mCallback = gnssStatusCompat$Callback;
    }

    @Override // android.location.GnssStatus$Callback
    public void onFirstFix(int i) {
        this.mCallback.onFirstFix(i);
    }

    @Override // android.location.GnssStatus$Callback
    public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
    }

    @Override // android.location.GnssStatus$Callback
    public void onStarted() {
        this.mCallback.onStarted();
    }

    @Override // android.location.GnssStatus$Callback
    public void onStopped() {
        this.mCallback.onStopped();
    }
}
