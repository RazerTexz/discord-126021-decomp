package androidx.core.location;

import android.location.LocationManager;
import androidx.annotation.RequiresPermission;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class LocationManagerCompat$3 implements Callable<Boolean> {
    public final /* synthetic */ LocationManager val$locationManager;
    public final /* synthetic */ LocationManagerCompat$GpsStatusTransport val$myTransport;

    public LocationManagerCompat$3(LocationManager locationManager, LocationManagerCompat$GpsStatusTransport locationManagerCompat$GpsStatusTransport) {
        this.val$locationManager = locationManager;
        this.val$myTransport = locationManagerCompat$GpsStatusTransport;
    }

    @Override // java.util.concurrent.Callable
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public /* bridge */ /* synthetic */ Boolean call() throws Exception {
        return call();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public Boolean call() {
        return Boolean.valueOf(this.val$locationManager.addGpsStatusListener(this.val$myTransport));
    }
}
