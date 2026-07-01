package f0;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: CipherSuite.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final Comparator<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, j> f3672b;
    public static final j c;
    public static final j d;
    public static final j e;
    public static final j f;
    public static final j g;
    public static final j h;
    public static final j i;
    public static final j j;
    public static final j k;
    public static final j l;
    public static final j m;
    public static final j n;
    public static final j o;
    public static final j p;
    public static final j q;
    public static final j r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final j$b f3673s;
    public final String t;

    static {
        j$b j_b = new j$b(null);
        f3673s = j_b;
        a = new j$a();
        f3672b = new LinkedHashMap();
        j$b.a(j_b, "SSL_RSA_WITH_NULL_MD5", 1);
        j$b.a(j_b, "SSL_RSA_WITH_NULL_SHA", 2);
        j$b.a(j_b, "SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        j$b.a(j_b, "SSL_RSA_WITH_RC4_128_MD5", 4);
        j$b.a(j_b, "SSL_RSA_WITH_RC4_128_SHA", 5);
        j$b.a(j_b, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        j$b.a(j_b, "SSL_RSA_WITH_DES_CBC_SHA", 9);
        c = j$b.a(j_b, "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        j$b.a(j_b, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        j$b.a(j_b, "SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        j$b.a(j_b, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        j$b.a(j_b, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        j$b.a(j_b, "SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        j$b.a(j_b, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        j$b.a(j_b, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        j$b.a(j_b, "SSL_DH_anon_WITH_RC4_128_MD5", 24);
        j$b.a(j_b, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        j$b.a(j_b, "SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        j$b.a(j_b, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        j$b.a(j_b, "TLS_KRB5_WITH_DES_CBC_SHA", 30);
        j$b.a(j_b, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        j$b.a(j_b, "TLS_KRB5_WITH_RC4_128_SHA", 32);
        j$b.a(j_b, "TLS_KRB5_WITH_DES_CBC_MD5", 34);
        j$b.a(j_b, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        j$b.a(j_b, "TLS_KRB5_WITH_RC4_128_MD5", 36);
        j$b.a(j_b, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        j$b.a(j_b, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        j$b.a(j_b, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        j$b.a(j_b, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        d = j$b.a(j_b, "TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        j$b.a(j_b, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        j$b.a(j_b, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        j$b.a(j_b, "TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        e = j$b.a(j_b, "TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        j$b.a(j_b, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        j$b.a(j_b, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        j$b.a(j_b, "TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        j$b.a(j_b, "TLS_RSA_WITH_NULL_SHA256", 59);
        j$b.a(j_b, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        j$b.a(j_b, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        j$b.a(j_b, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        j$b.a(j_b, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        j$b.a(j_b, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        j$b.a(j_b, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        j$b.a(j_b, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        j$b.a(j_b, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        j$b.a(j_b, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        j$b.a(j_b, "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        j$b.a(j_b, "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        j$b.a(j_b, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", Opcodes.IINC);
        j$b.a(j_b, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", Opcodes.I2D);
        j$b.a(j_b, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", Opcodes.L2I);
        j$b.a(j_b, "TLS_PSK_WITH_RC4_128_SHA", Opcodes.L2D);
        j$b.a(j_b, "TLS_PSK_WITH_3DES_EDE_CBC_SHA", Opcodes.F2I);
        j$b.a(j_b, "TLS_PSK_WITH_AES_128_CBC_SHA", Opcodes.F2L);
        j$b.a(j_b, "TLS_PSK_WITH_AES_256_CBC_SHA", Opcodes.F2D);
        j$b.a(j_b, "TLS_RSA_WITH_SEED_CBC_SHA", 150);
        f = j$b.a(j_b, "TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        g = j$b.a(j_b, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        j$b.a(j_b, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        j$b.a(j_b, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPEQ);
        j$b.a(j_b, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", Opcodes.IF_ICMPGE);
        j$b.a(j_b, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPGT);
        j$b.a(j_b, "TLS_DH_anon_WITH_AES_128_GCM_SHA256", Opcodes.IF_ACMPNE);
        j$b.a(j_b, "TLS_DH_anon_WITH_AES_256_GCM_SHA384", Opcodes.GOTO);
        j$b.a(j_b, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        j$b.a(j_b, "TLS_FALLBACK_SCSV", 22016);
        j$b.a(j_b, "TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        j$b.a(j_b, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        j$b.a(j_b, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        j$b.a(j_b, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        j$b.a(j_b, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        j$b.a(j_b, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        j$b.a(j_b, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        j$b.a(j_b, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        j$b.a(j_b, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        j$b.a(j_b, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        j$b.a(j_b, "TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        j$b.a(j_b, "TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        j$b.a(j_b, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        j$b.a(j_b, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        j$b.a(j_b, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        j$b.a(j_b, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        j$b.a(j_b, "TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        j$b.a(j_b, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        h = j$b.a(j_b, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        i = j$b.a(j_b, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        j$b.a(j_b, "TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        j$b.a(j_b, "TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        j$b.a(j_b, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        j$b.a(j_b, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        j$b.a(j_b, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        j$b.a(j_b, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        j$b.a(j_b, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        j$b.a(j_b, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        j$b.a(j_b, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        j$b.a(j_b, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        j$b.a(j_b, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        j$b.a(j_b, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        j$b.a(j_b, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        j = j$b.a(j_b, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        k = j$b.a(j_b, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        j$b.a(j_b, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        j$b.a(j_b, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        l = j$b.a(j_b, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        m = j$b.a(j_b, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        j$b.a(j_b, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        j$b.a(j_b, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        j$b.a(j_b, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        j$b.a(j_b, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        n = j$b.a(j_b, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        o = j$b.a(j_b, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        j$b.a(j_b, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        j$b.a(j_b, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        p = j$b.a(j_b, "TLS_AES_128_GCM_SHA256", 4865);
        q = j$b.a(j_b, "TLS_AES_256_GCM_SHA384", 4866);
        r = j$b.a(j_b, "TLS_CHACHA20_POLY1305_SHA256", 4867);
        j$b.a(j_b, "TLS_AES_128_CCM_SHA256", 4868);
        j$b.a(j_b, "TLS_AES_128_CCM_8_SHA256", 4869);
    }

    public j(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.t = str;
    }

    public String toString() {
        return this.t;
    }
}
