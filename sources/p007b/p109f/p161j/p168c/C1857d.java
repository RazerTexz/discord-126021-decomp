package p007b.p109f.p161j.p168c;

import java.util.LinkedHashSet;

/* JADX INFO: renamed from: b.f.j.c.d */
/* JADX INFO: compiled from: BoundedLinkedHashSet.java */
/* JADX INFO: loaded from: classes.dex */
public class C1857d<E> {

    /* JADX INFO: renamed from: a */
    public int f3656a;

    /* JADX INFO: renamed from: b */
    public LinkedHashSet<E> f3657b;

    public C1857d(int i) {
        this.f3657b = new LinkedHashSet<>(i);
        this.f3656a = i;
    }

    /* JADX INFO: renamed from: a */
    public synchronized boolean m1213a(E e) {
        if (this.f3657b.size() == this.f3656a) {
            LinkedHashSet<E> linkedHashSet = this.f3657b;
            linkedHashSet.remove(linkedHashSet.iterator().next());
        }
        this.f3657b.remove(e);
        return this.f3657b.add(e);
    }

    /* JADX INFO: renamed from: b */
    public synchronized boolean m1214b(E e) {
        return this.f3657b.contains(e);
    }
}
