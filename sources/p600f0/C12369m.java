package p600f0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;

/* JADX INFO: renamed from: f0.m */
/* JADX INFO: compiled from: ConnectionSpec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12369m {

    /* JADX INFO: renamed from: a */
    public static final C12366j[] f25930a;

    /* JADX INFO: renamed from: b */
    public static final C12366j[] f25931b;

    /* JADX INFO: renamed from: c */
    public static final C12369m f25932c;

    /* JADX INFO: renamed from: d */
    public static final C12369m f25933d;

    /* JADX INFO: renamed from: e */
    public final boolean f25934e;

    /* JADX INFO: renamed from: f */
    public final boolean f25935f;

    /* JADX INFO: renamed from: g */
    public final String[] f25936g;

    /* JADX INFO: renamed from: h */
    public final String[] f25937h;

    /* JADX INFO: renamed from: f0.m$a */
    /* JADX INFO: compiled from: ConnectionSpec.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public boolean f25938a;

        /* JADX INFO: renamed from: b */
        public String[] f25939b;

        /* JADX INFO: renamed from: c */
        public String[] f25940c;

        /* JADX INFO: renamed from: d */
        public boolean f25941d;

        public a(boolean z2) {
            this.f25938a = z2;
        }

        /* JADX INFO: renamed from: a */
        public final C12369m m10378a() {
            return new C12369m(this.f25938a, this.f25941d, this.f25939b, this.f25940c);
        }

        /* JADX INFO: renamed from: b */
        public final a m10379b(String... strArr) throws CloneNotSupportedException {
            C12238m.checkParameterIsNotNull(strArr, "cipherSuites");
            if (!this.f25938a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.f25939b = (String[]) objClone;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public final a m10380c(C12366j... c12366jArr) throws CloneNotSupportedException {
            C12238m.checkParameterIsNotNull(c12366jArr, "cipherSuites");
            if (!this.f25938a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(c12366jArr.length);
            for (C12366j c12366j : c12366jArr) {
                arrayList.add(c12366j.f25928t);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            m10379b((String[]) Arrays.copyOf(strArr, strArr.length));
            return this;
        }

        /* JADX INFO: renamed from: d */
        public final a m10381d(boolean z2) {
            if (!this.f25938a) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            this.f25941d = z2;
            return this;
        }

        /* JADX INFO: renamed from: e */
        public final a m10382e(String... strArr) throws CloneNotSupportedException {
            C12238m.checkParameterIsNotNull(strArr, "tlsVersions");
            if (!this.f25938a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.f25940c = (String[]) objClone;
            return this;
        }

        /* JADX INFO: renamed from: f */
        public final a m10383f(EnumC12268d0... enumC12268d0Arr) throws CloneNotSupportedException {
            C12238m.checkParameterIsNotNull(enumC12268d0Arr, "tlsVersions");
            if (!this.f25938a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(enumC12268d0Arr.length);
            for (EnumC12268d0 enumC12268d0 : enumC12268d0Arr) {
                arrayList.add(enumC12268d0.m10109f());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            m10382e((String[]) Arrays.copyOf(strArr, strArr.length));
            return this;
        }

        public a(C12369m c12369m) {
            C12238m.checkParameterIsNotNull(c12369m, "connectionSpec");
            this.f25938a = c12369m.f25934e;
            this.f25939b = c12369m.f25936g;
            this.f25940c = c12369m.f25937h;
            this.f25941d = c12369m.f25935f;
        }
    }

    static {
        C12366j c12366j = C12366j.f25924p;
        C12366j c12366j2 = C12366j.f25925q;
        C12366j c12366j3 = C12366j.f25926r;
        C12366j c12366j4 = C12366j.f25918j;
        C12366j c12366j5 = C12366j.f25920l;
        C12366j c12366j6 = C12366j.f25919k;
        C12366j c12366j7 = C12366j.f25921m;
        C12366j c12366j8 = C12366j.f25923o;
        C12366j c12366j9 = C12366j.f25922n;
        C12366j[] c12366jArr = {c12366j, c12366j2, c12366j3, c12366j4, c12366j5, c12366j6, c12366j7, c12366j8, c12366j9};
        f25930a = c12366jArr;
        C12366j[] c12366jArr2 = {c12366j, c12366j2, c12366j3, c12366j4, c12366j5, c12366j6, c12366j7, c12366j8, c12366j9, C12366j.f25916h, C12366j.f25917i, C12366j.f25914f, C12366j.f25915g, C12366j.f25912d, C12366j.f25913e, C12366j.f25911c};
        f25931b = c12366jArr2;
        a aVar = new a(true);
        aVar.m10380c((C12366j[]) Arrays.copyOf(c12366jArr, c12366jArr.length));
        EnumC12268d0 enumC12268d0 = EnumC12268d0.TLS_1_3;
        EnumC12268d0 enumC12268d1 = EnumC12268d0.TLS_1_2;
        aVar.m10383f(enumC12268d0, enumC12268d1);
        aVar.m10381d(true);
        aVar.m10378a();
        a aVar2 = new a(true);
        aVar2.m10380c((C12366j[]) Arrays.copyOf(c12366jArr2, c12366jArr2.length));
        aVar2.m10383f(enumC12268d0, enumC12268d1);
        aVar2.m10381d(true);
        f25932c = aVar2.m10378a();
        a aVar3 = new a(true);
        aVar3.m10380c((C12366j[]) Arrays.copyOf(c12366jArr2, c12366jArr2.length));
        aVar3.m10383f(enumC12268d0, enumC12268d1, EnumC12268d0.TLS_1_1, EnumC12268d0.TLS_1_0);
        aVar3.m10381d(true);
        aVar3.m10378a();
        f25933d = new C12369m(false, false, null, null);
    }

    public C12369m(boolean z2, boolean z3, String[] strArr, String[] strArr2) {
        this.f25934e = z2;
        this.f25935f = z3;
        this.f25936g = strArr;
        this.f25937h = strArr2;
    }

    /* JADX INFO: renamed from: a */
    public final List<C12366j> m10375a() {
        String[] strArr = this.f25936g;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(C12366j.f25927s.m10373b(str));
        }
        return C12163u.toList(arrayList);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m10376b(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "socket");
        if (!this.f25934e) {
            return false;
        }
        String[] strArr = this.f25937h;
        if (strArr != null && !C12272c.m10130k(strArr, sSLSocket.getEnabledProtocols(), C12169a.naturalOrder())) {
            return false;
        }
        String[] strArr2 = this.f25936g;
        if (strArr2 == null) {
            return true;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        C12366j.b bVar = C12366j.f25927s;
        Comparator<String> comparator = C12366j.f25909a;
        return C12272c.m10130k(strArr2, enabledCipherSuites, C12366j.f25909a);
    }

    /* JADX INFO: renamed from: c */
    public final List<EnumC12268d0> m10377c() {
        String[] strArr = this.f25937h;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(EnumC12268d0.f25393p.m10110a(str));
        }
        return C12163u.toList(arrayList);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C12369m)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z2 = this.f25934e;
        C12369m c12369m = (C12369m) obj;
        if (z2 != c12369m.f25934e) {
            return false;
        }
        return !z2 || (Arrays.equals(this.f25936g, c12369m.f25936g) && Arrays.equals(this.f25937h, c12369m.f25937h) && this.f25935f == c12369m.f25935f);
    }

    public int hashCode() {
        if (!this.f25934e) {
            return 17;
        }
        String[] strArr = this.f25936g;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f25937h;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f25935f ? 1 : 0);
    }

    public String toString() {
        if (!this.f25934e) {
            return "ConnectionSpec()";
        }
        StringBuilder sbM836X = C1643a.m836X("ConnectionSpec(", "cipherSuites=");
        sbM836X.append(Objects.toString(m10375a(), "[all enabled]"));
        sbM836X.append(", ");
        sbM836X.append("tlsVersions=");
        sbM836X.append(Objects.toString(m10377c(), "[all enabled]"));
        sbM836X.append(", ");
        sbM836X.append("supportsTlsExtensions=");
        sbM836X.append(this.f25935f);
        sbM836X.append(')');
        return sbM836X.toString();
    }
}
