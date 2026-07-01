package androidx.core.location;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class LocationManagerCompat$GpsStatusTransport$3 implements Runnable {
    public final /* synthetic */ LocationManagerCompat$GpsStatusTransport this$0;
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ int val$ttff;

    public LocationManagerCompat$GpsStatusTransport$3(LocationManagerCompat$GpsStatusTransport locationManagerCompat$GpsStatusTransport, Executor executor, int i) {
        this.this$0 = locationManagerCompat$GpsStatusTransport;
        this.val$executor = executor;
        this.val$ttff = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.this$0.mExecutor != this.val$executor) {
            return;
        }
        this.this$0.mCallback.onFirstFix(this.val$ttff);
    }
}
