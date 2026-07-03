package p507d0.p513e0.p514p.p515d.p517m0.p576p;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.C12219c;
import p507d0.p592z.p594d.C12224e0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.j */
/* JADX INFO: compiled from: SmartSet.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12042j<T> extends AbstractSet<T> {

    /* JADX INFO: renamed from: j */
    public static final b f25003j = new b(null);

    /* JADX INFO: renamed from: k */
    public Object f25004k;

    /* JADX INFO: renamed from: l */
    public int f25005l;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.j$a */
    /* JADX INFO: compiled from: SmartSet.kt */
    public static final class a<T> implements Iterator<T>, InterfaceC12228a {

        /* JADX INFO: renamed from: j */
        public final Iterator<T> f25006j;

        public a(T[] tArr) {
            C12238m.checkNotNullParameter(tArr, "array");
            this.f25006j = C12219c.iterator(tArr);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25006j.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f25006j.next();
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.j$b */
    /* JADX INFO: compiled from: SmartSet.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T> C12042j<T> create() {
            return new C12042j<>(null);
        }

        public final <T> C12042j<T> create(Collection<? extends T> collection) {
            C12238m.checkNotNullParameter(collection, "set");
            C12042j<T> c12042j = new C12042j<>(null);
            c12042j.addAll(collection);
            return c12042j;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.j$c */
    /* JADX INFO: compiled from: SmartSet.kt */
    public static final class c<T> implements Iterator<T>, InterfaceC12228a {

        /* JADX INFO: renamed from: j */
        public final T f25007j;

        /* JADX INFO: renamed from: k */
        public boolean f25008k = true;

        public c(T t) {
            this.f25007j = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25008k;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f25008k) {
                throw new NoSuchElementException();
            }
            this.f25008k = false;
            return this.f25007j;
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public C12042j() {
    }

    public static final <T> C12042j<T> create() {
        return f25003j.create();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        Object obj;
        if (size() == 0) {
            this.f25004k = t;
        } else if (size() == 1) {
            if (C12238m.areEqual(this.f25004k, t)) {
                return false;
            }
            this.f25004k = new Object[]{this.f25004k, t};
        } else if (size() < 5) {
            Object obj2 = this.f25004k;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr = (Object[]) obj2;
            if (C12141k.contains(objArr, t)) {
                return false;
            }
            if (size() == 4) {
                Object[] objArr2 = new Object[objArr.length];
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                LinkedHashSet linkedHashSetLinkedSetOf = C12148n0.linkedSetOf(objArr2);
                linkedHashSetLinkedSetOf.add(t);
                obj = linkedHashSetLinkedSetOf;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr, size() + 1);
                C12238m.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                objArrCopyOf[objArrCopyOf.length - 1] = t;
                obj = objArrCopyOf;
            }
            this.f25004k = obj;
        } else {
            Object obj3 = this.f25004k;
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!C12224e0.asMutableSet(obj3).add(t)) {
                return false;
            }
        }
        setSize(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f25004k = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return C12238m.areEqual(this.f25004k, obj);
        }
        if (size() < 5) {
            Object obj2 = this.f25004k;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return C12141k.contains((Object[]) obj2, obj);
        }
        Object obj3 = this.f25004k;
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    public int getSize() {
        return this.f25005l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new c(this.f25004k);
        }
        if (size() < 5) {
            Object obj = this.f25004k;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new a((Object[]) obj);
        }
        Object obj2 = this.f25004k;
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return C12224e0.asMutableSet(obj2).iterator();
    }

    public void setSize(int i) {
        this.f25005l = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    public C12042j(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
