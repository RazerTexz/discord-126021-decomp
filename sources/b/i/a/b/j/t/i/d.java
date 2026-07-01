package b.i.a.b.j.t.i;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: EventStoreConfig.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class d {
    public static final d a;

    static {
        Long l = 10485760L;
        Integer num = 200;
        Integer num2 = 10000;
        Long l2 = 604800000L;
        Integer num3 = 81920;
        String strW = l == null ? " maxStorageSizeInBytes" : "";
        if (num == null) {
            strW = b.d.b.a.a.w(strW, " loadBatchSize");
        }
        if (num2 == null) {
            strW = b.d.b.a.a.w(strW, " criticalSectionEnterTimeoutMs");
        }
        if (l2 == null) {
            strW = b.d.b.a.a.w(strW, " eventCleanUpAge");
        }
        if (num3 == null) {
            strW = b.d.b.a.a.w(strW, " maxBlobByteSizePerRow");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }
        a = new a(l.longValue(), num.intValue(), num2.intValue(), l2.longValue(), num3.intValue(), null);
    }

    public abstract int a();

    public abstract long b();

    public abstract int c();

    public abstract int d();

    public abstract long e();
}
