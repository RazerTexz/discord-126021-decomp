package b.f.j.l;

import android.util.SparseIntArray;
import b.f.d.g.MemoryTrimmableRegistry;
import b.f.d.g.NoOpMemoryTrimmableRegistry;
import b.f.j.r.FrescoSystrace;

/* JADX INFO: renamed from: b.f.j.l.w, reason: use source file name */
/* JADX INFO: compiled from: PoolConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public class PoolConfig {
    public final PoolParams a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PoolStatsTracker f600b;
    public final PoolParams c;
    public final MemoryTrimmableRegistry d;
    public final PoolParams e;
    public final PoolStatsTracker f;
    public final PoolParams g;
    public final PoolStatsTracker h;
    public final String i;
    public final int j;

    /* JADX INFO: renamed from: b.f.j.l.w$b */
    /* JADX INFO: compiled from: PoolConfig.java */
    public static class b {
        public b(a aVar) {
        }
    }

    public PoolConfig(b bVar, a aVar) {
        FrescoSystrace.b();
        this.a = DefaultBitmapPoolParams.a();
        this.f600b = NoOpPoolStatsTracker.h();
        int i = DefaultFlexByteArrayPoolParams.a;
        int i2 = i * 4194304;
        SparseIntArray sparseIntArray = new SparseIntArray();
        for (int i3 = 131072; i3 <= 4194304; i3 *= 2) {
            sparseIntArray.put(i3, i);
        }
        this.c = new PoolParams(4194304, i2, sparseIntArray, 131072, 4194304, DefaultFlexByteArrayPoolParams.a);
        this.d = NoOpMemoryTrimmableRegistry.b();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sparseIntArray2.put(1024, 5);
        sparseIntArray2.put(2048, 5);
        sparseIntArray2.put(4096, 5);
        sparseIntArray2.put(8192, 5);
        sparseIntArray2.put(16384, 5);
        sparseIntArray2.put(32768, 5);
        sparseIntArray2.put(65536, 5);
        sparseIntArray2.put(131072, 5);
        sparseIntArray2.put(262144, 2);
        sparseIntArray2.put(524288, 2);
        sparseIntArray2.put(1048576, 2);
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        int i4 = iMin < 16777216 ? 3145728 : iMin < 33554432 ? 6291456 : 12582912;
        int iMin2 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        this.e = new PoolParams(i4, iMin2 < 16777216 ? iMin2 / 2 : (iMin2 / 4) * 3, sparseIntArray2);
        this.f = NoOpPoolStatsTracker.h();
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        sparseIntArray3.put(16384, 5);
        this.g = new PoolParams(81920, 1048576, sparseIntArray3);
        this.h = NoOpPoolStatsTracker.h();
        this.i = "legacy";
        this.j = 4194304;
        FrescoSystrace.b();
    }
}
