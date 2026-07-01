package b.i.a.c;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: DefaultMediaClock.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a1 implements b.i.a.c.f3.s {
    public final b.i.a.c.f3.z j;
    public final a1$a k;

    @Nullable
    public f2 l;

    @Nullable
    public b.i.a.c.f3.s m;
    public boolean n = true;
    public boolean o;

    public a1(a1$a a1_a, b.i.a.c.f3.g gVar) {
        this.k = a1_a;
        this.j = new b.i.a.c.f3.z(gVar);
    }

    @Override // b.i.a.c.f3.s
    public x1 c() {
        b.i.a.c.f3.s sVar = this.m;
        return sVar != null ? sVar.c() : this.j.n;
    }

    @Override // b.i.a.c.f3.s
    public long e() {
        if (this.n) {
            return this.j.e();
        }
        b.i.a.c.f3.s sVar = this.m;
        Objects.requireNonNull(sVar);
        return sVar.e();
    }

    @Override // b.i.a.c.f3.s
    public void i(x1 x1Var) {
        b.i.a.c.f3.s sVar = this.m;
        if (sVar != null) {
            sVar.i(x1Var);
            x1Var = this.m.c();
        }
        this.j.i(x1Var);
    }
}
