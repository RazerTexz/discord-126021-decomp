package b.i.a.c;

import b.i.a.c.a3.a0$a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MediaSourceList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u1$c implements t1 {
    public final b.i.a.c.a3.v a;
    public int d;
    public boolean e;
    public final List<a0$a> c = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1139b = new Object();

    public u1$c(b.i.a.c.a3.a0 a0Var, boolean z2) {
        this.a = new b.i.a.c.a3.v(a0Var, z2);
    }

    @Override // b.i.a.c.t1
    public o2 a() {
        return this.a.n;
    }

    @Override // b.i.a.c.t1
    public Object getUid() {
        return this.f1139b;
    }
}
