package p007b.p225i.p361c.p368l;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p007b.p225i.p361c.p396q.InterfaceC4798c;
import p007b.p225i.p361c.p400t.InterfaceC4836a;

/* JADX INFO: renamed from: b.i.c.l.s */
/* JADX INFO: compiled from: RestrictedComponentContainer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4587s extends AbstractC4569a {

    /* JADX INFO: renamed from: a */
    public final Set<Class<?>> f12212a;

    /* JADX INFO: renamed from: b */
    public final Set<Class<?>> f12213b;

    /* JADX INFO: renamed from: c */
    public final Set<Class<?>> f12214c;

    /* JADX INFO: renamed from: d */
    public final Set<Class<?>> f12215d;

    /* JADX INFO: renamed from: e */
    public final Set<Class<?>> f12216e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC4573e f12217f;

    /* JADX INFO: renamed from: b.i.c.l.s$a */
    /* JADX INFO: compiled from: RestrictedComponentContainer.java */
    public static class a implements InterfaceC4798c {

        /* JADX INFO: renamed from: a */
        public final InterfaceC4798c f12218a;

        public a(Set<Class<?>> set, InterfaceC4798c interfaceC4798c) {
            this.f12218a = interfaceC4798c;
        }
    }

    public C4587s(C4572d<?> c4572d, InterfaceC4573e interfaceC4573e) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (C4583o c4583o : c4572d.f12176b) {
            if (c4583o.f12203c == 0) {
                if (c4583o.m6358a()) {
                    hashSet3.add(c4583o.f12201a);
                } else {
                    hashSet.add(c4583o.f12201a);
                }
            } else if (c4583o.m6358a()) {
                hashSet4.add(c4583o.f12201a);
            } else {
                hashSet2.add(c4583o.f12201a);
            }
        }
        if (!c4572d.f12180f.isEmpty()) {
            hashSet.add(InterfaceC4798c.class);
        }
        this.f12212a = Collections.unmodifiableSet(hashSet);
        this.f12213b = Collections.unmodifiableSet(hashSet2);
        this.f12214c = Collections.unmodifiableSet(hashSet3);
        this.f12215d = Collections.unmodifiableSet(hashSet4);
        this.f12216e = c4572d.f12180f;
        this.f12217f = interfaceC4573e;
    }

    @Override // p007b.p225i.p361c.p368l.AbstractC4569a, p007b.p225i.p361c.p368l.InterfaceC4573e
    /* JADX INFO: renamed from: a */
    public <T> T mo6346a(Class<T> cls) {
        if (!this.f12212a.contains(cls)) {
            throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t = (T) this.f12217f.mo6346a(cls);
        return !cls.equals(InterfaceC4798c.class) ? t : (T) new a(this.f12216e, (InterfaceC4798c) t);
    }

    @Override // p007b.p225i.p361c.p368l.InterfaceC4573e
    /* JADX INFO: renamed from: b */
    public <T> InterfaceC4836a<T> mo6355b(Class<T> cls) {
        if (this.f12213b.contains(cls)) {
            return this.f12217f.mo6355b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // p007b.p225i.p361c.p368l.InterfaceC4573e
    /* JADX INFO: renamed from: c */
    public <T> InterfaceC4836a<Set<T>> mo6356c(Class<T> cls) {
        if (this.f12215d.contains(cls)) {
            return this.f12217f.mo6356c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }

    @Override // p007b.p225i.p361c.p368l.AbstractC4569a, p007b.p225i.p361c.p368l.InterfaceC4573e
    /* JADX INFO: renamed from: d */
    public <T> Set<T> mo6347d(Class<T> cls) {
        if (this.f12214c.contains(cls)) {
            return this.f12217f.mo6347d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }
}
