package androidx.core.location;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class LocationManagerCompat$GpsStatusTransport$4 implements Runnable {
    public final /* synthetic */ LocationManagerCompat$GpsStatusTransport this$0;
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ GnssStatusCompat val$gnssStatus;

    public LocationManagerCompat$GpsStatusTransport$4(LocationManagerCompat$GpsStatusTransport locationManagerCompat$GpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.this$0 = locationManagerCompat$GpsStatusTransport;
        this.val$executor = executor;
        this.val$gnssStatus = gnssStatusCompat;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.this$0.mExecutor != this.val$executor) {
            return;
        }
        this.this$0.mCallback.onSatelliteStatusChanged(this.val$gnssStatus);
    }
}
