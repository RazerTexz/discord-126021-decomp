package b.i.c.l;

import b.i.c.q.Publisher;
import b.i.c.t.Provider2;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: b.i.c.l.s, reason: use source file name */
/* JADX INFO: compiled from: RestrictedComponentContainer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RestrictedComponentContainer extends AbstractComponentContainer {
    public final Set<Class<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Class<?>> f1671b;
    public final Set<Class<?>> c;
    public final Set<Class<?>> d;
    public final Set<Class<?>> e;
    public final ComponentContainer f;

    /* JADX INFO: renamed from: b.i.c.l.s$a */
    /* JADX INFO: compiled from: RestrictedComponentContainer.java */
    public static class a implements Publisher {
        public final Publisher a;

        public a(Set<Class<?>> set, Publisher publisher) {
            this.a = publisher;
        }
    }

    public RestrictedComponentContainer(Component4<?> component4, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (Dependency2 dependency2 : component4.f1662b) {
            if (dependency2.c == 0) {
                if (dependency2.a()) {
                    hashSet3.add(dependency2.a);
                } else {
                    hashSet.add(dependency2.a);
                }
            } else if (dependency2.a()) {
                hashSet4.add(dependency2.a);
            } else {
                hashSet2.add(dependency2.a);
            }
        }
        if (!component4.f.isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.a = Collections.unmodifiableSet(hashSet);
        this.f1671b = Collections.unmodifiableSet(hashSet2);
        this.c = Collections.unmodifiableSet(hashSet3);
        this.d = Collections.unmodifiableSet(hashSet4);
        this.e = component4.f;
        this.f = componentContainer;
    }

    @Override // b.i.c.l.AbstractComponentContainer, b.i.c.l.ComponentContainer
    public <T> T a(Class<T> cls) {
        if (!this.a.contains(cls)) {
            throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t = (T) this.f.a(cls);
        return !cls.equals(Publisher.class) ? t : (T) new a(this.e, (Publisher) t);
    }

    @Override // b.i.c.l.ComponentContainer
    public <T> Provider2<T> b(Class<T> cls) {
        if (this.f1671b.contains(cls)) {
            return this.f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // b.i.c.l.ComponentContainer
    public <T> Provider2<Set<T>> c(Class<T> cls) {
        if (this.d.contains(cls)) {
            return this.f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }

    @Override // b.i.c.l.AbstractComponentContainer, b.i.c.l.ComponentContainer
    public <T> Set<T> d(Class<T> cls) {
        if (this.c.contains(cls)) {
            return this.f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }
}
