package p007b.p109f.p161j.p177l;

import android.util.SparseIntArray;

/* JADX INFO: renamed from: b.f.j.l.j */
/* JADX INFO: compiled from: DefaultBitmapPoolParams.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1938j {

    /* JADX INFO: renamed from: a */
    public static final SparseIntArray f3941a = new SparseIntArray(0);

    /* JADX INFO: renamed from: a */
    public static C1953y m1390a() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return new C1953y(0, iMin > 16777216 ? (iMin / 4) * 3 : iMin / 2, f3941a);
    }
}
