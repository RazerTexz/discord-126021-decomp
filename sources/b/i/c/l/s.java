package b.i.c.l;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: RestrictedComponentContainer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends a {
    public final Set<Class<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Class<?>> f1671b;
    public final Set<Class<?>> c;
    public final Set<Class<?>> d;
    public final Set<Class<?>> e;
    public final e f;

    public s(d<?> dVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (o oVar : dVar.f1662b) {
            if (oVar.c == 0) {
                if (oVar.a()) {
                    hashSet3.add(oVar.a);
                } else {
                    hashSet.add(oVar.a);
                }
            } else if (oVar.a()) {
                hashSet4.add(oVar.a);
            } else {
                hashSet2.add(oVar.a);
            }
        }
        if (!dVar.f.isEmpty()) {
            hashSet.add(b.i.c.q.c.class);
        }
        this.a = Collections.unmodifiableSet(hashSet);
        this.f1671b = Collections.unmodifiableSet(hashSet2);
        this.c = Collections.unmodifiableSet(hashSet3);
        this.d = Collections.unmodifiableSet(hashSet4);
        this.e = dVar.f;
        this.f = eVar;
    }

    @Override // b.i.c.l.a, b.i.c.l.e
    public <T> T a(Class<T> cls) {
        if (!this.a.contains(cls)) {
            throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t = (T) this.f.a(cls);
        return !cls.equals(b.i.c.q.c.class) ? t : (T) new s$a(this.e, (b.i.c.q.c) t);
    }

    @Override // b.i.c.l.e
    public <T> b.i.c.t.a<T> b(Class<T> cls) {
        if (this.f1671b.contains(cls)) {
            return this.f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // b.i.c.l.e
    public <T> b.i.c.t.a<Set<T>> c(Class<T> cls) {
        if (this.d.contains(cls)) {
            return this.f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }

    @Override // b.i.c.l.a, b.i.c.l.e
    public <T> Set<T> d(Class<T> cls) {
        if (this.c.contains(cls)) {
            return this.f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }
}
