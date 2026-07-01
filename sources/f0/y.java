package f0;

/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum y {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    public static final y$a q = new y$a(null);
    private final String protocol;

    y(String str) {
        this.protocol = str;
    }

    public static final /* synthetic */ String f(y yVar) {
        return yVar.protocol;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
