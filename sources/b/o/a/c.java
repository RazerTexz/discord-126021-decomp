package b.o.a;

import androidx.annotation.NonNull;
import b.o.a.m.m;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: CameraOptions.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public Set<m> a = new HashSet(5);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<b.o.a.m.e> f1911b = new HashSet(2);
    public Set<b.o.a.m.f> c = new HashSet(4);
    public Set<b.o.a.m.h> d = new HashSet(2);
    public Set<b.o.a.x.b> e = new HashSet(15);
    public Set<b.o.a.x.b> f = new HashSet(5);
    public Set<b.o.a.x.a> g = new HashSet(4);
    public Set<b.o.a.x.a> h = new HashSet(3);
    public Set<b.o.a.m.j> i = new HashSet(2);
    public Set<Integer> j = new HashSet(2);
    public boolean k;
    public boolean l;
    public float m;
    public float n;
    public boolean o;
    public float p;
    public float q;

    @NonNull
    public final Collection<b.o.a.m.e> a() {
        return Collections.unmodifiableSet(this.f1911b);
    }

    @NonNull
    public final Collection<b.o.a.m.f> b() {
        return Collections.unmodifiableSet(this.c);
    }

    public final boolean c(@NonNull b.o.a.m.c cVar) {
        Collection collectionUnmodifiableSet;
        Class<?> cls = cVar.getClass();
        if (cls.equals(b.o.a.m.a.class)) {
            collectionUnmodifiableSet = Arrays.asList(b.o.a.m.a.values());
        } else if (cls.equals(b.o.a.m.e.class)) {
            collectionUnmodifiableSet = a();
        } else if (cls.equals(b.o.a.m.f.class)) {
            collectionUnmodifiableSet = b();
        } else if (cls.equals(b.o.a.m.g.class)) {
            collectionUnmodifiableSet = Arrays.asList(b.o.a.m.g.values());
        } else if (cls.equals(b.o.a.m.h.class)) {
            collectionUnmodifiableSet = Collections.unmodifiableSet(this.d);
        } else if (cls.equals(b.o.a.m.i.class)) {
            collectionUnmodifiableSet = Arrays.asList(b.o.a.m.i.values());
        } else if (cls.equals(b.o.a.m.l.class)) {
            collectionUnmodifiableSet = Arrays.asList(b.o.a.m.l.values());
        } else if (cls.equals(b.o.a.m.b.class)) {
            collectionUnmodifiableSet = Arrays.asList(b.o.a.m.b.values());
        } else if (cls.equals(m.class)) {
            collectionUnmodifiableSet = Collections.unmodifiableSet(this.a);
        } else if (cls.equals(b.o.a.m.d.class)) {
            collectionUnmodifiableSet = Arrays.asList(b.o.a.m.d.values());
        } else if (cls.equals(b.o.a.m.k.class)) {
            collectionUnmodifiableSet = Arrays.asList(b.o.a.m.k.values());
        } else {
            collectionUnmodifiableSet = cls.equals(b.o.a.m.j.class) ? Collections.unmodifiableSet(this.i) : Collections.emptyList();
        }
        return collectionUnmodifiableSet.contains(cVar);
    }
}
