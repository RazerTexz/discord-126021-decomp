package b.f.j.c;

import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DefaultEncodedMemoryCacheParamsSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements Supplier<MemoryCacheParams> {
    public static final long a = TimeUnit.MINUTES.toMillis(5);

    @Override // com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        int i;
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (iMin < 16777216) {
            i = 1048576;
        } else {
            i = iMin < 33554432 ? 2097152 : 4194304;
        }
        return new MemoryCacheParams(i, Integer.MAX_VALUE, i, Integer.MAX_VALUE, i / 8, a);
    }
}
