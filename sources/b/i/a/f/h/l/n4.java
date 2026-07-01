package b.i.a.f.h.l;

import b.i.a.f.h.l.p4;
import com.google.android.gms.internal.measurement.zzhi;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n4<T extends p4<T>> {
    public static final n4 a = new n4(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r6<T, Object> f1461b;
    public boolean c;
    public boolean d;

    public n4(boolean z2) {
        int i = r6.j;
        this.f1461b = new t6(0);
        h();
        h();
    }

    public static int a(p4<?> p4Var, Object obj) {
        p7 p7VarB = p4Var.b();
        int iA = p4Var.a();
        if (!p4Var.d()) {
            return b(p7VarB, iA, obj);
        }
        int iB = 0;
        if (p4Var.e()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iB += g(p7VarB, it.next());
            }
            return zzhi.D(iA) + iB + zzhi.L(iB);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iB += b(p7VarB, iA, it2.next());
        }
        return iB;
    }

    public static int b(p7 p7Var, int i, Object obj) {
        int iD = zzhi.D(i);
        if (p7Var == p7.f1479s) {
            c6 c6Var = (c6) obj;
            if (c6Var instanceof m3) {
            }
            iD <<= 1;
        }
        return g(p7Var, obj) + iD;
    }

    public static Object d(Object obj) {
        if (obj instanceof f6) {
            return ((f6) obj).a();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0016  */
    public static void e(p7 p7Var, Object obj) {
        Charset charset = w4.a;
        Objects.requireNonNull(obj);
        boolean z2 = true;
        switch (m4.a[p7Var.f().ordinal()]) {
            case 1:
                z2 = obj instanceof Integer;
                break;
            case 2:
                z2 = obj instanceof Long;
                break;
            case 3:
                z2 = obj instanceof Float;
                break;
            case 4:
                z2 = obj instanceof Double;
                break;
            case 5:
                z2 = obj instanceof Boolean;
                break;
            case 6:
                z2 = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof t3) && !(obj instanceof byte[])) {
                    z2 = false;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof y4)) {
                    z2 = false;
                }
                break;
            case 9:
                if (!(obj instanceof c6) && !(obj instanceof d5)) {
                    z2 = false;
                }
                break;
            default:
                z2 = false;
                break;
        }
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public static <T extends p4<T>> boolean f(Map$Entry<T, Object> map$Entry) {
        T key = map$Entry.getKey();
        if (key.c() == w7.MESSAGE) {
            if (key.d()) {
                Iterator it = ((List) map$Entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((c6) it.next()).j()) {
                        return false;
                    }
                }
            } else {
                Object value = map$Entry.getValue();
                if (!(value instanceof c6)) {
                    if (value instanceof d5) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((c6) value).j()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int g(p7 p7Var, Object obj) {
        int iG;
        int iL;
        switch (m4.f1458b[p7Var.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                Logger logger = zzhi.a;
                return 8;
            case 2:
                ((Float) obj).floatValue();
                Logger logger2 = zzhi.a;
                return 4;
            case 3:
                return zzhi.F(((Long) obj).longValue());
            case 4:
                return zzhi.F(((Long) obj).longValue());
            case 5:
                return zzhi.H(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                Logger logger3 = zzhi.a;
                return 8;
            case 7:
                ((Integer) obj).intValue();
                Logger logger4 = zzhi.a;
                return 4;
            case 8:
                ((Boolean) obj).booleanValue();
                Logger logger5 = zzhi.a;
                return 1;
            case 9:
                Logger logger6 = zzhi.a;
                return ((c6) obj).g();
            case 10:
                if (!(obj instanceof d5)) {
                    Logger logger7 = zzhi.a;
                    iG = ((c6) obj).g();
                    iL = zzhi.L(iG);
                } else {
                    Logger logger8 = zzhi.a;
                    iG = ((d5) obj).a();
                    iL = zzhi.L(iG);
                }
                break;
            case 11:
                return obj instanceof t3 ? zzhi.p((t3) obj) : zzhi.q((String) obj);
            case 12:
                if (obj instanceof t3) {
                    return zzhi.p((t3) obj);
                }
                Logger logger9 = zzhi.a;
                iG = ((byte[]) obj).length;
                iL = zzhi.L(iG);
                break;
            case 13:
                return zzhi.L(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                Logger logger10 = zzhi.a;
                return 4;
            case 15:
                ((Long) obj).longValue();
                Logger logger11 = zzhi.a;
                return 8;
            case 16:
                return zzhi.O(((Integer) obj).intValue());
            case 17:
                return zzhi.K(((Long) obj).longValue());
            case 18:
                return obj instanceof y4 ? zzhi.H(((y4) obj).a()) : zzhi.H(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iL + iG;
    }

    public static int k(Map$Entry<T, Object> map$Entry) {
        int iM;
        int iL;
        int iG;
        int iL2;
        T key = map$Entry.getKey();
        Object value = map$Entry.getValue();
        if (key.c() != w7.MESSAGE || key.d() || key.e()) {
            return a(key, value);
        }
        if (value instanceof d5) {
            int iA = map$Entry.getKey().a();
            iM = zzhi.M(2, iA) + (zzhi.L(8) << 1);
            iL = zzhi.L(24);
            iG = ((d5) value).a();
            iL2 = zzhi.L(iG);
        } else {
            int iA2 = map$Entry.getKey().a();
            iM = zzhi.M(2, iA2) + (zzhi.L(8) << 1);
            iL = zzhi.L(24);
            iG = ((c6) value).g();
            iL2 = zzhi.L(iG);
        }
        return iL2 + iG + iL + iM;
    }

    public final Object c(T t) {
        Object obj = this.f1461b.get(t);
        if (!(obj instanceof d5)) {
            return obj;
        }
        int i = d5.c;
        throw new NoSuchMethodError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        n4 n4Var = new n4();
        for (int i = 0; i < this.f1461b.e(); i++) {
            Map$Entry<K, Object> map$EntryD = this.f1461b.d(i);
            n4Var.i((p4) map$EntryD.getKey(), map$EntryD.getValue());
        }
        Iterator it = this.f1461b.g().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            n4Var.i((p4) map$Entry.getKey(), map$Entry.getValue());
        }
        n4Var.d = this.d;
        return n4Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n4) {
            return this.f1461b.equals(((n4) obj).f1461b);
        }
        return false;
    }

    public final void h() {
        if (this.c) {
            return;
        }
        this.f1461b.c();
        this.c = true;
    }

    public final int hashCode() {
        return this.f1461b.hashCode();
    }

    public final void i(T t, Object obj) {
        if (!t.d()) {
            e(t.b(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                e(t.b(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof d5) {
            this.d = true;
        }
        this.f1461b.b(t, obj);
    }

    public final void j(Map$Entry<T, Object> map$Entry) {
        T key = map$Entry.getKey();
        Object value = map$Entry.getValue();
        if (value instanceof d5) {
            int i = d5.c;
            throw new NoSuchMethodError();
        }
        if (key.d()) {
            Object objC = c(key);
            if (objC == null) {
                objC = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objC).add(d(it.next()));
            }
            this.f1461b.b(key, objC);
            return;
        }
        if (key.c() != w7.MESSAGE) {
            this.f1461b.b(key, d(value));
            return;
        }
        Object objC2 = c(key);
        if (objC2 == null) {
            this.f1461b.b(key, d(value));
        } else {
            this.f1461b.b(key, objC2 instanceof f6 ? key.c0((f6) objC2, (f6) value) : ((u4$b) key.X(((c6) objC2).f(), (c6) value)).p());
        }
    }

    public final Iterator<Map$Entry<T, Object>> l() {
        return this.d ? new i5(this.f1461b.entrySet().iterator()) : this.f1461b.entrySet().iterator();
    }

    public final boolean m() {
        for (int i = 0; i < this.f1461b.e(); i++) {
            if (!f(this.f1461b.d(i))) {
                return false;
            }
        }
        Iterator it = this.f1461b.g().iterator();
        while (it.hasNext()) {
            if (!f((Map$Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public n4() {
        int i = r6.j;
        this.f1461b = new t6(16);
    }
}
