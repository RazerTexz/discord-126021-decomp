package p007b.p225i.p226a.p288f.p313h.p325l;

import com.google.android.gms.internal.measurement.zzhi;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3786p4;

/* JADX INFO: renamed from: b.i.a.f.h.l.n4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3760n4<T extends InterfaceC3786p4<T>> {

    /* JADX INFO: renamed from: a */
    public static final C3760n4 f10110a = new C3760n4(true);

    /* JADX INFO: renamed from: b */
    public final C3814r6<T, Object> f10111b;

    /* JADX INFO: renamed from: c */
    public boolean f10112c;

    /* JADX INFO: renamed from: d */
    public boolean f10113d;

    public C3760n4(boolean z2) {
        int i = C3814r6.f10288j;
        this.f10111b = new C3840t6(0);
        m5132h();
        m5132h();
    }

    /* JADX INFO: renamed from: a */
    public static int m5124a(InterfaceC3786p4<?> interfaceC3786p4, Object obj) {
        EnumC3789p7 enumC3789p7Mo5175b = interfaceC3786p4.mo5175b();
        int iMo5174a = interfaceC3786p4.mo5174a();
        if (!interfaceC3786p4.mo5178d()) {
            return m5125b(enumC3789p7Mo5175b, iMo5174a, obj);
        }
        int iM5125b = 0;
        if (interfaceC3786p4.mo5179e()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iM5125b += m5129g(enumC3789p7Mo5175b, it.next());
            }
            return zzhi.m9052D(iMo5174a) + iM5125b + zzhi.m9059L(iM5125b);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iM5125b += m5125b(enumC3789p7Mo5175b, iMo5174a, it2.next());
        }
        return iM5125b;
    }

    /* JADX INFO: renamed from: b */
    public static int m5125b(EnumC3789p7 enumC3789p7, int i, Object obj) {
        int iM9052D = zzhi.m9052D(i);
        if (enumC3789p7 == EnumC3789p7.f10210s) {
            InterfaceC3612c6 interfaceC3612c6 = (InterfaceC3612c6) obj;
            if (interfaceC3612c6 instanceof AbstractC3746m3) {
            }
            iM9052D <<= 1;
        }
        return m5129g(enumC3789p7, obj) + iM9052D;
    }

    /* JADX INFO: renamed from: d */
    public static Object m5126d(Object obj) {
        if (obj instanceof InterfaceC3654f6) {
            return ((InterfaceC3654f6) obj).mo4880a();
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
    /* JADX INFO: renamed from: e */
    public static void m5127e(EnumC3789p7 enumC3789p7, Object obj) {
        Charset charset = C3877w4.f10379a;
        Objects.requireNonNull(obj);
        boolean z2 = true;
        switch (C3747m4.f10090a[enumC3789p7.m5180f().ordinal()]) {
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
                if (!(obj instanceof AbstractC3837t3) && !(obj instanceof byte[])) {
                    z2 = false;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof InterfaceC3903y4)) {
                    z2 = false;
                }
                break;
            case 9:
                if (!(obj instanceof InterfaceC3612c6) && !(obj instanceof C3625d5)) {
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

    /* JADX INFO: renamed from: f */
    public static <T extends InterfaceC3786p4<T>> boolean m5128f(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.mo5176c() == EnumC3880w7.MESSAGE) {
            if (key.mo5178d()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((InterfaceC3612c6) it.next()).mo4632j()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof InterfaceC3612c6)) {
                    if (value instanceof C3625d5) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((InterfaceC3612c6) value).mo4632j()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: g */
    public static int m5129g(EnumC3789p7 enumC3789p7, Object obj) {
        int iMo4606g;
        int iM9059L;
        switch (C3747m4.f10091b[enumC3789p7.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                Logger logger = zzhi.f20628a;
                return 8;
            case 2:
                ((Float) obj).floatValue();
                Logger logger2 = zzhi.f20628a;
                return 4;
            case 3:
                return zzhi.m9054F(((Long) obj).longValue());
            case 4:
                return zzhi.m9054F(((Long) obj).longValue());
            case 5:
                return zzhi.m9055H(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                Logger logger3 = zzhi.f20628a;
                return 8;
            case 7:
                ((Integer) obj).intValue();
                Logger logger4 = zzhi.f20628a;
                return 4;
            case 8:
                ((Boolean) obj).booleanValue();
                Logger logger5 = zzhi.f20628a;
                return 1;
            case 9:
                Logger logger6 = zzhi.f20628a;
                return ((InterfaceC3612c6) obj).mo4606g();
            case 10:
                if (!(obj instanceof C3625d5)) {
                    Logger logger7 = zzhi.f20628a;
                    iMo4606g = ((InterfaceC3612c6) obj).mo4606g();
                    iM9059L = zzhi.m9059L(iMo4606g);
                } else {
                    Logger logger8 = zzhi.f20628a;
                    iMo4606g = ((C3625d5) obj).m4934a();
                    iM9059L = zzhi.m9059L(iMo4606g);
                }
                break;
            case 11:
                return obj instanceof AbstractC3837t3 ? zzhi.m9074p((AbstractC3837t3) obj) : zzhi.m9075q((String) obj);
            case 12:
                if (obj instanceof AbstractC3837t3) {
                    return zzhi.m9074p((AbstractC3837t3) obj);
                }
                Logger logger9 = zzhi.f20628a;
                iMo4606g = ((byte[]) obj).length;
                iM9059L = zzhi.m9059L(iMo4606g);
                break;
            case 13:
                return zzhi.m9059L(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                Logger logger10 = zzhi.f20628a;
                return 4;
            case 15:
                ((Long) obj).longValue();
                Logger logger11 = zzhi.f20628a;
                return 8;
            case 16:
                return zzhi.m9062O(((Integer) obj).intValue());
            case 17:
                return zzhi.m9058K(((Long) obj).longValue());
            case 18:
                return obj instanceof InterfaceC3903y4 ? zzhi.m9055H(((InterfaceC3903y4) obj).mo4875a()) : zzhi.m9055H(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iM9059L + iMo4606g;
    }

    /* JADX INFO: renamed from: k */
    public static int m5130k(Map.Entry<T, Object> entry) {
        int iM9060M;
        int iM9059L;
        int iMo4606g;
        int iM9059L2;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.mo5176c() != EnumC3880w7.MESSAGE || key.mo5178d() || key.mo5179e()) {
            return m5124a(key, value);
        }
        if (value instanceof C3625d5) {
            int iMo5174a = entry.getKey().mo5174a();
            iM9060M = zzhi.m9060M(2, iMo5174a) + (zzhi.m9059L(8) << 1);
            iM9059L = zzhi.m9059L(24);
            iMo4606g = ((C3625d5) value).m4934a();
            iM9059L2 = zzhi.m9059L(iMo4606g);
        } else {
            int iMo5174a2 = entry.getKey().mo5174a();
            iM9060M = zzhi.m9060M(2, iMo5174a2) + (zzhi.m9059L(8) << 1);
            iM9059L = zzhi.m9059L(24);
            iMo4606g = ((InterfaceC3612c6) value).mo4606g();
            iM9059L2 = zzhi.m9059L(iMo4606g);
        }
        return iM9059L2 + iMo4606g + iM9059L + iM9060M;
    }

    /* JADX INFO: renamed from: c */
    public final Object m5131c(T t) {
        Object obj = this.f10111b.get(t);
        if (!(obj instanceof C3625d5)) {
            return obj;
        }
        int i = C3625d5.f9892c;
        throw new NoSuchMethodError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        C3760n4 c3760n4 = new C3760n4();
        for (int i = 0; i < this.f10111b.m5207e(); i++) {
            Map.Entry<K, Object> entryM5206d = this.f10111b.m5206d(i);
            c3760n4.m5133i((InterfaceC3786p4) entryM5206d.getKey(), entryM5206d.getValue());
        }
        Iterator it = this.f10111b.m5209g().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            c3760n4.m5133i((InterfaceC3786p4) entry.getKey(), entry.getValue());
        }
        c3760n4.f10113d = this.f10113d;
        return c3760n4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3760n4) {
            return this.f10111b.equals(((C3760n4) obj).f10111b);
        }
        return false;
    }

    /* JADX INFO: renamed from: h */
    public final void m5132h() {
        if (this.f10112c) {
            return;
        }
        this.f10111b.mo5205c();
        this.f10112c = true;
    }

    public final int hashCode() {
        return this.f10111b.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final void m5133i(T t, Object obj) {
        if (!t.mo5178d()) {
            m5127e(t.mo5175b(), obj);
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
                m5127e(t.mo5175b(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof C3625d5) {
            this.f10113d = true;
        }
        this.f10111b.put(t, obj);
    }

    /* JADX INFO: renamed from: j */
    public final void m5134j(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof C3625d5) {
            int i = C3625d5.f9892c;
            throw new NoSuchMethodError();
        }
        if (key.mo5178d()) {
            Object objM5131c = m5131c(key);
            if (objM5131c == null) {
                objM5131c = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objM5131c).add(m5126d(it.next()));
            }
            this.f10111b.put(key, objM5131c);
            return;
        }
        if (key.mo5176c() != EnumC3880w7.MESSAGE) {
            this.f10111b.put(key, m5126d(value));
            return;
        }
        Object objM5131c2 = m5131c(key);
        if (objM5131c2 == null) {
            this.f10111b.put(key, m5126d(value));
        } else {
            this.f10111b.put(key, objM5131c2 instanceof InterfaceC3654f6 ? key.mo5177c0((InterfaceC3654f6) objM5131c2, (InterfaceC3654f6) value) : ((AbstractC3851u4.b) key.mo5173X(((InterfaceC3612c6) objM5131c2).mo4605f(), (InterfaceC3612c6) value)).m5320p());
        }
    }

    /* JADX INFO: renamed from: l */
    public final Iterator<Map.Entry<T, Object>> m5135l() {
        return this.f10113d ? new C3695i5(this.f10111b.entrySet().iterator()) : this.f10111b.entrySet().iterator();
    }

    /* JADX INFO: renamed from: m */
    public final boolean m5136m() {
        for (int i = 0; i < this.f10111b.m5207e(); i++) {
            if (!m5128f(this.f10111b.m5206d(i))) {
                return false;
            }
        }
        Iterator it = this.f10111b.m5209g().iterator();
        while (it.hasNext()) {
            if (!m5128f((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public C3760n4() {
        int i = C3814r6.f10288j;
        this.f10111b = new C3840t6(16);
    }
}
