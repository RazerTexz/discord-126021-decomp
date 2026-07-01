package b.i.a.b.j.r.a;

import c0.a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.r.a.b, reason: use source file name */
/* JADX INFO: compiled from: InstanceFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class InstanceFactory<T> implements Provider3 {
    public final T a;

    public InstanceFactory(T t) {
        this.a = t;
    }

    @Override // c0.a.Provider3
    public T get() {
        return this.a;
    }
}
