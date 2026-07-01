package b.f.j.l;

import android.util.SparseIntArray;

/* JADX INFO: compiled from: DefaultBitmapPoolParams.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    public static final SparseIntArray a = new SparseIntArray(0);

    public static y a() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return new y(0, iMin > 16777216 ? (iMin / 4) * 3 : iMin / 2, a);
    }
}
