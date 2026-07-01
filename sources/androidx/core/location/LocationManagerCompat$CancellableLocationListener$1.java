package androidx.core.location;

import android.location.Location;
import androidx.annotation.RequiresPermission;

/* JADX INFO: loaded from: classes.dex */
public class LocationManagerCompat$CancellableLocationListener$1 implements Runnable {
    public final /* synthetic */ LocationManagerCompat$CancellableLocationListener this$0;

    public LocationManagerCompat$CancellableLocationListener$1(LocationManagerCompat$CancellableLocationListener locationManagerCompat$CancellableLocationListener) {
        this.this$0 = locationManagerCompat$CancellableLocationListener;
    }

    @Override // java.lang.Runnable
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public void run() {
        LocationManagerCompat$CancellableLocationListener locationManagerCompat$CancellableLocationListener = this.this$0;
        locationManagerCompat$CancellableLocationListener.mTimeoutRunnable = null;
        locationManagerCompat$CancellableLocationListener.onLocationChanged((Location) null);
    }
}
