package f0;

import b.d.b.a.outline;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: f0.j, reason: use source file name */
/* JADX INFO: compiled from: CipherSuite.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CipherSuite {
    public static final Comparator<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, CipherSuite> f3672b;
    public static final CipherSuite c;
    public static final CipherSuite d;
    public static final CipherSuite e;
    public static final CipherSuite f;
    public static final CipherSuite g;
    public static final CipherSuite h;
    public static final CipherSuite i;
    public static final CipherSuite j;
    public static final CipherSuite k;
    public static final CipherSuite l;
    public static final CipherSuite m;
    public static final CipherSuite n;
    public static final CipherSuite o;
    public static final CipherSuite p;
    public static final CipherSuite q;
    public static final CipherSuite r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final b f3673s;
    public final String t;

    /* JADX INFO: renamed from: f0.j$a */
    /* JADX INFO: compiled from: CipherSuite.kt */
    public static final class a implements Comparator<String> {
        /* JADX WARN: Code duplicated, block: B:9:0x002c A[RETURN, SYNTHETIC] */
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            String str3 = str;
            String str4 = str2;
            Intrinsics3.checkParameterIsNotNull(str3, "a");
            Intrinsics3.checkParameterIsNotNull(str4, "b");
            int iMin = Math.min(str3.length(), str4.length());
            for (int i = 4; i < iMin; i++) {
                char cCharAt = str3.charAt(i);
                char cCharAt2 = str4.charAt(i);
                if (cCharAt != cCharAt2) {
                    if (cCharAt < cCharAt2) {
                        return -1;
                    }
                    return 1;
                }
            }
            int length = str3.length();
            int length2 = str4.length();
            if (length == length2) {
                return 0;
            }
            if (length < length2) {
                return -1;
            }
            return 1;
        }
    }

    /* JADX INFO: renamed from: f0.j$b */
    /* JADX INFO: compiled from: CipherSuite.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final CipherSuite a(b bVar, String str, int i) {
            CipherSuite cipherSuite = new CipherSuite(str, null);
            CipherSuite.f3672b.put(str, cipherSuite);
            return cipherSuite;
        }

        public final synchronized CipherSuite b(String str) {
            CipherSuite cipherSuite;
            Intrinsics3.checkParameterIsNotNull(str, "javaName");
            Map<String, CipherSuite> map = CipherSuite.f3672b;
            cipherSuite = map.get(str);
            if (cipherSuite == null) {
                cipherSuite = map.get(c(str));
                if (cipherSuite == null) {
                    cipherSuite = new CipherSuite(str, null);
                }
                map.put(str, cipherSuite);
            }
            return cipherSuite;
        }

        public final String c(String str) {
            if (StringsJVM.startsWith$default(str, "TLS_", false, 2, null)) {
                StringBuilder sbU = outline.U("SSL_");
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = str.substring(4);
                Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sbU.append(strSubstring);
                return sbU.toString();
            }
            if (!StringsJVM.startsWith$default(str, "SSL_", false, 2, null)) {
                return str;
            }
            StringBuilder sbU2 = outline.U("TLS_");
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring2 = str.substring(4);
            Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            sbU2.append(strSubstring2);
            return sbU2.toString();
        }
    }

    static {
        b bVar = new b(null);
        f3673s = bVar;
        a = new a();
        f3672b = new LinkedHashMap();
        b.a(bVar, "SSL_RSA_WITH_NULL_MD5", 1);
        b.a(bVar, "SSL_RSA_WITH_NULL_SHA", 2);
        b.a(bVar, "SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        b.a(bVar, "SSL_RSA_WITH_RC4_128_MD5", 4);
        b.a(bVar, "SSL_RSA_WITH_RC4_128_SHA", 5);
        b.a(bVar, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        b.a(bVar, "SSL_RSA_WITH_DES_CBC_SHA", 9);
        c = b.a(bVar, "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        b.a(bVar, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        b.a(bVar, "SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        b.a(bVar, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        b.a(bVar, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        b.a(bVar, "SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        b.a(bVar, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        b.a(bVar, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        b.a(bVar, "SSL_DH_anon_WITH_RC4_128_MD5", 24);
        b.a(bVar, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        b.a(bVar, "SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        b.a(bVar, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        b.a(bVar, "TLS_KRB5_WITH_DES_CBC_SHA", 30);
        b.a(bVar, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        b.a(bVar, "TLS_KRB5_WITH_RC4_128_SHA", 32);
        b.a(bVar, "TLS_KRB5_WITH_DES_CBC_MD5", 34);
        b.a(bVar, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        b.a(bVar, "TLS_KRB5_WITH_RC4_128_MD5", 36);
        b.a(bVar, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        b.a(bVar, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        b.a(bVar, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        b.a(bVar, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        d = b.a(bVar, "TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        b.a(bVar, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        b.a(bVar, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        b.a(bVar, "TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        e = b.a(bVar, "TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        b.a(bVar, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        b.a(bVar, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        b.a(bVar, "TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        b.a(bVar, "TLS_RSA_WITH_NULL_SHA256", 59);
        b.a(bVar, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        b.a(bVar, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        b.a(bVar, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        b.a(bVar, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        b.a(bVar, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        b.a(bVar, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        b.a(bVar, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        b.a(bVar, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        b.a(bVar, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        b.a(bVar, "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        b.a(bVar, "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        b.a(bVar, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", Opcodes.IINC);
        b.a(bVar, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", Opcodes.I2D);
        b.a(bVar, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", Opcodes.L2I);
        b.a(bVar, "TLS_PSK_WITH_RC4_128_SHA", Opcodes.L2D);
        b.a(bVar, "TLS_PSK_WITH_3DES_EDE_CBC_SHA", Opcodes.F2I);
        b.a(bVar, "TLS_PSK_WITH_AES_128_CBC_SHA", Opcodes.F2L);
        b.a(bVar, "TLS_PSK_WITH_AES_256_CBC_SHA", Opcodes.F2D);
        b.a(bVar, "TLS_RSA_WITH_SEED_CBC_SHA", 150);
        f = b.a(bVar, "TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        g = b.a(bVar, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        b.a(bVar, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        b.a(bVar, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPEQ);
        b.a(bVar, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", Opcodes.IF_ICMPGE);
        b.a(bVar, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPGT);
        b.a(bVar, "TLS_DH_anon_WITH_AES_128_GCM_SHA256", Opcodes.IF_ACMPNE);
        b.a(bVar, "TLS_DH_anon_WITH_AES_256_GCM_SHA384", Opcodes.GOTO);
        b.a(bVar, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        b.a(bVar, "TLS_FALLBACK_SCSV", 22016);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        b.a(bVar, "TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        b.a(bVar, "TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        b.a(bVar, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        b.a(bVar, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        b.a(bVar, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        b.a(bVar, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        b.a(bVar, "TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        b.a(bVar, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        h = b.a(bVar, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        i = b.a(bVar, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        b.a(bVar, "TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        b.a(bVar, "TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        b.a(bVar, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        b.a(bVar, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        b.a(bVar, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        b.a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        b.a(bVar, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        b.a(bVar, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        b.a(bVar, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        b.a(bVar, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        j = b.a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        k = b.a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        b.a(bVar, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        l = b.a(bVar, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        m = b.a(bVar, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        b.a(bVar, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        b.a(bVar, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        b.a(bVar, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        b.a(bVar, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        n = b.a(bVar, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        o = b.a(bVar, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        b.a(bVar, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        b.a(bVar, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        p = b.a(bVar, "TLS_AES_128_GCM_SHA256", 4865);
        q = b.a(bVar, "TLS_AES_256_GCM_SHA384", 4866);
        r = b.a(bVar, "TLS_CHACHA20_POLY1305_SHA256", 4867);
        b.a(bVar, "TLS_AES_128_CCM_SHA256", 4868);
        b.a(bVar, "TLS_AES_128_CCM_8_SHA256", 4869);
    }

    public CipherSuite(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.t = str;
    }

    public String toString() {
        return this.t;
    }
}
