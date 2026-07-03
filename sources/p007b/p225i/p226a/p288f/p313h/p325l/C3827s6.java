package p007b.p225i.p226a.p288f.p313h.p325l;

import com.google.android.gms.internal.measurement.zzhi;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/* JADX INFO: renamed from: b.i.a.f.h.l.s6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3827s6 {

    /* JADX INFO: renamed from: a */
    public static final Class<?> f10313a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3627d7<?, ?> f10314b;

    /* JADX INFO: renamed from: c */
    public static final AbstractC3627d7<?, ?> f10315c;

    /* JADX INFO: renamed from: d */
    public static final AbstractC3627d7<?, ?> f10316d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f10313a = cls;
        f10314b = m5239e(false);
        f10315c = m5239e(true);
        f10316d = new C3655f7();
    }

    /* JADX INFO: renamed from: A */
    public static void m5217A(int i, List<Long> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9087g(i, zzhi.m9065R(list.get(i2).longValue()));
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int iM9058K = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM9058K += zzhi.m9058K(list.get(i3).longValue());
        }
        c3666g4.f9967a.mo9094r(iM9058K);
        while (i2 < list.size()) {
            c3666g4.f9967a.mo9093m(zzhi.m9065R(list.get(i2).longValue()));
            i2++;
        }
    }

    /* JADX INFO: renamed from: B */
    public static int m5218B(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.m9052D(i) * size) + m5219C(list);
    }

    /* JADX INFO: renamed from: C */
    public static int m5219C(List<Integer> list) {
        int iM9059L;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3890x4) {
            C3890x4 c3890x4 = (C3890x4) list;
            iM9059L = 0;
            while (i < size) {
                iM9059L += zzhi.m9059L(c3890x4.m5357e(i));
                i++;
            }
        } else {
            iM9059L = 0;
            while (i < size) {
                iM9059L += zzhi.m9059L(list.get(i).intValue());
                i++;
            }
        }
        return iM9059L;
    }

    /* JADX INFO: renamed from: D */
    public static void m5220D(int i, List<Long> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9098z(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).longValue();
            Logger logger = zzhi.f20628a;
            i3 += 8;
        }
        c3666g4.f9967a.mo9094r(i3);
        while (i2 < list.size()) {
            c3666g4.f9967a.mo9080A(list.get(i2).longValue());
            i2++;
        }
    }

    /* JADX INFO: renamed from: E */
    public static int m5221E(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.m9052D(i) * size) + m5222F(list);
    }

    /* JADX INFO: renamed from: F */
    public static int m5222F(List<Integer> list) {
        int iM9062O;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3890x4) {
            C3890x4 c3890x4 = (C3890x4) list;
            iM9062O = 0;
            while (i < size) {
                iM9062O += zzhi.m9062O(c3890x4.m5357e(i));
                i++;
            }
        } else {
            iM9062O = 0;
            while (i < size) {
                iM9062O += zzhi.m9062O(list.get(i).intValue());
                i++;
            }
        }
        return iM9062O;
    }

    /* JADX INFO: renamed from: G */
    public static void m5223G(int i, List<Long> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9098z(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).longValue();
            Logger logger = zzhi.f20628a;
            i3 += 8;
        }
        c3666g4.f9967a.mo9094r(i3);
        while (i2 < list.size()) {
            c3666g4.f9967a.mo9080A(list.get(i2).longValue());
            i2++;
        }
    }

    /* JADX INFO: renamed from: H */
    public static int m5224H(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzhi.m9066S(i) * size;
    }

    /* JADX INFO: renamed from: I */
    public static int m5225I(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: renamed from: J */
    public static void m5226J(int i, List<Integer> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9095s(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int iM9055H = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM9055H += zzhi.m9055H(list.get(i3).intValue());
        }
        c3666g4.f9967a.mo9094r(iM9055H);
        while (i2 < list.size()) {
            c3666g4.f9967a.mo9085e(list.get(i2).intValue());
            i2++;
        }
    }

    /* JADX INFO: renamed from: K */
    public static int m5227K(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzhi.m9061N(i) * size;
    }

    /* JADX INFO: renamed from: L */
    public static int m5228L(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: renamed from: M */
    public static void m5229M(int i, List<Integer> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9097y(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int iM9059L = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM9059L += zzhi.m9059L(list.get(i3).intValue());
        }
        c3666g4.f9967a.mo9094r(iM9059L);
        while (i2 < list.size()) {
            c3666g4.f9967a.mo9094r(list.get(i2).intValue());
            i2++;
        }
    }

    /* JADX INFO: renamed from: N */
    public static void m5230N(int i, List<Integer> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9097y(i, zzhi.m9069V(list.get(i2).intValue()));
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int iM9062O = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM9062O += zzhi.m9062O(list.get(i3).intValue());
        }
        c3666g4.f9967a.mo9094r(iM9062O);
        while (i2 < list.size()) {
            c3666g4.f9967a.mo9094r(zzhi.m9069V(list.get(i2).intValue()));
            i2++;
        }
    }

    /* JADX INFO: renamed from: O */
    public static void m5231O(int i, List<Integer> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9082G(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).intValue();
            Logger logger = zzhi.f20628a;
            i3 += 4;
        }
        c3666g4.f9967a.mo9094r(i3);
        while (i2 < list.size()) {
            c3666g4.f9967a.mo9081C(list.get(i2).intValue());
            i2++;
        }
    }

    /* JADX INFO: renamed from: P */
    public static void m5232P(int i, List<Integer> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9082G(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).intValue();
            Logger logger = zzhi.f20628a;
            i3 += 4;
        }
        c3666g4.f9967a.mo9094r(i3);
        while (i2 < list.size()) {
            c3666g4.f9967a.mo9081C(list.get(i2).intValue());
            i2++;
        }
    }

    /* JADX INFO: renamed from: Q */
    public static void m5233Q(int i, List<Integer> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9095s(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int iM9055H = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM9055H += zzhi.m9055H(list.get(i3).intValue());
        }
        c3666g4.f9967a.mo9094r(iM9055H);
        while (i2 < list.size()) {
            c3666g4.f9967a.mo9085e(list.get(i2).intValue());
            i2++;
        }
    }

    /* JADX INFO: renamed from: R */
    public static void m5234R(int i, List<Boolean> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9092l(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).booleanValue();
            Logger logger = zzhi.f20628a;
            i3++;
        }
        c3666g4.f9967a.mo9094r(i3);
        while (i2 < list.size()) {
            c3666g4.f9967a.mo9084d(list.get(i2).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m5235a(int i, Object obj, InterfaceC3801q6 interfaceC3801q6) {
        if (!(obj instanceof C3681h5)) {
            return zzhi.m9071c((InterfaceC3612c6) obj, interfaceC3801q6) + zzhi.m9059L(i << 3);
        }
        int iM9059L = zzhi.m9059L(i << 3);
        int iM4934a = ((C3681h5) obj).m4934a();
        return zzhi.m9059L(iM4934a) + iM4934a + iM9059L;
    }

    /* JADX INFO: renamed from: b */
    public static int m5236b(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iM9052D = zzhi.m9052D(i) * size;
        if (list instanceof InterfaceC3709j5) {
            InterfaceC3709j5 interfaceC3709j5 = (InterfaceC3709j5) list;
            while (i2 < size) {
                Object objMo4863A = interfaceC3709j5.mo4863A(i2);
                iM9052D = (objMo4863A instanceof AbstractC3837t3 ? zzhi.m9074p((AbstractC3837t3) objMo4863A) : zzhi.m9075q((String) objMo4863A)) + iM9052D;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iM9052D = (obj instanceof AbstractC3837t3 ? zzhi.m9074p((AbstractC3837t3) obj) : zzhi.m9075q((String) obj)) + iM9052D;
                i2++;
            }
        }
        return iM9052D;
    }

    /* JADX INFO: renamed from: c */
    public static int m5237c(int i, List<?> list, InterfaceC3801q6 interfaceC3801q6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM9052D = zzhi.m9052D(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            iM9052D += obj instanceof C3681h5 ? zzhi.m9070b((C3681h5) obj) : zzhi.m9071c((InterfaceC3612c6) obj, interfaceC3801q6);
        }
        return iM9052D;
    }

    /* JADX INFO: renamed from: d */
    public static int m5238d(List<Long> list) {
        int iM9054F;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3800q5) {
            C3800q5 c3800q5 = (C3800q5) list;
            iM9054F = 0;
            while (i < size) {
                iM9054F += zzhi.m9054F(c3800q5.m5187e(i));
                i++;
            }
        } else {
            iM9054F = 0;
            while (i < size) {
                iM9054F += zzhi.m9054F(list.get(i).longValue());
                i++;
            }
        }
        return iM9054F;
    }

    /* JADX INFO: renamed from: e */
    public static AbstractC3627d7<?, ?> m5239e(boolean z2) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (AbstractC3627d7) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z2));
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m5240f(int i, List<String> list, InterfaceC3867v7 interfaceC3867v7) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!(list instanceof InterfaceC3709j5)) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9091k(i, list.get(i2));
                i2++;
            }
            return;
        }
        InterfaceC3709j5 interfaceC3709j5 = (InterfaceC3709j5) list;
        while (i2 < list.size()) {
            Object objMo4863A = interfaceC3709j5.mo4863A(i2);
            if (objMo4863A instanceof String) {
                c3666g4.f9967a.mo9091k(i, (String) objMo4863A);
            } else {
                c3666g4.f9967a.mo9088h(i, (AbstractC3837t3) objMo4863A);
            }
            i2++;
        }
    }

    /* JADX INFO: renamed from: g */
    public static void m5241g(int i, List<?> list, InterfaceC3867v7 interfaceC3867v7, InterfaceC3801q6 interfaceC3801q6) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        for (int i2 = 0; i2 < list.size(); i2++) {
            c3666g4.f9967a.mo9090j(i, (InterfaceC3612c6) list.get(i2), interfaceC3801q6);
        }
    }

    /* JADX INFO: renamed from: h */
    public static void m5242h(int i, List<Double> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                zzhi zzhiVar = c3666g4.f9967a;
                double dDoubleValue = list.get(i2).doubleValue();
                Objects.requireNonNull(zzhiVar);
                zzhiVar.mo9098z(i, Double.doubleToRawLongBits(dDoubleValue));
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).doubleValue();
            Logger logger = zzhi.f20628a;
            i3 += 8;
        }
        c3666g4.f9967a.mo9094r(i3);
        while (i2 < list.size()) {
            zzhi zzhiVar2 = c3666g4.f9967a;
            double dDoubleValue2 = list.get(i2).doubleValue();
            Objects.requireNonNull(zzhiVar2);
            zzhiVar2.mo9080A(Double.doubleToRawLongBits(dDoubleValue2));
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: i */
    public static <T, FT extends InterfaceC3786p4<FT>> void m5243i(AbstractC3708j4<FT> abstractC3708j4, T t, T t2) {
        C3760n4<T> c3760n4Mo4970b = abstractC3708j4.mo4970b(t2);
        if (c3760n4Mo4970b.f10111b.isEmpty()) {
            return;
        }
        C3760n4<T> c3760n4Mo4974f = abstractC3708j4.mo4974f(t);
        Objects.requireNonNull(c3760n4Mo4974f);
        for (int i = 0; i < c3760n4Mo4970b.f10111b.m5207e(); i++) {
            c3760n4Mo4974f.m5134j(c3760n4Mo4970b.f10111b.m5206d(i));
        }
        Iterator<T> it = c3760n4Mo4970b.f10111b.m5209g().iterator();
        while (it.hasNext()) {
            c3760n4Mo4974f.m5134j((Map.Entry) it.next());
        }
    }

    /* JADX INFO: renamed from: j */
    public static boolean m5244j(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: renamed from: k */
    public static int m5245k(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzhi.m9052D(i) * list.size()) + m5238d(list);
    }

    /* JADX INFO: renamed from: l */
    public static int m5246l(int i, List<AbstractC3837t3> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM9052D = zzhi.m9052D(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            iM9052D += zzhi.m9074p(list.get(i2));
        }
        return iM9052D;
    }

    /* JADX INFO: renamed from: m */
    public static int m5247m(int i, List<InterfaceC3612c6> list, InterfaceC3801q6 interfaceC3801q6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM9079x = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iM9079x += zzhi.m9079x(i, list.get(i2), interfaceC3801q6);
        }
        return iM9079x;
    }

    /* JADX INFO: renamed from: n */
    public static int m5248n(List<Long> list) {
        int iM9054F;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3800q5) {
            C3800q5 c3800q5 = (C3800q5) list;
            iM9054F = 0;
            while (i < size) {
                iM9054F += zzhi.m9054F(c3800q5.m5187e(i));
                i++;
            }
        } else {
            iM9054F = 0;
            while (i < size) {
                iM9054F += zzhi.m9054F(list.get(i).longValue());
                i++;
            }
        }
        return iM9054F;
    }

    /* JADX INFO: renamed from: o */
    public static void m5249o(int i, List<AbstractC3837t3> list, InterfaceC3867v7 interfaceC3867v7) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        for (int i2 = 0; i2 < list.size(); i2++) {
            c3666g4.f9967a.mo9088h(i, list.get(i2));
        }
    }

    /* JADX INFO: renamed from: p */
    public static void m5250p(int i, List<?> list, InterfaceC3867v7 interfaceC3867v7, InterfaceC3801q6 interfaceC3801q6) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        for (int i2 = 0; i2 < list.size(); i2++) {
            c3666g4.m4913e(i, list.get(i2), interfaceC3801q6);
        }
    }

    /* JADX INFO: renamed from: q */
    public static void m5251q(int i, List<Float> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                zzhi zzhiVar = c3666g4.f9967a;
                float fFloatValue = list.get(i2).floatValue();
                Objects.requireNonNull(zzhiVar);
                zzhiVar.mo9082G(i, Float.floatToRawIntBits(fFloatValue));
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).floatValue();
            Logger logger = zzhi.f20628a;
            i3 += 4;
        }
        c3666g4.f9967a.mo9094r(i3);
        while (i2 < list.size()) {
            zzhi zzhiVar2 = c3666g4.f9967a;
            float fFloatValue2 = list.get(i2).floatValue();
            Objects.requireNonNull(zzhiVar2);
            zzhiVar2.mo9081C(Float.floatToRawIntBits(fFloatValue2));
            i2++;
        }
    }

    /* JADX INFO: renamed from: r */
    public static int m5252r(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.m9052D(i) * size) + m5248n(list);
    }

    /* JADX INFO: renamed from: s */
    public static int m5253s(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.m9052D(i) * size) + m5254t(list);
    }

    /* JADX INFO: renamed from: t */
    public static int m5254t(List<Long> list) {
        int iM9058K;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3800q5) {
            C3800q5 c3800q5 = (C3800q5) list;
            iM9058K = 0;
            while (i < size) {
                iM9058K += zzhi.m9058K(c3800q5.m5187e(i));
                i++;
            }
        } else {
            iM9058K = 0;
            while (i < size) {
                iM9058K += zzhi.m9058K(list.get(i).longValue());
                i++;
            }
        }
        return iM9058K;
    }

    /* JADX INFO: renamed from: u */
    public static void m5255u(int i, List<Long> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9087g(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int iM9054F = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM9054F += zzhi.m9054F(list.get(i3).longValue());
        }
        c3666g4.f9967a.mo9094r(iM9054F);
        while (i2 < list.size()) {
            c3666g4.f9967a.mo9093m(list.get(i2).longValue());
            i2++;
        }
    }

    /* JADX INFO: renamed from: v */
    public static int m5256v(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.m9052D(i) * size) + m5257w(list);
    }

    /* JADX INFO: renamed from: w */
    public static int m5257w(List<Integer> list) {
        int iM9055H;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3890x4) {
            C3890x4 c3890x4 = (C3890x4) list;
            iM9055H = 0;
            while (i < size) {
                iM9055H += zzhi.m9055H(c3890x4.m5357e(i));
                i++;
            }
        } else {
            iM9055H = 0;
            while (i < size) {
                iM9055H += zzhi.m9055H(list.get(i).intValue());
                i++;
            }
        }
        return iM9055H;
    }

    /* JADX INFO: renamed from: x */
    public static void m5258x(int i, List<Long> list, InterfaceC3867v7 interfaceC3867v7, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
        Objects.requireNonNull(c3666g4);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                c3666g4.f9967a.mo9087g(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        c3666g4.f9967a.mo9086f(i, 2);
        int iM9054F = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM9054F += zzhi.m9054F(list.get(i3).longValue());
        }
        c3666g4.f9967a.mo9094r(iM9054F);
        while (i2 < list.size()) {
            c3666g4.f9967a.mo9093m(list.get(i2).longValue());
            i2++;
        }
    }

    /* JADX INFO: renamed from: y */
    public static int m5259y(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.m9052D(i) * size) + m5260z(list);
    }

    /* JADX INFO: renamed from: z */
    public static int m5260z(List<Integer> list) {
        int iM9055H;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3890x4) {
            C3890x4 c3890x4 = (C3890x4) list;
            iM9055H = 0;
            while (i < size) {
                iM9055H += zzhi.m9055H(c3890x4.m5357e(i));
                i++;
            }
        } else {
            iM9055H = 0;
            while (i < size) {
                iM9055H += zzhi.m9055H(list.get(i).intValue());
                i++;
            }
        }
        return iM9055H;
    }
}
