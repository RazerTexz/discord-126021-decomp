package p007b.p109f.p161j.p168c;

import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: b.f.j.c.o */
/* JADX INFO: compiled from: DefaultEncodedMemoryCacheParamsSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class C1868o implements Supplier<MemoryCacheParams> {

    /* JADX INFO: renamed from: a */
    public static final long f3685a = TimeUnit.MINUTES.toMillis(5);

    @Override // com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        int i;
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (iMin < 16777216) {
            i = 1048576;
        } else {
            i = iMin < 33554432 ? 2097152 : 4194304;
        }
        return new MemoryCacheParams(i, Integer.MAX_VALUE, i, Integer.MAX_VALUE, i / 8, f3685a);
    }
}
