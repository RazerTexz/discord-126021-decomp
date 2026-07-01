package b.i.a.f.h.l;

import com.google.android.gms.internal.measurement.zzhi;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s6 {
    public static final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d7<?, ?> f1495b;
    public static final d7<?, ?> c;
    public static final d7<?, ?> d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        f1495b = e(false);
        c = e(true);
        d = new f7();
    }

    public static void A(int i, List<Long> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                g4Var.a.g(i, zzhi.R(list.get(i2).longValue()));
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int iK = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iK += zzhi.K(list.get(i3).longValue());
        }
        g4Var.a.r(iK);
        while (i2 < list.size()) {
            g4Var.a.m(zzhi.R(list.get(i2).longValue()));
            i2++;
        }
    }

    public static int B(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.D(i) * size) + C(list);
    }

    public static int C(List<Integer> list) {
        int iL;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof x4) {
            x4 x4Var = (x4) list;
            iL = 0;
            while (i < size) {
                iL += zzhi.L(x4Var.e(i));
                i++;
            }
        } else {
            iL = 0;
            while (i < size) {
                iL += zzhi.L(list.get(i).intValue());
                i++;
            }
        }
        return iL;
    }

    public static void D(int i, List<Long> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                g4Var.a.z(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).longValue();
            Logger logger = zzhi.a;
            i3 += 8;
        }
        g4Var.a.r(i3);
        while (i2 < list.size()) {
            g4Var.a.A(list.get(i2).longValue());
            i2++;
        }
    }

    public static int E(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.D(i) * size) + F(list);
    }

    public static int F(List<Integer> list) {
        int iO;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof x4) {
            x4 x4Var = (x4) list;
            iO = 0;
            while (i < size) {
                iO += zzhi.O(x4Var.e(i));
                i++;
            }
        } else {
            iO = 0;
            while (i < size) {
                iO += zzhi.O(list.get(i).intValue());
                i++;
            }
        }
        return iO;
    }

    public static void G(int i, List<Long> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                g4Var.a.z(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).longValue();
            Logger logger = zzhi.a;
            i3 += 8;
        }
        g4Var.a.r(i3);
        while (i2 < list.size()) {
            g4Var.a.A(list.get(i2).longValue());
            i2++;
        }
    }

    public static int H(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzhi.S(i) * size;
    }

    public static int I(List<?> list) {
        return list.size() << 2;
    }

    public static void J(int i, List<Integer> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                g4Var.a.s(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int iH = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iH += zzhi.H(list.get(i3).intValue());
        }
        g4Var.a.r(iH);
        while (i2 < list.size()) {
            g4Var.a.e(list.get(i2).intValue());
            i2++;
        }
    }

    public static int K(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzhi.N(i) * size;
    }

    public static int L(List<?> list) {
        return list.size() << 3;
    }

    public static void M(int i, List<Integer> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                g4Var.a.y(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int iL = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iL += zzhi.L(list.get(i3).intValue());
        }
        g4Var.a.r(iL);
        while (i2 < list.size()) {
            g4Var.a.r(list.get(i2).intValue());
            i2++;
        }
    }

    public static void N(int i, List<Integer> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                g4Var.a.y(i, zzhi.V(list.get(i2).intValue()));
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int iO = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iO += zzhi.O(list.get(i3).intValue());
        }
        g4Var.a.r(iO);
        while (i2 < list.size()) {
            g4Var.a.r(zzhi.V(list.get(i2).intValue()));
            i2++;
        }
    }

    public static void O(int i, List<Integer> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                g4Var.a.G(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).intValue();
            Logger logger = zzhi.a;
            i3 += 4;
        }
        g4Var.a.r(i3);
        while (i2 < list.size()) {
            g4Var.a.C(list.get(i2).intValue());
            i2++;
        }
    }

    public static void P(int i, List<Integer> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                g4Var.a.G(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).intValue();
            Logger logger = zzhi.a;
            i3 += 4;
        }
        g4Var.a.r(i3);
        while (i2 < list.size()) {
            g4Var.a.C(list.get(i2).intValue());
            i2++;
        }
    }

    public static void Q(int i, List<Integer> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                g4Var.a.s(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int iH = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iH += zzhi.H(list.get(i3).intValue());
        }
        g4Var.a.r(iH);
        while (i2 < list.size()) {
            g4Var.a.e(list.get(i2).intValue());
            i2++;
        }
    }

    public static void R(int i, List<Boolean> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                g4Var.a.l(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).booleanValue();
            Logger logger = zzhi.a;
            i3++;
        }
        g4Var.a.r(i3);
        while (i2 < list.size()) {
            g4Var.a.d(list.get(i2).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static int a(int i, Object obj, q6 q6Var) {
        if (!(obj instanceof h5)) {
            return zzhi.c((c6) obj, q6Var) + zzhi.L(i << 3);
        }
        int iL = zzhi.L(i << 3);
        int iA = ((h5) obj).a();
        return zzhi.L(iA) + iA + iL;
    }

    public static int b(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iD = zzhi.D(i) * size;
        if (list instanceof j5) {
            j5 j5Var = (j5) list;
            while (i2 < size) {
                Object objA = j5Var.A(i2);
                iD = (objA instanceof t3 ? zzhi.p((t3) objA) : zzhi.q((String) objA)) + iD;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iD = (obj instanceof t3 ? zzhi.p((t3) obj) : zzhi.q((String) obj)) + iD;
                i2++;
            }
        }
        return iD;
    }

    public static int c(int i, List<?> list, q6 q6Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iD = zzhi.D(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            iD += obj instanceof h5 ? zzhi.b((h5) obj) : zzhi.c((c6) obj, q6Var);
        }
        return iD;
    }

    public static int d(List<Long> list) {
        int iF;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof q5) {
            q5 q5Var = (q5) list;
            iF = 0;
            while (i < size) {
                iF += zzhi.F(q5Var.e(i));
                i++;
            }
        } else {
            iF = 0;
            while (i < size) {
                iF += zzhi.F(list.get(i).longValue());
                i++;
            }
        }
        return iF;
    }

    public static d7<?, ?> e(boolean z2) {
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
            return (d7) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z2));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void f(int i, List<String> list, v7 v7Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!(list instanceof j5)) {
            while (i2 < list.size()) {
                g4Var.a.k(i, list.get(i2));
                i2++;
            }
            return;
        }
        j5 j5Var = (j5) list;
        while (i2 < list.size()) {
            Object objA = j5Var.A(i2);
            if (objA instanceof String) {
                g4Var.a.k(i, (String) objA);
            } else {
                g4Var.a.h(i, (t3) objA);
            }
            i2++;
        }
    }

    public static void g(int i, List<?> list, v7 v7Var, q6 q6Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        for (int i2 = 0; i2 < list.size(); i2++) {
            g4Var.a.j(i, (c6) list.get(i2), q6Var);
        }
    }

    public static void h(int i, List<Double> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                zzhi zzhiVar = g4Var.a;
                double dDoubleValue = list.get(i2).doubleValue();
                Objects.requireNonNull(zzhiVar);
                zzhiVar.z(i, Double.doubleToRawLongBits(dDoubleValue));
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).doubleValue();
            Logger logger = zzhi.a;
            i3 += 8;
        }
        g4Var.a.r(i3);
        while (i2 < list.size()) {
            zzhi zzhiVar2 = g4Var.a;
            double dDoubleValue2 = list.get(i2).doubleValue();
            Objects.requireNonNull(zzhiVar2);
            zzhiVar2.A(Double.doubleToRawLongBits(dDoubleValue2));
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
    public static <T, FT extends p4<FT>> void i(j4<FT> j4Var, T t, T t2) {
        n4<T> n4VarB = j4Var.b(t2);
        if (n4VarB.f1461b.isEmpty()) {
            return;
        }
        n4<T> n4VarF = j4Var.f(t);
        Objects.requireNonNull(n4VarF);
        for (int i = 0; i < n4VarB.f1461b.e(); i++) {
            n4VarF.j(n4VarB.f1461b.d(i));
        }
        Iterator<T> it = n4VarB.f1461b.g().iterator();
        while (it.hasNext()) {
            n4VarF.j((Map$Entry) it.next());
        }
    }

    public static boolean j(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int k(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzhi.D(i) * list.size()) + d(list);
    }

    public static int l(int i, List<t3> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iD = zzhi.D(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            iD += zzhi.p(list.get(i2));
        }
        return iD;
    }

    public static int m(int i, List<c6> list, q6 q6Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iX = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iX += zzhi.x(i, list.get(i2), q6Var);
        }
        return iX;
    }

    public static int n(List<Long> list) {
        int iF;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof q5) {
            q5 q5Var = (q5) list;
            iF = 0;
            while (i < size) {
                iF += zzhi.F(q5Var.e(i));
                i++;
            }
        } else {
            iF = 0;
            while (i < size) {
                iF += zzhi.F(list.get(i).longValue());
                i++;
            }
        }
        return iF;
    }

    public static void o(int i, List<t3> list, v7 v7Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        for (int i2 = 0; i2 < list.size(); i2++) {
            g4Var.a.h(i, list.get(i2));
        }
    }

    public static void p(int i, List<?> list, v7 v7Var, q6 q6Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        for (int i2 = 0; i2 < list.size(); i2++) {
            g4Var.e(i, list.get(i2), q6Var);
        }
    }

    public static void q(int i, List<Float> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                zzhi zzhiVar = g4Var.a;
                float fFloatValue = list.get(i2).floatValue();
                Objects.requireNonNull(zzhiVar);
                zzhiVar.G(i, Float.floatToRawIntBits(fFloatValue));
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).floatValue();
            Logger logger = zzhi.a;
            i3 += 4;
        }
        g4Var.a.r(i3);
        while (i2 < list.size()) {
            zzhi zzhiVar2 = g4Var.a;
            float fFloatValue2 = list.get(i2).floatValue();
            Objects.requireNonNull(zzhiVar2);
            zzhiVar2.C(Float.floatToRawIntBits(fFloatValue2));
            i2++;
        }
    }

    public static int r(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.D(i) * size) + n(list);
    }

    public static int s(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.D(i) * size) + t(list);
    }

    public static int t(List<Long> list) {
        int iK;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof q5) {
            q5 q5Var = (q5) list;
            iK = 0;
            while (i < size) {
                iK += zzhi.K(q5Var.e(i));
                i++;
            }
        } else {
            iK = 0;
            while (i < size) {
                iK += zzhi.K(list.get(i).longValue());
                i++;
            }
        }
        return iK;
    }

    public static void u(int i, List<Long> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                g4Var.a.g(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int iF = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iF += zzhi.F(list.get(i3).longValue());
        }
        g4Var.a.r(iF);
        while (i2 < list.size()) {
            g4Var.a.m(list.get(i2).longValue());
            i2++;
        }
    }

    public static int v(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.D(i) * size) + w(list);
    }

    public static int w(List<Integer> list) {
        int iH;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof x4) {
            x4 x4Var = (x4) list;
            iH = 0;
            while (i < size) {
                iH += zzhi.H(x4Var.e(i));
                i++;
            }
        } else {
            iH = 0;
            while (i < size) {
                iH += zzhi.H(list.get(i).intValue());
                i++;
            }
        }
        return iH;
    }

    public static void x(int i, List<Long> list, v7 v7Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        g4 g4Var = (g4) v7Var;
        Objects.requireNonNull(g4Var);
        int i2 = 0;
        if (!z2) {
            while (i2 < list.size()) {
                g4Var.a.g(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        g4Var.a.f(i, 2);
        int iF = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iF += zzhi.F(list.get(i3).longValue());
        }
        g4Var.a.r(iF);
        while (i2 < list.size()) {
            g4Var.a.m(list.get(i2).longValue());
            i2++;
        }
    }

    public static int y(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.D(i) * size) + z(list);
    }

    public static int z(List<Integer> list) {
        int iH;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof x4) {
            x4 x4Var = (x4) list;
            iH = 0;
            while (i < size) {
                iH += zzhi.H(x4Var.e(i));
                i++;
            }
        } else {
            iH = 0;
            while (i < size) {
                iH += zzhi.H(list.get(i).intValue());
                i++;
            }
        }
        return iH;
    }
}
