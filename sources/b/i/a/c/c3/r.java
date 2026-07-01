package b.i.a.c.c3;

import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.h2;
import b.i.a.c.p2;

/* JADX INFO: compiled from: TrackSelectorResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h2[] f912b;
    public final j[] c;
    public final p2 d;

    @Nullable
    public final Object e;

    public r(h2[] h2VarArr, j[] jVarArr, p2 p2Var, @Nullable Object obj) {
        this.f912b = h2VarArr;
        this.c = (j[]) jVarArr.clone();
        this.d = p2Var;
        this.e = obj;
        this.a = h2VarArr.length;
    }

    public boolean a(@Nullable r rVar, int i) {
        return rVar != null && e0.a(this.f912b[i], rVar.f912b[i]) && e0.a(this.c[i], rVar.c[i]);
    }

    public boolean b(int i) {
        return this.f912b[i] != null;
    }
}
