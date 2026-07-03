package p007b.p195g.p196a.p205c;

import java.io.IOException;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2270t;
import p007b.p195g.p196a.p205c.p219i0.AbstractC2352n;

/* JADX INFO: renamed from: b.g.a.c.n */
/* JADX INFO: compiled from: JsonSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2364n<T> {

    /* JADX INFO: renamed from: b.g.a.c.n$a */
    /* JADX INFO: compiled from: JsonSerializer.java */
    public static abstract class a extends AbstractC2364n<Object> {
    }

    /* JADX INFO: renamed from: c */
    public Class<T> mo2041c() {
        return null;
    }

    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, T t) {
        return t == null;
    }

    /* JADX INFO: renamed from: e */
    public boolean mo2058e() {
        return this instanceof C2270t;
    }

    /* JADX INFO: renamed from: f */
    public abstract void mo1807f(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException;

    /* JADX INFO: renamed from: g */
    public void mo1808g(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        Class clsMo2041c = mo2041c();
        if (clsMo2041c == null) {
            clsMo2041c = t.getClass();
        }
        abstractC2374x.mo1942f(abstractC2374x.m1938b(clsMo2041c), String.format("Type id handling not implemented for type %s (by serializer of type %s)", clsMo2041c.getName(), getClass().getName()));
        throw null;
    }

    /* JADX INFO: renamed from: h */
    public AbstractC2364n<T> mo1984h(AbstractC2352n abstractC2352n) {
        return this;
    }

    /* JADX INFO: renamed from: i */
    public boolean mo2052i() {
        return false;
    }
}
