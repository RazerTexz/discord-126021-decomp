package androidx.core.location;

import android.location.GnssStatus;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class LocationManagerCompat$PreRGnssStatusTransport$4 implements Runnable {
    public final /* synthetic */ LocationManagerCompat$PreRGnssStatusTransport this$0;
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ GnssStatus val$status;

    public LocationManagerCompat$PreRGnssStatusTransport$4(LocationManagerCompat$PreRGnssStatusTransport locationManagerCompat$PreRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
        this.this$0 = locationManagerCompat$PreRGnssStatusTransport;
        this.val$executor = executor;
        this.val$status = gnssStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.this$0.mExecutor != this.val$executor) {
            return;
        }
        this.this$0.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(this.val$status));
    }
}
