package b.i.c.l;

import java.util.Set;

/* JADX INFO: compiled from: AbstractComponentContainer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements e {
    @Override // b.i.c.l.e
    public <T> T a(Class<T> cls) {
        b.i.c.t.a<T> aVarB = b(cls);
        if (aVarB == null) {
            return null;
        }
        return aVarB.get();
    }

    @Override // b.i.c.l.e
    public <T> Set<T> d(Class<T> cls) {
        return c(cls).get();
    }
}
