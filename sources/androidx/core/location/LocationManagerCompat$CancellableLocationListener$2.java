package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class LocationManagerCompat$CancellableLocationListener$2 implements Runnable {
    public final /* synthetic */ LocationManagerCompat$CancellableLocationListener this$0;
    public final /* synthetic */ Consumer val$consumer;
    public final /* synthetic */ Location val$location;

    public LocationManagerCompat$CancellableLocationListener$2(LocationManagerCompat$CancellableLocationListener locationManagerCompat$CancellableLocationListener, Consumer consumer, Location location) {
        this.this$0 = locationManagerCompat$CancellableLocationListener;
        this.val$consumer = consumer;
        this.val$location = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$consumer.accept(this.val$location);
    }
}
