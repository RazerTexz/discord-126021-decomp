package b.i.c.l;

import b.i.c.t.Provider2;
import java.util.Set;

/* JADX INFO: renamed from: b.i.c.l.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractComponentContainer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractComponentContainer implements ComponentContainer {
    @Override // b.i.c.l.ComponentContainer
    public <T> T a(Class<T> cls) {
        Provider2<T> provider2B = b(cls);
        if (provider2B == null) {
            return null;
        }
        return provider2B.get();
    }

    @Override // b.i.c.l.ComponentContainer
    public <T> Set<T> d(Class<T> cls) {
        return c(cls).get();
    }
}
