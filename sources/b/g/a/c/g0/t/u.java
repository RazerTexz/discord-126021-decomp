package b.g.a.c.g0.t;

import b.g.a.a.i0;
import b.g.a.c.x;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: WritableObjectId.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public final i0<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f713b;
    public boolean c = false;

    public u(i0<?> i0Var) {
        this.a = i0Var;
    }

    public boolean a(b.g.a.b.d dVar, x xVar, j jVar) throws IOException {
        if (this.f713b == null) {
            return false;
        }
        if (!this.c && !jVar.e) {
            return false;
        }
        Objects.requireNonNull(dVar);
        jVar.d.f(this.f713b, dVar, xVar);
        return true;
    }
}
