package d0.t;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AbstractList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a {
    public c$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final void checkElementIndex$kotlin_stdlib(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(b.d.b.a.a.s("index: ", i, ", size: ", i2));
        }
    }

    public final void checkPositionIndex$kotlin_stdlib(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(b.d.b.a.a.s("index: ", i, ", size: ", i2));
        }
    }

    public final void checkRangeIndexes$kotlin_stdlib(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            StringBuilder sbW = b.d.b.a.a.W("fromIndex: ", i, ", toIndex: ", i2, ", size: ");
            sbW.append(i3);
            throw new IndexOutOfBoundsException(sbW.toString());
        }
        if (i > i2) {
            throw new IllegalArgumentException(b.d.b.a.a.s("fromIndex: ", i, " > toIndex: ", i2));
        }
    }

    public final boolean orderedEquals$kotlin_stdlib(Collection<?> collection, Collection<?> collection2) {
        d0.z.d.m.checkNotNullParameter(collection, "c");
        d0.z.d.m.checkNotNullParameter(collection2, "other");
        if (collection.size() != collection2.size()) {
            return false;
        }
        Iterator<?> it = collection2.iterator();
        Iterator<?> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!d0.z.d.m.areEqual(it2.next(), it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int orderedHashCode$kotlin_stdlib(Collection<?> collection) {
        d0.z.d.m.checkNotNullParameter(collection, "c");
        Iterator<?> it = collection.iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }
}
