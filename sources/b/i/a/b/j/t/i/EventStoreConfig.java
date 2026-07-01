package b.i.a.b.j.t.i;

import b.d.b.a.outline;
import com.google.auto.value.AutoValue;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.d, reason: use source file name */
/* JADX INFO: compiled from: EventStoreConfig.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class EventStoreConfig {
    public static final EventStoreConfig a;

    static {
        Long l = 10485760L;
        Integer num = 200;
        Integer num2 = 10000;
        Long l2 = 604800000L;
        Integer num3 = 81920;
        String strW = l == null ? " maxStorageSizeInBytes" : "";
        if (num == null) {
            strW = outline.w(strW, " loadBatchSize");
        }
        if (num2 == null) {
            strW = outline.w(strW, " criticalSectionEnterTimeoutMs");
        }
        if (l2 == null) {
            strW = outline.w(strW, " eventCleanUpAge");
        }
        if (num3 == null) {
            strW = outline.w(strW, " maxBlobByteSizePerRow");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }
        a = new AutoValue_EventStoreConfig(l.longValue(), num.intValue(), num2.intValue(), l2.longValue(), num3.intValue(), null);
    }

    public abstract int a();

    public abstract long b();

    public abstract int c();

    public abstract int d();

    public abstract long e();
}
