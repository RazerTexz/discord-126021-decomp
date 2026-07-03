package p007b.p225i.p226a.p242c.p259f3;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4519n;
import p007b.p225i.p355b.p357b.AbstractC4523p;

/* JADX INFO: renamed from: b.i.a.c.f3.f */
/* JADX INFO: compiled from: BundleableUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2739f {
    /* JADX INFO: renamed from: a */
    public static <T extends InterfaceC2963w0> AbstractC4523p<T> m3019a(InterfaceC2963w0.a<T> aVar, List<Bundle> list) {
        AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
        C3404f.m4189A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Bundle bundle = list.get(i);
            Objects.requireNonNull(bundle);
            InterfaceC2963w0 interfaceC2963w0Mo2576a = aVar.mo2576a(bundle);
            Objects.requireNonNull(interfaceC2963w0Mo2576a);
            int i3 = i2 + 1;
            if (objArrCopyOf.length < i3) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, AbstractC4519n.b.m6260a(objArrCopyOf.length, i3));
            }
            objArrCopyOf[i2] = interfaceC2963w0Mo2576a;
            i++;
            i2 = i3;
        }
        return AbstractC4523p.m6262l(objArrCopyOf, i2);
    }

    /* JADX INFO: renamed from: b */
    public static <T extends InterfaceC2963w0> List<T> m3020b(InterfaceC2963w0.a<T> aVar, @Nullable List<Bundle> list, List<T> list2) {
        return list == null ? list2 : m3019a(aVar, list);
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public static <T extends InterfaceC2963w0> T m3021c(InterfaceC2963w0.a<T> aVar, @Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return (T) aVar.mo2576a(bundle);
    }
}
