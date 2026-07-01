package b.f.j.c;

import java.util.LinkedHashSet;

/* JADX INFO: renamed from: b.f.j.c.d, reason: use source file name */
/* JADX INFO: compiled from: BoundedLinkedHashSet.java */
/* JADX INFO: loaded from: classes.dex */
public class BoundedLinkedHashSet<E> {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedHashSet<E> f554b;

    public BoundedLinkedHashSet(int i) {
        this.f554b = new LinkedHashSet<>(i);
        this.a = i;
    }

    public synchronized boolean a(E e) {
        if (this.f554b.size() == this.a) {
            LinkedHashSet<E> linkedHashSet = this.f554b;
            linkedHashSet.remove(linkedHashSet.iterator().next());
        }
        this.f554b.remove(e);
        return this.f554b.add(e);
    }

    public synchronized boolean b(E e) {
        return this.f554b.contains(e);
    }
}
