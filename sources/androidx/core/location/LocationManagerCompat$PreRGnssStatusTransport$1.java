package androidx.core.location;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class LocationManagerCompat$PreRGnssStatusTransport$1 implements Runnable {
    public final /* synthetic */ LocationManagerCompat$PreRGnssStatusTransport this$0;
    public final /* synthetic */ Executor val$executor;

    public LocationManagerCompat$PreRGnssStatusTransport$1(LocationManagerCompat$PreRGnssStatusTransport locationManagerCompat$PreRGnssStatusTransport, Executor executor) {
        this.this$0 = locationManagerCompat$PreRGnssStatusTransport;
        this.val$executor = executor;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.this$0.mExecutor != this.val$executor) {
            return;
        }
        this.this$0.mCallback.onStarted();
    }
}
