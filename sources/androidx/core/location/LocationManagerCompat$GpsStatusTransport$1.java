package androidx.core.location;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class LocationManagerCompat$GpsStatusTransport$1 implements Runnable {
    public final /* synthetic */ LocationManagerCompat$GpsStatusTransport this$0;
    public final /* synthetic */ Executor val$executor;

    public LocationManagerCompat$GpsStatusTransport$1(LocationManagerCompat$GpsStatusTransport locationManagerCompat$GpsStatusTransport, Executor executor) {
        this.this$0 = locationManagerCompat$GpsStatusTransport;
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
