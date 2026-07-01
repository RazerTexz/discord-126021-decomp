package b.i.b.b;

import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.i.b.b.h, reason: use source file name */
/* JADX INFO: compiled from: Collections2.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Collections2 {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: b.i.b.b.h$a */
    /* JADX INFO: compiled from: Sets.java */
    public static class a<E> extends Sets4<E> {
        public final /* synthetic */ Set j;
        public final /* synthetic */ Set k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.j = set;
            this.k = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.j.contains(obj) && this.k.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.j.containsAll(collection) && this.k.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.k, this.j);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new Sets2(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.j.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.k.contains(it.next())) {
                    i++;
                }
            }
            return i;
        }
    }

    public static int a(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static <E> Sets4<E> b(Set<E> set, Set<?> set2) {
        Objects.requireNonNull(set, "set1");
        Objects.requireNonNull(set2, "set2");
        return new a(set, set2);
    }

    public static <E> Set<E> c() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    public static boolean d(Set<?> set, Iterator<?> it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }
}
