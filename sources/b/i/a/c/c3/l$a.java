package b.i.a.c.c3;

import androidx.annotation.VisibleForTesting;
import b.i.a.c.a3.o0;

/* JADX INFO: compiled from: MappingTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l$a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f903b;
    public final o0[] c;
    public final int[] d;
    public final int[][][] e;
    public final o0 f;

    @VisibleForTesting
    public l$a(String[] strArr, int[] iArr, o0[] o0VarArr, int[] iArr2, int[][][] iArr3, o0 o0Var) {
        this.f903b = iArr;
        this.c = o0VarArr;
        this.e = iArr3;
        this.d = iArr2;
        this.f = o0Var;
        this.a = iArr.length;
    }

    public int a(int i, int i2, int i3) {
        return this.e[i][i2][i3] & 7;
    }
}
