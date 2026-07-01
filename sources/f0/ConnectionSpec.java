package f0;

import b.d.b.a.outline;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import f0.CipherSuite;
import f0.e0.Util7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;

/* JADX INFO: renamed from: f0.m, reason: use source file name */
/* JADX INFO: compiled from: ConnectionSpec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionSpec {
    public static final CipherSuite[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CipherSuite[] f3674b;
    public static final ConnectionSpec c;
    public static final ConnectionSpec d;
    public final boolean e;
    public final boolean f;
    public final String[] g;
    public final String[] h;

    /* JADX INFO: renamed from: f0.m$a */
    /* JADX INFO: compiled from: ConnectionSpec.kt */
    public static final class a {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f3675b;
        public String[] c;
        public boolean d;

        public a(boolean z2) {
            this.a = z2;
        }

        public final ConnectionSpec a() {
            return new ConnectionSpec(this.a, this.d, this.f3675b, this.c);
        }

        public final a b(String... strArr) throws CloneNotSupportedException {
            Intrinsics3.checkParameterIsNotNull(strArr, "cipherSuites");
            if (!this.a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.f3675b = (String[]) objClone;
            return this;
        }

        public final a c(CipherSuite... cipherSuiteArr) throws CloneNotSupportedException {
            Intrinsics3.checkParameterIsNotNull(cipherSuiteArr, "cipherSuites");
            if (!this.a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(cipherSuiteArr.length);
            for (CipherSuite cipherSuite : cipherSuiteArr) {
                arrayList.add(cipherSuite.t);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            b((String[]) Arrays.copyOf(strArr, strArr.length));
            return this;
        }

        public final a d(boolean z2) {
            if (!this.a) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            this.d = z2;
            return this;
        }

        public final a e(String... strArr) throws CloneNotSupportedException {
            Intrinsics3.checkParameterIsNotNull(strArr, "tlsVersions");
            if (!this.a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.c = (String[]) objClone;
            return this;
        }

        public final a f(TlsVersion... tlsVersionArr) throws CloneNotSupportedException {
            Intrinsics3.checkParameterIsNotNull(tlsVersionArr, "tlsVersions");
            if (!this.a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(tlsVersionArr.length);
            for (TlsVersion tlsVersion : tlsVersionArr) {
                arrayList.add(tlsVersion.f());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            e((String[]) Arrays.copyOf(strArr, strArr.length));
            return this;
        }

        public a(ConnectionSpec connectionSpec) {
            Intrinsics3.checkParameterIsNotNull(connectionSpec, "connectionSpec");
            this.a = connectionSpec.e;
            this.f3675b = connectionSpec.g;
            this.c = connectionSpec.h;
            this.d = connectionSpec.f;
        }
    }

    static {
        CipherSuite cipherSuite = CipherSuite.p;
        CipherSuite cipherSuite2 = CipherSuite.q;
        CipherSuite cipherSuite3 = CipherSuite.r;
        CipherSuite cipherSuite4 = CipherSuite.j;
        CipherSuite cipherSuite5 = CipherSuite.l;
        CipherSuite cipherSuite6 = CipherSuite.k;
        CipherSuite cipherSuite7 = CipherSuite.m;
        CipherSuite cipherSuite8 = CipherSuite.o;
        CipherSuite cipherSuite9 = CipherSuite.n;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9};
        a = cipherSuiteArr;
        CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, CipherSuite.h, CipherSuite.i, CipherSuite.f, CipherSuite.g, CipherSuite.d, CipherSuite.e, CipherSuite.c};
        f3674b = cipherSuiteArr2;
        a aVar = new a(true);
        aVar.c((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, cipherSuiteArr.length));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        aVar.f(tlsVersion, tlsVersion2);
        aVar.d(true);
        aVar.a();
        a aVar2 = new a(true);
        aVar2.c((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length));
        aVar2.f(tlsVersion, tlsVersion2);
        aVar2.d(true);
        c = aVar2.a();
        a aVar3 = new a(true);
        aVar3.c((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length));
        aVar3.f(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        aVar3.d(true);
        aVar3.a();
        d = new ConnectionSpec(false, false, null, null);
    }

    public ConnectionSpec(boolean z2, boolean z3, String[] strArr, String[] strArr2) {
        this.e = z2;
        this.f = z3;
        this.g = strArr;
        this.h = strArr2;
    }

    public final List<CipherSuite> a() {
        String[] strArr = this.g;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(CipherSuite.f3673s.b(str));
        }
        return _Collections.toList(arrayList);
    }

    public final boolean b(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "socket");
        if (!this.e) {
            return false;
        }
        String[] strArr = this.h;
        if (strArr != null && !Util7.k(strArr, sSLSocket.getEnabledProtocols(), d0.u.a.naturalOrder())) {
            return false;
        }
        String[] strArr2 = this.g;
        if (strArr2 == null) {
            return true;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        CipherSuite.b bVar = CipherSuite.f3673s;
        Comparator<String> comparator = CipherSuite.a;
        return Util7.k(strArr2, enabledCipherSuites, CipherSuite.a);
    }

    public final List<TlsVersion> c() {
        String[] strArr = this.h;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(TlsVersion.p.a(str));
        }
        return _Collections.toList(arrayList);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z2 = this.e;
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        if (z2 != connectionSpec.e) {
            return false;
        }
        return !z2 || (Arrays.equals(this.g, connectionSpec.g) && Arrays.equals(this.h, connectionSpec.h) && this.f == connectionSpec.f);
    }

    public int hashCode() {
        if (!this.e) {
            return 17;
        }
        String[] strArr = this.g;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.h;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f ? 1 : 0);
    }

    public String toString() {
        if (!this.e) {
            return "ConnectionSpec()";
        }
        StringBuilder sbX = outline.X("ConnectionSpec(", "cipherSuites=");
        sbX.append(Objects.toString(a(), "[all enabled]"));
        sbX.append(", ");
        sbX.append("tlsVersions=");
        sbX.append(Objects.toString(c(), "[all enabled]"));
        sbX.append(", ");
        sbX.append("supportsTlsExtensions=");
        sbX.append(this.f);
        sbX.append(')');
        return sbX.toString();
    }
}
