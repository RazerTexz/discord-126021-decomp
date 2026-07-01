package b.i.a.c.c3;

import androidx.annotation.Nullable;
import b.i.a.c.a3.n0;
import b.i.a.c.j1;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: BaseTrackSelection.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g implements j {
    public final n0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f897b;
    public final int[] c;
    public final j1[] d;
    public int e;

    public g(n0 n0Var, int[] iArr, int i) {
        b.c.a.a0.d.D(iArr.length > 0);
        Objects.requireNonNull(n0Var);
        this.a = n0Var;
        int length = iArr.length;
        this.f897b = length;
        this.d = new j1[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.d[i2] = n0Var.l[iArr[i2]];
        }
        Arrays.sort(this.d, a.j);
        this.c = new int[this.f897b];
        int i3 = 0;
        while (true) {
            int i4 = this.f897b;
            if (i3 >= i4) {
                long[] jArr = new long[i4];
                return;
            }
            int[] iArr2 = this.c;
            j1 j1Var = this.d[i3];
            int i5 = 0;
            while (true) {
                j1[] j1VarArr = n0Var.l;
                if (i5 >= j1VarArr.length) {
                    i5 = -1;
                    break;
                } else if (j1Var == j1VarArr[i5]) {
                    break;
                } else {
                    i5++;
                }
            }
            iArr2[i3] = i5;
            i3++;
        }
    }

    @Override // b.i.a.c.c3.m
    public final n0 a() {
        return this.a;
    }

    @Override // b.i.a.c.c3.j
    public /* synthetic */ void c(boolean z2) {
        i.b(this, z2);
    }

    @Override // b.i.a.c.c3.m
    public final j1 d(int i) {
        return this.d[i];
    }

    @Override // b.i.a.c.c3.j
    public void e() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.a == gVar.a && Arrays.equals(this.c, gVar.c);
    }

    @Override // b.i.a.c.c3.m
    public final int f(int i) {
        return this.c[i];
    }

    @Override // b.i.a.c.c3.j
    public void g() {
    }

    @Override // b.i.a.c.c3.j
    public final j1 h() {
        return this.d[b()];
    }

    public int hashCode() {
        if (this.e == 0) {
            this.e = Arrays.hashCode(this.c) + (System.identityHashCode(this.a) * 31);
        }
        return this.e;
    }

    @Override // b.i.a.c.c3.j
    public void i(float f) {
    }

    @Override // b.i.a.c.c3.j
    public /* synthetic */ void j() {
        i.a(this);
    }

    @Override // b.i.a.c.c3.j
    public /* synthetic */ void k() {
        i.c(this);
    }

    @Override // b.i.a.c.c3.m
    public final int l(int i) {
        for (int i2 = 0; i2 < this.f897b; i2++) {
            if (this.c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // b.i.a.c.c3.m
    public final int length() {
        return this.c.length;
    }
}
