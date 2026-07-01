package f0;

/* JADX INFO: compiled from: TlsVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum d0 {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");

    public static final d0$a p = new d0$a(null);
    private final String javaName;

    d0(String str) {
        this.javaName = str;
    }

    public final String f() {
        return this.javaName;
    }
}
