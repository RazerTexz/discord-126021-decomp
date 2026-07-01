package b.i.a.c.e3;

import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: BaseDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g implements l {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<a0> f941b = new ArrayList<>(1);
    public int c;

    @Nullable
    public n d;

    public g(boolean z2) {
        this.a = z2;
    }

    @Override // b.i.a.c.e3.l
    public final void d(a0 a0Var) {
        Objects.requireNonNull(a0Var);
        if (this.f941b.contains(a0Var)) {
            return;
        }
        this.f941b.add(a0Var);
        this.c++;
    }

    @Override // b.i.a.c.e3.l
    public /* synthetic */ Map j() {
        return k.a(this);
    }

    public final void p(int i) {
        n nVar = this.d;
        int i2 = e0.a;
        for (int i3 = 0; i3 < this.c; i3++) {
            this.f941b.get(i3).e(this, nVar, this.a, i);
        }
    }

    public final void q() {
        n nVar = this.d;
        int i = e0.a;
        for (int i2 = 0; i2 < this.c; i2++) {
            this.f941b.get(i2).a(this, nVar, this.a);
        }
        this.d = null;
    }

    public final void r(n nVar) {
        for (int i = 0; i < this.c; i++) {
            this.f941b.get(i).g(this, nVar, this.a);
        }
    }

    public final void s(n nVar) {
        this.d = nVar;
        for (int i = 0; i < this.c; i++) {
            this.f941b.get(i).b(this, nVar, this.a);
        }
    }
}
