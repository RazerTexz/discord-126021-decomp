package androidx.core.location;

import androidx.annotation.RequiresPermission;
import androidx.core.os.CancellationSignal$OnCancelListener;

/* JADX INFO: loaded from: classes.dex */
public class LocationManagerCompat$2 implements CancellationSignal$OnCancelListener {
    public final /* synthetic */ LocationManagerCompat$CancellableLocationListener val$listener;

    public LocationManagerCompat$2(LocationManagerCompat$CancellableLocationListener locationManagerCompat$CancellableLocationListener) {
        this.val$listener = locationManagerCompat$CancellableLocationListener;
    }

    @Override // androidx.core.os.CancellationSignal$OnCancelListener
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public void onCancel() {
        this.val$listener.cancel();
    }
}
