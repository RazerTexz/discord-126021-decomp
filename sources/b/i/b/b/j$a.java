package b.i.b.b;

import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: ComparisonChain.java */
/* JADX INFO: loaded from: classes3.dex */
public class j$a extends j {
    public j$a() {
        super(null);
    }

    @Override // b.i.b.b.j
    public j a(int i, int i2) {
        int i3;
        if (i < i2) {
            i3 = -1;
        } else {
            i3 = i > i2 ? 1 : 0;
        }
        return f(i3);
    }

    @Override // b.i.b.b.j
    public <T> j b(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator) {
        return f(comparator.compare(t, t2));
    }

    @Override // b.i.b.b.j
    public j c(boolean z2, boolean z3) {
        int i;
        if (z2 == z3) {
            i = 0;
        } else {
            i = z2 ? 1 : -1;
        }
        return f(i);
    }

    @Override // b.i.b.b.j
    public j d(boolean z2, boolean z3) {
        int i;
        if (z3 == z2) {
            i = 0;
        } else {
            i = z3 ? 1 : -1;
        }
        return f(i);
    }

    @Override // b.i.b.b.j
    public int e() {
        return 0;
    }

    public j f(int i) {
        if (i < 0) {
            return j.f1646b;
        }
        return i > 0 ? j.c : j.a;
    }
}
