package b.f.j.l;

import android.util.SparseIntArray;

/* JADX INFO: compiled from: PoolConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public class w {
    public final y a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f600b;
    public final y c;
    public final b.f.d.g.c d;
    public final y e;
    public final z f;
    public final y g;
    public final z h;
    public final String i;
    public final int j;

    public w(w$b w_b, w$a w_a) {
        b.f.j.r.b.b();
        this.a = j.a();
        this.f600b = v.h();
        int i = k.a;
        int i2 = i * 4194304;
        SparseIntArray sparseIntArray = new SparseIntArray();
        for (int i3 = 131072; i3 <= 4194304; i3 *= 2) {
            sparseIntArray.put(i3, i);
        }
        this.c = new y(4194304, i2, sparseIntArray, 131072, 4194304, k.a);
        this.d = b.f.d.g.d.b();
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
        this.e = new y(i4, iMin2 < 16777216 ? iMin2 / 2 : (iMin2 / 4) * 3, sparseIntArray2);
        this.f = v.h();
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        sparseIntArray3.put(16384, 5);
        this.g = new y(81920, 1048576, sparseIntArray3);
        this.h = v.h();
        this.i = "legacy";
        this.j = 4194304;
        b.f.j.r.b.b();
    }
}
