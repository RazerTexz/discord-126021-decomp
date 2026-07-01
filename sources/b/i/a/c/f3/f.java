package b.i.a.c.f3;

import android.os.Bundle;
import androidx.annotation.Nullable;
import b.i.a.c.w0;
import b.i.a.c.w0$a;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: BundleableUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static <T extends w0> b.i.b.b.p<T> a(w0$a<T> w0_a, List<Bundle> list) {
        b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
        b.i.a.f.e.o.f.A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Bundle bundle = list.get(i);
            Objects.requireNonNull(bundle);
            w0 w0VarA = w0_a.a(bundle);
            Objects.requireNonNull(w0VarA);
            int i3 = i2 + 1;
            if (objArrCopyOf.length < i3) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, b.i.b.b.n$b.a(objArrCopyOf.length, i3));
            }
            objArrCopyOf[i2] = w0VarA;
            i++;
            i2 = i3;
        }
        return b.i.b.b.p.l(objArrCopyOf, i2);
    }

    public static <T extends w0> List<T> b(w0$a<T> w0_a, @Nullable List<Bundle> list, List<T> list2) {
        return list == null ? list2 : a(w0_a, list);
    }

    @Nullable
    public static <T extends w0> T c(w0$a<T> w0_a, @Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return (T) w0_a.a(bundle);
    }
}
