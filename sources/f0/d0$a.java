package f0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TlsVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0$a {
    public d0$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final d0 a(String str) {
        d0.z.d.m.checkParameterIsNotNull(str, "javaName");
        int iHashCode = str.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            return d0.TLS_1_1;
                        }
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            return d0.TLS_1_2;
                        }
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            return d0.TLS_1_3;
                        }
                        break;
                }
            } else if (str.equals("TLSv1")) {
                return d0.TLS_1_0;
            }
        } else if (str.equals("SSLv3")) {
            return d0.SSL_3_0;
        }
        throw new IllegalArgumentException(b.d.b.a.a.w("Unexpected TLS version: ", str));
    }
}
