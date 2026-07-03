package p600f0;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.d0 */
/* JADX INFO: compiled from: TlsVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC12268d0 {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");


    /* JADX INFO: renamed from: p */
    public static final a f25393p = new a(null);
    private final String javaName;

    /* JADX INFO: renamed from: f0.d0$a */
    /* JADX INFO: compiled from: TlsVersion.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX INFO: renamed from: a */
        public final EnumC12268d0 m10110a(String str) {
            C12238m.checkParameterIsNotNull(str, "javaName");
            int iHashCode = str.hashCode();
            if (iHashCode != 79201641) {
                if (iHashCode != 79923350) {
                    switch (iHashCode) {
                        case -503070503:
                            if (str.equals("TLSv1.1")) {
                                return EnumC12268d0.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (str.equals("TLSv1.2")) {
                                return EnumC12268d0.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (str.equals("TLSv1.3")) {
                                return EnumC12268d0.TLS_1_3;
                            }
                            break;
                    }
                } else if (str.equals("TLSv1")) {
                    return EnumC12268d0.TLS_1_0;
                }
            } else if (str.equals("SSLv3")) {
                return EnumC12268d0.SSL_3_0;
            }
            throw new IllegalArgumentException(C1643a.m883w("Unexpected TLS version: ", str));
        }
    }

    EnumC12268d0(String str) {
        this.javaName = str;
    }

    /* JADX INFO: renamed from: f */
    public final String m10109f() {
        return this.javaName;
    }
}
