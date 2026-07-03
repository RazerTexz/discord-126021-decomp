package p007b.p109f.p161j.p177l;

import android.util.SparseIntArray;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.f.j.l.y */
/* JADX INFO: compiled from: PoolParams.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1953y {

    /* JADX INFO: renamed from: a */
    public final int f3976a;

    /* JADX INFO: renamed from: b */
    public final int f3977b;

    /* JADX INFO: renamed from: c */
    public final SparseIntArray f3978c;

    /* JADX INFO: renamed from: d */
    public final int f3979d;

    public C1953y(int i, int i2, SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public C1953y(int i, int i2, SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        C1460d.m419B(i >= 0 && i2 >= i);
        this.f3977b = i;
        this.f3976a = i2;
        this.f3978c = sparseIntArray;
        this.f3979d = i5;
    }
}
