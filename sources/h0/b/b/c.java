package h0.b.b;

import java.io.Serializable;

/* JADX INFO: compiled from: StdInstantiatorStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements a {
    @Override // h0.b.b.a
    public <T> h0.b.a.a<T> newInstantiatorOf(Class<T> cls) {
        if (b.b("Java HotSpot") || b.b("OpenJDK")) {
            if (b.d != null) {
                return Serializable.class.isAssignableFrom(cls) ? new h0.b.a.c.b(cls) : new h0.b.a.c.a(cls);
            }
            return new h0.b.a.f.a(cls);
        }
        if (!b.b("Dalvik")) {
            if (b.b("BEA")) {
                return new h0.b.a.f.a(cls);
            }
            if (b.b("GNU libgcj")) {
                return new h0.b.a.d.a(cls);
            }
            return b.b("PERC") ? new h0.b.a.e.a(cls) : new h0.b.a.f.b(cls);
        }
        if (b.c) {
            return new h0.b.a.f.b(cls);
        }
        int i = b.f3734b;
        if (i <= 10) {
            return new h0.b.a.b.a(cls);
        }
        return i <= 17 ? new h0.b.a.b.b(cls) : new h0.b.a.b.c(cls);
    }
}
