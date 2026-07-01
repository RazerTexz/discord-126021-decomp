package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class LocationManagerCompat$1 implements Runnable {
    public final /* synthetic */ Consumer val$consumer;
    public final /* synthetic */ Location val$location;

    public LocationManagerCompat$1(Consumer consumer, Location location) {
        this.val$consumer = consumer;
        this.val$location = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$consumer.accept(this.val$location);
    }
}
