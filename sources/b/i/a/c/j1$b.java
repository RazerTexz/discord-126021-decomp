package b.i.a.c;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;

/* JADX INFO: compiled from: Format.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j1$b {
    public int A;
    public int B;
    public int C;
    public int D;

    @Nullable
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public String f1021b;

    @Nullable
    public String c;
    public int d;
    public int e;
    public int f;
    public int g;

    @Nullable
    public String h;

    @Nullable
    public Metadata i;

    @Nullable
    public String j;

    @Nullable
    public String k;
    public int l;

    @Nullable
    public List<byte[]> m;

    @Nullable
    public DrmInitData n;
    public long o;
    public int p;
    public int q;
    public float r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1022s;
    public float t;

    @Nullable
    public byte[] u;
    public int v;

    @Nullable
    public b.i.a.c.g3.n w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1023x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1024y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1025z;

    public j1$b() {
        this.f = -1;
        this.g = -1;
        this.l = -1;
        this.o = RecyclerView.FOREVER_NS;
        this.p = -1;
        this.q = -1;
        this.r = -1.0f;
        this.t = 1.0f;
        this.v = -1;
        this.f1023x = -1;
        this.f1024y = -1;
        this.f1025z = -1;
        this.C = -1;
        this.D = 0;
    }

    public j1 a() {
        return new j1(this, null);
    }

    public j1$b b(int i) {
        this.a = Integer.toString(i);
        return this;
    }

    public j1$b(j1 j1Var, j1$a j1_a) {
        this.a = j1Var.l;
        this.f1021b = j1Var.m;
        this.c = j1Var.n;
        this.d = j1Var.o;
        this.e = j1Var.p;
        this.f = j1Var.q;
        this.g = j1Var.r;
        this.h = j1Var.t;
        this.i = j1Var.u;
        this.j = j1Var.v;
        this.k = j1Var.w;
        this.l = j1Var.f1018x;
        this.m = j1Var.f1019y;
        this.n = j1Var.f1020z;
        this.o = j1Var.A;
        this.p = j1Var.B;
        this.q = j1Var.C;
        this.r = j1Var.D;
        this.f1022s = j1Var.E;
        this.t = j1Var.F;
        this.u = j1Var.G;
        this.v = j1Var.H;
        this.w = j1Var.I;
        this.f1023x = j1Var.J;
        this.f1024y = j1Var.K;
        this.f1025z = j1Var.L;
        this.A = j1Var.M;
        this.B = j1Var.N;
        this.C = j1Var.O;
        this.D = j1Var.P;
    }
}
