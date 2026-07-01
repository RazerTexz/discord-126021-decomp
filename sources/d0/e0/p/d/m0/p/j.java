package d0.e0.p.d.m0.p;

import d0.t.k;
import d0.t.n0;
import d0.z.d.e0;
import d0.z.d.m;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SmartSet.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j<T> extends AbstractSet<T> {
    public static final j$b j = new j$b(null);
    public Object k;
    public int l;

    public j() {
    }

    public static final <T> j<T> create() {
        return j.create();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        Object obj;
        if (size() == 0) {
            this.k = t;
        } else if (size() == 1) {
            if (m.areEqual(this.k, t)) {
                return false;
            }
            this.k = new Object[]{this.k, t};
        } else if (size() < 5) {
            Object obj2 = this.k;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr = (Object[]) obj2;
            if (k.contains(objArr, t)) {
                return false;
            }
            if (size() == 4) {
                Object[] objArr2 = new Object[objArr.length];
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                LinkedHashSet linkedHashSetLinkedSetOf = n0.linkedSetOf(objArr2);
                linkedHashSetLinkedSetOf.add(t);
                obj = linkedHashSetLinkedSetOf;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr, size() + 1);
                m.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                objArrCopyOf[objArrCopyOf.length - 1] = t;
                obj = objArrCopyOf;
            }
            this.k = obj;
        } else {
            Object obj3 = this.k;
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!e0.asMutableSet(obj3).add(t)) {
                return false;
            }
        }
        setSize(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.k = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return m.areEqual(this.k, obj);
        }
        if (size() < 5) {
            Object obj2 = this.k;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return k.contains((Object[]) obj2, obj);
        }
        Object obj3 = this.k;
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    public int getSize() {
        return this.l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new j$c(this.k);
        }
        if (size() < 5) {
            Object obj = this.k;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new j$a((Object[]) obj);
        }
        Object obj2 = this.k;
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return e0.asMutableSet(obj2).iterator();
    }

    public void setSize(int i) {
        this.l = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    public j(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
