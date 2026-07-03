package p600f0;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.j */
/* JADX INFO: compiled from: CipherSuite.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12366j {

    /* JADX INFO: renamed from: a */
    public static final Comparator<String> f25909a;

    /* JADX INFO: renamed from: b */
    public static final Map<String, C12366j> f25910b;

    /* JADX INFO: renamed from: c */
    public static final C12366j f25911c;

    /* JADX INFO: renamed from: d */
    public static final C12366j f25912d;

    /* JADX INFO: renamed from: e */
    public static final C12366j f25913e;

    /* JADX INFO: renamed from: f */
    public static final C12366j f25914f;

    /* JADX INFO: renamed from: g */
    public static final C12366j f25915g;

    /* JADX INFO: renamed from: h */
    public static final C12366j f25916h;

    /* JADX INFO: renamed from: i */
    public static final C12366j f25917i;

    /* JADX INFO: renamed from: j */
    public static final C12366j f25918j;

    /* JADX INFO: renamed from: k */
    public static final C12366j f25919k;

    /* JADX INFO: renamed from: l */
    public static final C12366j f25920l;

    /* JADX INFO: renamed from: m */
    public static final C12366j f25921m;

    /* JADX INFO: renamed from: n */
    public static final C12366j f25922n;

    /* JADX INFO: renamed from: o */
    public static final C12366j f25923o;

    /* JADX INFO: renamed from: p */
    public static final C12366j f25924p;

    /* JADX INFO: renamed from: q */
    public static final C12366j f25925q;

    /* JADX INFO: renamed from: r */
    public static final C12366j f25926r;

    /* JADX INFO: renamed from: s */
    public static final b f25927s;

    /* JADX INFO: renamed from: t */
    public final String f25928t;

    /* JADX INFO: renamed from: f0.j$a */
    /* JADX INFO: compiled from: CipherSuite.kt */
    public static final class a implements Comparator<String> {
        /* JADX WARN: Code duplicated, block: B:9:0x002c A[RETURN, SYNTHETIC] */
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            String str3 = str;
            String str4 = str2;
            C12238m.checkParameterIsNotNull(str3, "a");
            C12238m.checkParameterIsNotNull(str4, "b");
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

        /* JADX INFO: renamed from: a */
        public static final C12366j m10372a(b bVar, String str, int i) {
            C12366j c12366j = new C12366j(str, null);
            C12366j.f25910b.put(str, c12366j);
            return c12366j;
        }

        /* JADX INFO: renamed from: b */
        public final synchronized C12366j m10373b(String str) {
            C12366j c12366j;
            C12238m.checkParameterIsNotNull(str, "javaName");
            Map<String, C12366j> map = C12366j.f25910b;
            c12366j = map.get(str);
            if (c12366j == null) {
                c12366j = map.get(m10374c(str));
                if (c12366j == null) {
                    c12366j = new C12366j(str, null);
                }
                map.put(str, c12366j);
            }
            return c12366j;
        }

        /* JADX INFO: renamed from: c */
        public final String m10374c(String str) {
            if (C12103t.startsWith$default(str, "TLS_", false, 2, null)) {
                StringBuilder sbM833U = C1643a.m833U("SSL_");
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = str.substring(4);
                C12238m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sbM833U.append(strSubstring);
                return sbM833U.toString();
            }
            if (!C12103t.startsWith$default(str, "SSL_", false, 2, null)) {
                return str;
            }
            StringBuilder sbM833U2 = C1643a.m833U("TLS_");
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring2 = str.substring(4);
            C12238m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            sbM833U2.append(strSubstring2);
            return sbM833U2.toString();
        }
    }

    static {
        b bVar = new b(null);
        f25927s = bVar;
        f25909a = new a();
        f25910b = new LinkedHashMap();
        b.m10372a(bVar, "SSL_RSA_WITH_NULL_MD5", 1);
        b.m10372a(bVar, "SSL_RSA_WITH_NULL_SHA", 2);
        b.m10372a(bVar, "SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        b.m10372a(bVar, "SSL_RSA_WITH_RC4_128_MD5", 4);
        b.m10372a(bVar, "SSL_RSA_WITH_RC4_128_SHA", 5);
        b.m10372a(bVar, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        b.m10372a(bVar, "SSL_RSA_WITH_DES_CBC_SHA", 9);
        f25911c = b.m10372a(bVar, "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        b.m10372a(bVar, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        b.m10372a(bVar, "SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        b.m10372a(bVar, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        b.m10372a(bVar, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        b.m10372a(bVar, "SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        b.m10372a(bVar, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        b.m10372a(bVar, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        b.m10372a(bVar, "SSL_DH_anon_WITH_RC4_128_MD5", 24);
        b.m10372a(bVar, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        b.m10372a(bVar, "SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        b.m10372a(bVar, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        b.m10372a(bVar, "TLS_KRB5_WITH_DES_CBC_SHA", 30);
        b.m10372a(bVar, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        b.m10372a(bVar, "TLS_KRB5_WITH_RC4_128_SHA", 32);
        b.m10372a(bVar, "TLS_KRB5_WITH_DES_CBC_MD5", 34);
        b.m10372a(bVar, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        b.m10372a(bVar, "TLS_KRB5_WITH_RC4_128_MD5", 36);
        b.m10372a(bVar, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        b.m10372a(bVar, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        b.m10372a(bVar, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        b.m10372a(bVar, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        f25912d = b.m10372a(bVar, "TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        b.m10372a(bVar, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        b.m10372a(bVar, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        b.m10372a(bVar, "TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f25913e = b.m10372a(bVar, "TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        b.m10372a(bVar, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        b.m10372a(bVar, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        b.m10372a(bVar, "TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        b.m10372a(bVar, "TLS_RSA_WITH_NULL_SHA256", 59);
        b.m10372a(bVar, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        b.m10372a(bVar, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        b.m10372a(bVar, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        b.m10372a(bVar, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        b.m10372a(bVar, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        b.m10372a(bVar, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        b.m10372a(bVar, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        b.m10372a(bVar, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        b.m10372a(bVar, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        b.m10372a(bVar, "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        b.m10372a(bVar, "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        b.m10372a(bVar, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", Opcodes.IINC);
        b.m10372a(bVar, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", Opcodes.I2D);
        b.m10372a(bVar, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", Opcodes.L2I);
        b.m10372a(bVar, "TLS_PSK_WITH_RC4_128_SHA", Opcodes.L2D);
        b.m10372a(bVar, "TLS_PSK_WITH_3DES_EDE_CBC_SHA", Opcodes.F2I);
        b.m10372a(bVar, "TLS_PSK_WITH_AES_128_CBC_SHA", Opcodes.F2L);
        b.m10372a(bVar, "TLS_PSK_WITH_AES_256_CBC_SHA", Opcodes.F2D);
        b.m10372a(bVar, "TLS_RSA_WITH_SEED_CBC_SHA", 150);
        f25914f = b.m10372a(bVar, "TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f25915g = b.m10372a(bVar, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        b.m10372a(bVar, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        b.m10372a(bVar, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPEQ);
        b.m10372a(bVar, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", Opcodes.IF_ICMPGE);
        b.m10372a(bVar, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPGT);
        b.m10372a(bVar, "TLS_DH_anon_WITH_AES_128_GCM_SHA256", Opcodes.IF_ACMPNE);
        b.m10372a(bVar, "TLS_DH_anon_WITH_AES_256_GCM_SHA384", Opcodes.GOTO);
        b.m10372a(bVar, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        b.m10372a(bVar, "TLS_FALLBACK_SCSV", 22016);
        b.m10372a(bVar, "TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        b.m10372a(bVar, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        b.m10372a(bVar, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        b.m10372a(bVar, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        b.m10372a(bVar, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        b.m10372a(bVar, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        b.m10372a(bVar, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        b.m10372a(bVar, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        b.m10372a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        b.m10372a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        b.m10372a(bVar, "TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        b.m10372a(bVar, "TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        b.m10372a(bVar, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        b.m10372a(bVar, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        b.m10372a(bVar, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        b.m10372a(bVar, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        b.m10372a(bVar, "TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        b.m10372a(bVar, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        f25916h = b.m10372a(bVar, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        f25917i = b.m10372a(bVar, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        b.m10372a(bVar, "TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        b.m10372a(bVar, "TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        b.m10372a(bVar, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        b.m10372a(bVar, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        b.m10372a(bVar, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        b.m10372a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        b.m10372a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        b.m10372a(bVar, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        b.m10372a(bVar, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        b.m10372a(bVar, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        b.m10372a(bVar, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        b.m10372a(bVar, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        b.m10372a(bVar, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        f25918j = b.m10372a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        f25919k = b.m10372a(bVar, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        b.m10372a(bVar, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        b.m10372a(bVar, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        f25920l = b.m10372a(bVar, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f25921m = b.m10372a(bVar, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        b.m10372a(bVar, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        b.m10372a(bVar, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        b.m10372a(bVar, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        b.m10372a(bVar, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        f25922n = b.m10372a(bVar, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        f25923o = b.m10372a(bVar, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        b.m10372a(bVar, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        b.m10372a(bVar, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        f25924p = b.m10372a(bVar, "TLS_AES_128_GCM_SHA256", 4865);
        f25925q = b.m10372a(bVar, "TLS_AES_256_GCM_SHA384", 4866);
        f25926r = b.m10372a(bVar, "TLS_CHACHA20_POLY1305_SHA256", 4867);
        b.m10372a(bVar, "TLS_AES_128_CCM_SHA256", 4868);
        b.m10372a(bVar, "TLS_AES_128_CCM_8_SHA256", 4869);
    }

    public C12366j(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f25928t = str;
    }

    public String toString() {
        return this.f25928t;
    }
}
