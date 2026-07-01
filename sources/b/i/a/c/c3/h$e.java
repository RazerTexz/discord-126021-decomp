package b.i.a.c.c3;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import b.i.a.c.a3.o0;
import java.util.Map;

/* JADX INFO: compiled from: DefaultTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$e extends p$a {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public final SparseArray<Map<o0, h$f>> J;
    public final SparseBooleanArray K;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f900y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f901z;

    public h$e(Context context) {
        a(context);
        c(context, true);
        this.J = new SparseArray<>();
        this.K = new SparseBooleanArray();
        e();
    }

    @Override // b.i.a.c.c3.p$a
    public p$a a(Context context) {
        super.a(context);
        return this;
    }

    @Override // b.i.a.c.c3.p$a
    public p$a b(int i, int i2, boolean z2) {
        this.i = i;
        this.j = i2;
        this.k = z2;
        return this;
    }

    @Override // b.i.a.c.c3.p$a
    public p$a c(Context context, boolean z2) {
        super.c(context, z2);
        return this;
    }

    public h$d d() {
        return new h$d(this, null);
    }

    public final void e() {
        this.f900y = true;
        this.f901z = false;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = true;
        this.H = false;
        this.I = true;
    }

    @Deprecated
    public h$e() {
        this.J = new SparseArray<>();
        this.K = new SparseBooleanArray();
        e();
    }
}
