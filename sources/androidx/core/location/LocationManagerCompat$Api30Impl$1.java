package androidx.core.location;

import android.location.Location;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class LocationManagerCompat$Api30Impl$1 implements Consumer<Location> {
    public final /* synthetic */ androidx.core.util.Consumer val$consumer;

    public LocationManagerCompat$Api30Impl$1(androidx.core.util.Consumer consumer) {
        this.val$consumer = consumer;
    }

    @Override // java.util.function.Consumer
    public /* bridge */ /* synthetic */ void accept(Location location) {
        accept2(location);
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(Location location) {
        this.val$consumer.accept(location);
    }
}
