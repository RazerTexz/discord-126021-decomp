package b.i.a.c.f3;

import android.os.Bundle;
import androidx.annotation.Nullable;
import b.i.a.c.Bundleable;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableCollection;
import b.i.b.b.ImmutableList2;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.f3.f, reason: use source file name */
/* JADX INFO: compiled from: BundleableUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BundleableUtil {
    public static <T extends Bundleable> ImmutableList2<T> a(Bundleable.a<T> aVar, List<Bundle> list) {
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
        b.i.a.f.e.o.f.A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Bundle bundle = list.get(i);
            Objects.requireNonNull(bundle);
            Bundleable bundleableA = aVar.a(bundle);
            Objects.requireNonNull(bundleableA);
            int i3 = i2 + 1;
            if (objArrCopyOf.length < i3) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.a(objArrCopyOf.length, i3));
            }
            objArrCopyOf[i2] = bundleableA;
            i++;
            i2 = i3;
        }
        return ImmutableList2.l(objArrCopyOf, i2);
    }

    public static <T extends Bundleable> List<T> b(Bundleable.a<T> aVar, @Nullable List<Bundle> list, List<T> list2) {
        return list == null ? list2 : a(aVar, list);
    }

    @Nullable
    public static <T extends Bundleable> T c(Bundleable.a<T> aVar, @Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return (T) aVar.a(bundle);
    }
}
