package b.f.j.l;

import android.util.SparseIntArray;

/* JADX INFO: renamed from: b.f.j.l.j, reason: use source file name */
/* JADX INFO: compiled from: DefaultBitmapPoolParams.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultBitmapPoolParams {
    public static final SparseIntArray a = new SparseIntArray(0);

    public static PoolParams a() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return new PoolParams(0, iMin > 16777216 ? (iMin / 4) * 3 : iMin / 2, a);
    }
}
