package b.f.j.l;

import android.util.SparseIntArray;
import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.f.j.l.y, reason: use source file name */
/* JADX INFO: compiled from: PoolParams.java */
/* JADX INFO: loaded from: classes3.dex */
public class PoolParams {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f602b;
    public final SparseIntArray c;
    public final int d;

    public PoolParams(int i, int i2, SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public PoolParams(int i, int i2, SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        AnimatableValueParser.B(i >= 0 && i2 >= i);
        this.f602b = i;
        this.a = i2;
        this.c = sparseIntArray;
        this.d = i5;
    }
}
