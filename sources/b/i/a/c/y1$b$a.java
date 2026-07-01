package b.i.a.c;

import b.i.a.c.f3.n$b;
import java.util.Objects;

/* JADX INFO: compiled from: Player.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y1$b$a {
    public final n$b a = new n$b();

    public y1$b$a a(y1$b y1_b) {
        n$b n_b = this.a;
        b.i.a.c.f3.n nVar = y1_b.k;
        Objects.requireNonNull(n_b);
        for (int i = 0; i < nVar.c(); i++) {
            n_b.a(nVar.b(i));
        }
        return this;
    }

    public y1$b$a b(int i, boolean z2) {
        n$b n_b = this.a;
        Objects.requireNonNull(n_b);
        if (z2) {
            b.c.a.a0.d.D(!n_b.f972b);
            n_b.a.append(i, true);
        }
        return this;
    }

    public y1$b c() {
        return new y1$b(this.a.b(), null);
    }
}
